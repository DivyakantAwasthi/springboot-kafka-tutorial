package com.divyakant.springbootkafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic createnewTopic()
    {
        return TopicBuilder.name("kafkademo")
                .build();
    }

    @Bean
    public NewTopic createnewJsonTopic()
    {
        return TopicBuilder.name("kafkademo-json")
                .build();
    }
}
