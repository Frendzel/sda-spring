package pl.sda.springparent.controller;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
//MOCK MVC
public class JokesRestControllerTest {

    @Autowired
    WebApplicationContext context;// 🙏
    MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = webAppContextSetup(context).build();
    }

    @Test
    public void getJoke() throws Exception {
        mockMvc.perform(get("/joke/10")).andExpect(status().isBadRequest());
    }

    @Test
    public void getJokes() throws Exception {
        mockMvc.perform(get("/jokes"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(
                        ResultMatcher.matchAll(
                                MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8),
                                MockMvcResultMatchers.status().isOk())
                );
    }

    @Test
    public void postJokes() throws Exception {
        mockMvc.perform(post("/jokes").content(" ").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(ResultMatcher.matchAll(status().isBadRequest()));
        //MockMvcResultMatchers.jsonPath()); TODO JSON PATH
    }

    @Test
    public void putJoke() throws Exception {
        //given
        Joke joke = Joke.builder()
                .value(JokeValue.builder()
                        .id(500000)
                        .joke("HaHa")
                        .categories(new String[]{})
                        .build())
                .build();

        Joke secndJoke = Joke.builder()
                .value(JokeValue.builder()
                        .id(5000000)
                        .joke("HaHaHa")
                        .categories(new String[]{})
                        .build())
                .build();
        Gson gson = new Gson();
        mockMvc.perform(post("/jokes").content(gson.toJson(joke))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        //when
        mockMvc.perform(put("/joke/{id}", 500000).content(gson.toJson(secndJoke))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        //then
        mockMvc.perform(get("/joke/{id}", 5000000))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(ResultMatcher.matchAll(
                        content().json(gson.toJson(secndJoke)),
                        MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8)));

    }

    @Test
    public void deleteJoke() throws Exception {
        //given
        //ADD
        Joke joke = Joke.builder()
                .value(JokeValue.builder()
                        .id(5000001)
                        .joke("HaHa")
                        .categories(new String[]{})
                        .build())
                .build();
        Gson gson = new Gson();
        mockMvc.perform(post("/jokes").content(gson.toJson(joke))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        //when
        mockMvc.perform(delete("/joke/{id}", 5000001))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        //DELETE
        //then
        //GET
        mockMvc.perform(get("/joke/{id}", 5000001))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }
}