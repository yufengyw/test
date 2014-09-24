package com.helloWorld.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
@Configuration
public class DataSourceConfig {
	@Bean
	 public DataSource myDataSource(){
		 SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
	      dataSource.setDriverClass(org.h2.Driver.class);
	      dataSource.setUsername("sa");
	      dataSource.setUrl("jdbc:h2:~/testdb");
	      dataSource.setPassword("");
		return dataSource; 
	 }
	 

}
