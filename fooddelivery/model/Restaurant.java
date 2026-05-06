package fooddelivery.model;

import java.util.List;

public class Restaurant {
    private final String id;
    private final String name;
    private final String loaction;
    private final List<MenuItem> menuitems;

    public Restaurant(String id, String name, String location, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.loaction = location;
        this.menuitems = menuItems;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return loaction;
    }

    public List<MenuItem> getMenuItems() {
        return menuitems;
    }
}
