package hyun6ik.corerepeat.infrastructure.order;

import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.order.Order;
import hyun6ik.corerepeat.domain.order.OrderService;
import hyun6ik.corerepeat.infrastructure.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

//    // @Autowired 필드 명 매칭
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = rateDiscountPolicy;
//    }

//    // @Qualifier
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        var member = memberRepository.findById(memberId);
        var discountPrice = discountPolicy.discount(member, itemPrice);

        return Order.of(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
