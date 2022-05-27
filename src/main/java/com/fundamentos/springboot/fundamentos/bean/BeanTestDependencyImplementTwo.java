package com.fundamentos.springboot.fundamentos.bean;

public class BeanTestDependencyImplementTwo implements BeanTestDependency{

	@Override
	public void testDependency() {
		System.out.println("probando mi segunda implementacion");
		
	}

}
