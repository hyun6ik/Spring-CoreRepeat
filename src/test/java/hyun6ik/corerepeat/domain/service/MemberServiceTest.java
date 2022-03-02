package hyun6ik.corerepeat.domain.service;

import hyun6ik.corerepeat.config.AppConfig;
import hyun6ik.corerepeat.domain.member.Member;
import hyun6ik.corerepeat.domain.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void setUp() {
        final AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        final Member member = Member.of(1L, "memberA", Member.Grade.VIP);
        memberService.join(member);
        //when
        final Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(findMember).isEqualTo(member);

    }

}