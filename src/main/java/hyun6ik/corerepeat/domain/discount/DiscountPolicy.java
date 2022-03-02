package hyun6ik.corerepeat.domain.discount;

import hyun6ik.corerepeat.domain.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
