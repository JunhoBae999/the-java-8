package main.java.chapter1.lecture4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        UnaryOperator<String> hi = (s) -> "hi" + s;
        UnaryOperator<String> hiMethodReference = Greeting::hi;
        System.out.println(hiMethodReference.apply("junho"));

        Greeting greeting = new Greeting();
        UnaryOperator<String> hiInstanceMehotdReference = greeting::hello;
        System.out.println(hiInstanceMehotdReference.apply("junho"));

        /*
        생성자도 참조 가능
         */
        Supplier<Greeting> greetingSupplier =  Greeting::new;
        Greeting greeting1 = greetingSupplier.get();
        greeting1.getName();

        /*
        입력이 있는 생성자도 가능
         */
        Function<String,Greeting> junhoGretting = Greeting::new;
        Greeting junho = junhoGretting.apply("junho");
        junho.getName();

        /*
        임의의 객체의 인스턴스 메서드 참조
         */
        String[] names = {"junho", "nick", "baejunho"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));


    }

}
