package pl.sda.springparent.dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity //CREATE TABLE
public class JokeEntity {
    @Id
    @GeneratedValue
    Integer id;
    Integer externalId;
    String value;
    @Transient //ignore column
    List<String> categories = new ArrayList<>();
}
