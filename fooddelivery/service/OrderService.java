package fooddelivery.service;

import fooddelivery.model.Order;

public class OrderService {

    private final OrderManager orderManager;
    private final NotificationService notificationService;

    public OrderService(OrderManager orderManager,
                        NotificationService notificationService) {
        this.orderManager = orderManager;
        this.notificationService = notificationService;
    }

    public void placeOrder(Order order) {

        // 1. Process payment
        order.processOrderPayment();

        // 2. Save order
        orderManager.addOrder(order);

        // 3. Send notification
        notificationService.sendOrderPlacedNotification(
                order.getUser(),
                order.getId()
        );
    }
}
