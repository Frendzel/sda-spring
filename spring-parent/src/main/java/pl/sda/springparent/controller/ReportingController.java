package pl.sda.springparent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.springparent.exception.ReportingException;
import pl.sda.springparent.monitoring.CalculateInvocationTime;
import pl.sda.springparent.reporting.CsvExporter;
import pl.sda.springparent.service.JokesService;

import java.io.IOException;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class ReportingController {

    @Autowired
    private JokesService jokesService;

    @GetMapping("/report/csv")
    @Async
    @CalculateInvocationTime
    public Future<String> generateReport() {
        try {
            CsvExporter.saveJokes(jokesService.getJokes());
            return new AsyncResult<>("SUCCESS");
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new ReportingException();
        }
    }
}
