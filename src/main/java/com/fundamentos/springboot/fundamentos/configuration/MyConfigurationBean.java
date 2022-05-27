package com.fundamentos.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.springboot.fundamentos.bean.BeanTestDependency;
import com.fundamentos.springboot.fundamentos.bean.BeanTestDependencyImplementTwo;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanImplement2;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependencyImplement;
import com.fundamentos.springboot.fundamentos.bean.MyOperation;
import com.fundamentos.springboot.fundamentos.bean.OperationImplement;

@Configuration
public class MyConfigurationBean {
	
	@Bean
	public MyBean beanOperation() {
		return new MyBeanImplement2();
	}
	
	@Bean
	public MyOperation beanMyOperation(){
		return new OperationImplement();
	}
	
	@Bean
	public BeanTestDependency beanTestDependencyOperation() {
		return new BeanTestDependencyImplementTwo();
	}
		
	@Bean
	public MyBeanWithDependency myBeanWtihDependency(MyOperation miOperation){
		return new MyBeanWithDependencyImplement(miOperation);
	}
}
