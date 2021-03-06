package web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages="web.repository")
@EnableTransactionManagement
@EntityScan(basePackages="web.models")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

//        ObjectMapper objectMapper = new ObjectMapper();
    }
}
