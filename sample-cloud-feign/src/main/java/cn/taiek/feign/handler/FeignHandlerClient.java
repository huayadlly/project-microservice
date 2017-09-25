package cn.taiek.feign.handler;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huayadlly on 2017/9/23.
 */

/**
 * <P>
 * 通过@FeignClient注解来绑定该接口对应的SAMPLE-CLOUD-PAPERINFO服务；
 * 使用restTemplate的方式定义调用服务中对应的具体方法；
 * </p>
 * <p>
 * 注意：
 * 1.在Dalston.SR1这个版本中，hystrix默认是关闭状态，
 * 必须在application中配置feign.hystrix.enabled=true才能正常使用，
 * 否则断路器不生效
 * 2.创建类(FeignClientHystrix)实现该接口(FeignHandlerClient),
 * 在@FeignClient注解中指定请求失败是回调的类，类中重写接口中的类，返回的即是请求失败的返回值
 * 3.Feign中已经引入了Hystix，Feign中已经有hystix的依赖，所以在feign中使用hystix的时候不需要再引入其他的依赖包；
 * </p>
 */
@FeignClient(value = "SAMPLE-CLOUD-PAPERINFO", fallback = FeignHandlerClientImpl.class)
public interface FeignHandlerClient {

    @RequestMapping(value = "/paper/add", method = RequestMethod.GET)
    Integer addPaperInfo(@RequestParam(value = "a") Integer number1, @RequestParam(value = "b") Integer number2);
}
