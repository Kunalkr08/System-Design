package fooddelivery.service;

import java.util.List;

import fooddelivery.model.Order;

public class OrderManager {
    private final List<Order> orders;

    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
