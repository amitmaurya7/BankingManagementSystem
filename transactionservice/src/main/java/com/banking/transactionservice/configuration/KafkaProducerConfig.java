package com.banking.transactionservice.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.banking.transactionservice.transactiondto.NotificationEvent;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

	    @Bean
	    public ProducerFactory<String, NotificationEvent> producerFactory() {
	        Map<String, Object> config = new HashMap<>();
	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        config.put(ProducerConfig.ACKS_CONFIG, "all");
	        return new DefaultKafkaProducerFactory<>(config);
	    }

	    @Bean
	    public KafkaTemplate<String, NotificationEvent> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }
	    
	    @Bean
	    public NewTopic createTopic() {
	        return new NewTopic("notification-topic", 1, (short) 1); // topic name, partitions, replication factor
	    }
}
