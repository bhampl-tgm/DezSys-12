package at.ac.tgm.hit.dezsyslabor.hampl.session;


import at.ac.tgm.hit.dezsyslabor.hampl.Utils;
import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Singleton
@Primary
@Component
public class DefaultSessionManager implements SessionManager {

    private Map<UUID, User> users;

    public DefaultSessionManager() {
        this.users = new HashMap<>();
    }

    @Override
    public UUID login(User user) {
        if (this.isLoggedIn(user)) return (UUID) Utils.getKeyFromValue(this.users, user);
        UUID uuid = UUID.randomUUID();
        this.users.put(uuid, user);
        return uuid;
    }

    @Override
    public boolean isLoggedIn(User user) {
        return this.users.values().contains(user);
    }

    @Override
    public boolean validSession(UUID uuid, User user) {
        return this.users.get(uuid) != null && this.users.get(uuid).equals(user);
    }

    @Override
    public boolean logout(UUID uuid) {
        return this.users.remove(uuid) != null;
    }
}
