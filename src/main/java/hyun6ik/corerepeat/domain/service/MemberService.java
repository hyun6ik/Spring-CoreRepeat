package hyun6ik.corerepeat.domain.service;

import hyun6ik.corerepeat.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
