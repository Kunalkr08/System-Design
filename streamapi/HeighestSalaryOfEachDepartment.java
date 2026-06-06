package streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class HeighestSalaryOfEachDepartment {
    static class Employee {
        private final String name;
        private final String department;
        private final int salary;

        public Employee(String name, String department, int salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public int getSalary() {
            return salary;
        }
    }   
    
    public static void main(String[] args) {
        List<Employee> employees = List.of(
           new Employee("Alice", "IT", 80000),
           new Employee("Bob", "IT", 90000),
           new Employee("Charlie", "HR", 70000),
           new Employee("David", "HR", 85000)
        );       
        
        Map<String, Optional<Employee>> res = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        for(Map.Entry<String, Optional<Employee>> entery : res.entrySet()) {
            System.out.println(entery.getKey() + " -> " + entery.getValue().get().getName() + " " + entery.getValue().get().getDepartment() + " " + entery.getValue().get().getSalary());
        }
    }
}
