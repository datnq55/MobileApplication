package com.luvsoft.utils;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBConnection {
    public static MongoClient mongoClient;
    public static DB database;

    private static final String MONGOCONNECTION_MONGOLAB = "mongodb://test:test@ds041992.mongolab.com:41992/test_database";
    private static final String MONGOCONNECTION_LOCALHOST = "mongodb://localhost:27017/moviedb";

    /*
     * @name connectMongoDB function
     */
    public void connectMongoDB() {
        try {
            MongoClientURI uri = new MongoClientURI(MONGOCONNECTION_LOCALHOST);
            mongoClient = new MongoClient(uri);
            database = mongoClient.getDB(uri.getDatabase());
            if (database != null) {
                System.out.println("Connected to MongoDB successfully!....");
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
