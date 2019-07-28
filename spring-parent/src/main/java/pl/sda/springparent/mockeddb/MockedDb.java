package pl.sda.springparent.mockeddb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.exception.ValidationException;
import pl.sda.springparent.repository.DbApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
@Profile("mocked") // profile aplikacji
public class MockedDb implements DbApi {
    Map<Integer, JokeEntity> db = new ConcurrentHashMap<>();

    @Override
    public List<JokeEntity> getJokes() {
        return new ArrayList<>(db.values());
    }

    @Override
    public JokeEntity getJoke(Integer id) {
        Map.Entry<Integer, JokeEntity> joke = db.entrySet()
                .stream()
                .filter(e -> e.getValue().getExternalId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ValidationException("No joke"));
        return joke.getValue();
    }

    @Override
    public void addJoke(JokeEntity joke) {
        Integer counter = counter();
        joke.setId(counter);
        db.putIfAbsent(counter, joke);
        log.info("Joke has been saved: {} with id: {}", joke, counter);
    }

    public void deleteJoke(Integer id) {
        Map.Entry<Integer, JokeEntity> joke = db.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getExternalId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ValidationException("Couldn't find any joke 💩"));
        db.remove(joke.getKey());
    }

    @Override
    public void updateJoke(Integer id, JokeEntity entity) {
        Map.Entry<Integer, JokeEntity> jokeToUpdate = db.entrySet().stream()
                .filter(e -> e.getValue().getExternalId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ValidationException("no joke"));
        jokeToUpdate.setValue(entity);
    }

    private synchronized Integer counter() {
        return db.size() + 1;
    }

}
