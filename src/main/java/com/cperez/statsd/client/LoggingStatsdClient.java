package com.cperez.statsd.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.timgroup.statsd.ConvenienceMethodProvidingStatsDClient;

public class LoggingStatsdClient extends ConvenienceMethodProvidingStatsDClient {

	private static final Logger log = LoggerFactory.getLogger(LoggingStatsdClient.class);

	@Override
	public void stop() {
	}

	@Override
	public void count(String aspect, long delta, double sampleRate) {
		log.debug("count.{}:{}|c|@{}", aspect, sampleRate, delta);
	}

	@Override
	public void recordGaugeValue(String aspect, long value) {
		log.debug("gauge.{}:{}|g", aspect, value);
	}

	@Override
	public void recordGaugeValue(String aspect, double value) {
		log.debug("gauge.{}:{}|g", aspect, value);
	}

	@Override
	public void recordGaugeDelta(String aspect, long delta) {
		log.debug("gauge.{}:{}|g", aspect, delta);
	}

	@Override
	public void recordGaugeDelta(String aspect, double delta) {
		log.debug("gauge.{}:{}|g", aspect, delta);
	}

	@Override
	public void recordSetEvent(String aspect, String eventName) {
		log.debug("sets.{}:{}|s", aspect, eventName);
	}

	@Override
	public void recordExecutionTime(String aspect, long timeInMs, double sampleRate) {
		log.debug("timing.{}:{}|ms|@{}", aspect, timeInMs, sampleRate);
	}

}
