package jp.falsystack.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@EnableWebSecurity
public class OAuth2ClientConfig {

    @Bean
    MvcRequestMatcher.Builder mvc(
            HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        return http
                .authorizeHttpRequests(authRequest -> authRequest.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
//                .authorizeHttpRequests(authRequest ->
//                        authRequest.requestMatchers(
//                                mvc.pattern("/loginPage")
//                        ).permitAll().anyRequest().authenticated())
//                .oauth2Login(oauth2 -> oauth2.loginPage("/loginPage"))
                .build();
    }
}
