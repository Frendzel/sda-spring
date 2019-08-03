package pl.sda.springparent.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;
import pl.sda.springparent.exception.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("online")
public class MongoConnectorTest {

    @Autowired
    MongoConnector mongoConnector;

    //negatywny scenariusz
    @Test(expected = ValidationException.class)
    public void saveJoke() {
        mongoConnector.saveJoke(null);
    }

    //negatywny scenariusz
    @Test(expected = ValidationException.class)
    public void findJoke() {
        mongoConnector.findJoke(null);
    }

    //pozytywy scenariusz
    @Test
    public void findJokePositive() {
        Joke joke = mongoConnector.findJoke(Joke.builder().value(
                JokeValue.builder().id(100).build())
                .build());
        System.out.println(joke);
    }
}