package an.easycodedemo.config;

import an.easycodedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author AnRuicheng
 * @date 2020/4/1 - 20:15
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/img/**","/js/**","/json/**","/layui/**","/LoginPage.html","/register.html","/user").permitAll()
                .antMatchers("/ADMIN/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/LoginPage.html").loginProcessingUrl("/login").successHandler(new LoginSuccessHandler()).permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/LoginPage.html").invalidateHttpSession(true).permitAll()
                .and()
                .rememberMe().rememberMeParameter("rememberMe")
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userService).passwordEncoder(encoder());
    }

}
