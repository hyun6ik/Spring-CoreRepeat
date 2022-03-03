package hyun6ik.corerepeat.singleton;

import hyun6ik.corerepeat.config.AppConfig;
import hyun6ik.corerepeat.domain.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        final AppConfig appConfig = new AppConfig();
        // 1. 조회: 호출할 때마다 객체를 생성
        final MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때마다 객체를 생성
        final MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        //given && when
        final SingletonService singletonService1 = SingletonService.getInstance();
        final SingletonService singletonService2 = SingletonService.getInstance();
        //then
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}
