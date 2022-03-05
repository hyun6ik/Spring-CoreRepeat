package hyun6ik.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class PrototypeBeanTest {

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }

    @Test
    void prototypeBeanFind() {
        //given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        //when
        final PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        //then
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }
}
