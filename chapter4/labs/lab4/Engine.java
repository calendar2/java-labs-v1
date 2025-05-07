package chapter4.labs.lab4;

/**
 * Lab 4: 접근 제한자와 객체 간 관계 구현하기
 * 
 * Engine 클래스 정의하기
 */
public class Engine {
    // TODO: 적절한 접근 제한자를 사용하여 필드를 정의하세요.
    // (엔진 타입, 마력, 작동 상태 등)
    private String engineType;
    private int power;
    private String status;
    
    // TODO: 생성자를 정의하세요.
    public Engine(String engineType, int power) {
        this.engineType = engineType;
        this.power = power;
    }
    
    // TODO: 엔진을 시작하는 메소드를 정의하세요.
    public void startEngine() {
        System.out.println("엔진 시작!");
    }
    
    // TODO: 엔진을 정지하는 메소드를 정의하세요.
    public void stopEngine() {
        System.out.println("엔진 정지!");
    }
    
    // TODO: 엔진의 상태를 확인하는 메소드를 정의하세요.
    public void checkStatus() {
        System.out.println(status);
    }
    
    // TODO: 엔진의 정보를 출력하는 메소드를 정의하세요.
    public void engineInfo() {
        System.out.println("엔진 타입: " + engineType + ", 마력: " + power + ", 상태: " + status);
    }
    
    // TODO: 필요한 getter/setter 메소드를 정의하세요.
    public String getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}