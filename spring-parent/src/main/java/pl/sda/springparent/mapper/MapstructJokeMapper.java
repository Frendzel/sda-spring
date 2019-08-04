package pl.sda.springparent.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.springparent.dao.JokeModel;
import pl.sda.springparent.dto.Joke;

@Mapper
public interface MapstructJokeMapper {

    MapstructJokeMapper INSTANCE = Mappers.getMapper(MapstructJokeMapper.class);

    @Mappings({
            @Mapping(source = "value.id", target = "externalId"),
            @Mapping(source = "value.joke", target = "value"),
            @Mapping(source = "value.categories", target = "categories")
    })
    JokeModel jokeToJokeEntity(Joke joke);

    @Mappings({
            @Mapping(source = "externalId", target = "value.id"),
            @Mapping(source = "value", target = "value.joke"),
            @Mapping(source = "categories", target = "value.categories")
    })
    Joke jokeEntityToJoke(JokeModel entity);
}
