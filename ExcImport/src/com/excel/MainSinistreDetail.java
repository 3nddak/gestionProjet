package com.excel;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Context;
import com.entities.Sinistre;
import com.entities.SinistreDetail;
import com.exception.ExcelException;
import com.imetier.IMetierSinistre;
import com.imetier.IMetierSinistreDetail;

public class MainSinistreDetail {

		static int cp = 0;
		static int t=0;
		static int i = 0;
		static int p = 0;
		static int j = 0;

		public static void main(String[] args) {
			Sinistre sinistre = new Sinistre();
			DataFormatter formatter = new DataFormatter();
			System.out.println("Je suis dans le main !!");

			// Déclaration des varriables
			ArrayList<Object> values = new ArrayList<Object>();

			Context ctx = new Context();
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { ctx.getApplicationContextDb() });
			IMetierSinistreDetail metier = (IMetierSinistreDetail) context.getBean("metierSinistreDetail");
			// Récupération des données depuis excel

			try {
				System.out.println("Je suis dans le main2 !!");
				FileInputStream input = new FileInputStream(new File("SinistreDetail2018.xlsx"));
				XSSFWorkbook wb = new XSSFWorkbook(input);
				XSSFSheet sheet = wb.getSheetAt(0);
				Iterator rows = sheet.rowIterator();
				SimpleDateFormat dFomat = new SimpleDateFormat();
				// System.out.println("Je suis dans le main3 !!");
				
				
				while (rows.hasNext()) {
					i++;
					System.out.println("Je suis dans le while1");
					values.clear();
					XSSFRow row = (XSSFRow) rows.next();

					Iterator cells = row.cellIterator();

					
					while (cells.hasNext()) {
						j++;
						
						System.out.println("Je suis dans le while2 !!");
						// System.out.println("Affichages cells
						// "+cells.toString().length());

						XSSFCell cell = (XSSFCell) cells.next();

						System.out.println("i vaut : =" + i);
						System.out.println("j vaut : =" + j);
						values.add(contenuCellule(cell, wb));
						

					}
           j=0;
					try {

						System.out.println("Je suis dans le try insertion Sinistre !!!");
						SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
						
						//metier.ajouterSinistreDetail(new SinistreDetail(verifieObjetDate(values.get(0), i, j), verifieObjetString(values.get(1), i, j),verifieObjetInteger(2, i, j)));

						/*System.out.println("Je suis dans le try insertion Sinistre, après SimpleDateFormat sdf= new SimpleDateFormat(dd:MM:yyyy)  !!!  "
										+verifieObjetString(values.get(0), i, j));*/
					
						
						
						System.out.println("--verifieObjetDate(values.get(0))-- "+verifieObjetDate(values.get(0), i, j)+"--verifieObjetString(values.get(1))---"+
								verifieObjetInteger(values.get(1), i, j)+"--verifieObjetInteger(values.get(2))--"+verifieObjetInteger(values.get(2), i, j)+
								"--verifieObjetInteger(values.get(2))--"+verifieObjetInteger(values.get(2), i, j)+"-- verifieObjetString(values.get(3))--"
										+verifieObjetString(values.get(3), i, j)+"--verifieObjetInteger(values.get(4))--"+verifieObjetInteger(values.get(4), i, j)+
									"---verifieObjetString(values.get(5))--"+verifieObjetString(values.get(5), i, j)+"--verifieObjetString(values.get(6))--"
										+verifieObjetString(values.get(6), i, j)+"--verifieObjetString(values.get(7))---"+verifieObjetString(values.get(7), i, j)+
										"--verifieObjetString(values.get(8))--"+verifieObjetString(values.get(8), i, j)+"--verifieObjetString(values.get(9))--"+
										verifieObjetString(values.get(9), i, j)+"--verifieObjetString(values.get(10))--"+verifieObjetString(values.get(10), i, j)+
										"--verifieObjetString(values.get(11))--"+verifieObjetString(values.get(11), i, j)+"--verifieObjetDouble(values.get(12))--"
										+verifieObjetDouble(values.get(12), i, j)+"--verifieObjetDouble(values.get(13))--"+verifieObjetDouble(values.get(13), i, j)+
										"--verifieObjetDouble(values.get(14)--)"+verifieObjetDouble(values.get(14), i, j)+"--verifieObjetDouble(values.get(15))--"
										+verifieObjetDouble(values.get(15), i, j)+"--verifieObjetString(values.get(16))--"+verifieObjetString(values.get(16), i, j)+
										"--verifieObjetString(values.get(17))--"+verifieObjetString(values.get(17), i, j)+"--verifieObjetString(values.get(18))--"
										+verifieObjetString(values.get(18), i, j)+"--verifieObjetString(values.get(19))--"+verifieObjetString(values.get(19), i, j));
						
						
						   System.out.println("Nous somme après la ligne N° "+i);
						

						cp = 0;
						System.out.println("réussite d'insertion de la ligne N° "+p);
					/*
							
				metier.ajouterSinistreDetail(new SinistreDetail(verifieObjetDate(values.get(0), i, j), verifieObjetInteger(values.get(1), i, j), 
						verifieObjetInteger(values.get(2), i, j),verifieObjetString(values.get(3), i, j), verifieObjetInteger(values.get(4), i, j),
						verifieObjetString(values.get(5), i, j), verifieObjetString(values.get(6), i, j),verifieObjetString(values.get(7), i, j), 
						verifieObjetString(values.get(8), i, j), verifieObjetString(values.get(9), i, j), verifieObjetString(values.get(10), i, j),
						verifieObjetString(values.get(11), i, j), verifieObjetDouble(values.get(12), i, j), verifieObjetDouble(values.get(13), i, j), 
						verifieObjetDouble(values.get(14), i, j),verifieObjetDouble(values.get(15), i, j), verifieObjetString(values.get(16), i, j),
						verifieObjetString(values.get(17), i, j), verifieObjetString(values.get(18), i, j),verifieObjetString(values.get(19), i, j)));
							*/
					
						p++;
						
						
						System.out.println("j vaut : " +j);

						System.out.println("Je suis après l'insertion   " + values.get(0));

						System.out.println("Je suis l'objet createStatement !");

						System.out.println("Je suis l'objet COUNT ");
						

					} catch (Exception e) {

					}
					    
					
				}

			} catch (Exception e) {

			}
		}

		public static double verifieObjetDouble(Object o,int i,int j) {
			cp++;
			System.out.println("Caste double réussie !!" + cp);
			System.out.println("j vaut : !!" + j);
			System.out.println("i vaut : " +i);
			if (o instanceof Double) {
                double n = (double) o;
                double t = Double.valueOf(n).doubleValue();
				return t;
			} else {

				System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkj ai pas reussi le caste " + o.getClass());
				return 0;
			}

		}

		public static String verifieObjetString(Object o,int i,int j) {
			String d="";
			String t = null;
			
			
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
				
				try {
					d = (String) o;
					  t= String.valueOf(d).toString();
					  cp++;
					System.out.println("caste String réussi !!" +cp);
					
				} catch (Exception e) {
					
					System.out.println("kkkk--kDavid--kkkkkkj ai pas reussi le caste!! lingne= "+i+"---de la celule : "+j+"---"+e.getLocalizedMessage()+"--t--  "+t+" "+e.getLocalizedMessage()+" objet "+o.toString());
				}
				return  t;
			} else {
				System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkj ai pas reussi le caste " + o.getClass());
				return null;
			}

		}


		public static int verifieObjetInteger(Object o,int i, int j) {
			cp++;
			
			if (o instanceof Double) {
				double a=(double)o;
				System.out.println("OK OK Integer"+a);
				int t=Double.valueOf(a).intValue();
				System.out.println("caste Integer réussi !" + cp);
				return t;
				
			} else {
				System.out.println("j'ai pas reussie a caster l'entier ######################");

				return 0;
			}

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
				System.out.println("j'ai pas reussie a caster la date ######################");

				return new Date();
			}

		}

		public static Object contenuCellule(XSSFCell cell, XSSFWorkbook wb) throws ExcelException {
			Object value = null;
			Double d =0.0;
			if (cell == null) {
				
				return value;
			}

			else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {

				FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
				CellValue cellValue = evaluator.evaluate(cell);

				if (cellValue.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
					try {
						Boolean b=false;
						b=cell.getBooleanCellValue();
						return b;
					} catch (Exception e) {
						e.getMessage();
					}
				} else if (cellValue.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
					
					if (DateUtil.isCellDateFormatted(cell)) {
						
						try {
							
							return cell.getDateCellValue();
						} catch (Exception e) {
							System.out.println(" FormulaDate Exception !"+e.getMessage());
						}

						
					}

					else {

						try {
							return d = cell.getNumericCellValue();
						} catch (Exception e) {
							e.getMessage();
						}
					}
				} else if (cellValue.getCellType() == XSSFCell.CELL_TYPE_STRING) {
					System.out.println("rentreerrrrrrrrrrrrrrrrrrrrrr");
					
					try {
						
						return cell.getRichStringCellValue();
						
					} catch (Exception e) {
						e.getMessage();
					}
				} else if (cellValue.getCellType() == XSSFCell.CELL_TYPE_ERROR) {
					try {
						Byte b=0;
						b=cell.getErrorCellValue();
						return b;
					} catch (Exception e) {
						e.getMessage();
					}
				}
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {

				if (DateUtil.isCellDateFormatted(cell)) {

					try {
						return cell.getDateCellValue();
					} catch (Exception e) {
						e.getMessage();
					}
				}

				else {

					try {
						return d = cell.getNumericCellValue();
						
					} catch (Exception e) {
						e.getMessage();
					}
				}

			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				try {
					
					return cell.getRichStringCellValue();
					
				} catch (Exception e) {
					e.getMessage();
				}

			}
			return value;
		}

}
