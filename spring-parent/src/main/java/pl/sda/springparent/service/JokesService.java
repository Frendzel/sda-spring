package pl.sda.springparent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springparent.dao.JokeEntity;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.mapper.ManualJokeMapper;
import pl.sda.springparent.repository.DbApi;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class JokesService {

    @Autowired
    DbApi mockedDb;

    public List<Joke> getJokes() {
        return mockedDb.getJokes().stream()
                .map(ManualJokeMapper::map)
                .collect(toList());
    }

    public Joke getJoke(Integer id) {
        JokeEntity joke = mockedDb.getJoke(id);
        return ManualJokeMapper.map(joke);
    }

    public void addJoke(Joke joke) {
        JokeEntity entity = ManualJokeMapper.map(joke);
        mockedDb.addJoke(entity);
    }

    public void deleteJoke(Integer id){
        mockedDb.deleteJoke(id);
    }

    public void update(Integer id, Joke joke) {
        JokeEntity entity = ManualJokeMapper.map(joke);
        mockedDb.updateJoke(id,entity);
    }
}
