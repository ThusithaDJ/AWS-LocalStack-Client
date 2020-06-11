package com.aws.localstack.sample.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class SQSListenerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SQSListenerService.class);

	
	@JmsListener(destination = "${aws.sqs.queuename:test_queue}")
	public void sqlListener(String json) {
		LOG.info("AWS SQS/LocalStack sent message : "+json);
	}
}
