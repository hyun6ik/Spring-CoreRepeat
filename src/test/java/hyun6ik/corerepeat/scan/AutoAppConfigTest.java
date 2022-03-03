package hyun6ik.corerepeat.scan;

import hyun6ik.corerepeat.config.AutoAppConfig;
import hyun6ik.corerepeat.domain.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //when
        final MemberService memberService = ac.getBean("memberServiceImpl",MemberService.class);
        //then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
