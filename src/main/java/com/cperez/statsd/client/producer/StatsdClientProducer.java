package com.cperez.statsd.client.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cperez.statsd.errorHandler.LoggingStatsdErrorHandler;
import com.timgroup.statsd.NonBlockingStatsDClient;
import com.timgroup.statsd.StatsDClient;

@Configuration
@ConditionalOnProperty(name = "spring.statsd.enable", matchIfMissing = true)
public class StatsdClientProducer {

	@Value("${spring.statsd.prefix:metrics}")
	private String prefix;
	@Value("${spring.statsd.host:localhost}")
	private String host;
	@Value("${spring.statsd.port:8125}")
	private int port;

	@Bean
	public StatsDClient statsdClient() {
		return new NonBlockingStatsDClient(prefix, host, port, null, new LoggingStatsdErrorHandler());
	}
}