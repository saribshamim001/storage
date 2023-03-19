package Main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class fetchDataGoogle {
	
	

	static XSSFWorkbook work_book;
	static XSSFSheet sheet;
	
	public fetchDataGoogle(String excelfilePath) {
	
	try {
	
	File s = new File(excelfilePath);
	FileInputStream stream = new FileInputStream(s);
	work_book = new XSSFWorkbook(stream);
	
	}
	catch(Exception e) {
	
	System.out.println(e.getMessage());
	
	}
	
	
	}
	
	
	public static ArrayList <String[]> getData(int sheetnumber){
	
	sheet = work_book.getSheetAt(sheetnumber);

	int len = work_book.getSheetAt(sheetnumber).getLastRowNum();
	len = len + 1;
	
	ArrayList <String[]> theDataArray = new ArrayList<String[]>();  
	
	for (int i=0; i < len ; i ++) {
		
		//Get string and numeric values:
		String value = sheet.getRow(i).getCell(0).getStringCellValue();
		//Double secNum = sheet.getRow(i).getCell(11).getNumericCellValue();
		
		String values[]= {value};
		theDataArray.add(values);
	
	}
	
	
	return theDataArray;
	
	}
	

}
