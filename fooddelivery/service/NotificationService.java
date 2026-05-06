package fooddelivery.service;


import fooddelivery.model.User;

public class NotificationService {

    public void sendOrderPlacedNotification(User user, String orderId) {
        String message = "Hi " + user.getName() +
                ", your order " + orderId + " has been placed successfully.";

        System.out.println(message);
    }
}
