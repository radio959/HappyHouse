package ssafy.com.kkyuwoo.happyhouse.auth.oauth2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ssafy.com.kkyuwoo.happyhouse.auth.oauth2.CustomOAuth2UserService;
import ssafy.com.kkyuwoo.happyhouse.domain.user.Role;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/statics/**")
                .antMatchers("/resources/**")
                .antMatchers("/css/**")
                .antMatchers("/vendor/**")
                .antMatchers("/js/**")
                .antMatchers("/favicon*/**")
                .antMatchers("/h2-console/**")
                .antMatchers("/images/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/api/v1/**").permitAll() // .hasRole(Role.USER.getKey())
                .anyRequest().permitAll();

        http.oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("http://localhost:8081/logoutProccess");
    }
}
