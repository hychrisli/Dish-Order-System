package cmpe.dos;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
public class DosApp {
    public static void main(String[] args) {
	SpringApplication.run(DosApp.class, args);
    }
}
