package com.helloWorld.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.access.AccessDeniedHandler;


@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource myDataSource;
	
	 @Autowired
	  protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  /*  auth.inMemoryAuthentication()
	        .withUser("user").password("password").roles("USER")
	        .and()
	        .withUser("admin").password("password").roles("ADMIN","USER");
	        */
		 auth
	        .jdbcAuthentication()
	            .dataSource(myDataSource)
	            .usersByUsernameQuery(getUserQuery())
	            .authoritiesByUsernameQuery(getAuthoritiesQuery());
	  }
	 
	 @Override
	  public void configure(WebSecurity webSecurity) throws Exception
	  {
	      webSecurity.ignoring().antMatchers("/resources/**");
	      webSecurity.ignoring().antMatchers("/html/**");
	  }
	 
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    //{!begin configure}
	    http.csrf().disable()
	    	.authorizeRequests()
	    	.anyRequest().authenticated()
	    	.antMatchers("/resources/**").permitAll() 
	    	.antMatchers("/html/**").permitAll() 
	    	.antMatchers("/admin/**").hasAnyRole("ADMIN")
	    	.and().exceptionHandling().accessDeniedPage("/403")
	        .and()
	        .formLogin()
	        //This will generate a login form if none is supplied.
	        //.formLogin().loginPage("/login")
	      //  .permitAll()
	       //  .and()
	        // .logout()                                    
            // .permitAll()
             
            ;
	    //{!end configure}
	  }

	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	  }
	
	  private String getUserQuery() {
	        return "SELECT username,password,true as enabled "
	                + "FROM user "
	                + "WHERE username = ?";
	    }

	    private String getAuthoritiesQuery() {
	        return "SELECT username,role "
	                + "FROM user "
	                + "WHERE username = ? ";
	    }
}

