package java8.day01;

public class FilterEmployeeForAge  implements MyPredicate<Employee>{
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() <= 35;
    }
}
