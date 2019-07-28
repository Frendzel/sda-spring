package pl.sda.springparent.jms;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dto.Joke;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
@Slf4j
public class JokesConsumer {
    private Gson gson = new Gson();

    @JmsListener(destination = "jokes")
    public void consumeJoke(Message message) {
        try {
            Joke joke = gson.fromJson(((ActiveMQTextMessage) message).getText(), Joke.class);
            log.info("consumed joke: {}", joke);
        } catch (JMSException e) {
            log.error(e.getMessage());
        }
    }
}
