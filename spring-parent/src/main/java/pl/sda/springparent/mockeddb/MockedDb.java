package pl.sda.springparent.mockeddb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.repository.DbApi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@Profile("mocked") // profile aplikacji
public class MockedDb implements DbApi {
    Map<Integer, JokeEntity> db = new ConcurrentHashMap<>();

    @Override
    public JokeEntity getJoke(Integer id) {
        return db.get(id);
    }

    @Override
    public void addJoke(JokeEntity joke) {
        Integer counter = counter();
        joke.setId(counter);
        db.putIfAbsent(counter, joke);
        log.info("Joke has been saved: {} with id: {}", joke, counter);
    }

    private synchronized Integer counter() {
        return db.size() + 1;
    }

}
