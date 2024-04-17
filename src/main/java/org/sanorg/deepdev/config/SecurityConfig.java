package org.sanorg.deepdev.config;


import org.sanorg.deepdev.service.UserInfoDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userDetailsServiceProvider() {

//        UserDetails admin = User.withUsername("sanjay").password(passwordEncoder.encode("sanjay")).roles("ADMIN").build();
//        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("sanjay")).roles("USER").build();
//        return new InMemoryUserDetailsManager(admin, user);

        return new UserInfoDetailsService();
}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/dev/adduser").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin.loginPage("/index.html").permitAll()
            );
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceProvider());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}
