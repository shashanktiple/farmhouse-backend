package org.app.farmhouse.config.security.webconfig;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityFilter {

//    @Autowired
//    private CustomAuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(h -> {
//                            h.requestMatchers("/api/inventory/product").permitAll();
//                            h.requestMatchers("/hello").permitAll();
//                            h.requestMatchers("/api/inventory/product/add").permitAll();
//                            h.requestMatchers("/api/inventory/product/add/**").permitAll();
//                            h.requestMatchers("/api/user/register/**").permitAll();
//                            h.requestMatchers("/api/user/login/**").permitAll();
            h.anyRequest().permitAll();
        });
//        http.addFilterAt(filter, UsernamePasswordAuthenticationFilter.class);
        return http.formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
