package main.java.chapter1.lecture1;

public class Foo {
    //함수처럼 특벼한 오브젝트
    //함수를 변수에 할당
    public static void main(String[] args) {
        //익명 내부 클래스
        RunSomething runSomething =  new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello");
            }
        };

        //위랑 동일한데 람다 표현식으로 줄일 수 있다.
        RunSomething runSomethingLambda = () -> System.out.println("hi");

        //여러 라인을 사용한다면 중괄호로 묶어서
        RunSomething runSomethingLambdaMultiLine = () -> {
            System.out.println("hi");
            System.out.println("I'm Junho");
        };

        runSomething.doIt();
        runSomethingLambda.doIt();
        runSomethingLambdaMultiLine.doIt();

        /*
        pure function을 만들고 싶은 경우
        1. 사이드 이펙트가 있으면 안된다. 외부의 값을 변경해서는 안된다.
        2. 함수 밖에 정의되어 있는 상태가 없어야 한다.
         */
        RunSomethingInteger runSomethingInteger = new RunSomethingInteger() {
            //1.
            int base = 10; //이런 식으로 외부 상태값을 가지고 있고
            @Override
            public int doIt(int number) {
                base++; // 외부의 상태 값을 변경한다거나, 혹은 같은 인풋에 같은 아웃풋이 보장되지 않는다면 이건 순수함수가 아니다. 따라서 함수형 프로그래밍을 할거면 이걸 조심해야한다.
                return base;
            }
        };
    }
}
