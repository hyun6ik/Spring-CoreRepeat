package hyun6ik.corerepeat.domain.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
