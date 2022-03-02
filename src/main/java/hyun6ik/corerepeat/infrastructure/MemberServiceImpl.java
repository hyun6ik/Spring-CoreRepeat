package hyun6ik.corerepeat.infrastructure;

import hyun6ik.corerepeat.domain.Member;
import hyun6ik.corerepeat.domain.service.MemberService;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
