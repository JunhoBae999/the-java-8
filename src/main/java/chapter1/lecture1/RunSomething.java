package main.java.chapter1.lecture1;

@FunctionalInterface // 얘가 컴파일할때 에러를 잡아줌
public interface RunSomething {
    abstract void doIt(); //인터페이스에 추상 메서드가 하나만 있으면 함수형 인터페이스다. 두개 있으면 안됨.

//    void doAgain();

    //아래 애들이 있어도 상관 없음. abstract method의 개수만 중요함.
    static void printName() {
        System.out.println("junho");
    }

    default void printAge() {
        System.out.println("27");
    }
}
