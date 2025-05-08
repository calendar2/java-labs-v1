package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * Book 클래스를 정의하세요.
 * 이 클래스는 Buyable 인터페이스를 구현합니다.
 */
public class Book implements Buyable {
    // TODO: 책의 속성 정의 (예: 제목, 가격, 저자)
    String title;
    String author;
    int price;
    
    // TODO: 생성자 정의
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // TODO: Buyable 인터페이스의 메소드 구현
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public void getInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 가격: " + price + "원");
    }

    // TODO: 책만의 고유한 메소드 추가
    
} 