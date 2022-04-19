package com.caster.rabbitmq.service;
import com.caster.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
/**
 * Author: Minchang Hsu (Caster)
 * Date: 2022/4/18
 * Comment:
 */
@Service
public class MessageService {

	private final RabbitTemplate rabbitTemplate;

	public MessageService(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(String message) throws Exception {
		System.out.println("Sending message:" + message);
		/**
		 * public void convertAndSend(String exchange,
		 * 		String routingKey,
		 * 		Object message,
		 * 		MessagePostProcessor messagePostProcessor,
		 * 		@Nullable CorrelationData correlationData) throws AmqpException
		 * exchange: 路由
		 * routingKey: 綁定key
		 * message: 消息體
		 * messagePostProcessor: 消息屬性處理器
		 * correlationData: 表示當前消息唯一性
		 */
		rabbitTemplate.convertAndSend(RabbitMqConfig.TOPIC_EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, message);
	}
}
