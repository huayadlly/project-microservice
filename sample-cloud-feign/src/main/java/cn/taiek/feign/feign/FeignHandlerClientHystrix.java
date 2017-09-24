package cn.taiek.feign.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by huayadlly on 2017/9/24.
 */
@Slf4j
@Component
public class FeignHandlerClientHystrix implements FeignHandlerClient {

    @Override
    public Integer addPaperInfo(Integer number1, Integer number2) {
        log.error("Feign Consumer Error, there be some Inner Error of Servers, params:[{}, {}]", number1, number2);
        return 500;
    }
}
