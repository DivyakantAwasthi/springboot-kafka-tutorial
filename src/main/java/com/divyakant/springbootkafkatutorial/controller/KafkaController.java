package com.divyakant.springbootkafkatutorial.controller;

import com.divyakant.springbootkafkatutorial.kafka.JsonKafkaProducerService;
import com.divyakant.springbootkafkatutorial.kafka.KafkaProducerService;
import com.divyakant.springbootkafkatutorial.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Autowired
    JsonKafkaProducerService jsonKafkaProducerService;

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message)
    {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonMessage(@RequestBody User user)
    {
        jsonKafkaProducerService.sendMessage(user);
        return ResponseEntity.ok("Json Message sent successfully");
    }
}
