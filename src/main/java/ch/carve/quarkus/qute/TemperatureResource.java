package ch.carve.quarkus.qute;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

@Path("temperature")
public class TemperatureResource {

    @Inject
    Template temperatures;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        List<Temperature> data = new ArrayList<>();
        data.add(new Temperature("Schlazimmer", new BigDecimal(20), new BigDecimal(43)));
        data.add(new Temperature("Keller", new BigDecimal(16), new BigDecimal(60)));
        data.add(new Temperature("Wohnzimmer", new BigDecimal(22), new BigDecimal(46)));
        return temperatures.data("temperatures", data)
                .data("active", "Temperature");
    }

}
