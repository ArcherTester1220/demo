package com.archer.mockito;

import org.springframework.stereotype.Service;

@Service
public class PriceService {

    public int getActualPrice(long price) {
        //throw new UnsupportedOperationException("Fail is not mocked!");
        return 11;
    }

    public int calculatePriceForOrder(Order order) {
        int orderPrice = 0;
        orderPrice += getActualPrice(order.getPrice());
        return orderPrice;
    }
}
