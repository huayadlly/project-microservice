package cn.taiek.feign.web;

import cn.taiek.feign.feign.FeignHandlerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayadlly on 2017/9/23.
 */
@RestController
public class FeignController {

    @Autowired
    private FeignHandlerClient feignHandlerClient;

    @RequestMapping(value = "/feign/add/paper", method = RequestMethod.GET)
    public Object feignAddTest(@RequestParam(value = "abc") Integer number1,
                               @RequestParam(value = "def") Integer number2) {

        Integer sumNumber = feignHandlerClient.addPaperInfo(number1, number2);
        return sumNumber;
    }
}
