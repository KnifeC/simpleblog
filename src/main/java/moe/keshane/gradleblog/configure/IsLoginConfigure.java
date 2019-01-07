package moe.keshane.gradleblog.configure;

import moe.keshane.gradleblog.component.PermissionIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IsLoginConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionIntercepter()).addPathPatterns("/deletearticle","/edit","/edit/**","/article","/write");
    }
}
