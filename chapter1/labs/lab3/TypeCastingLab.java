package chapter1.labs.lab3;

/**
 * Lab 3: 자바 타입 변환(Type Casting) 실습
 * 
 * 이 실습은 자바의 타입 변환에 대해 이해하고 실습하는 것을 목표로 합니다.
 */
public class TypeCastingLab {
    public static void main(String[] args) {
        // TODO: 1. 자동 형변환(Implicit Casting) 예제
        // byte -> int, int -> long, long -> float, float -> double 순으로 
        // 변수를 선언하고 자동 형변환을 수행한 뒤 결과 출력하기
        byte a = 10;
        int b = a;
        long c = b;
        float d = c;
        double f = d;
        System.out.println(f);
        
        // TODO: 2. 명시적 형변환(Explicit Casting) 예제
        // double -> float -> long -> int -> char -> short -> byte 순으로
        // 변수를 선언하고 명시적 형변환을 수행한 뒤 결과 출력하기
        f = 12.5432;
        d = (float) f;
        c = (long) d;
        b = (int) c;
        char g = (char) b;
        short h = (short) g;
        a = (byte) h;
        System.out.println(a);
        
        // TODO: 3. 데이터 손실 확인하기
        // int 값을 byte로 변환하여 데이터 손실이 발생하는 예제 작성하기
        b = 3000;
        a = (byte) b;
        System.out.println(a);
        
        // TODO: 4. 문자열과 숫자 간 변환하기
        // 문자열 "123"을 정수로, "3.14"를 실수로 변환하기
        String ex1 = "123";
        String ex2 = "3.14";
        int ex1_change = Integer.parseInt(ex1);
        double ex2_change = Double.parseDouble(ex2);
        System.out.println("ex1_change = " + ex1_change);
        System.out.println("ex2_change = " + ex2_change);
        
        // TODO: 5. 숫자를 문자열로 변환하기
        // 정수 456과 실수 7.89를 문자열로 변환하기
        int ex3 = 456;
        double ex4 = 7.89;
        String ex3_change = "" + ex3;
        String ex4_change = "" + ex4;
        System.out.println("ex3_change = " + ex3_change);
        System.out.println("ex4_change = " + ex4_change);
    }
} 