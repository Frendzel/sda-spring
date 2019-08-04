package pl.sda.springparent.repository;

import pl.sda.springparent.dao.JokeModel;

import java.util.List;

/**
 * Interfejs dla bazy danych, ktory moze byc uzyty
 * przez konkretna implementacje
 */
public interface DbApi {
    List<JokeModel> getJokes();

    JokeModel getJoke(Integer id);

    void addJoke(JokeModel joke);

    void deleteJoke(Integer id);

    void updateJoke(Integer id, JokeModel entity);
}
