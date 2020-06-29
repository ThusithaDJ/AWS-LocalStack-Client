package com.aws.localstack.sample.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SNSResponseModel {

	private String MessageId;
	String Type;
	String Message;
	
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		this.Type = type;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		this.Message = message;
	}
	public String getMessageId() {
		return MessageId;
	}
	public void setMessageId(String messageId) {
		this.MessageId = messageId;
	}
}
