package pl.sda.springparent.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(code = NOT_FOUND, reason = "Joke has not been found")
public class JokeNotFoundException extends RuntimeException {
    public JokeNotFoundException(String message) {
        super(message);
    }
}
