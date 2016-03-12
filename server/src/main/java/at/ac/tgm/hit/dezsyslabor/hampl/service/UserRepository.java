package at.ac.tgm.hit.dezsyslabor.hampl.service;

import at.ac.tgm.hit.dezsyslabor.hampl.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * The repository for the user
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * Finds the user with the given email
     *
     * @param email the email
     * @return if the user with the email exists the user
     */
    User findByEmail(@Param("email") String email);
}
