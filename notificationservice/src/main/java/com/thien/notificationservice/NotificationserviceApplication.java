package com.thien.notificationservice;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import com.fasterxml.jackson.annotation.JsonAlias;

@SpringBootApplication
public class NotificationserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationserviceApplication.class, args);
	}

	@Bean
	JsonMessageConverter converter() { // giúp convert event đọc từ kafka chuyển sang đúng dạng MessageDTO của server
		return new JsonMessageConverter();
	}
}
