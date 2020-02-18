package ch.carve.quarkus;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/env")
public class HttpResource {

    private static final Logger logger = LoggerFactory.getLogger(HttpResource.class);

    @PostConstruct
    public void init() {
    }

    @GET
    @Path("/alpha3")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryCode getAlpha3(@QueryParam("alpha2") String alpha2) {
        return CountryCode.CH;
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    public String hello(String body) {
        logger.info(body);
        return "hello from " + System.getenv("HOSTNAME");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello from " + System.getenv("HOSTNAME");
    }

}