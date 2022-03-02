package hyun6ik.corerepeat.infrastructure.order;

import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.member.Member;
import hyun6ik.corerepeat.domain.order.Order;
import hyun6ik.corerepeat.domain.order.OrderService;
import hyun6ik.corerepeat.infrastructure.discount.FixDiscountPolicy;
import hyun6ik.corerepeat.infrastructure.member.MemberRepository;
import hyun6ik.corerepeat.infrastructure.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        var member = memberRepository.findById(memberId);
        var discountPrice = discountPolicy.discount(member, itemPrice);

        return Order.of(memberId, itemName, itemPrice, discountPrice);
    }
}
