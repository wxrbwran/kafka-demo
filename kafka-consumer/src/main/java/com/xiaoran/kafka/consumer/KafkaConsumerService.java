package com.xiaoran.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author wuxiaoran
 */
@Slf4j
@Component
public class KafkaConsumerService {
  @KafkaListener(groupId = "group02", topics = "topic02")
  public void onMessage(
      ConsumerRecord<String, Object> record,
      Acknowledgment acknowledgment,
      Consumer<?, ?> consumer) {
    log.info("消费端接收消息onMessage record : {}", record.value());
    // 手工签收机制
    acknowledgment.acknowledge();
  }
}
