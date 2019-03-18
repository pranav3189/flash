package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

*/
//@EnableWebSecurity
public class SecurityConfig {

	/*
	
	@Configuration

	public class UserSecurityApp2 extends WebSecurityConfigurerAdapter{
	

		@Override
		public void configure(WebSecurity web) throws Exception {

			//web.ignoring().antMatchers("/api/**");
		}

		
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/api/**").permitAll()
			.and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/accessDenied");
			
			http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
		
		
	
		
		
	}

	*/


}
