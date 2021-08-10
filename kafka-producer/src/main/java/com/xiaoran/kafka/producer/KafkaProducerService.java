package com.xiaoran.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author wuxiaoran
 */
@Component
public class KafkaProducerService {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;
  public void sendMessage(String topic, String message) {
    kafkaTemplate.send(topic, message);
  }
}