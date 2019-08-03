package pl.sda.springparent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;
import pl.sda.springparent.service.MongoJokesService;

@Controller
//MVC
//https://www.w3schools.com/bootstrap4/tryit.asp?filename=trybs_form_basic&stacked=h
public class MongoJokeController {

    @Autowired
    MongoJokesService mongoJokesService;

    @GetMapping("/hello_thymeleaf") //@RequestMapping(method = RequestMethod.GET)
    public String helloWorld() {
        return "world";
    }

    @GetMapping("/mongo/ui/joke/{id}")
    public String getJoke(@PathVariable Integer id, Model model) {
        Joke joke = mongoJokesService.findJoke(Joke.builder().value(JokeValue.builder().id(id).build()).build());
        model.addAttribute("joke", joke);
        return "jokes";
    }

}
