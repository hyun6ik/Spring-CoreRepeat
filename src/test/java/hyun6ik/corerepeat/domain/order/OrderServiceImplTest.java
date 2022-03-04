package hyun6ik.corerepeat.domain.order;

import hyun6ik.corerepeat.domain.member.Member;
import hyun6ik.corerepeat.infrastructure.discount.FixDiscountPolicy;
import hyun6ik.corerepeat.infrastructure.member.MemoryMemberRepository;
import hyun6ik.corerepeat.infrastructure.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        //given
        final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(Member.of(1L, "memberA", Member.Grade.VIP));
        final OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        //when
        final Order order = orderService.createOrder(1L, "itemA", 1000);
        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
