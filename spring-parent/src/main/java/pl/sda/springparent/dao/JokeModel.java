package pl.sda.springparent.dao;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@Entity
@Table(name = "JOKE")
public class JokeModel {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;
    Integer externalId;
    String value;
    @Transient //ignore column
    List<String> categories = new ArrayList<>();
}
