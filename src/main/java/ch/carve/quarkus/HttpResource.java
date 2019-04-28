package ch.carve.quarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;

@Path("/hello")
public class HttpResource {

    private static final Logger logger = LoggerFactory.getLogger(HttpResource.class);
    
    @Inject
    @Stream("scs")
    Emitter<String> emitter;
    
    @POST
    @Produces(MediaType.APPLICATION_XML)
    public String hello(String body) {
        logger.info(body);
        emitter.send(body);
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello";
    }
    
}