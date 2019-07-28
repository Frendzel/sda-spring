package pl.sda.springparent.collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.jms.JokesProducer;
import pl.sda.springparent.mockeddb.MockedDb;
import pl.sda.springparent.repository.MongoConnector;

import static pl.sda.springparent.mapper.ManualJokeMapper.map;

@Service
public class ChuckNorrisJokesCollector {
    @Autowired
    MockedDb mockedDb;

    @Autowired
    MongoConnector mongoConnector;

    @Autowired
    JokesProducer jokesProducer;

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "* * * * * *") // Scheduler
    public void saveJokeFromChuckApi() {
        ResponseEntity<Joke> entity = restTemplate.getForEntity("http://api.icndb.com/jokes/random", Joke.class);
        Joke joke = entity.getBody();
        mockedDb.addJoke(map(joke));
        mongoConnector.saveJoke(joke);
        jokesProducer.populateJoke(joke);

    }

}
