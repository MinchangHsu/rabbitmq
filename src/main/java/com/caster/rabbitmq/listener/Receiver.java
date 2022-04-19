package com.caster.rabbitmq.listener;
import com.caster.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
/**
 * Author: Minchang Hsu (Caster)
 * Date: 2022/4/18
 * Comment:
 */

@Component
public class Receiver {

	@RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
	public void receiveMessage(String message) {
		System.out.println("Received message:" + message);
	}

}
