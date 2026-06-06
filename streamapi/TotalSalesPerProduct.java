package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalSalesPerProduct {

    static class Product{
        private final String name;
        private final int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Product("Laptop", 50000),
            new Product("Mobile", 20000),
            new Product("Laptop", 30000),
            new Product("Mobile", 10000)
        );

        Map<String, Integer> res = products.stream().collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getPrice)));

        for(Map.Entry<String, Integer> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
