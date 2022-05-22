package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
	
	
	private MyOperation myOperation;
	
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		this.myOperation = myOperation;
	}


	@Override
	public void printWithDependency() {
		System.out.println(myOperation.suma(8));
		System.out.println("MyBeanWithDependency");
		
	}

}
