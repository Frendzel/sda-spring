package pl.sda.springparent.mapper;

import com.google.gson.Gson;
import org.junit.Test;
import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ManualJokeMapperTest {

    @Test
    public void testJsonParsing() {
        Joke joke = Joke.builder()
                .value(JokeValue.builder()
                        .id(500000)
                        .joke("HaHa")
                        .categories(new String[]{})
                        .build())
                .build();
        Gson gson = new Gson();
        String s = gson.toJson(joke);
        System.out.println(s);
    }


    @Test
    public void should_map_correctly_joke_to_joke_entity() {

        //given
        Joke joke = Joke.builder().type("Success")
                .value(JokeValue.builder()
                        .id(123)
                        .joke("Funny joke")
                        .categories(new String[]{})
                        .build())
                .build();

        //when
        JokeEntity result = ManualJokeMapper.map(joke);
        //then
        assertEquals(joke.getValue().getJoke(), result.getValue());
        assertEquals(Arrays.asList(joke.getValue().getCategories()), result.getCategories());
    }
}