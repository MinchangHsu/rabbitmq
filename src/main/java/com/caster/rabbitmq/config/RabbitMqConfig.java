package com.caster.rabbitmq.config;

import com.caster.rabbitmq.listener.Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Minchang Hsu (Caster)
 * Date: 2022/4/18
 * Comment:
 */
@Configuration
public class RabbitMqConfig {

	public static final String TOPIC_EXCHANGE_NAME = "demo-exchange";

	public static final String QUEUE_NAME = "demo-queue";

	public static final String ROUTING_KEY = "demo-routing-key";

	/**
	 * 聲明隊列
	 * public Queue(String name, boolean durable, boolean exclusive, boolean autoDelete) {
	 *         this(name, durable, exclusive, autoDelete, (Map)null);
	 *     }
	 * String name: 隊列名
	 * boolean durable: 持久化消息隊列，rabbitmq 重啟的時候不需要創建新的隊列，默認為 true
	 * boolean exclusive: 表示該消息隊列是否只在當前的connection生效，默認為 false
	 * boolean autoDelete: 表示消息隊列在沒有使用時將自動被刪除，默認為 false
	 **/
	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE_NAME);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

}
