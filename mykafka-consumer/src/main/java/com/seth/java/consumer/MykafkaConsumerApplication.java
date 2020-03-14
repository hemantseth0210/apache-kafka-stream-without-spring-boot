package com.seth.java.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MykafkaConsumerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MykafkaConsumerApplication.class, args);
		String bootstrapAddress = "localhost:9092";
		String outputTopic = "kafka-streams-output-topic";
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", bootstrapAddress);
		props.setProperty("group.id", "mykafkagroup");
		props.setProperty("enable.auto.commit", "true");
		props.setProperty("auto.commit.interval.ms", "1000");
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
		KafkaConsumer<String, Long> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(outputTopic));
		while (true) {
		  ConsumerRecords<String, Long> records = consumer.poll(Duration.ofMillis(100));
		  for (ConsumerRecord<String, Long> record : records)
		    System.out.printf("word = %s, count = %s%n", record.key(), record.value());
		}
	}

}
