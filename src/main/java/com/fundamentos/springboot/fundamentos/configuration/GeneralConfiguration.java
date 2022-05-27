package com.fundamentos.springboot.fundamentos.configuration;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
@PropertySource("classpath:connection.properties")
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
//@EnableJpaRepositories(basePackages = {"com.fundamentos.springboot.fundamentos"})
//@ComponentScan(basePackages = {"com.fundamentos.springboot.fundamentos"})
public class GeneralConfiguration {
	@Value("${value.name}")
	private String name;
	
	@Value("${value.surname}")
	private String surname;
	
	@Value("${value.apodo}")
	private String apodo;
	
	@Value("${value.random}")
	private String random;
	
	@Value("${jdbc.url}")
	private String jdbcUrl;
	
	@Value("${driver}")
	private String driver;
	
	@Value("${username}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public MyBeanWithProperties function() {
		return new MyBeanWithPropertiesImplement(name, surname, apodo);
	}
	
//	@Bean
//	public DataSource dataSource() {
//		DataSourceBuilder dataSourceBuilder= DataSourceBuilder.create();
//		dataSourceBuilder.driverClassName(driver);
//		dataSourceBuilder.url(jdbcUrl);
//		dataSourceBuilder.username(username);
//		dataSourceBuilder.password(password);
//		return (DataSource) dataSourceBuilder.build();
//	}
//	
//	@Bean(name="entityManagerFactory")
//	public LocalSessionFactoryBean sessionFactory() {
//	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//	    return sessionFactory;
//	}
	
}
