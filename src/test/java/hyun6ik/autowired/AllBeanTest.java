package hyun6ik.autowired;

import hyun6ik.corerepeat.config.AutoAppConfig;
import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    static class DiscountService {
        private final Map<String , DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            final DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
    
    @Test
    void findAllBean_fixDiscountPolicy() {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        final DiscountService discountService = ac.getBean(DiscountService.class);
        final Member member = Member.of(1L, "userA", Member.Grade.VIP);
        //when
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        //then
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    void findAllBean_rateDiscountPolicy() {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        final DiscountService discountService = ac.getBean(DiscountService.class);
        final Member member = Member.of(1L, "userA", Member.Grade.VIP);
        //when
        int discountPrice = discountService.discount(member, 10000, "rateDiscountPolicy");
        //then
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }
}
