package pl.sda.springparent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.service.JokesService;

import java.util.List;

import static java.lang.Thread.sleep;

//@Controller // mvc
@RestController //rest
@Slf4j
public class JokesRestController {

    @Autowired
    JokesService jokesService;

    @GetMapping("/hello")
    //@RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        return "world";
    }

    @GetMapping("/joke/{id}")
    public Joke getJoke(@PathVariable Integer id) {
        return jokesService.getJoke(id);
    }

    @GetMapping("/jokes")
    public List<Joke> getJokes() {
        return jokesService.getJokes();
    }

    //add Joke
    @PostMapping("/jokes")
    public void postJokes(@RequestBody Joke joke) {
        jokesService.addJoke(joke);
    }

    @PutMapping("/joke")
    public void putJoke(@RequestBody Joke joke) {
        Joke jokeToUpdate = jokesService.getJoke(joke.getValue().getId());
        //jokesService.update(jokeToUpdate, joke);
    }

    @DeleteMapping("/joke/{id}")
    public void deleteJoke(@PathVariable Integer id) {
        //jokesService.delete(id);
    }

    @GetMapping("/lag")
    @Cacheable("lag")
    public Joke lag() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return Joke.builder().build();
    }

}
