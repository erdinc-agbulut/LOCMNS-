package edu.mns.locmns.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecuriteLocMns extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersonneDetailsSeviceLocMns personneDetailsSeviceLocMns;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(personneDetailsSeviceLocMns);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/connexion").permitAll()
                    .antMatchers("/gestionnaire/**").hasRole("GESTIONNAIRE")
                    .antMatchers("/**").hasAnyRole("GESTIONNAIRE","UTILISATEUR")
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager getAuthentificationManager() throws Exception {
        return super.authenticationManager();
    }
}
