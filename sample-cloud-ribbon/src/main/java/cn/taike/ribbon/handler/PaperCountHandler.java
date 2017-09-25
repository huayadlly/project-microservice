package cn.taike.ribbon.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayadlly on 2017/9/26.
 */
@Slf4j
@Component
public class PaperCountHandler {

    @Autowired
    private RestTemplate restTemplate;

    public String ribbonPaperAdd(String num1, String num2) {
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
                num1,
                num2
        );
        return response.getBody();
    }
}
