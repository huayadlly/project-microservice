package cn.taike.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @SpringCloudApplication 注解整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker,
 * 主要的目的是为了简化配置；
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
