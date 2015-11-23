package tv.tweek.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String message){
		rabbitTemplate.convertAndSend("tweekQueue", message);
	}

}
