package pl.sda.springparent.jms;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dto.Joke;

@Component
public class JokesProducer {

    @Autowired
    JmsTemplate jmsTemplate;
    private Gson gson = new Gson();

    public void populateJoke(Joke joke) {
        jmsTemplate.send("jokes", c -> c.createTextMessage(gson.toJson(joke)));
    }
}
