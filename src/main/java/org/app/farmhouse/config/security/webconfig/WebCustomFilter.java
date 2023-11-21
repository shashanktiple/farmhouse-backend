package org.app.farmhouse.config.security.webconfig;

import org.app.farmhouse.config.security.filter.CustomAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebCustomFilter {

    @Autowired
    private CustomAuthenticationFilter filter;

    public SecurityFilterChain customFilterChain(HttpSecurity http) throws Exception {
        return http.addFilterAt(filter, UsernamePasswordAuthenticationFilter.class).build();
    }
}
