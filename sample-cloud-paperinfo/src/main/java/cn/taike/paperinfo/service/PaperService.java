package cn.taike.paperinfo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by huayadlly on 2017/9/26.
 */
@Slf4j
@Service
public class PaperService {

    // 计算两个数的和
    public Integer addSum(Integer a, Integer b) {
        return a + b;
    }
}
