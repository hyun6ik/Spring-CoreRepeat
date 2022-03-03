package hyun6ik.corerepeat.singleton;

import hyun6ik.corerepeat.config.AppConfig;
import hyun6ik.corerepeat.infrastructure.member.MemberRepository;
import hyun6ik.corerepeat.infrastructure.member.MemberServiceImpl;
import hyun6ik.corerepeat.infrastructure.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        final OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        final MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        //when
        final MemberRepository memberRepository1 = memberService.getMemberRepository();
        final MemberRepository memberRepository2 = orderService.getMemberRepository();
        //then
        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository).isSameAs(memberRepository1);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }
}
