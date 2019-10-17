package ch.carve.quarkus;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("secured")
public class SecuredResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("all")
    public String hello(@Context SecurityContext context) {
        Principal caller = context.getUserPrincipal();
        String name = caller == null ? "anonymous" : caller.getName();
        boolean hasJWT = jwt != null;
        String helloReply = String.format("hello + %s, isSecure: %s, authScheme: %s, hasJWT: %s", name, context.isSecure(), context.getAuthenticationScheme(), hasJWT);
        return helloReply;
    }

    @GET
    @Path("role")
    @RolesAllowed("simplerole")
    public String role(@Context SecurityContext context) {
        Principal caller = context.getUserPrincipal();
        String name = caller == null ? "anonymous" : caller.getName();
        boolean hasJWT = jwt != null;

        String helloReply = String.format("hello + %s, isSecure: %s, authScheme: %s, hasJWT: %s", name, context.isSecure(), context.getAuthenticationScheme(), hasJWT);
        return helloReply;
    }

}
