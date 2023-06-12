package Test.Scripts.IBG;

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

public class CDR_Issuance_IBG extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\ CDRIssuanceinput.xlsx";

    @Test(groups = {"IBGInputter"})

    public void CDRIssueInputIBG(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Issuance ");
        PageObject.menu_Link("Call Deposit Receipt- Single Issuance ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");
        String HomePage2 = driver.getWindowHandle();
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1000264788");
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","SARA");

        PageObject.switchToChildWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);

        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE" , 4);

        PageObject.form_Tab("Due Delligence");

        PageObject.textinput_Locator("fieldName:DD.ADDRESS:1","D1-SAT");
        PageObject.textinput_Locator("fieldName:ID.TYPE","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER","4220190909123");
        PageObject.textinput_Locator("fieldName:CONTACT.NO:1","03338980967");
        PageObject.select_Locator("fieldName:INS.ISS.PURPOSE", "Business Investment");

        PageObject.commitDeal("CDRIssueInputIBG");

}

    @DataProvider(name = "excelDataCDRIssuanceinput")
    public Object[][] readExcelData1() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        //rowCount-=2;
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
    }

    @Test(groups = {"Authorizer"})

    public void  CDRRevalidate_Auth() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("IBG - Manager Operation Menu");

        PageObject.menu_Dropdown("Core Retail Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt- Authorizer Menu");

        PageObject.menu_Dropdown("Call Deposit Receipt Instrument Authorization");

        PageObject.menu_Link("Authorization of Single CDR Issuance ");

        String menu1 = PageObject.switchToChildWindow();

        PageObject.find_Button();

        PageObject.form_Link("Authorize Transaction");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.img_Button("Authorises a deal");


    }

    @DataProvider(name = " CDRIssuanceinput")
    public Object[][]  CDRIssuanceinputData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CDRIssuanceinput.xlsx";
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
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
    }
}
