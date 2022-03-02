package hyun6ik.corerepeat.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public static Order of(Long memberId, String itemName, int itemPrice, int discountPrice) {
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

}
