package cn.taike.ribbon.web;

import cn.taike.ribbon.service.RibbonConsumerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayadlly on 2017/9/22.
 */
@Slf4j
@RestController
public class RibbonConsumerController {

    @Autowired
    private RibbonConsumerService ribbonConsumerService;

    @RequestMapping(value = "/ribbon/consumer", method = RequestMethod.GET)
    public Object ribbonConsumer(@RequestParam(value = "a") String integer1,
                                 @RequestParam(value = "b") String integer2) throws JsonProcessingException {
        try {
            String responseBody = ribbonConsumerService.consumerAddService(integer1, integer2);
            log.info("ribbon,result:[{}]", responseBody);

            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

}
