package com.refactor.animals;

import com.refactor.animals.controller.filter.LogFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;


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

//    @Bean //기본 message사용
//    public MessageSource messageSource(){
//        ResourceBundleMessageSource  messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
////        messageSource.setDefaultLocale(Locale.KOREAN);
////        messageSource.setBasename("errors");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean //errors message 사용을 위한 빈등록
//    public MessageSource errorMessageSource(){
//        ReloadableResourceBundleMessageSource  messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:/errors");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }



}
