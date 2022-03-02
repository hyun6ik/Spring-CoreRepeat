package hyun6ik.corerepeat;

import hyun6ik.corerepeat.domain.Member;
import hyun6ik.corerepeat.domain.service.MemberService;
import hyun6ik.corerepeat.infrastructure.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        final Member member = Member.of(1L, "memberA", Member.Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
