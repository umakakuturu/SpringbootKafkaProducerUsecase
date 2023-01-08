package com.uma.KafkaProducerDemo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uma.KafkaProducerDemo.Producer.KafkaProducerImpl;

@SpringBootApplication
public class KafkaProducerDemoApplication implements ApplicationRunner
{
	@Autowired
	private KafkaProducerImpl kafkaProducerImpl;

	public static void main(String[] args)
	{
		SpringApplication.run(KafkaProducerDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		ArrayList<String> sheetList = getAsheetList();

		for (String sheetName : sheetList)
		{
			kafkaProducerImpl.sendMessage(sheetName);
			System.out.println("Successfully sent the sheetName = '" + sheetName + "' to the uploadsheettopic");
			Thread.sleep(4000);
		}
	}

	private static ArrayList<String> getAsheetList()
	{
		ArrayList<String> sheetList = new ArrayList<String>();
		sheetList.add("hotels");
		sheetList.add("flights");
		sheetList.add("cars");
		sheetList.add("bundle");
		return sheetList;
	}

}
