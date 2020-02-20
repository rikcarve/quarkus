package ch.carve.quarkus.qute;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.carve.quarkus.qute.Light.Switch;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("light")
public class LightResource {

    @Inject
    Template light;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Light> data = new ArrayList<>();
        data.add(new Light("Esszimmer", Switch.ON));
        data.add(new Light("Wohnzimmer", Switch.OFF));
        return light.data("light", data);
    }

}
