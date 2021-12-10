package ws.synopsis.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(User.withUsername("operator")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("12345678").roles("OPERATOR").build());

        userDetailsManager.createUser(User.withUsername("manager")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("87654321").roles("MANAGER").build());

        return userDetailsManager;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/v1/clients", "/v1/clients/filter/phone/**").hasRole("OPERATOR")
            .antMatchers(HttpMethod.POST,"/v1/clients").hasRole("MANAGER")
            .antMatchers(HttpMethod.PUT,"/v1/clients").hasRole("MANAGER")
            .antMatchers(HttpMethod.DELETE,"/v1/clients").hasRole("MANAGER")
            .antMatchers(HttpMethod.POST,"/v1/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            //.and()
            //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }

}
