package fooddelivery.service;

import java.util.ArrayList;
import java.util.List;
import fooddelivery.model.Restaurant;

public class RestaurantManager {
    private static volatile RestaurantManager instance;
    private final List<Restaurant> restaurants;

    public RestaurantManager() {
        this.restaurants = new ArrayList<>();
    }

    // Static method to get single instance
    public static RestaurantManager getInstance() {
        if (instance == null) {
            synchronized (RestaurantManager.class) {
                if (instance == null) {
                    instance = new RestaurantManager();
                }
            }
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public boolean containsRestaurant(Restaurant restaurant) {
        return restaurant != null
                && restaurant.getId() != null
                && restaurants.stream().anyMatch(r -> restaurant.getId().equals(r.getId()));
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        if (restaurant == null || restaurant.getId() == null) {
            return false;
        }

        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant existing = restaurants.get(i);
            if (restaurant.getId().equals(existing.getId())) {
                restaurants.set(i, restaurant);
                return true;
            }
        }

        return false;
    }

    public List<Restaurant> searchRestaurant(String location) {
        List<Restaurant> results = new ArrayList<>();
        if (location == null || location.isBlank()) {
            return results;
        }

        String target = location.trim();

        for (Restaurant restaurant : restaurants) {
            if (target.equals(restaurant.getLocation())) {
                results.add(restaurant);
            }
        }

        return results;
    }
}
