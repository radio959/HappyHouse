package ssafy.com.kkyuwoo.happyhouse.auth.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing // jpa 실행시 감시 로그 남김
public class JpaConfiguration {
}
