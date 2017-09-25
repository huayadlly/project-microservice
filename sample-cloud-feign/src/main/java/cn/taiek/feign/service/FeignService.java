package cn.taiek.feign.service;

import cn.taiek.feign.exception.CloudInnerException;
import cn.taiek.feign.handler.FeignHandlerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayadlly on 2017/9/26.
 */
@Slf4j
@Service
public class FeignService {


    @Autowired
    private FeignHandlerClient feignHandlerClient;

    public Integer addCount(Integer a, Integer b) throws CloudInnerException {

        Integer sum = feignHandlerClient.addPaperInfo(a, b);
        if (sum.equals(500)) {
            throw new CloudInnerException("Cloud Inner Exception");
        }
        return sum;
    }

}
