package pl.sda.springparent.repository;

import pl.sda.springparent.dao.JokeEntity;

import java.util.List;

/**
 * Interfejs dla bazy danych, ktory moze byc uzyty
 * przez konkretna implementacje
 */
public interface DbApi {
    List<JokeEntity> getJokes();

    JokeEntity getJoke(Integer id);

    void addJoke(JokeEntity joke);
}
