package com.caster.rabbitmq.controller;
import com.caster.rabbitmq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 * Author: Minchang Hsu (Caster)
 * Date: 2022/4/18
 * Comment:
 */
@RestController
public class RabbitController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/test/{message}")
	public void test(@PathVariable String message) throws Exception {
		messageService.send(message);
	}

}
