package at.ac.tgm.hit.dezsyslabor.hampl.rest;

import at.ac.tgm.hit.dezsyslabor.hampl.Utils;
import at.ac.tgm.hit.dezsyslabor.hampl.service.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The user endpoint for testing purpose
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@Named
@Path("/user")
@Produces({MediaType.APPLICATION_JSON})
public class UserEndpoint {

    @Inject
    UserRepository userRepository;

    /**
     * Finds the user with the given email
     *
     * @param email the email
     * @return a new HTTP response
     */
    @GET
    @Path("/{email}")
    public Response get(@PathParam("email") String email) {
        if (this.userRepository.exists(email)) {
            return Response.ok(this.userRepository.findByEmail(email), MediaType.APPLICATION_JSON).build();
        } else {
            return Utils.createResponse(Response.Status.NOT_FOUND, "User with email " + email + " not found");
        }
    }
}
