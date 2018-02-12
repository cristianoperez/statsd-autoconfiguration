package com.cperez.statsd.errorHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.timgroup.statsd.StatsDClientErrorHandler;

public class LoggingStatsdErrorHandler implements StatsDClientErrorHandler {

	private static final Logger log = LoggerFactory.getLogger(LoggingStatsdErrorHandler.class);

	@Override
	public void handle(Exception e) {
		log.error("Failed to write metric. Exception: " + e.getClass() + ", message: " + e.getMessage());
	}

}