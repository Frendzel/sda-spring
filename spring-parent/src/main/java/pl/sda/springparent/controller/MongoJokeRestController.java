package pl.sda.springparent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;
import pl.sda.springparent.service.MongoJokesService;

import java.util.Collections;
import java.util.List;

@RestController
//GET VS POST
//HTTP METODY
//SOAP VS REST
//REST
public class MongoJokeRestController {

    @Autowired
    MongoJokesService mongoJokesService;

    @GetMapping("/mongo/joke/{id}")
    public Joke getJoke(@PathVariable Integer id) {
        return mongoJokesService.findJoke(Joke.builder().value(JokeValue.builder().id(id).build()).build());
    }

    @PostMapping("/mongo/joke")
    public Joke getJoke(@RequestBody Joke joke) {
        return mongoJokesService.findJoke(joke);
    }

    @GetMapping(value = "/mongo/jokes", produces = "application/json;charset=UTF-8")
    public List<Joke> getJokes() {
        //TODO
        return Collections.EMPTY_LIST;
    }
}
