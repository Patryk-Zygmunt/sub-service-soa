package agh.givealift.subs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {


    @Bean
    public String notificationKey() {
        String key = System.getenv("notification.key");
        return key;
    }

}
