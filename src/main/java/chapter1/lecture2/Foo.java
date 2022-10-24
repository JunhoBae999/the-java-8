package main.java.chapter1.lecture2;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        Plus10 plus10 = new Plus10();
        plus10.apply(1);

        Function<Integer,Integer> plus10Lambda =  (number) -> number+10; //한줄은 return 생략 가능
        plus10Lambda.apply(1);

        Function<Integer,Integer> multiply2 = (number) -> number*2;
        multiply2.apply(2);

        /*
        Function<R,T> :  함수 조합하기
         */
        Function<Integer, Integer> multiply2AndPlus10 = plus10Lambda.compose(multiply2);// plus10(multiply2(number))
        System.out.println(multiply2AndPlus10.apply(1)); //12

        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2); // multiply2(plus10(number))
        System.out.println(plus10AndMultiply2.apply(1)); // 22


        /*
        Consumer<T> : 받기만 하고 리턴하지 않음
         */
        Consumer<Integer> consumer = (number) -> System.out.println(number); // 받기만 하고 입력 값이 없는 메서드

        /*
        Supplier<T> : 입력해줄 값이 없음. 받아오기만 함
         */
        Supplier<Integer> get10  = () -> 10;

        /*
        Predicate<T> : 어떤 인자 값을 받아서 True, False를 리턴
         */
        Predicate<String> startsWithJunho = (s) -> s.startsWith("junho"); //boolean 조합 가능


        /*
        UnaryOperator : 입력값과 결과값의 리턴 타입이 같은 경우, 더 간단하게 쓸려고, Function 클래스 상속해서 컴포즈 이런거 다 사용 가능
         */
        UnaryOperator<Integer> plus10Unary = (number) -> number+10;

        /*

         */




    }
}
