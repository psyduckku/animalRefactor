package com.refactor.animals;

import com.refactor.animals.controller.interceptor.LogInterceptor;
import com.refactor.animals.controller.filter.LogFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LogInterceptor())
//                .order(1)
//                .addPathPatterns("/**") //logFilter랑은 다름. 전체*인데 그 이하모두*
//                .excludePathPatterns("/css/**", "/ico/**");// 자동 에러페이지는 basic경로가 /error임
//    }

    //@Bean
    public FilterRegistrationBean logFilter(){ //WAS가동시 필터도 같이 실행됨
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); //만들어준 로그필터를 넣음
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
