package java8.day01;

import org.junit.Test;

import java.util.function.Function;

public class TestMethodRef {

    // 数组引用
    @Test
    public void test8(){
        Function<Integer, String[]> fun = args -> new String[args];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        System.out.println("-----------------------------------");
        Function<Integer, Employee[]> fun2 = Employee[] :: new;
        Employee[] emps = fun2.apply(20);
        System.out.println(emps.length);
    }

}
