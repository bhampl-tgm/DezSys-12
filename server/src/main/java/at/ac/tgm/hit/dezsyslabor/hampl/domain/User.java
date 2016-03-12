package at.ac.tgm.hit.dezsyslabor.hampl.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * The entity class for the user
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@Entity
public class User implements Serializable {

    @Id
    @Size(max = 50)
    private String email;

    @Size(max = 50)
    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public User() {

    }

    /**
     * Creates a now user with the given parameters
     *
     * @param email    the email
     * @param name     the name
     * @param password the password
     */
    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getEmail().equals(user.getEmail()) && (getName() != null ? getName().equals(user.getName()) : user.getName() == null && getPassword().equals(user.getPassword()));

    }

    @Override
    public int hashCode() {
        int result = getEmail().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
