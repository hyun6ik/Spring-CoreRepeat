package hyun6ik.corerepeat.infrastructure.discount;

import hyun6ik.corerepeat.domain.discount.DiscountPolicy;
import hyun6ik.corerepeat.domain.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private static int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Member.Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
