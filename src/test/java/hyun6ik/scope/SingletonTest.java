package hyun6ik.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    static class SingletonBean{
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");;
        }
    }

    @Test
    void singletonBeanFind() {
        //given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
        //when
        final SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        final SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        //then
        assertThat(singletonBean1).isSameAs(singletonBean2);
        ac.close();
    }
}
