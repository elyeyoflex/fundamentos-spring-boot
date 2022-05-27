package com.fundamentos.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
	
	private Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class)	;
	private MyOperation myOperation;
	
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		this.myOperation = myOperation;
	}


	@Override
	public void printWithDependency() {
		int numero = 9;
		System.out.println(myOperation.suma(numero));
		System.out.println("MyBeanWithDependency");
		LOGGER.info("hemos ingresados al metodo printWithDependency");
		LOGGER.debug("el numero enviado como parametro a la dependencia operacion es: " + numero);
	}

}
