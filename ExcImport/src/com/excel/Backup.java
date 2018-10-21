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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Sinistre;
import com.imetier.IMetierSinistre;

public class Backup {
	

		@SuppressWarnings("deprecation")
		public static void main(String[] args) {
			//Déclaration des varriables
			ArrayList<String> values=new ArrayList<String>();
			ApplicationContext 	context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			IMetierSinistre metier = (IMetierSinistre) context.getBean("metier");
			
			//Récupération des données depuis excel
			
			try {
				InputStream input=new FileInputStream("Classeur1.xls");
				POIFSFileSystem fs=new POIFSFileSystem(input);
				HSSFWorkbook wb=new HSSFWorkbook(fs);
				HSSFSheet sheet=wb.getSheetAt(0);
				Iterator rows=sheet.rowIterator();
				
				while(rows.hasNext()){
					values.clear();
					HSSFRow row=(HSSFRow) rows.next();
					
					Iterator cells=row.cellIterator();
					
					while(cells.hasNext()){
						HSSFCell cell =(HSSFCell) rows.next();
						
						 if(HSSFCell.CELL_TYPE_NUMERIC==cell.getCellType())
						 
							 values.add(Integer.toString((int) cell.getNumericCellValue()));

						 else if(HSSFCell.CELL_TYPE_STRING==cell.getCellType())
						
							 values.add(cell.getStringCellValue());
						 System.out.println(values);
					}
					

					
					try {
								metier.ajouterSinistre(new Sinistre(new Date(), values.get(0), 400, values.get(1), 234500, values.get(2), values.get(3), "Koffi NGUISSAN", 17000, 12000, 0, 5000, 12000, "Fature N°000123", "CodeSEM", "BOA", "", new Date(), ""));
								
						
					} catch (Exception e) {
						
					}
					
					
					
				}
				
				
				
			} catch (Exception e) {
				
			}
			
			

		}

	}



