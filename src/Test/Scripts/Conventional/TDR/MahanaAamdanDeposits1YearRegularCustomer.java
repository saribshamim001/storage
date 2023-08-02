package Test.Scripts.Conventional.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MahanaAamdanDeposits1YearRegularCustomer extends BaseClass {

    @Test(groups = {"InputterTDR"},dataProvider = "MahanaAamdanDepositInputter")
    public void MahanaAamdanDepositInputter(Map<String, String> testData) throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Mahana Aamdan Deposits - 1 Year");
        PageObject.menu_Link("Mahana Aamdan Deposits 1Y - Regular Customer ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.img_Button("New Deal");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID",testData.get("Customer"));
        PageObject.textinput_Locator("fieldName:PRINCIPAL",testData.get("Principal"));
        PageObject.img_Button("Validate a deal");

    }
    @Test(groups = {"AuthorizerTDR"})
            public void MahanaAamdanDepositAuth() throws IOException{

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Authorization Of Mahana Aamdan Deposits");
        PageObject.menu_Link("Authorization of Mahana Aamdan Deposits 1 Y ");
        PageObject.switchToChildWindow();
        driver.manage().window().maximize();
            }

    @DataProvider(name = "MahanaAamdanDepositInputter")
    public Object[][] readExcelData1() throws IOException {

        String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\MahanaAamdanDeposits1YearRegularCustomer.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("MahanaAamdanDepositInputter"); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
            Row row = sheet.getRow(i);
            Map<String, String> map = new HashMap<String, String>();
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);
                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
            }
            data[i - 1][0] = map;
        }
        workbook.close();
        fis.close();
        return data;
//
    }
}
