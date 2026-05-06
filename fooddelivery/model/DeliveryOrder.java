package fooddelivery.model;

import java.time.Instant;
import java.util.List;

import fooddelivery.strategy.PaymentStrategy;

public class DeliveryOrder extends Order {

    public DeliveryOrder(String id, Restaurant restaurant,
                         PaymentStrategy payment, User user,
                         List<MenuItem> items, Instant scheduledTime,
                         String address) {
        super(id, restaurant, payment, user, items, scheduledTime);
    }

    @Override
    public String getType() {
        return "DELIVERY";
    }
}
