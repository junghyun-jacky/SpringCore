package hello.core.order;

public interface OrderService {

    // 파라미터 3개를 넘겨서 주문을 생성하면 가공하여 주문 결과를 반환
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
