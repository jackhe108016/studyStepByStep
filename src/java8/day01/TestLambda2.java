package java8.day01;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一、 Lambda表达式的基础语法：Java8 中引入了一个新的操作符
 *
 * 二、Lambda表达式需要函数式接口的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解@FunctionalInterface修饰
 * 可以检查是否是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1(){
        int num = 0;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };
        r.run();
        System.out.println("-----------------------------------");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();

    }

    @Test
    public void test2(){
        Consumer<String> con = x -> System.out.println(x);
        con.accept("我大尚硅谷威武！");
    }

    @Test
    public void test3(){
        Comparator<Integer> com = (x, y) ->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }

    @Test
    public void test4(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    // 需求： 对一个数进行运算
    @Test
    public void test6(){
        Integer num = oprtation(100, x -> x * x);
        System.out.println(num);
        System.out.println(oprtation(200, y -> y + 200));
    }
    public Integer oprtation(Integer num, MyFun mf){
        return mf.getValue(num);
    }
}
