package com.aws.localstack.sample.client.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

@RestController
@RequestMapping(path = "v1/api/aws/sqs/")
public class AWSController {

//	@GetMapping(path = "/")
//	public void getSQSMessages() {
//		System.out.println("GET SQS");
//		
//		String localstackRegion = "temp";
//		String localstackSQSEndpointURL = "http://localhost:4576";
//
//		EndpointConfiguration endpointConfiguration = new EndpointConfiguration(localstackSQSEndpointURL,
//				localstackRegion);
//		
//		final AmazonSQS sqs = AmazonSQSClientBuilder.standard().withEndpointConfiguration(endpointConfiguration).build();
//		
//		List<String> queueUrls = sqs.listQueues().getQueueUrls();
//		for (String string : queueUrls) {
//			System.out.println("SQS queue : "+string);
//		}
//		
//		while (true) {
//			
//			
////			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withEndpointConfiguration(endpointConfiguration)
////					.enablePathStyleAccess().build();
//			
//			
//			final ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest("http://localhost:4576/queue/test_queue")
//					.withMaxNumberOfMessages(1).withWaitTimeSeconds(3);
//			final List<Message> messages = sqs.receiveMessage(receiveMessageRequest)
//					.getMessages();
//			
//			for (Message message : messages) {
//				System.out.println(message.getBody());
//			}
//		}
//
//	}
}
