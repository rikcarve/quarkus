package ch.carve.quarkus.qute;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ch.carve.quarkus.qute.Light.Switch;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("light")
public class LightResource {

    static Map<String, Switch> lightMap = new HashMap<String, Light.Switch>() {
        {
            put("Kitchen", Switch.ON);
            put("Living Room", Switch.OFF);
        }
    };

    @Inject
    Template light;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Light> data = lightMap
                .entrySet()
                .stream()
                .map(e -> new Light(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        return light.data("light", data)
                .data("active", "Light");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("/{name}/toggle")
    public Response toggle(@PathParam("name") String name) {
        log.info(name);
        lightMap.put(name, lightMap.get(name) == Switch.OFF ? Switch.ON : Switch.OFF);
        return Response.status(301)
                .location(URI.create("/light"))
                .build();
    }
}
