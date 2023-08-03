package Test.Scripts.Conventional.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FloatingRateTermDepositsLCY extends BaseClass {

    String Txn;
    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TDR\\FloatingRateTermDepositsLCY.xlsx";

    @Test(groups = {"InputterTDR"}, dataProvider = "excelDataFloatingRateTermDepositsLCY")

    public void FloatingRateTermDepositsLCY(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR ");
        PageObject.menu_Dropdown("Alfalah Floating Rate Term Deposits LCY");
        PageObject.menu_Link("Alfalah Floating Rate Term Deposits LCY ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

//        PageObject.img_Button("New Deal");

//        String menu1 = PageObject.switchToChildWindow();
//        PageObject.switchToParentWindow(menu1);
//        homePage = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();

        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", testData.get("CUSTOMER.ID"));

        PageObject.textinput_Locator("fieldName:AMOUNT:1",testData.get("AMOUNT:1"));

        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");
        PageObject.textinput_Locator("","");

        PageObject.click_Locator("fieldName:DRAWDOWN.ACCOUNT");

//        String menu2 = PageObject.switchToChildWindow();

//        driver.close();



        PageObject.textinput_Locator("fieldName:DRAWDOWN.ACCOUNT",testData.get("DRAWDOWN.ACCOUNT"));
//        PageObject.click_Locator("fieldName:PRINCIPAL");
        PageObject.textinput_Locator("fieldName:PRIN.LIQ.ACCT",testData.get("PRIN.LIQ.ACCT"));
//        PageObject.click_Locator("fieldName:PRINCIPAL");
        PageObject.textinput_Locator("fieldName:INT.LIQ.ACCT",testData.get("INT.LIQ.ACCT"));
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD",testData.get("REST.PERIOD.LD"));

//        PageObject.form_Tab("Rollover Info");
        PageObject.radiobutton_Locator("radio:tab1:ZAKAT.EXEMP.LD",Integer.parseInt(testData.get("ZAKAT.EXEMP.LD")));
        PageObject.radiobutton_Locator("radio:tab1:PROFIT.EXEMP.LD",Integer.parseInt(testData.get("PROFIT.EXEMP.LD")));


//        PageObject.commitDeal("FloatingRateTermDepositsLCY");
        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();
        if (driver.getPageSource().contains("Accept Overrides")){
            WebElement override = driver.findElement(By.xpath("//tr/td/a[text()='Accept Overrides']"));
            override.click();
        }
        PageObject.commitDeal("FloatingRateTermDepositsLCY");



//        PageObject.authorizeByTxn(testData.get("Transaction Number"));





        Txn = PageObject.getTxn();
        System.out.println(Txn);

    }

    @DataProvider(name = "excelDataFloatingRateTermDepositsLCY")
    public Object[][] readExcelData1() throws IOException {

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
    public static void saveAccNumToFile(String accNumber) throws IOException {

        String Txn = accNumber ;
        System.out.println("Acc Number is: "+Txn);

        File file = new File(System.getProperty("user.dir") + "\\Data\\FloatingRateTermDepositsLCY.xlsx");
        XSSFWorkbook workbook;
        Row row;
        Cell cell;
        int rowNum = 0;

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            rowNum = sheet.getLastRowNum() + 1; // Start writing from the next row
        } else {
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0);
            cell.setCellValue("Acc Number");
        }

        Sheet sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum++);
        cell = row.createCell(0);
        cell.setCellValue(Txn);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }

    String FILE_PATH2 = System.getProperty("user.dir") + "\\Data\\FloatingRateTermDepositsLCY.xlsx";

    @Test(groups = {"AuthorizerTDR"}, dataProvider = "DataFloatingRateTermDepositsLCY")

    public void FloatingRateTermDepositsLCYAuth(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown(" Centralized TDR");
        PageObject.menu_Dropdown("Alfalah Floating Rate TDR Authorizer");
        PageObject.menu_Link("Authorization- Alfalah Floating Rate TDR ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();


        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();


        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Select Drilldown");
//        PageObject.authorizeByTxn(testData.get("Transaction Number"));

        String menu2 = PageObject.switchToChildWindow();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
    }

    @DataProvider(name = "DataFloatingRateTermDepositsLCY")
    public Object[][] readExcelData2() throws IOException {

        FileInputStream fis = new FileInputStream(FILE_PATH2);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
//        rowCount-=2;
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
