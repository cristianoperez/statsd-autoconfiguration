package com.cperez.statsd.client.producer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.timgroup.statsd.NoOpStatsDClient;
import com.timgroup.statsd.StatsDClient;

@ConditionalOnProperty(name = "spring.statsd.enable", havingValue = "false")
@Configuration
public class LoggingStatsdClientProducer {

	@Bean
	public StatsDClient statsDClient() {
		return new NoOpStatsDClient();
	}
}
