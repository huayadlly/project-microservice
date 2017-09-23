package cn.taiek.feign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huayadlly on 2017/9/23.
 */
@FeignClient("SAMPLE-CLOUD-PAPERINFO")
public interface FeignHandlerClient {

    @RequestMapping(value = "/paper/add", method = RequestMethod.GET)
    Integer addPaperInfo(@RequestParam(value = "num") Integer number1, @RequestParam(value = "num2") Integer number2);
}
