package chapter5.labs.lab3;

/**
 * Lab 3: 인터페이스 활용하기
 * 
 * 인터페이스 구현과 다형성을 테스트하는 클래스입니다.
 */
public class ShopTest {
    public static void main(String[] args) {
        System.out.println("Lab 3: 인터페이스 활용하기 실습");
        
        // TODO: Book 객체 생성
        Buyable book = new Book("해리포터", "조앤롤링", 10000);
        
        // TODO: Electronics 객체 생성
        Buyable electronics = new Electronics("갤럭시S", 20000, "삼성");
        
        // TODO: DiscountedBook 객체 생성
        Buyable discountedBook = new DiscountedBook("아기돼지 삼형제", "홍길동", 5000, 0.1);
        
        // TODO: ShoppingCart 객체 생성
        ShoppingCart cart = new ShoppingCart();
        
        // TODO: 장바구니에 상품 추가하기
        cart.addGoods(book);
        cart.addGoods(electronics);
        cart.addGoods(discountedBook);
        
        // TODO: 장바구니 내용과 총액 출력하기
        cart.cartListInfo();
        System.out.println("장바구니 총액: " + cart.totalPrice() + "원");
        
        // TODO: 인터페이스를 활용한 다형성 테스트
        //       - Buyable 타입 배열에 다양한 상품 담기
        Buyable[] buyables = new Buyable[3];
        buyables[0] = book;
        buyables[1] = electronics;
        buyables[2] = discountedBook;

        //       - 모든 상품의 정보 출력하기
        for (Buyable buyable : buyables) {
            buyable.getInfo();
        }
        
        // TODO: Discountable 인터페이스를 구현한 객체만 별도로 처리하기
        for (Buyable buyable : buyables) {
            if (buyable instanceof Discountable) {
                buyable.getInfo();
            }
        }
    }
} 