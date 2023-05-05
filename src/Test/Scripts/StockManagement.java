package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StockManagement extends BaseClass {

    @Test(groups = {"Inputter"})
    public void stocksReceived() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Recieve  ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:INSTRUMENT.TYPE:1","CDR");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NUM:1","444444680");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NUM:1","444444685");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","345");
        PageObject.textinput_Locator("fieldName:INVOICE.NUMBER","55555");

        PageObject.commitDeal("StockManagement_StocksReceived");
        String txn = PageObject.getTxn();
        System.out.println(txn);

    }

    @Test(groups = {"Inputter"})
    public void stocksTransferFromMStoWS() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Transfer from MS to WS ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        //PageObject.textinput_Locator("transactionId","BC.123456");
        driver.findElement(By.xpath("(//input[@id='transactionId'])[2]")).sendKeys("BC.123558");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NO:1","123558");
        PageObject.click_Locator("fieldName:TO.SERIAL.NO:1");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NO:1","123580");
        PageObject.textinput_Locator("fieldName:NARRATIVE:1","Transfering from Main to Working Stock");
        PageObject.commitDeal("StocksTransfer_From_MStoWS");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }

    @Test(groups = {"Inputter"})
    public void stocksTransferFromWStoMS() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Transfer from WS to MS ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        //PageObject.textinput_Locator("transactionId","BC.123456");
        driver.findElement(By.xpath("(//input[@id='transactionId'])[2]")).sendKeys("BC.123558");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NO:1","123558");
        PageObject.click_Locator("fieldName:TO.SERIAL.NO:1");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NO:1","123580");
        PageObject.textinput_Locator("fieldName:NARRATIVE:1","Transfering from Main to Working Stock");
        PageObject.commitDeal("StocksTransfer_From_WStoMS");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }

    @Test(groups = {"Inputter"})
    public void stocksEnquiryMainStock() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Enquiries of Stock");
        PageObject.menu_Link("Main Stock ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1","FT123456789");
        PageObject.find_Button();
    }

    @Test(groups = {"Inputter"})
    public void stocksEnquiryWorkingStock() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Enquiries of Stock");
        PageObject.menu_Link("Working Stock ");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("value:1:1:1","FT123456789");
        PageObject.find_Button();
    }


    //Auth will be depended upon stocksReceived
    //Add parameter in @annotation of dependsUponMethod
    @Test(groups = {"Authorizer"},dataProvider = "excelData")
    public void authTheStocks(Map<String, String> testData) throws IOException  {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Authorisation of Stock");
        PageObject.menu_Link("Authorise/Delete Stock Records ");
        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();
        //Got the value from DataProvider file
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise Transaction");
        PageObject.img_Button("Authorises a deal");
        //then logout
    }

    //DependsOnMethods = {"stocksTransferFromMStoWS","stocksTransferFromWStoMS"}
    @Test(groups = {"Authorizer"},dataProvider = "excelData")
    public void authTheStockTransfers(Map<String, String> testData) throws IOException  {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Authorisation of Stock");
        PageObject.menu_Link("Authorise/Delete Stock Transfer Records ");

        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();

        //Got the value from DataProvider file
        PageObject.textinput_Locator("value:1:1:1",testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("Authorise Transaction");
        PageObject.img_Button("Authorises a deal");

        //Authorise click
        //then logout
    }


    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\StockManagement_StocksReceived.xlsx";
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
