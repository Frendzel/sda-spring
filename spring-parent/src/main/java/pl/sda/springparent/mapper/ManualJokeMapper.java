package pl.sda.springparent.mapper;

import pl.sda.springparent.dao.JokeModel;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;

import static java.util.Arrays.asList;

//TODO walidacja na dane
public class ManualJokeMapper {
    public static JokeModel map(Joke joke) {
        return JokeModel.builder()
                .value(joke.getValue().getJoke())
                .categories(asList(joke.getValue().getCategories()))
                .externalId(joke.getValue().getId())
                .build();
    }

    public static Joke map(JokeModel entity) {
        return Joke.builder()
                .value(JokeValue.builder()
                        .id(entity.getExternalId())
                        .joke(entity.getValue())
                        .categories((String[]) entity.getCategories().toArray())
                        .build())
                .build();
    }
}
