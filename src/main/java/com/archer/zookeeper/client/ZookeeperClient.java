package com.archer.zookeeper.client;

import com.google.common.collect.Lists;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class ZookeeperClient implements Watcher {

    private Logger log = LoggerFactory.getLogger(ZookeeperClient.class);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zooKeeper;

    private static Stat stat = new Stat();

    public ZookeeperClient() {
    }


    /**
     * @param address
     * @param timeOut
     * @throws IOException
     */
    public ZookeeperClient(String address, int timeOut) throws IOException {

        if (address == null || address.length() == 0) {
            log.error("address连接地址异常={}", address);
            throw new InvalidParameterException("address连接地址异常");
        }
        String host = address.split(":")[0];
        String port = address.split(":")[1];
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, new Integer(port)), 5000);
        } catch (IOException e) {
            log.error("{}连接异常,{}", address, e.getMessage());
            throw new IOException(address + "连接异常" + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        try {
            this.zooKeeper = new ZooKeeper(address, timeOut, this);
        } catch (IOException e) {
            log.error("初始化Zk失败,地址={},errorMessage={}", e.getMessage());
        }
        if (zooKeeper != null && zooKeeper.getState().isAlive()) {
            log.info("zookeeper connection success");
        } else {
            log.error("初始化Zk失败,zk地址={}", address);
            throw new IOException("初始化Zk失败");
        }
    }

    public void closeConnection() throws InterruptedException {
        if (zooKeeper != null) {
            zooKeeper.close();
        }
    }

    /**
     * @param zooParrent
     * @return
     */
    public List<String> getPath(@NotNull String zooParrent) {


        if (zooParrent == null || zooParrent.length() == 0 || zooParrent.endsWith("/")) {
            throw new InvalidParameterException("参数异常");
        }
        List<String> zooChildren = Lists.newArrayList();
        try {
            zooChildren = zooKeeper.getChildren(zooParrent, true);
            countDownLatch.await();
        } catch (KeeperException e) {
            log.error(e.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return zooChildren;
    }

    /**
     * @param path
     * @return
     */
    public String getDataSync(String path) {
        byte[] bytes = new byte[]{};
        Stat stat = new Stat();
        try {
            bytes = zooKeeper.getData(path, true, stat);
        } catch (KeeperException e) {
            log.error(e.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        return new String(bytes);
    }

    /**
     * @param path
     * @param cb
     */
    public void getDataASync(String path, AsyncCallback.DataCallback cb) {
        zooKeeper.getData(path, true, cb, null);
    }


    /**
     * @param path
     * @param bytes
     */
    public void setData(String path, byte[] bytes) {
        try {
            zooKeeper.setData(path, bytes, -1);
        } catch (KeeperException e) {
            log.error(e.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }


    @Override
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) { // 连接时的监听事件
                countDownLatch.countDown();
            } else if (event.getType() == Event.EventType.NodeDataChanged) { // 子节点内容变更时的监听
                try {
                    log.info("path={},监听获得通知内容：data={}", event.getPath(), new String(zooKeeper.getData(event.getPath(), true, stat)));
                    log.info("path={},监听获得通知Stat：czxid={},mzxid={},version={}", event.getPath(), stat.getCzxid(), stat.getMzxid(), stat.getVersion());
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }
        }
    }
}
