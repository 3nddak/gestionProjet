package com.Controleur;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextProvider {
	static ApplicationContext	 context;
	static {
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}
	public static ApplicationContext  getContext(){
		return context;
	}
}
