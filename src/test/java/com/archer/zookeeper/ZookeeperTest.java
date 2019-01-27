package com.archer.zookeeper;


import com.archer.zookeeper.client.ZookeeperClient;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


public class ZookeeperTest {

    private Logger log = LoggerFactory.getLogger(ZookeeperTest.class);


    private static String address = "192.168.1.113:2181";


    public static void main(String[] args) throws IOException, InterruptedException {

        ZookeeperClient client = new ZookeeperClient(address, 2000);

        String zpath = "/dubbo/A/provider";

        List<String> zooChildren;
        zooChildren = client.getPath(zpath);
        for (String child : zooChildren) {
            if (child == "") {
                log.info("{},子节点为空！", zpath);
            } else {
                log.info("{},子节点:{}", zpath, child);
            }
        }
        log.info("同步读取节点内容：{}", new String(client.getDataSync(zpath)));
        client.setData(zpath, "123".getBytes());
        log.info("同步读取节点内容：{}", new String(client.getDataSync("/dubbo/A")));
        client.setData("/dubbo/A", "456".getBytes());

        client.getDataASync(zpath, new ZkDataCallback());
//        Thread.sleep(10000);

        client.closeConnection();

    }

    private static class ZkDataCallback implements AsyncCallback.DataCallback {
        @Override
        public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
            log.info("异步返回结果：rc={},path={},data={}", i, s, new String(bytes));
            log.info("异步读取Stat：czxid={},mzxid={},version={}", stat.getCzxid(), stat.getMzxid(), stat.getVersion());
        }
    }
}
