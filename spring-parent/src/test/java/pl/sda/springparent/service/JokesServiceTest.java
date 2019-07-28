package pl.sda.springparent.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JokesServiceTest {
    private static final Integer RANDOM_ID = Double.valueOf(Math.random()*100+3).intValue();
    @Autowired
    JokesService jokesService;

    @Before
    public void init() {
        jokesService.addJoke(Joke.builder()
                .value(JokeValue.builder()
                        .joke("Joke 1")
                        .id(1)
                        .categories(new String[]{"SUCCESS"})
                        .build())
                .build());
        jokesService.addJoke(Joke.builder()
                .value(JokeValue.builder()
                        .joke("Joke 2")
                        .id(2)
                        .categories(new String[]{})
                        .build())
                .build());
        jokesService.addJoke(Joke.builder()
                .value(JokeValue.builder()
                        .joke("Joke 3")
                        .id(3)
                        .categories(new String[]{"FAILURE"})
                        .build())
                .build());
        log.info("Init db completed");
    }

    @Test
    public void getJokes() throws InterruptedException {
        // GIVEN
        // wait to fill the data
        Thread.sleep(2000); //
        // WHEN
        List<Joke> jokes = jokesService.getJokes();
        // THEN
        Assert.assertTrue(jokes.size() > 0);

    }

    @Test
    public void getJoke() {
        //when
        Joke joke = jokesService.getJoke(1);
        //then
        Assert.assertTrue(joke != null);
    }

    @Test
    public void addJoke() {
        //given
        Joke joke = Joke.builder()
                .value(JokeValue.builder()
                        .id(RANDOM_ID)
                        .categories(new String[]{})
                        .build())
                .build();
        //when
        jokesService.addJoke(joke);
        //then
        Assert.assertEquals(joke, jokesService.getJoke(5));

    }

    @Test//(expected = RuntimeException.class)
    public void deleteJoke() {
        //given
        Joke joke = Joke.builder()
                .value(JokeValue.builder()
                        .id(RANDOM_ID)
                        .categories(new String[]{})
                        .build())
                .build();
        jokesService.addJoke(joke);
        //when
        jokesService.deleteJoke(RANDOM_ID);
        //then
        try {
            jokesService.getJoke(RANDOM_ID);
            fail();
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "No joke");
        }
    }

    @Test
    public void update() {
        //given
        Joke joke = Joke.builder()
                .value(JokeValue.builder()
                        .id(RANDOM_ID)
                        .categories(new String[]{})
                        .build())
                .build();
        Joke newJoke = Joke.builder()
                .value(JokeValue.builder()
                        .id(RANDOM_ID + 1)
                        .categories(new String[]{"🌈"})
                        .build())
                .build();
        jokesService.addJoke(joke);
        //when
        jokesService.update(RANDOM_ID, newJoke);
        //UPDATE
        //then
        try {
            jokesService.getJoke(RANDOM_ID);
            fail();
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "No joke");
        }
        Joke joke2 = jokesService.getJoke(RANDOM_ID + 1);
        Assert.assertEquals(newJoke, joke2);
    }
}