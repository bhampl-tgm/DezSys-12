package at.ac.tgm.hit.dezsyslabor.hampl;

import at.ac.tgm.hit.dezsyslabor.hampl.rest.LoginEndpoint;
import at.ac.tgm.hit.dezsyslabor.hampl.rest.LogoutEndpoint;
import at.ac.tgm.hit.dezsyslabor.hampl.rest.RegisterEndpoint;
import at.ac.tgm.hit.dezsyslabor.hampl.rest.UserEndpoint;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

/**
 * The Jersey config
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@Named
public class JerseyConfig extends ResourceConfig {

    /**
     * The Jersey config
     */
    public JerseyConfig() {
        this.register(LoginEndpoint.class);
        this.register(RegisterEndpoint.class);
        this.register(UserEndpoint.class);
        this.register(LogoutEndpoint.class);
        this.register(JacksonFeature.class);
    }
}
