package fooddelivery;

import java.util.ArrayList;
import java.util.List;

import fooddelivery.enums.OrderType;
import fooddelivery.model.MenuItem;
import fooddelivery.model.Order;
import fooddelivery.model.Restaurant;
import fooddelivery.model.User;
import fooddelivery.service.Cart;
import fooddelivery.service.NotificationService;
import fooddelivery.service.OrderFactory;
import fooddelivery.service.OrderManager;
import fooddelivery.service.OrderService;
import fooddelivery.service.RestaurantManager;
import fooddelivery.strategy.PaymentStrategy;
import fooddelivery.strategy.UPIPayment;

public class Main {
    public static void main(String[] args) {
        // 1) Create menu items
        MenuItem pizza = new MenuItem("M1", "Pizza", 299.0);
        MenuItem burger = new MenuItem("M2", "Burger", 149.0);
        MenuItem pasta = new MenuItem("M3", "Pasta", 199.0);

        // 2) Create restaurants
        Restaurant r1 = new Restaurant(
                "R1",
                "Food Hub",
                "Bangalore",
                new ArrayList<>(List.of(pizza, burger)));

        Restaurant r2 = new Restaurant(
                "R2",
                "Pasta Point",
                "Bangalore",
                new ArrayList<>(List.of(pasta)));

        // 3) Restaurant manager usage
        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(r1);
        restaurantManager.addRestaurant(r2);

        List<Restaurant> restaurants = restaurantManager.searchRestaurant("Bangalore");
        
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants found for this location");
            return; // stop order flow
        }
        System.out.println(restaurants.size() + " restaurants found for this location");

        // 4) Create a user and cart
        User user = new User("U1", "Kunal", "kunal@example.com", "9876543210");
        Cart cart = new Cart(
                "C1",
                new ArrayList<>(),
                r1,
                user);

        cart.addToCart(pasta);
        cart.addToCart(burger);

        // 5) Create order via factory
        PaymentStrategy paymentStrategy = new UPIPayment();

        Order order = OrderFactory.createOrder(
                OrderType.PICKUP,
                cart,
                paymentStrategy,
                "Store pickup counter");

        // 6) Use OrderService (correct flow)

        OrderManager orderManager = new OrderManager(new ArrayList<>());
        NotificationService notificationService = new NotificationService();

        OrderService orderService = new OrderService(
                orderManager,
                notificationService
        );

        // place order (this will handle everything)
        orderService.placeOrder(order);
    }
}
