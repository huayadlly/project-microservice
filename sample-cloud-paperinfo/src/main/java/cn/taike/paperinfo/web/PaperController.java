package cn.taike.paperinfo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayadlly on 2017/9/22.
 */
@Slf4j
@RestController
public class PaperController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/paper/add", method = RequestMethod.GET)
    public Object addPaperInfo(@RequestParam(value = "num") Integer number1,
                               @RequestParam(value = "num2") Integer number2) {

        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
        Integer result = number1 + number2;
        log.info("/paper/add,host:[{}],port:[{}],result:[{}]", localServiceInstance.getHost(), localServiceInstance.getPort(), result);
        return result;
    }
}
