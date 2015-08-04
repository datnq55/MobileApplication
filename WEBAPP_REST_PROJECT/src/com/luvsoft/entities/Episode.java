package com.luvsoft.entities;

import com.mongodb.DBObject;

public class Episode extends AbstractEntity {
    private String id;
    private int order;
    private String resource;
    private String link;
    private String quality;
    private String movie_id;

    public Episode() {

    }

    public Episode(DBObject dbobject) {
        id = dbobject.get("_id").toString();
        order = Integer.valueOf(dbobject.get("Order").toString());
        resource = dbobject.get("Resource").toString();
        link = dbobject.get("Link").toString();
        quality = dbobject.get("Quality").toString();
        movie_id = dbobject.get("Movie_id").toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }
}
