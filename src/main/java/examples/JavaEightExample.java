package examples;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Lakith Dharmarathna
 * Date : 10/08/2022
 */
class Employee{
    String name;
    Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
public class JavaEightExample {


    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee("A",12000),
                new Employee("B",14000),
                new Employee("C",11030),
                new Employee("D",19000));

        System.out.println("Find the second largest element"+employeeList
                .stream()
                .sorted((emp1,emp2)->emp2.getSalary().compareTo(emp1.getSalary()))
                .skip(2)
                .map(Employee::getName).findFirst().get());
        //Find how many times elements repeat

        List<Integer> numberList = List.of(2,2,2,3,3,3,3,4,4,5,5,5,5,5,5);

        Map<Integer,Long> numMap = numberList
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(numMap);
    }
}
