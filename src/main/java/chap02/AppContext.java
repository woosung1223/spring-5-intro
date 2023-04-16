package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {

    @Bean
    public Greeter greeter() {
        return new Greeter();
    }

    @Bean
    @Scope("prototype")
    public Greeter greeterPrototype() {
        return new Greeter();
    }
}
