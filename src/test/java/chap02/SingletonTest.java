package chap02;

import chap02.AppContext;
import chap02.Greeter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonTest {

    @Test
    @DisplayName("빈 객체는 기본적으로 싱글톤이다")
    void testSingleton() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);

        Greeter greeter1 = ctx.getBean("greeter", Greeter.class);
        Greeter greeter2 = ctx.getBean("greeter", Greeter.class);
        ctx.close();

        assertSame(greeter1, greeter2);
    }

    @Test
    @DisplayName("프로토타입 빈은 싱글톤이 아니다")
    void testPrototype() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppContext.class);

        Greeter greeter1 = ctx.getBean("greeterPrototype", Greeter.class);
        Greeter greeter2 = ctx.getBean("greeterPrototype", Greeter.class);
        ctx.close();

        assertNotSame(greeter1, greeter2);
    }
}
