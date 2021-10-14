package ken.blog.Config;

import ken.blog.Handler.CustomLoginSuccessHandler;
import ken.blog.Handler.CustomLogoutSuccessHandler;
import ken.blog.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/script/**", "/favicon/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/loginAccount", "/createAccount").permitAll()
                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/loginAccount")
                .loginProcessingUrl("/loginAccount")
                .successHandler(new CustomLoginSuccessHandler())
                .and()

                .logout()
                .logoutUrl("/logoutAccount")
                .logoutSuccessHandler(new CustomLogoutSuccessHandler());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
           auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

    }
}