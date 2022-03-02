package hyun6ik.corerepeat.infrastructure;

import hyun6ik.corerepeat.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
