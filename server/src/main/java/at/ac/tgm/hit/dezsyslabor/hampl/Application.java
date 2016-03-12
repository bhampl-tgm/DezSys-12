package at.ac.tgm.hit.dezsyslabor.hampl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the web service
 *
 * @author Burkhard Hampl [bhampl@student.tgm.ac.at]
 * @version 1.0
 */
@SpringBootApplication
public class Application {
    /**
     * Main method for the web service
     *
     * @param args the program arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
