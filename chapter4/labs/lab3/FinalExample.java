package chapter4.labs.lab3;

/**
 * Lab 3: static과 final 키워드 사용하기
 * 
 * final 키워드 예제 클래스
 */
public class FinalExample {
    // TODO: final 변수를 선언하고 초기화하세요.
    private final int count = 0;
    
    // TODO: final 변수를 선언만 하고, 생성자에서 초기화하세요.
    private final String name;
    
    // TODO: 생성자를 정의하세요.
    public FinalExample() {
        // final 변수 초기화
        name = "홍길동";
    }
    
    // TODO: final 메소드를 정의하세요.
    public final void getName() {
        System.out.println("이름: " + name);
    }
    
    // TODO: final 매개변수를 받는 메소드를 정의하세요.
    public void getName2(String name) {
        System.out.println("이름: " + name);
    }
    
    public static void main(String[] args) {
        System.out.println("Final 키워드 예제를 실행합니다.");
        
        // TODO: FinalExample 객체를 생성하세요.
        FinalExample finalExample = new FinalExample();
        
        // TODO: 객체의 메소드를 호출하세요.
        finalExample.getName();
        
        // TODO: final 클래스의 객체를 생성하고 메소드를 호출하세요.
        FinalExample2 finalExample2 = new FinalExample2();
        finalExample2.setCount(1);
        System.out.println("갯수: " + finalExample2.getCount());
        
        // TODO: final 지역 변수를 선언하고 사용하세요.
        final int localVar = 0;
        System.out.println(localVar);
    }
}

// TODO: final 클래스를 정의하세요.
final class FinalExample2 {
    private int count;

    public FinalExample2() {}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

// TODO: 일반 클래스와 하위 클래스를 정의하고, final 메소드 오버라이딩을 시도해보세요.
// 일반 클래스
class Parent {
    // final 메소드
    public final void cannotOverride() {
        System.out.println("이 메소드는 오버라이딩할 수 없습니다.");
    }

    // 일반 메소드
    public void canOverride() {
        System.out.println("Parent: 이 메소드는 오버라이딩 가능합니다.");
    }
}

// 상속 예제
class Child extends Parent {
    // final 메소드 오버라이딩 시도
    // @Override
    // public void cannotOverride() { } // 에러: final 메소드는 오버라이딩 불가

    // 일반 메소드 오버라이딩
    @Override
    public void canOverride() {
        System.out.println("Child: 메소드를 오버라이딩했습니다.");
    }
}