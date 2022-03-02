package hyun6ik.corerepeat.domain.service;

import hyun6ik.corerepeat.domain.Member;
import hyun6ik.corerepeat.infrastructure.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

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