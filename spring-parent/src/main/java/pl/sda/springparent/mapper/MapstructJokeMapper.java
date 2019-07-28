package pl.sda.springparent.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.dto.Joke;

@Mapper
public interface MapstructJokeMapper {

    @Mappings({
            @Mapping(source = "value.id", target = "externalId"),
            @Mapping(source = "value.joke", target = "value"),
            @Mapping(source = "value.categories", target = "categories")
    })
    JokeEntity jokeToJokeEntity(Joke joke);

    @Mappings({
            @Mapping(source = "externalId", target = "value.id"),
            @Mapping(source = "value", target = "value.joke"),
            @Mapping(source = "categories", target = "value.categories")
    })
    Joke jokeEntityToJoke(JokeEntity entity);
}
