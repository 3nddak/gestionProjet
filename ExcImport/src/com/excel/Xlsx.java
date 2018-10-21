package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entities.Context;
import com.entities.Sinistre;
import com.exception.ExcelException;
import com.imetier.IMetierSinistre;

public class Xlsx {
	static int cp = 0;
	static int j = 0;
	static int i = 0;

	public static void main(String[] args) {
		Sinistre sinistre = new Sinistre();
		DataFormatter formatter = new DataFormatter();
		System.out.println("Je suis dans le main !!");

		// Déclaration des varriables
		ArrayList<Object> values = new ArrayList<Object>();

		Context ctx = new Context();
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { ctx.getApplicationContextDb() });
		IMetierSinistre metier = (IMetierSinistre) context.getBean("metierSinistre");
		// Récupération des données depuis excel

		try {
			System.out.println("Je suis dans le main2 !!");
			FileInputStream input = new FileInputStream(new File("maladie2.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(input);
			XSSFSheet sheet = wb.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
			SimpleDateFormat dFomat = new SimpleDateFormat();
			// System.out.println("Je suis dans le main3 !!");
			
			for (int x=0;x<=5312;x++) {
				i++;
				System.out.println("Je suis dans le while1");
				values.clear();
				XSSFRow row = (XSSFRow) rows.next();

				Iterator cells = row.cellIterator();

				
				for (int c=0;c<=18;c++) {
					j++;
					System.out.println("Je suis dans le while2 !!");
					// System.out.println("Affichages cells
					// "+cells.toString().length());

					XSSFCell cell = (XSSFCell) cells.next();

					System.out.println("j vaut : =" + j);
					
							if(cell.getCellType()==cell.CELL_TYPE_BLANK){
								values.add(cell.CELL_TYPE_BLANK);
								System.out.println("cell.getCellType()==cell.CELL_TYPE_BLANK  je suis dans j vaut : =" + j);
							}
							else{
								values.add(contenuCellule(cell, wb));
								System.out.println("values.add(contenuCellule(cell, wb));  je suis dans j vaut : =" + j);
							}

				}
       j=0;
				try {

					System.out.println("Je suis dans le try insertion Sinistre !!!");
					SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");

					System.out.println(
							"Je suis dans le try insertion Sinistre, après SimpleDateFormat sdf= new SimpleDateFormat(dd:MM:yyyy)  !!!  "
									+verifieObjetString(values.get(3),i,j));
					/*
					 * System.out.
					 * println("J'affiche tous les sinistres --Date---"+values.
					 * get(0)+"J'affiche tous les sinistres---AnneeProd---"
					 * +values.get(1)+"----Integger----"+values.get(2)+
					 * "----NumDossier----"+values.get(3)+
					 * "---Integger----NumPolice----"+values.get(4)+
					 * "---NumAvenant--String---"+values.get(5) +
					 * "---Souscripteur---String-----"+values.get(6)+
					 * "---Bénéficiaire--String----"+values.get(7)+
					 * "---Expose---double----"+verifieObjetDouble(values.get(8)
					 * )+"--"
					 * +"---Paye--double---"+verifieObjetDouble(values.get(9))+
					 * "---Recours---Double---"+verifieObjetDouble(values.get(10
					 * ))
					 * +"---ApresRecours--Double---"+verifieObjetDouble(values.
					 * get(12))+"----PartPA---Formule---Valeur---"+
					 * verifieObjetDouble(values.get(13))+
					 * "---LibelletFacture--String--"+values.get(14)+
					 * "---CodeSem---String---"+values.get(15)+
					 * "--Banque--Nom--String---"+values.get(16)+
					 * "---Chaque--NumCheque--String---"+values.get(17)+
					 * "---Date--DateCheque--Date----"+values.get(18)+
					 * "----Observation---String---"+values.get(19));
					 */

					cp = 0;
					metier.ajouterSinistre(new Sinistre(verifieObjetDate(values.get(0), i, j), verifieObjetString(values.get(1), i, j),
							verifieObjetInteger(values.get(2), i, j),verifieObjetString(values.get(3), i, j), verifieObjetInteger(values.get(4), i, j),
							verifieObjetString(values.get(5), i, j),verifieObjetString(values.get(6), i, j), verifieObjetString(values.get(7), i, j),
							verifieObjetDouble(values.get(8), i, j),verifieObjetDouble(values.get(9), i, j), verifieObjetDouble(values.get(10), i, j),
							verifieObjetDouble(values.get(11), i, j),verifieObjetDouble(values.get(12), i, j),verifieObjetString(values.get(13), i, j),
							verifieObjetString(values.get(14), i, j), verifieObjetString(values.get(15), i, j),verifieObjetString(values.get(16), i, j),
							verifieObjetDate(values.get(17), i, j), verifieObjetString(values.get(18), i, j),2));

					System.out.println("Je suis après l'insertion   " + values.get(0));

					System.out.println("Je suis l'objet createStatement !");

					System.out.println("Je suis l'objet COUNT ");

				} catch (Exception e) {

				}

				System.out.println("i vaut : " + i);
			}

		} catch (Exception e) {

		}

	}

	public static double verifieObjetDouble(Object o,int i,int j) {
		cp++;
		System.out.println("Caste double réussie !!" + cp);
		if (o instanceof Double) {
			double db =(double) o;
			
			return Double.valueOf(db).doubleValue();
		} else {

			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkj ai pas reussi le caste " + o.getClass());
			return 0.0;
		}

	}

	public static String verifieObjetString(Object o,int i, int j) {
		String d="";
		cp++;
		
		// if(o==null){
		//
		// return d;
		// }
		// else{
		// try {
		// d = (String) o;
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// }
		// System.out.println("l'objet string converti vaut: "+d);
		// return d;
		// }
		o = o.toString();
		if (o instanceof String) {
			  d = (String) o;
			System.out.println("caste String réussi !!" + cp);
			return  d;
		} else {
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkj ai pas reussi le caste d'un String linge "+i+" cellule "+j);
			return null;
		}

	}

	public static int verifieObjetInteger(Object o,int i,int j) {
		cp++;
		

		if (o instanceof Double) {
			double a=(double)o;
			if(a!=0.0){
				System.out.println("OK OK Integer"+a);
				int k=Double.valueOf(a).intValue();
				System.out.println("caste Integer réussi !" + cp);
				return k;
			}
			
		} else {
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkj ai pas reussi le caste d'un entier linge "+i+" cellule "+j);

			return 0;
		}
		return 0;

	}
	
	
	public static Date verifieObjetDate(Object o, int i, int j) {
		cp++;
		if (o instanceof Date) {
			Date a= new Date();
			a=(Date) o;
			System.out.println("OK OK Date verif "+a);
		
			System.out.println("caste Date réussi !" + cp);
			return a ;
			
		} else {
			System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkj ai pas reussi le caste d'une date linge "+i+" cellule "+j);

			return new Date();
		}

	}
	

	public static Object contenuCellule(XSSFCell cell, XSSFWorkbook wb) throws ExcelException {
		Object value = null;
		SimpleDateFormat dFomat = new SimpleDateFormat();

		if (cell.getCellType()==cell.CELL_TYPE_BLANK) {
			
			System.out.println("Champ vide !!");
			
         return value;
		}

		else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
			return cell.getBooleanCellValue();
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
			int a = cell.getErrorCellValue();
			return a;
		}

		else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {

			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			CellValue cellValue = evaluator.evaluate(cell);

			if (cellValue.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();
			} else if (cellValue.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getNumericCellValue();
			} else if (cellValue.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				//System.out.println("rentreerrrrrrrrrrrrrrrrrrrrrr");
				return cell.getRichStringCellValue().getString();
			} else if (cellValue.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
				return cell.getErrorCellValue();
			}
		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {

			if (DateUtil.isCellDateFormatted(cell)) {

				return cell.getDateCellValue();
			}

			else {

				return cell.getNumericCellValue();
			}

		} else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
			return cell.getRichStringCellValue().getString();

		}
		return value;
	}

}
