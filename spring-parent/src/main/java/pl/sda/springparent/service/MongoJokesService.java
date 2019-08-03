package pl.sda.springparent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.repository.MongoConnector;

@Component
public class MongoJokesService {

    @Autowired
    MongoConnector mongoConnector;

    //TODO Mapowanie DTO -> ENTITY
    public Joke findJoke(Joke joke) {
        return mongoConnector.findJoke(joke);
    }
}
