package cn.taike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaperInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperInfoApplication.class, args);
    }
}
