package streamapi;

import java.util.List;

public class ActiveUsers {

    static class User {
        private final String name;
        private final boolean present;

        public User(String name, boolean present) {
            this.name = name;
            this.present = present;
        }

        public String getName() {
            return name;
        }

        public boolean isPresent() {
            return present;
        }
    }

    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Alice", true),
            new User("Bob", false),
            new User("Kunal", true)
        );
     
        List<User> res = users.stream().filter(User::isPresent).toList();
        
        for(User user : res) {
            System.out.println(user.getName());
        }
    }
}
