package fooddelivery.model;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final String cart;

    public User(String id, String name, String email, String cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cart = cart;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return cart;
    }
}
