package com.deepan;

import com.deepan.filters.TestFilterOne;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountRestIbfDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountRestIbfDemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<TestFilterOne> setTestFilterOne(){

		FilterRegistrationBean<TestFilterOne> filter = new FilterRegistrationBean<>();

		filter.setFilter(new TestFilterOne());
		filter.addUrlPatterns("/api/v1/accounts/*");
		filter.setOrder(1);
		return  filter;
	}

}

//component
//service


//@configuration
//@ComponentScan
