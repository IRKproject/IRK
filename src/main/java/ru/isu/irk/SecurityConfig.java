package ru.isu.irk;

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
                .username("IRK_User1")
                .password("123")
                .roles("USER")
                .build();        
        UserDetails admin = User.builder()
                .username("IRK_admin")
                .password("12345")
                .roles("USER","ADMIN")
                .build();        
        return new InMemoryUserDetailsManager(user, admin);
    }
}*/
    
    /*@Bean
    public UserDetailsService users(){
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}123")
                .roles("USER")
                .build();        
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}123")
                .roles("USER","ADMIN")
                .build();        
        return new InMemoryUserDetailsManager(user, admin);
    }*/
    

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("admin")
            .password("{noop}admin")
            .roles("ADMIN")
            .build();

        UserDetails user1 = User.withUsername("IRK_User1")
                .password("{noop}123")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("IRK_admin")
                .password("{noop}12345")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, user1, admin);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}*/