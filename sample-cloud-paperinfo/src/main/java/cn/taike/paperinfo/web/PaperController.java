package cn.taike.paperinfo.web;

import cn.taike.paperinfo.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private PaperService paperService;

    @RequestMapping(value = "/paper/add", method = RequestMethod.GET)
    public Object addPaperInfo(@RequestParam(value = "a") Integer number1,
                               @RequestParam(value = "b") Integer number2) {
        try {
            ServiceInstance localServiceInstance = client.getLocalServiceInstance();
            Integer result = paperService.addSum(number1, number2);
            log.info("/paper/add success,host:[{}],port:[{}],result:[{}]", localServiceInstance.getHost(), localServiceInstance.getPort(), result);
            return result;

        } catch (Exception e) {
            log.error("paperInfo, number count error.", e);
            return ResponseEntity.badRequest().build();
        }

    }
}
