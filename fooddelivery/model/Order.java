package fooddelivery.model;

import java.time.Instant;
import java.util.List;

import fooddelivery.strategy.PaymentStrategy;

public abstract class Order {
    private final String id;
    private final Restaurant restaurant;
    private final PaymentStrategy paymentStrategy;
    private final User user;
    private final List<MenuItem> menuItems;
    private final Instant scheduleTime;

    public Order(String id, Restaurant restaurant, PaymentStrategy paymentStrategy, User user, List<MenuItem> menuItems, Instant scheduleInstant) {
        this.id = id;
        this.restaurant = restaurant;
        this.paymentStrategy = paymentStrategy;
        this.user = user;
        this.menuItems = menuItems;
        this.scheduleTime = scheduleInstant;
    }

    public String getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public User getUser() {
        return user;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Instant getScheduleInstant() {
        return scheduleTime;
    }

    public void processOrderPayment() {
        double totalAmount = calculateTotal();
        paymentStrategy.processPayment(totalAmount);
    }

    private double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : menuItems) {
            total += item.getPrice();
        }
        return total;
    }    

    public abstract String getType();
}
