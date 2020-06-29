package com.aws.localstack.sample.client.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.aws.localstack.sample.client.model.SNSResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class SQSListenerService {
	
	private static final Logger LOG = LoggerFactory.getLogger(SQSListenerService.class);
	public static List<SNSResponseModel> messges = new ArrayList<>();

	
	@JmsListener(destination = "${aws.sqs.queuename:test_queue}")
	public void sqlListener(String json) {
		LOG.info("AWS SQS/LocalStack sent message : "+ json);
	}
	
	@JmsListener(destination = "${aws.sqs.sns.subscribe.queuename}")
	public void snsListener(String json) throws JsonMappingException, JsonProcessingException {
		LOG.info("AWS SNS/LocalStack sent message : "+ json);
//		ObjectMapper mapper = new ObjectMapper();
//		SNSResponseModel readValue = mapper.readValue(json, SNSResponseModel.class);
//		mapper.readValue
		
		Gson gson = new Gson();
		SNSResponseModel fromJson = gson.fromJson(json, SNSResponseModel.class);
		
		messges.add(fromJson);
	}
}
