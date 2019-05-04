package ch.carve.quarkus;

import java.util.logging.Handler;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logmanager.Level;
import org.jboss.logmanager.LogContext;
import org.jboss.logmanager.formatters.JsonFormatter;
import org.jboss.logmanager.handlers.ConsoleHandler;
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
    
    @PostConstruct
    public void init() {
        ConsoleHandler handler = new ConsoleHandler(new JsonFormatter());
        handler.setLevel(Level.INFO);
        LogContext.getLogContext().getLogger("").setHandlers(new Handler[] {handler});
    }
    
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