package hyun6ik.corerepeat.config;

import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.member.MemberService;
import hyun6ik.corerepeat.domain.order.OrderService;
import hyun6ik.corerepeat.infrastructure.discount.FixDiscountPolicy;
import hyun6ik.corerepeat.infrastructure.member.MemberRepository;
import hyun6ik.corerepeat.infrastructure.member.MemberServiceImpl;
import hyun6ik.corerepeat.infrastructure.member.MemoryMemberRepository;
import hyun6ik.corerepeat.infrastructure.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
