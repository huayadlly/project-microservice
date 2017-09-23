package cn.taiek.feign.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huayadlly on 2017/9/23.
 */

/**
 * 通过@FeignClient注解来绑定该接口对应的SAMPLE-CLOUD-PAPERINFO服务；
 * 使用restTemplate的方式定义调用服务中对应的具体方法；
 */
@FeignClient("SAMPLE-CLOUD-PAPERINFO")
public interface FeignHandlerClient {

    @RequestMapping(value = "/paper/add", method = RequestMethod.GET)
    Integer addPaperInfo(@RequestParam(value = "num") Integer number1, @RequestParam(value = "num2") Integer number2);
}
