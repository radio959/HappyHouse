package ssafy.com.kkyuwoo.happyhouse.auth.oauth2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ssafy.com.kkyuwoo.happyhouse.auth.LoginUserAnnotationProcessor;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private final LoginUserAnnotationProcessor loginUserAnnotationProcessor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        argumentResolvers.add(loginUserAnnotationProcessor);
    }
}
