package com.divyakant.springbootkafkatutorial.kafka;

import com.divyakant.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String,User> kafkaTemplate;

    public void sendMessage(User user)
    {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"kafkademo-json")
                .build();

        kafkaTemplate.send(message);

        LOGGER.info(String.format("Json message sent --> %s",user.toString()));
    }
}
