package com.fundamentos.springboot.fundamentos.bean;


public class BeanTestDependencyImplement implements BeanTestDependency{

	@Override
	public void testDependency() {
		System.out.println("probando mi dependencia");
		
	}

}
