package pl.sda.springparent.reporting;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import pl.sda.springparent.dto.Joke;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class CsvExporter {

    public static void saveJokes(List<Joke> jokes) throws IOException {
        FileWriter fileWriter = new FileWriter("jokes.csv");
        try (CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.
                withHeader("ID", "JOKE", "CATEGORY"))) {
            jokes.forEach(joke -> {
                try {
                    csvPrinter.printRecord(
                            joke.getValue().getId(),
                            joke.getValue().getJoke(),
                            Arrays.toString(joke.getValue().getCategories()));
                } catch (IOException e) {
                    log.error("Sth wrong happened during csv export");
                }
            });
        }
    }
}
