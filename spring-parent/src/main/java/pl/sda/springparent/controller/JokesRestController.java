package pl.sda.springparent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.service.JokesService;

import java.util.List;

//@Controller // mvc
@RestController //rest
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

}
