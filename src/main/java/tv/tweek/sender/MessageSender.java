package tv.tweek.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendMessage(Queue queue, String message){
		rabbitTemplate.convertAndSend(queue.getName(), message);
	}

}
