package pl.sda.springparent.repository;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;
import pl.sda.springparent.dto.Joke;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MongoConnector {
    private static final String DB_NAME = "sdaldz16";
    private static final String COLLECTION_NAME = "jokes";

    private final MongoClient mongoClient;

    public MongoConnector(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @PostConstruct
    public void check() {
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> jokes = db.getCollection(COLLECTION_NAME);
        log.info("Successfully connected to the: {}, collection: {} with size: {}",
                DB_NAME,
                COLLECTION_NAME,
                jokes.countDocuments());
    }

    public void saveJoke(Joke joke) {
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> jokes = db.getCollection(COLLECTION_NAME);
        Gson gson = new Gson();
        jokes.insertOne(Document.parse(gson.toJson(joke)));
        log.info("Successfully inserted document to the database");
    }
}
