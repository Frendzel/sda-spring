package pl.sda.springparent.reporting;

import org.junit.Test;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.dto.JokeValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvExporterTest {

    @Test
    public void saveJokes() throws IOException {
        //given
        Joke joke1 = Joke.builder()
                .value(JokeValue.builder()
                        .id(5000001)
                        .joke("HaHa")
                        .categories(new String[]{})
                        .build())
                .build();
        Joke joke2 = Joke.builder()
                .value(JokeValue.builder()
                        .id(5000001)
                        .joke("HaHa")
                        .categories(new String[]{})
                        .build())
                .build();
        List<Joke> jokes = new ArrayList<>();
        jokes.add(joke1);
        jokes.add(joke2);
        //when
        CsvExporter.saveJokes(jokes);
        //then
        //TODO
    }
}