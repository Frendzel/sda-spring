package pl.sda.springparent.repository;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dto.Joke;
import pl.sda.springparent.exception.JokeNotFoundException;
import pl.sda.springparent.exception.ValidationException;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MongoConnector {
    private static final String DB_NAME = "sdaldz16";
    private static final String COLLECTION_NAME = "jokes";

    private final MongoClient mongoClient;
    private Gson gson = new Gson();

    //@Autowired
    public MongoConnector(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @PostConstruct
    public void check() {
        MongoCollection<Document> jokes = getJokesCollection();
        log.debug("Successfully connected to the: {}, collection: {} with size: {}",
                DB_NAME,
                COLLECTION_NAME,
                jokes.countDocuments());
    }

    public void saveJoke(Joke joke) {
        //walidacja -> FAIL FAST
        MongoCollection<Document> jokes = getJokesCollection();
        Gson gson = new Gson();
        try {
            jokes.insertOne(Document.parse(gson.toJson(joke)));
        } catch (Exception e) {
            throw new ValidationException("Wrong joke format");
        }
        log.debug("Successfully inserted document to the database");
    }

    //{
//        "type": "success",
//        "value": {
//        "id": 298,
//        "joke": "MacGyver immediately tried to make a bomb out of some Q-Tips and Gatorade, but Chuck Norris roundhouse-kicked him in the solar plexus. MacGyver promptly threw up his own heart.",
//        "categories": []
//        }
//        }
    //TODO sprobuj sie zastanowic jak mozna ten kod zrefaktorowac uzywajac dowolnego wzorca projektowego
    public Joke findJoke(Joke joke) {
        if (joke == null) {
            throw new ValidationException("Wrong joke format");
        }
        MongoCollection<Document> jokes = getJokesCollection();
        return findJoke(joke, jokes);

    }

    /**
     * Fallback search mechanism
     * TODO list or single document?
     *
     * @param joke
     * @param jokes
     * @return
     */
    private Joke findJoke(Joke joke, MongoCollection<Document> jokes) {
        //byId
        for (Document document : jokes.find(new Document("value.id", joke.getValue().getId()))) {
            return gson.fromJson(document.toJson(), Joke.class);
        }

        //byJoke
        for (Document document : jokes.find(new Document("value.joke", joke.getValue().getJoke()))) {
            return gson.fromJson(document.toJson(), Joke.class);
        }

        //byCategory
        //TODO []
        for (Document document : jokes.find(new Document("value.categories", joke.getValue().getCategories()))) {
            return gson.fromJson(document.toJson(), Joke.class);
        }
        throw new JokeNotFoundException("Cannot find joke with params: " + joke.toString());
    }

    private MongoCollection<Document> getJokesCollection() {
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        return db.getCollection(COLLECTION_NAME);
    }
}
