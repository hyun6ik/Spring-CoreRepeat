package hyun6ik.corerepeat.domain.order;

import hyun6ik.corerepeat.domain.member.Member;
import hyun6ik.corerepeat.domain.member.MemberService;
import hyun6ik.corerepeat.infrastructure.member.MemberServiceImpl;
import hyun6ik.corerepeat.infrastructure.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        final Member member = Member.of(memberId, "memberA", Member.Grade.VIP);
        memberService.join(member);
        //when
        final Order order = orderService.createOrder(memberId, "itemA", 10000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}