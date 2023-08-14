package com.xuecheng.content.feignclient;

import com.xuecheng.content.model.dto.CourseIndex;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @projectName: xuecheng-project
 * @author: buxitang
 * @description: TODO
 * @date: 2023/8/15 0:17
 * @version: 1.0
 */
@Slf4j
@Component
public class SearchServiceClientFallbackFactory implements FallbackFactory<SearchServiceClient> {
    @Override
    public SearchServiceClient create(Throwable throwable) {

        return new SearchServiceClient() {

            @Override
            public Boolean add(CourseIndex courseIndex) {
                throwable.printStackTrace();
                log.debug("调用搜索发生熔断走降级方法,熔断异常:", throwable.getMessage());

                return false;
            }
        };
    }
}

