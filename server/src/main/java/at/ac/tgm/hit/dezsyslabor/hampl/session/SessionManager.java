package at.ac.tgm.hit.dezsyslabor.hampl.session;

import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;

import java.util.UUID;


public interface SessionManager {
    UUID login(User user);

    boolean isLoggedIn(User user);

    boolean validSession(UUID uuid, User user);

    boolean logout(UUID uuid);
}
