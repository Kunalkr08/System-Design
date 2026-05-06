package fooddelivery.model;

import java.time.Instant;
import java.util.List;

import fooddelivery.strategy.PaymentStrategy;

public class PickupOrder extends Order {

    public PickupOrder(String id, Restaurant restaurant,
                         PaymentStrategy payment, User user,
                         List<MenuItem> items, Instant scheduledTime,
                         String address) {
        super(id, restaurant, payment, user, items, scheduledTime);
    }

    @Override
    public String getType() {
        return "PICKUP";
    }
}
