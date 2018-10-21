package test;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Utilisateurs;
import com.imetier.IMetierUtilsateurs;

public class Test {

	public static void main(String[] args) {
				
				try {
					ApplicationContext 	context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
					IMetierUtilsateurs metier = (IMetierUtilsateurs) context.getBean("metier");
					
					metier.ajoutUser(new Utilisateurs("N'GUISSAN", "Nana", "ndavid", "3nddak"));
					
					
					
				System.out.println("  "+ new Date());	
				
				
				
				
				} catch (BeansException e) {
					e.printStackTrace();
				}
					
		
		

			}

		
		


}
