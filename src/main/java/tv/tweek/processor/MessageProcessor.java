package tv.tweek.processor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {

	@RabbitListener(queues="tweekQueue")
	public void processMessage(String content) {
		try {
			Thread.sleep(500);
			System.err.println("=============================");
			System.err.println(content);
			System.err.println("=============================");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
