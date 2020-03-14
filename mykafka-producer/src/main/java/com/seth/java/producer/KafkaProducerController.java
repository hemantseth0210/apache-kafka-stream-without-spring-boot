/**
 * 
 */
package com.seth.java.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heseth
 *
 */
@RestController
public class KafkaProducerController {
	
	@RequestMapping("/sendMessages/{message}")
	public String sendMessages(@PathVariable("message") String message) {
	 
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092");
	    props.put("acks", "all");
	    props.put("key.serializer", 
	    		"org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", 
	    		"org.apache.kafka.common.serialization.StringSerializer");
	    Producer<String, String> producer = new KafkaProducer<>(props);
	    producer.send(
	    		new ProducerRecord<String, String>("kafka-streams-input-topic", null, message));
	    producer.close();
	    return "Message has been sent";
	}
}
