package hyun6ik.corerepeat.infrastructure.member;

import hyun6ik.corerepeat.domain.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
