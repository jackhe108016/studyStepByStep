package java8.day01;

import org.junit.Test;

import java.util.*;

public class TestLambda1 {
    // 原来的匿名内部类
    @Test
    public void test1(){
        Comparator<String> com = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        };
        TreeSet<String> ts = new TreeSet<>(com);


        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
    }

    // 现在的Lambda
    @Test
    public void test2(){
        Comparator<String> com = (x,y) -> Integer.compare(x.length(),y.length());
        TreeSet<String> ts = new TreeSet<>(com);
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101,"张三",18,9999.99),
            new Employee(102,"李四",59,6666.66),
            new Employee(103,"王五",28,3333.33),
            new Employee(104,"赵六",8,7777.77),
            new Employee(105,"田七",38,5555.55)
    );

    // 需求： 获取公司中年龄小于35的员工信息
    public List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<>();
        for (Employee emp: emps) {
            if(emp.getAge() <= 35){
                list.add(emp);
            }
        }
        return list;
    }

    @Test
    public void test3(){
        List<Employee> list = filterEmployeeAge(emps);
        for (Employee emp: list) {
            System.out.println(emp);
        }
    }

    // 需求：获取公司中工资大于5000 的员工信息
    public List<Employee> filteEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<>();
        for (Employee emp: emps) {
            if(emp.getSalary() >= 5000){
                list.add(emp);
            }
        }
        return list;
    }

    // 优化方式一： 策略设计模式
    public List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp ){
       List<Employee> list = new ArrayList<>();
       for (Employee emp: emps){
           if(mp.test(emp)){
             list.add(emp);
           }
       }
       return list;
    }

    @Test
    public void test4(){
        List<Employee> list = filterEmployee(emps, new FilterEmployeeForAge());
        for(Employee emp : list){
            System.out.println(emp);
        }
        System.out.println("-------------------------------");
        list = filterEmployee(emps,new FilterEmployeeForSalary());
        for (Employee employee : list){
            System.out.println(employee);
        }
    }

    //优化方式二： 匿名内部类
    @Test
    public void test5(){
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getId() <= 103;
            }
        });
        for (Employee emp: list) {
            System.out.println(emp);
        }
    }

    // 优化方式三Lambda表达式
    @Test
    public void test6(){
        List<Employee> list = filterEmployee(emps, e->e.getAge() < 35);
        list.forEach(System.out::println);

        System.out.println("------------------------------");
        List<Employee> list2 = filterEmployee(emps, e -> e.getSalary() >= 6000);
        list2.forEach(System.out::println);
    }
    // 优化方式四： Stream API
    @Test
    public void test7(){
        emps.stream().filter(e -> e.getAge() <= 35).forEach(System.out::println);
        System.out.println("------------------------------------------");
        emps.stream().map(Employee::getName).sorted().forEach(System.out::println);
    }

}
