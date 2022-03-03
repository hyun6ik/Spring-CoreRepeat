package hyun6ik.corerepeat.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

public class StatefulServiceTest {

    static class TestConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


    @Test
    void statefulServiceSingleton() {
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        final StatefulService statefulService1 = ac.getBean(StatefulService.class);
        final StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A : A사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // Thread B : B사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // Thread A : 사용자A 주문 금액 조회
        final int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isNotEqualTo(10000);
    }
}
