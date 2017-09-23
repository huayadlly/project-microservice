package cn.taike.ribbon.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayadlly on 2017/9/22.
 */
@Slf4j
@RestController
public class RibbonConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon/consumer", method = RequestMethod.GET)
    public Object ribbonConsumer(@RequestParam(value = "a") String integer1,
                                 @RequestParam(value = "b") String integer2) throws JsonProcessingException {

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
        String responseBody = response.getBody();
        log.info("ribbon,result:[{}]", responseBody);
        return responseBody;
    }

}
