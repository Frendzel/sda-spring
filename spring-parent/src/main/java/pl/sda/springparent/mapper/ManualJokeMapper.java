package pl.sda.springparent.mapper;

import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;

import static java.util.Arrays.asList;

public class ManualJokeMapper {
    public static JokeEntity map(Joke joke) {
        return JokeEntity.builder()
                .value(joke.getValue().getJoke())
                .categories(asList(joke.getValue().getCategories()))
                .externalId(joke.getValue().getId())
                .build();
    }

    public static Joke map(JokeEntity entity) {
        return Joke.builder().type("SUCCESS")
                .value(JokeValue.builder()
                        .id(entity.getExternalId())
                        .joke(entity.getValue())
                        .categories((String[]) entity.getCategories().toArray()) //nieładnie :(
                        .build())
                .build();
    }
}
