package pl.sda.springparent.mockeddb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dao.JokeEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class MockedDb {
    Map<Integer, JokeEntity> db = new ConcurrentHashMap<>();

    public JokeEntity getJoke(Integer id) {
        return db.get(id);
    }

    public void addJoke(JokeEntity joke) {
        Integer counter = counter();
        db.putIfAbsent(counter, joke);
        log.info("Joke has been saved: {} with id: {}", joke, counter);
    }

    private synchronized Integer counter() {
        return db.size() + 1;
    }

}
