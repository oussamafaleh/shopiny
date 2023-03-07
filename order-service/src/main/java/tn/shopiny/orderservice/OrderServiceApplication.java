package tn.shopiny.orderservice;

import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.extensions.kafka.eventhandling.KafkaMessageConverter;
import org.axonframework.extensions.kafka.eventhandling.consumer.ConsumerFactory;
import org.axonframework.extensions.kafka.eventhandling.producer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import java.time.Duration;
import java.util.Map;
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class OrderServiceApplication {
    public static final String KAFKA_GROUP = "kafka-group";

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
//@Configuration
//class KafkaEventPublicationConfiguration {
//
//    public ProducerFactory<String, byte[]> producerFactory(Duration closeTimeout,
//                                                           int producerCacheSize,
//                                                           Map<String, Object> producerConfiguration,
//                                                           ConfirmationMode confirmationMode,
//                                                           String transactionIdPrefix) {
//        return DefaultProducerFactory.<String, byte[]>builder()
//                .closeTimeout(closeTimeout)                 // Defaults to "30" seconds
//                .producerCacheSize(producerCacheSize)       // Defaults to "10"; only used for "TRANSACTIONAL" mode
//                .configuration(producerConfiguration)       // Hard requirement
//                .confirmationMode(confirmationMode)         // Defaults to a Confirmation Mode of "NONE"
//                .transactionalIdPrefix(transactionIdPrefix) // Hard requirement when in "TRANSACTIONAL" mode
//                .build();
//    }
//
//    public KafkaPublisher<String, byte[]> kafkaPublisher(String topic,
//                                                         ProducerFactory<String, byte[]> producerFactory,
//                                                         KafkaMessageConverter<String, byte[]> kafkaMessageConverter,
//                                                         int publisherAckTimeout) {
//        return KafkaPublisher.<String, byte[]>builder()
//                .topic("Order")                               // Defaults to "Axon.Events"
//                .producerFactory(producerFactory)           // Hard requirement
//                .messageConverter(kafkaMessageConverter)    // Defaults to a "DefaultKafkaMessageConverter"
//                .publisherAckTimeout(publisherAckTimeout)   // Defaults to "1000" milliseconds; only used for "WAIT_FOR_ACK" mode
//                .build();
//    }
//
//    public KafkaEventPublisher<String, byte[]> kafkaEventPublisher(KafkaPublisher<String, byte[]> kafkaPublisher) {
//        return KafkaEventPublisher.<String, byte[]>builder()
//                .kafkaPublisher(kafkaPublisher)             // Hard requirement
//                .build();
//    }
//
//    public void registerPublisherToEventProcessor(EventProcessingConfigurer eventProcessingConfigurer,
//                                                  KafkaEventPublisher<String, byte[]> kafkaEventPublisher) {
//        String processingGroup = KafkaEventPublisher.DEFAULT_PROCESSING_GROUP;
//        eventProcessingConfigurer.registerEventHandler(configuration -> kafkaEventPublisher)
//                .assignHandlerTypesMatching(
//                        processingGroup,
//                        clazz -> clazz.isAssignableFrom(KafkaEventPublisher.class)
//                )
//                .registerSubscribingEventProcessor(processingGroup);
//        // Replace `registerSubscribingEventProcessor` for `registerTrackingEventProcessor` to use a tracking processor
//    }
//}
//public class KafkaEventConsumptionConfiguration {
//    // ...
//    public ConsumerFactory<String, byte[]> consumerFactory(Map<String, Object> consumerConfiguration) {
//        return new DefaultConsumerFactory<>(consumerConfiguration);
//    }
//    // ...
//}
//
