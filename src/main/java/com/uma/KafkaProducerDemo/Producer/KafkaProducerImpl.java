package com.uma.KafkaProducerDemo.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerImpl
{
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private final static String TOPIC_NAME = "uploadsheettopic";

	public void sendMessage(String sheetName)
	{
		kafkaTemplate.send(TOPIC_NAME, sheetName);
	}
}
