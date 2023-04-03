package com.wuzhenhua.cfos.config;

import com.wuzhenhua.cfos.common.JwtInterceptor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author wuzhenhua
 * @Title WebConfig
 * @ProjectName: campus-food-ordering-system
 * @Description: 拦截器
 * @Date 2022/12/14 14:18
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
       registry.addInterceptor(jwtInterceptor).addPathPatterns("/**")
               .excludePathPatterns("/user/userLogin")
               .excludePathPatterns("/user/userRegister");
    }
}
