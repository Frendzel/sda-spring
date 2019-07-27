package pl.sda.springparent.mapper;

import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.dto.Joke;

import static java.util.Arrays.asList;

public class ManualJokeMapper {
    public static JokeEntity map(Joke joke) {
        return JokeEntity.builder()
                .value(joke.getValue().getJoke())
                .categories(asList(joke.getValue().getCategories()))
                .build();
    }
}
