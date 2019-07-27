package pl.sda.springparent.dao;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class JokeEntity {
    Integer id;
    String value;
    List<String> categories = new ArrayList<>();
}
