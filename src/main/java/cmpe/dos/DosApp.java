package cmpe.dos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DosApp {
    public static void main(String[] args) {
	SpringApplication.run(DosApp.class, args);
    }
}
