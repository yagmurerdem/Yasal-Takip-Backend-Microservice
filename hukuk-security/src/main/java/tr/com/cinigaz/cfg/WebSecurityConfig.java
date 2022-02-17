package tr.com.cinigaz.cfg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import tr.com.cinigaz.entity.UserEnt;
import tr.com.cinigaz.service.AccountService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private BCryptPasswordEncoder passwordEncoder;
    private AccountService service;
    private JWTTokenHelper jWTTokenHelper;
    private AuthenticationEntryPoint authenticationEntryPoint;

    public WebSecurityConfig(AccountService service, BCryptPasswordEncoder passwordEncoder,JWTTokenHelper jwtTokenHelper,AuthenticationEntryPoint authenticationEntryPoint) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
        this.jWTTokenHelper = jwtTokenHelper;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }


    @Bean
    public UserDetailsService userDetailsService() {

        return (UserDetailsService) username -> {
            Optional<UserEnt> user = service.findbyusername(username);
            if (!user.isPresent())
                throw new UsernameNotFoundException("Kullanici yok" + username);
            return (UserDetails) user.get();
        };
    }

    @Bean
    public AuthenticationManager getAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*

        http
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .authorizeRequests()
                .antMatchers("/register","/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/authenticated")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable();

*/


        http.cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint).and()
                .authorizeRequests().antMatchers("/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(new JWTAuthenticationFilter(service,jWTTokenHelper), UsernamePasswordAuthenticationFilter.class);
    }
}