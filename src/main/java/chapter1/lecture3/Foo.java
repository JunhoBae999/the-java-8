package main.java.chapter1.lecture3;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        final int baseNumber = 10; //자바 8 이상에서는 사실상 final인 경우, final 키워드를 생략해도 된다. 즉, 어디서도 변경하지 않는 경우 (effective final)

        /*
        로컬 변수가 effective final인 경우, 아래의 모든 경우에서 참조가 가능하다.
        단, 람다에서는 쉐도잉이 안된다!! 즉, 로컬/익명함수에서는 동일한 이름의 로컬 변수를 둔다면, 뒤의 baseNumber가 가려진다. 하지만 람다는 스콥이 메서드와 동일하기 때문에..
         */

        //로컬 클래스에서 로컬 변수를 참조하는 경우
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber); //11이 찍힘. 즉 쉐도잉 되어있음
            }
        }

        //내부익명클래스에서 로컬 변수를 참조하는 경우
        IntConsumer printIntInnerAnonymous = new IntConsumer() {
            @Override
            public void accept(int baseNumber) {
                System.out.println(baseNumber); // 파라미터 이름을 참조하지, 메서드의 baseNumber를 참조하지 않음. 쉐도잉
            }
        };

        //람다에서 로컬 변수를 참조하는 경우
        IntConsumer printInt = (number) -> System.out.println(number + baseNumber); // 얘는 run()과 같은 scope! 동일한 변수의 이름을 사용할 수 없음!!
        //IntConsumer printIntSmaeVariable = (baseNumber) -> System.out.println(number + baseNumber); // 얘는 run()과 같은 scope! 동일한 변수의 이름을 사용할 수 없음!!
        printInt.accept(10);


        //baseNumber++; 이런 식으로 effective final이 아닌 경우, 람다에서 쓰지 말라고 컴파일 에러가 난다.

    }

}
