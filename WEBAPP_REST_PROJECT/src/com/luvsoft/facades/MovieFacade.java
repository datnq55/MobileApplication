package com.luvsoft.facades;

import com.luvsoft.entities.Movie;
import com.mongodb.DBObject;

public class MovieFacade extends AbstractFacade {
    private static final String MOVIE_COLLECTION_NAME = "Movie";

    @Override
    public String getCollectionName() {
        return MOVIE_COLLECTION_NAME;
    }

    @Override
    public Movie mapObject(DBObject dbobject) {
        Movie movie = new Movie();
        movie.setId(dbobject.get("_id").toString());
        movie.setName(dbobject.get("Name").toString());
        movie.setDirector(dbobject.get("Director").toString());
        movie.setActor(dbobject.get("Actor").toString());
        movie.setYear(dbobject.get("Year").toString());
        movie.setStatus(dbobject.get("Status").toString());
        movie.setThumbnail(dbobject.get("Thumbnail").toString());
        movie.setDescription(dbobject.get("Description").toString());

        return movie;
    }
}
