package chap02;

import chap02.AppContext;
import chap02.Greeter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBeanTest {

    @Test
    @DisplayName("getBean 메소드를 통해 빈 객체를 가져올 수 있다")
    void test() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);

        Greeter greeter = ctx.getBean("greeter", Greeter.class);
        greeter.setFormat("Hello, %s!");
        ctx.close();

        assertThat(greeter.greet("spring"))
                .isEqualTo("Hello, spring!");
    }
}
