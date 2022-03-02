package hyun6ik.corerepeat;

import hyun6ik.corerepeat.config.AppConfig;
import hyun6ik.corerepeat.domain.member.Member;
import hyun6ik.corerepeat.domain.member.MemberService;

public class MemberApp {

    public static void main(String[] args) {
        final AppConfig appConfig = new AppConfig();
        final MemberService memberService = appConfig.memberService();

        final Member member = Member.of(1L, "memberA", Member.Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
