package fooddelivery.service;

import java.util.List;
import fooddelivery.model.MenuItem;
import fooddelivery.model.Restaurant;
import fooddelivery.model.User;

public class Cart {
    private final String id;
    private final List<MenuItem> menuItems;
    private final Restaurant restaurant;
    private final User user;
    
    public Cart(String id, List<MenuItem> menuItems, Restaurant restaurant, User user) {
        this.id = id;
        this.menuItems = menuItems;
        this.restaurant = restaurant;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public User getUser() {
        return user;
    }

    public void addToCart(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public Boolean isCardEmpty() {
        return menuItems.isEmpty();
    }

    public Double calculatePrice() {
        Double totalPrice = 0.0;
        for(MenuItem menuItem: menuItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }
}
