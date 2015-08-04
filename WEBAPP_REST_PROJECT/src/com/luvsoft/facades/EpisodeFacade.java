package com.luvsoft.facades;

import java.util.List;

import org.bson.types.ObjectId;

import com.luvsoft.entities.Episode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class EpisodeFacade extends AbstractFacade {
    private static final String EPISODE_COLLECTION_NAME = "Episode";

    @Override
    public String getCollectionName() {
        return EPISODE_COLLECTION_NAME;
    }

    @Override
    public Episode mapObject(DBObject dbobject) {
        Episode episode = new Episode();

        episode.setId(dbobject.get("_id").toString());
        episode.setOrder(Integer.valueOf(dbobject.get("Order").toString()));
        episode.setResource(dbobject.get("Resource").toString());
        episode.setLink(dbobject.get("Link").toString());
        episode.setQuality(dbobject.get("Quality").toString());
        episode.setMovie_id(dbobject.get("Movie_id").toString());

        return episode;
    }

    public List<Episode> getEpisodeByMovieId(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("Movie_id", new ObjectId(id));
        return findByQuery(query);
    }
}
