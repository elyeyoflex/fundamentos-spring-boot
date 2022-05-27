package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties{
	private String name;
	private String surname;
	private String apodo;
	
	public MyBeanWithPropertiesImplement(String name, String surname, String apodo) {
		this.name = name;
		this.surname = surname;
		this.apodo = apodo;
	}

	@Override
	public String function() {
		String namesurname = "nombre: " + name + " "+apodo+" apellido: " + surname;
		return namesurname;
	}}
