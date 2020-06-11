package com.aws.localstack.sample.client;

import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

@ConditionalOnProperty(name = "aws.debug.localstack", havingValue = "false", matchIfMissing = false)
@Configuration
@EnableJms
public class JmsConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(JmsConfig.class);

	
	@Value("${aws.credentials.profile:default}")
	private String awsCredentialProfile;

	SQSConnectionFactory connectionFactory;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		LOG.info("JmsConfig : Started configuring AWS configs profile: " + awsCredentialProfile);
		
		connectionFactory = SQSConnectionFactory.builder()
				.withRegion(Region.getRegion(Regions.US_EAST_1))
				.withAWSCredentialsProvider(new ProfileCredentialsProvider(awsCredentialProfile)).build();
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(this.connectionFactory);
		factory.setDestinationResolver(new DynamicDestinationResolver());
		factory.setConcurrency("3-10");
		factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		return factory;
	}

	@Bean
	public JmsTemplate defaultJmsTemplate() {
		return new JmsTemplate(this.connectionFactory);
	}
}
