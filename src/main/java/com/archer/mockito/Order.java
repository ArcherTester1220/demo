package com.archer.mockito;

public class Order {
    private String id;

    private long price;

    public Order(String id, long price) {
        this.id = id;
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
