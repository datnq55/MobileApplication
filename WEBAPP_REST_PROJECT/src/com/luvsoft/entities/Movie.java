package com.luvsoft.entities;

import com.mongodb.DBObject;

public class Movie extends AbstractEntity {

    private String id;
    private String name;
    private String director;
    private String actor;
    private String year;
    private String status;
    private String thumbnail;
    private String description;

    public Movie() {
    }

    public Movie(DBObject dbobject) {
        id = dbobject.get("_id").toString();
        name = dbobject.get("Name").toString();
        director = dbobject.get("Director").toString();
        actor = dbobject.get("Actor").toString();
        year = dbobject.get("Year").toString();
        status = dbobject.get("Status").toString();
        thumbnail = dbobject.get("Thumbnail").toString();
        description = dbobject.get("Description").toString();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
