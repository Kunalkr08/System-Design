package fooddelivery.service;

import fooddelivery.enums.OrderType;
import fooddelivery.model.DeliveryOrder;
import fooddelivery.model.Order;
import fooddelivery.model.PickupOrder;
import fooddelivery.strategy.PaymentStrategy;

import java.time.Instant;
import java.util.UUID;

public class OrderFactory {

    public static Order createOrder(
            OrderType orderType,
            Cart cart,
            PaymentStrategy paymentStrategy,
            String address // needed for delivery/pickup
    ) {

        String orderId = "ORD-" + UUID.randomUUID();
        Instant scheduleTime = Instant.now();

        if (orderType == null) {
            throw new IllegalArgumentException("Order type cannot be null");
        }

        if (orderType == OrderType.DELIVERY) {
            return new DeliveryOrder(
                    orderId,
                    cart.getRestaurant(),
                    paymentStrategy,
                    cart.getUser(),
                    cart.getMenuItems(),
                    scheduleTime,
                    address
            );
        } else if (orderType == OrderType.PICKUP) {
            return new PickupOrder(
                    orderId,
                    cart.getRestaurant(),
                    paymentStrategy,
                    cart.getUser(),
                    cart.getMenuItems(),
                    scheduleTime,
                    address
            );
        } else {
            throw new IllegalArgumentException("Invalid order type");
        }
    }
}
