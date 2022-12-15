package com.wuzhenhua.cfos.config;

import com.wuzhenhua.cfos.common.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 吴振华
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //加自定义拦截器JwtInterceptor，设置拦截规则
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/user/userLogin")
                .excludePathPatterns("/user/userRegister")
                .excludePathPatterns("/swagger-resources")
                .excludePathPatterns("/v2/api-docs/**")
                .excludePathPatterns("/doc.html");
    }
}
