package com.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Context;
import com.entities.Sinistre;
import com.imetier.IMetierSinistre;

public class Xls {

	public static void main(String[] args) {
		
		System.out.println("Je suis dans le main !!");
		
		//Déclaration des varriables
				ArrayList<String> values=new ArrayList<String>();
				Context ctx=new Context();
				ApplicationContext 	context = new ClassPathXmlApplicationContext(new String[]{ctx.getApplicationContextDb()});
				IMetierSinistre metier = (IMetierSinistre) context.getBean("metier");
				//Récupération des données depuis excel
				
				try {
					InputStream input=new FileInputStream("Classeur1.xls");
					POIFSFileSystem fs=new POIFSFileSystem(input);
					HSSFWorkbook wb=new HSSFWorkbook(fs);
					HSSFSheet sheet=wb.getSheetAt(0);
					Iterator rows=sheet.rowIterator();
					
					//System.out.println("Je suis dans le main3 !!");
					int i=0;
					while(rows.hasNext()){
						i++;
						System.out.println("Je suis dans le while1");
						values.clear();
						HSSFRow row=(HSSFRow) rows.next();
						
						Iterator cells=row.cellIterator();
						
						int j=0;
						while(cells.hasNext()){
							j++;
							System.out.println("Je suis dans le while2 !!");
						//	System.out.println("Affichages cells "+cells.toString().length());
							
							HSSFCell cell =(HSSFCell) cells.next();
							
							
							//System.out.println("Affichage de cell.getCellType()= "+cell.getCellType());
							//System.out.println("Affichage de HSSFCell.CELL_TYPE_NUMERIC=  !!"+HSSFCell.CELL_TYPE_NUMERIC);
							
							 if(HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType())

								 values.add(Integer.toString((int) cell.getNumericCellValue()));
								// System.out.println("Je suis dans le if1 !!"+values.get(0));
							
								 

							 else if(HSSFCell.CELL_TYPE_STRING == cell.getCellType())

								 values.add(cell.getStringCellValue());
							 //System.out.println("Je suis dans la fin add !!"+values.get(0));
							 
							 System.out.println("j vaut : ="+j);
							 try {
									
/*									
									System.out.println("je rentre dans le stockage DB");
									String sql =String
											.format("INSERT INTO users(first_name, last_name, username, passwords, age) VALUES ('%s','%s','%s','%s',%s)",
											values.get(0),values.get(1),values.get(2),values.get(3),values.get(4));*/
									System.out.println("Je suis après l'insertion   "+values.get(0));
									
									metier.ajouterSinistre(new Sinistre(new Date(), values.get(0), 400, values.get(1), 234500, values.get(2), values.get(3), "Koffi NGUISSAN", 17000, 12000, 0, 5000, 12000, "Fature N°000123", "CodeSEM", "BOA", "", new Date(), ""));
									System.out.println("Je suis après la connection !");
									
									
									System.out.println("Je suis l'objet createStatement !");
									
									
									
									System.out.println("Je suis l'objet COUNT ");
										
								
									
								} catch (Exception e) {
								
								}	
							
						}
	
	System.out.println("i vaut : "+i);
					}
					
				} catch (Exception e) {
					
				}
				
				


	}

}
