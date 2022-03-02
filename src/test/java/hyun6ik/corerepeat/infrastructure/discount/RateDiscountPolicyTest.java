package hyun6ik.corerepeat.infrastructure.discount;

import hyun6ik.corerepeat.domain.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_success() {
        //given
        final Member member = Member.of(1L, "membberVIP", Member.Grade.VIP);
        //when
        final int discountPrice = discountPolicy.discount(member, 10000);
        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void basic_success() {
        //given
        final Member member = Member.of(1L, "membberBasic", Member.Grade.BASIC);
        //when
        final int discountPrice = discountPolicy.discount(member, 10000);
        //then
        assertThat(discountPrice).isEqualTo(0);

    }
}