package com.cxq.observer;

import com.google.common.eventbus.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class ObserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObserverApplication.class, args);
	}

	@Bean
	public EventBus EventBus() {
		return new EventBus();
	}
}
