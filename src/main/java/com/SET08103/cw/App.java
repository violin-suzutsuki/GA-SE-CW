package com.SET08103.cw;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * App.java
 *
 * This is the program entrypoint, and connects to a MongoDB instance hosted on a VPS.
 * The MongoDB integration will soon redundant as we are moving to an SQL instance running in a local docker container
 */
public class App {
    public static void main(String[] args)
    {
        MongoClientURI url = new MongoClientURI("mongodb+srv://administrator:1dy955HGnUDvj1gw@mongodb-geo-data.40ppl.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

        MongoClient client;

        try {
            client = new MongoClient(url);
        } catch (Exception e) {
            System.out.println("Failed to connect to server.");
            return;
        }

        MongoDatabase database;

        try {
            database = client.getDatabase("Database");
        } catch (Exception e) {
            System.out.println("Failed to find database.");
            return;
        }

        MongoCollection collection;

        try {
            collection = database.getCollection("GeoData");
        } catch (Exception e) {
            System.out.println("Failed to find collection.");
            return;
        }

        System.out.println("Connected to MongoDB, found GeoData collection!");
    }
}
