package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountEmployeePerDepartment {

    static class Employee {
        private final String name;
        private final String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = List.of(
           new Employee("Alice", "IT"),
           new Employee("Bob", "HR"),
           new Employee("Charlie", "IT"),
           new Employee("David", "HR"),
           new Employee("Eve", "IT")
        );

        Map<String, Long> res = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        for (Map.Entry<String, Long> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
