package hyun6ik.corerepeat.beanfind;

import hyun6ik.corerepeat.config.AppConfig;
import hyun6ik.corerepeat.domain.member.MemberService;
import hyun6ik.corerepeat.infrastructure.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        //given && when
        final MemberService memberService = ac.getBean("memberService", MemberService.class);
        //then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        //given && when
        final MemberService memberService = ac.getBean(MemberService.class);
        //then
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        //given && when
        final MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByName_fail() {
        //given && then
        assertThatThrownBy(() -> ac.getBean("xxxx", MemberService.class))
                .isInstanceOf(NoSuchBeanDefinitionException.class);

    }
}
