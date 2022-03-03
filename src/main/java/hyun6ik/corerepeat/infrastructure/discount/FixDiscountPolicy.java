package hyun6ik.corerepeat.infrastructure.discount;

import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.member.Member;
import org.springframework.stereotype.Component;

public class FixDiscountPolicy implements DiscountPolicy {

    private static int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Member.Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
