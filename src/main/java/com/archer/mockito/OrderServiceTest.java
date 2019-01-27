package com.archer.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class OrderServiceTest {


    private static final int TEST_ORDER_ID = 1;
    private static final int TEST_SHOES_PRICE = 2;
    private static final int TEST_SHIRT_PRICE = 1;

    @InjectMocks
    private OrderService testingObject;

    @Spy
    private PriceService priceService;

    @Mock
    private OrderDao orderDao;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetOrderService() {
        Order order1 = new Order("1", 11);
        Order order2 = new Order("2", 22);
        Mockito.when(orderDao.getOrder(TEST_ORDER_ID)).thenReturn(order1);
        Order returnOrder = orderDao.getOrder(TEST_ORDER_ID);
        System.out.println(returnOrder.getPrice() + "-" + returnOrder.getId());

        //notice different Mockito syntax for spy
        Mockito.doReturn(TEST_SHIRT_PRICE).when(priceService).getActualPrice(1);
        Mockito.doReturn(TEST_SHOES_PRICE).when(priceService).getActualPrice(2);
        System.out.println(priceService.getActualPrice(1));
        System.out.println(priceService.getActualPrice(2));
        System.out.println(priceService.getActualPrice(11));

        //call testing method
        int actualOrderPrice = testingObject.getOrderPrice(TEST_ORDER_ID);

        Assert.assertEquals(TEST_SHIRT_PRICE + TEST_SHOES_PRICE, actualOrderPrice);
    }


}
