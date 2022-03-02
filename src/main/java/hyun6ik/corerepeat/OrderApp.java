package hyun6ik.corerepeat;

import hyun6ik.corerepeat.domain.member.Member;
import hyun6ik.corerepeat.domain.member.MemberService;
import hyun6ik.corerepeat.domain.order.Order;
import hyun6ik.corerepeat.domain.order.OrderService;
import hyun6ik.corerepeat.infrastructure.member.MemberServiceImpl;
import hyun6ik.corerepeat.infrastructure.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        final Member member = Member.of(memberId, "memberA", Member.Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
