package com.cperez.statsd.client.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
import org.springframework.boot.actuate.metrics.statsd.StatsdMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.statsd.metrics", matchIfMissing = true, havingValue = "true")
public class StatsdMetricsProducer {

	@Value("${spring.statsd.prefix:metrics}")
	private String prefix;
	@Value("${spring.statsd.host:localhost}")
	private String host;
	@Value("${spring.statsd.port:8125}")
	private int port;

	@Bean
	public MetricsEndpointMetricReader metricsEndpointMetricReader(final MetricsEndpoint metricsEndpoint) {
		return new MetricsEndpointMetricReader(metricsEndpoint);
	}

	@Bean
	@ExportMetricWriter
	public MetricWriter metricWriter() {
		return new StatsdMetricWriter(prefix, host, port);
	}

}