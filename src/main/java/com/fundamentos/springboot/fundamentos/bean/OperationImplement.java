package com.fundamentos.springboot.fundamentos.bean;

public class OperationImplement implements MyOperation{

	@Override
	public int suma(int number) {

		return number + 1;
	}

}
