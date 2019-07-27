package pl.sda.springparent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.springparent.repository.DbApi;

@Service
public class JokesService {

    @Autowired
    DbApi mockedDb;

}
