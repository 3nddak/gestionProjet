package test;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Sinistre;
import com.entities.SinistreDetail;
import com.imetier.IMetierSinistre;
import com.imetier.IMetierSinistreDetail;
import com.metierImpl.MetierSinistreImpl;

public class Test {

	public static void main(String[] args) {
				
				try {
					ApplicationContext 	context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
					IMetierSinistreDetail metier = (IMetierSinistreDetail) context.getBean("metierSinistreDetail");
					
					metier.ajouterSinistreDetail(new SinistreDetail(new Date(), "2018", 400, "45FTGH", 9801256, "AN",
					"Nana N'Guissan", "234/6TG/0098", "00TH76", "SZE3DFF", "568UJH00", "08JY76HTT", 23444, 567890, 123456,
					1234567, "9065GFEE", "Nean", " ", "OKKK"));
					
					
					
				System.out.println("  "+ new Date());	
				
				
				
				
				} catch (BeansException e) {
					e.printStackTrace();
				}
					
		
		

			}

		
		


}
