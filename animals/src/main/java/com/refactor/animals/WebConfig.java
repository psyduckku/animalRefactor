package com.refactor.animals;

import com.refactor.animals.common.filter.LogFilter;
import com.refactor.animals.common.interceptor.LoginCheckInterceptor;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/css/**", "/*.ico", "/error", "/bootstrap/bootstrap.min.css",
                        "/bootstrap/bootstrap.min.css.map", "/adoptBoard/images/**",
                        "/js/**", "/img/**",
                        "/base/", "/base/join","/base/login", "/base/findInfo"
                        ,"/animal/api/login",
                         "/animal/api/join", "/", "/animal/api/isLoginIdDuplicate",
                        "/adoptBoard/adoptBoardList", "/animalBoard/animalBoardList",
                        "/animalBoard/animalBoard", "/animalReplyBoard/boardList",
                        "/animal/api/logout", "/animalBoard/getAsideBoard",
                        "/adoptBoard/bookmarkList",
                        "/email/auth/sendEmail",
                        "/adoptReplyBoard/good", "/animalReplyBoard/getReplyList",
                        "/animalReplyBoard/insertReply",
                        "/market/", "/market/getMainProdList"


                );
    }

    //@Bean
    public FilterRegistrationBean logFilter(){ //WAS가동시 필터도 같이 실행됨
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter()); //만들어준 로그필터를 넣음
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
