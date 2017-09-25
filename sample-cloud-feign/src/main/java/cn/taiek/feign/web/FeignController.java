package cn.taiek.feign.web;

import cn.taiek.feign.exception.CloudInnerException;
import cn.taiek.feign.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayadlly on 2017/9/23.
 */
@Slf4j
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/feign/add", method = RequestMethod.GET)
    public Object feignAddTest(@RequestParam(value = "a") Integer number1,
                               @RequestParam(value = "b") Integer number2) {
        try {
            Integer sumNumber = feignService.addCount(number1, number2);
            log.info("handler, add numbers success.");
            return sumNumber;

        } catch (CloudInnerException e) {
            log.error("Cloud Inner Exception.", e);
            return ResponseEntity.badRequest().build();

        } catch (Exception e) {
            log.error("Feign add error.", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
