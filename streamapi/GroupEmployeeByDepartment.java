package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeeByDepartment {
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

        Map<String, List<String>> res = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        for(Map.Entry<String, List<String>> entry : res.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            for(String str : entry.getValue()) {
                System.out.print(str + " ");
            }

            System.out.println();
        }
    }
}
