package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserDetailServiceImpl;



@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	public void configueGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		// Set đặt dịch vụ để tìm kiếm User trong database
		// Và set đặt PasswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		// chặn các csrf
		
		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/","/trang-chu", "/dang-nhap", "/dang-xuat").permitAll();
		
		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN
		// Nếu chưa login, nó sẽ redirect tới trang /login
		http.authorizeRequests().antMatchers("/trang-chu").access("hasAnyRole('ROLE_USER','ROLE_EMPLOYEE','ROLE_ADMIN')");
		
		// Trang chỉ dành cho ADMIN
		/*
		 * http.authorizeRequests().antMatchers("/admin","/admin/product",
		 * "/admin/product-save","/admin/category-save")
		 * .access("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')");
		 */
		
		http.authorizeRequests().antMatchers("/admin","/admin/product","/admin/product-save","/admin/category-save")
		.access("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')");
		
		
		
		//Khi người dùng đã login, với vai trò ROLE_USER,
		// Nhưng truy cập vào trang yêu cầu vai trò ROLE_ADMIN,
		// Ngoại lệ AccessDeniedException sẽ ném ra
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		// Cấu hình cho Login Form
		http.authorizeRequests().and().formLogin()
		             //Submit URL của trang login
					.loginPage("/dang-nhap")
					.defaultSuccessUrl("/") // Đường dẫn tới trang đăng nhập thành công
					.failureUrl("/dang-nhap?error=true") // đường nhẫn tới trang đăng nhập thất bại
					.usernameParameter("username")
					.passwordParameter("password")
					
					// Cấu hình cho Logout Page
					.and().logout().logoutUrl("/dang-xuat").logoutSuccessUrl("/dang-xuat");
	
	}
}
