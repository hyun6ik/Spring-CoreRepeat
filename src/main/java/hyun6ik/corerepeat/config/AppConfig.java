package hyun6ik.corerepeat.config;

import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.member.MemberService;
import hyun6ik.corerepeat.domain.order.OrderService;
import hyun6ik.corerepeat.infrastructure.discount.RateDiscountPolicy;
import hyun6ik.corerepeat.infrastructure.member.MemberRepository;
import hyun6ik.corerepeat.infrastructure.member.MemberServiceImpl;
import hyun6ik.corerepeat.infrastructure.member.MemoryMemberRepository;
import hyun6ik.corerepeat.infrastructure.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()


    @Bean
    public MemberService memberService() {
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
