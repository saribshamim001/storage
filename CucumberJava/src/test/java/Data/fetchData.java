package Data;

import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class fetchData {
	
	
	static XSSFWorkbook work_book;
	static XSSFSheet sheet;
	public fetchData(String excelfilePath) {
	try {
	File s = new File(excelfilePath);
	FileInputStream stream = new FileInputStream(s);
	work_book = new XSSFWorkbook(stream);
	}
	catch(Exception e) {
	System.out.println(e.getMessage());
	}
	}
	
	public String getData(String sheetname,int row){
	
	sheet = work_book.getSheet(sheetname);
	
	String stringFound = sheet.getRow(row).getCell(0).getStringCellValue();
	
	try {
		work_book.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return stringFound;
	}
}

	


