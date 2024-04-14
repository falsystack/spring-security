package jp.falsystack.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuth2ClientConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
    }

    ClientRegistration keycloakClientRegistration() {
        return ClientRegistrations
                .fromIssuerLocation("http://localhost:8080/realms/OAuth2")
                .clientId("oauth2-client-app")
//                .scope("openid")
                .clientSecret("tOgXbt455UlUmDn9jEs73sAZXFlNhldR")
                .redirectUri("http://localhost:8081/login/oauth2/code/keycloak")
                .build();
    }
}
