package program2;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	static XSSFWorkbook work_book;
	static XSSFSheet sheet;
	
	public ReadExcelFile(String excelfilePath) {
	
	try {
	
	File s = new File(excelfilePath);
	FileInputStream stream = new FileInputStream(s);
	work_book = new XSSFWorkbook(stream);
	
	}
	catch(Exception e) {
	
	System.out.println(e.getMessage());
	
	}
	
	
	}
	
	
	public static ArrayList <Object[]> getData(int sheetnumber){
	
	sheet = work_book.getSheetAt(sheetnumber);
	
	int len = sheet.getLastRowNum() + 1;
	
	System.out.println("The row count: "+len);
	
	ArrayList <Object[]> theDataArray = new ArrayList<Object[]>();  
	
	for (int i=0; i < len ; i ++) {
		
		String username = sheet.getRow(i).getCell(0).getStringCellValue();
		
		String password = sheet.getRow(i).getCell(1).getStringCellValue();
		
		String city = sheet.getRow(i).getCell(2).getStringCellValue();
		
		String d1 = sheet.getRow(i).getCell(3).getStringCellValue();
		
		String d2 = sheet.getRow(i).getCell(4).getStringCellValue();
		
		String name = sheet.getRow(i).getCell(5).getStringCellValue();
		
		String fname = sheet.getRow(i).getCell(6).getStringCellValue();
		
		String address = sheet.getRow(i).getCell(7).getStringCellValue();
		
		Double dnum = sheet.getRow(i).getCell(8).getNumericCellValue();
		
		Double month = sheet.getRow(i).getCell(9).getNumericCellValue();
		
		
		Double year = sheet.getRow(i).getCell(10).getNumericCellValue();
		
		Double secNum = sheet.getRow(i).getCell(11).getNumericCellValue();
		
		Object ob[]= {username,password,city,d1,d2,name,fname,address,dnum,month,year,secNum};
		theDataArray.add(ob);
	
	}
	
	
	return theDataArray;
	
	}
	
	
	public int getRowCount(int sheetIndex){
	
	int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
	row = row + 1;
	return row;
	
	}
	

}
