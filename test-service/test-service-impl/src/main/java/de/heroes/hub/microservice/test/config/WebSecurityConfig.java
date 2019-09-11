package de.heroes.hub.microservice.test.config;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import java.nio.charset.Charset;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    /**
     * define basic login
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .antMatchers("/").denyAll()
                .and().csrf().disable().httpBasic();
    }

    @Bean
    public SimpleUrlLogoutSuccessHandler simpleUrlLogoutSuccessHandler() {
        SimpleUrlLogoutSuccessHandler result = new SimpleUrlLogoutSuccessHandler();
        result.setTargetUrlParameter("spring-security-redirect");
        result.setDefaultTargetUrl("/login?logout");
        return result;
    }

    @Bean
    public HttpHeaders httpHeaders() {
        return new HttpHeaders() {

			private static final long serialVersionUID = 1L;

			{
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }
}
