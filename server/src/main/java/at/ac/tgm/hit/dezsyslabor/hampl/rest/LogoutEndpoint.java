package at.ac.tgm.hit.dezsyslabor.hampl.rest;

import at.ac.tgm.hit.dezsyslabor.hampl.Utils;
import at.ac.tgm.hit.dezsyslabor.hampl.session.SessionManager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The logout endpoint
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@Named
@Path("/logout")
@Produces({MediaType.APPLICATION_JSON})
public class LogoutEndpoint {

    @Inject
    SessionManager sessionManager;

    /**
     * Logs a user out
     *
     * @return a new HTTP response
     */
    @POST
    public Response post(@Context HttpHeaders headers) {
        String sid = headers.getCookies().get("sid").toString();
        Matcher m = Pattern.compile("^.*sid=(.*)$").matcher(sid);
        if (m.find()) {
            sid = m.group(1);
        } else {
            return Utils.createResponse(Response.Status.BAD_REQUEST, "No SID given");
        }
        System.out.println(sid);
        if (sessionManager.logout(UUID.fromString(sid))) {
            return Utils.createResponse(Response.Status.OK, "User successfully logged out");
        } else {
            return Utils.createResponse(Response.Status.BAD_REQUEST, "SID does not exists");
        }
    }
}
