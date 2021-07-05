package java8.day01;

public class FilterEmployeeForSalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee o) {
        return o.getSalary() > 5000;
    }
}
