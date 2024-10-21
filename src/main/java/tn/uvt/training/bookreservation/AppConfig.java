package tn.uvt.training.bookreservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackages = "tn.uvt.training.bookreservation.controller")
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
