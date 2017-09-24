package cn.taike.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayadlly on 2017/9/24.
 */
@Service
public class RibbonConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    // 业务逻辑
    @HystrixCommand(fallbackMethod = "consumerAddServiceFallback")
    public String consumerAddService(String integer1, String integer2) {

        // body -- GET请求
        // String body = mapper.writeValueAsString(new RequestBody(integer1, integer2));
        // header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // request
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        // response
        ResponseEntity<String> response = restTemplate.exchange(
                "http://SAMPLE-CLOUD-PAPERINFO/paper/add?num={integer1}&num2={integer2}",
                HttpMethod.GET,
                requestEntity,
                String.class,
                integer1,
                integer2
        );
        return response.getBody();
    }

    /**
     * 熔断器：consumerAddService方法其你去失败的时候回调的方法，
     * 该方法的名字必须为：原方法名 + Fallback(), 熔断器的方法中的参数和返回值都必须与原方法的参数和返回值相同；
     *
     * @param integer1
     * @param integer2
     * @return
     */
    public String consumerAddServiceFallback(String integer1, String integer2) {
        return "error, params:[" + integer1 + "], [" + integer2 + "]";
    }
}
