package at.ac.tgm.hit.dezsyslabor.hampl;

import org.hornetq.utils.json.JSONObject;

import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A util class for the web service
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
public class Utils {
    /**
     * Creates a HTTP response with the given HTTP status code and message in JSON
     *
     * @param status  the HTTP status code
     * @param message a additional massage
     * @return the finished HTTP response with the content as JSON representation
     */
    public static Response createResponse(Response.Status status, String message) {
        Map<String, String> msg = new HashMap<>();
        msg.put("code", status.getStatusCode() + "");
        msg.put("reason", status.toString());
        msg.put("message", message);
        return Response.status(status).entity(new JSONObject(msg).toString()).build();
    }

    /**
     * Creates a HTTP response with the given HTTP status code and message in JSON with SID
     *
     * @param status  the HTTP status code
     * @param message a additional massage
     * @return the finished HTTP response with the content as JSON representation
     */
    public static Response createResponseWithSID(Response.Status status, String message, UUID uuid) {
        Map<String, String> msg = new HashMap<>();
        msg.put("code", status.getStatusCode() + "");
        msg.put("reason", status.toString());
        msg.put("message", message);
        return Response.status(status).cookie(new NewCookie("sid", uuid.toString())).entity(new JSONObject(msg).toString()).build();
    }

    public static Object getKeyFromValue(Map hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
}
