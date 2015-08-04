package com.luvsoft.facades;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.luvsoft.entities.AbstractEntity;
import com.luvsoft.utils.MongoDBConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public abstract class AbstractFacade {

    // ///////////////////////////////////////////////////////////
    // ! Function is used to get all document in a collection
    // !
    // ! @return ArrayList list of documents in this collection
    // ///////////////////////////////////////////////////////////
    public <T extends AbstractEntity> List<T> findAll() {
        List<T> list = new ArrayList<T>();
        DBCollection collection = MongoDBConnection.database
                .getCollection(getCollectionName());
        DBCursor cursor = collection.find();

        while (cursor.hasNext()) {
            list.add((T) mapObject(cursor.next()));
        }
        return list;
    }

    // ///////////////////////////////////////////////////////////
    // ! Function is used to get all document in a collection by Id
    // !
    // ! @return An Object in the collection who has the Id
    // ///////////////////////////////////////////////////////////
    public <T extends AbstractEntity> T findById(String id) {
        DBCollection collection = MongoDBConnection.database
                .getCollection(getCollectionName());
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new ObjectId(id));
        DBObject dbobj = collection.findOne(query);

        return (T) mapObject(dbobj);
    }

    // ///////////////////////////////////////////////////////////
    // ! Function is used to get all document in a collection by a query
    // !
    // ! @return ArrayList list of documents in this collection
    // ///////////////////////////////////////////////////////////
    public <T extends AbstractEntity> List<T> findByQuery(BasicDBObject query) {
        List<T> list = new ArrayList<T>();
        DBCollection collection = MongoDBConnection.database
                .getCollection(getCollectionName());

        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            list.add((T) mapObject(cursor.next()));
        }

        return list;
    }

    public abstract String getCollectionName();

    public abstract AbstractEntity mapObject(DBObject dbobject);
}
