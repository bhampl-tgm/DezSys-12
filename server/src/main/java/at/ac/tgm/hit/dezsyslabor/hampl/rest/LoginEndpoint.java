package at.ac.tgm.hit.dezsyslabor.hampl.rest;

import at.ac.tgm.hit.dezsyslabor.hampl.Utils;
import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;
import at.ac.tgm.hit.dezsyslabor.hampl.service.UserRepository;
import at.ac.tgm.hit.dezsyslabor.hampl.session.SessionManager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The login endpoint
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@Named
@Path("/login")
@Produces({MediaType.APPLICATION_JSON})
public class LoginEndpoint {

    @Inject
    UserRepository userRepository;

    @Inject
    SessionManager sessionManager;

    /**
     * Logs a user in
     *
     * @param user the user
     * @return a new HTTP response
     */
    @POST
    public Response post(User user) {
        if (user != null && user.getEmail() != null) {
            User loginUser = this.userRepository.findByEmail(user.getEmail());
            if (user.getPassword() != null && loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
                return Utils.createResponseWithSID(Response.Status.OK, "Welcome " + loginUser.getName() + "!", sessionManager.login(loginUser));
            }
        }
        return Utils.createResponse(Response.Status.FORBIDDEN, "Email or password is wrong");
    }
}
