package com.excel;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class LireExcelFichier {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Déclaration des varriables
		ArrayList<String> values=new ArrayList<String>();
		Connection connection;
		Statement statement;
		
		//Récupération des données depuis excel
		
		try {
			InputStream input=new FileInputStream("");
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
					
					Class.forName("com.mysql.jdbc.Driver");
					
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/importexcel","root","toor");
					
					statement = connection.createStatement();
					String sql =String.format("INSERT INTO users(first_name,last_name,username,passwords,age) VALUES ('%','%','%','%','%')", 
							values.get(0),values.get(1),values.get(2),values.get(3),values.get(4));
					
					int count=statement.executeUpdate(sql);
					System.out.println(count);
					
					if(count>0){
						System.out.printf("Enrégistrements effectués ! \n",count);
					}
					
				} catch (Exception e) {
					
				}
				
			}
			
		} catch (Exception e) {
			
		}
		
		

	}

}
