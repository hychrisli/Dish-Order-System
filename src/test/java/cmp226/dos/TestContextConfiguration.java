package cmp226.dos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = {"classpath:application.properties", "classpath:encoded-key-example.bin"})
public class TestContextConfiguration {

    
    
}
