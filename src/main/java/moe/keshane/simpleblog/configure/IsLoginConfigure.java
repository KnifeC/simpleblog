package moe.keshane.simpleblog.configure;

import moe.keshane.simpleblog.component.PermissionIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IsLoginConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionIntercepter()).addPathPatterns("/image","/admin","/deletearticle/**","/edit","/edit/**","/article","/write","/postcomment");
    }
}
