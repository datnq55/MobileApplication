package com.luvsoft.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.luvsoft.entities.Episode;
import com.luvsoft.facades.EpisodeFacade;
import com.luvsoft.utils.MongoDBConnection;

@Path("/demoservice")
public class HelloService {

    static {
        MongoDBConnection dbconnection = new MongoDBConnection();
        dbconnection.connectMongoDB();
    }

    @GET
    @Path("hello1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloMessage() throws JSONException {

        /*
         * MovieController movieController = new MovieController();
         * ArrayList<Movie> list = movieController.findAll();
         */
        EpisodeFacade episodeController = new EpisodeFacade();
        List<Episode> list = episodeController.findAll();
        // .getEpisodeByMovieId("55b64669b4f3a80c604a186a");

        JSONArray ja = new JSONArray();
        for (Episode movie : list) {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("ID", movie.getId());
            jsonobject.put("NAME", movie.getResource());
            ja.put(jsonobject);
        }

        return Response.status(200).entity(ja.toString()).build();
    }

    /*
     * @GET
     *
     * @Path("/hello2/id={episodeId}")
     *
     * @Produces(MediaType.APPLICATION_JSON) public Response
     * helloMessage1(@PathParam("episodeId") String episodeId) throws
     * JSONException {
     *
     * EpisodeFacade episodeController = new EpisodeFacade(); List<Episode> list
     * = episodeController.findAll();
     *
     * JSONArray ja = new JSONArray(); for (Episode movie : list) { JSONObject
     * jsonobject = new JSONObject(); jsonobject.put("ID", movie.getId());
     * jsonobject.put("ABC", episodeId); ja.put(jsonobject); }
     *
     * return Response.status(200).entity(ja.toString()).build(); }
     */
}
