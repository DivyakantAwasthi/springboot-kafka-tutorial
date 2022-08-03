package com.divyakant.springbootkafkatutorial.kafka;

import com.divyakant.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "kafkademo",groupId = "myGroup")
    public void consume(String message)
    {
        LOGGER.info(String.format("Message consumed -> %s",message));
    }

    @KafkaListener(topics = "kafkademo-json",groupId = "myGroup")
    public void consumeJson(User user)
    {
        LOGGER.info(String.format("Json message consumed -> %s",user.toString()));
    }
}
