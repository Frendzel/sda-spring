package pl.sda.springparent.repository;

import pl.sda.springparent.dao.JokeEntity;

/**
 * Interfejs dla bazy danych, ktory moze byc uzyty
 * przez konkretna implementacje
 */
public interface DbApi {
    JokeEntity getJoke(Integer id);

    void addJoke(JokeEntity joke);
}
