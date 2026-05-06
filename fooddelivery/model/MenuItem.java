package fooddelivery.model;

public class MenuItem {
    private final String id;
    private final String name;
    private final Double price;

    public MenuItem(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
