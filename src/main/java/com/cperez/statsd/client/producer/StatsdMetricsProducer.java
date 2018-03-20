package com.cperez.statsd.client.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpointMetricReader;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cperez.statsd.metrics.StatsdMetricWriter;
import com.timgroup.statsd.StatsDClient;

@Configuration
@ConditionalOnProperty(name = "spring.statsd.metrics", matchIfMissing = true, havingValue = "true")
public class StatsdMetricsProducer {

	@Autowired
	private StatsDClient statsdClient;

	@Bean
	public MetricsEndpointMetricReader metricsEndpointMetricReader(final MetricsEndpoint metricsEndpoint) {
		return new MetricsEndpointMetricReader(metricsEndpoint);
	}

	@Bean
	@ExportMetricWriter
	public MetricWriter metricWriter() {
		return new StatsdMetricWriter(statsdClient);
	}

}