package Test.Scripts.Conventional.RetailBanking;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KYCAccountAmendment extends BaseClass {

    String ibgHomePage;
    String menu1;

    @Test(groups = {"caoInputter"},dataProvider = "TestData")
    public void KYC(Map <String,String> testData) throws InterruptedException, IOException {

        PageObject.menu_Dropdown("CENTRALIZED ACCOUNT PROCESSOR");
        PageObject.menu_Dropdown("CORE/RETAIL MAIN MENU");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("ACCOUNT");
        PageObject.menu_Dropdown("Amendment Account ");
        PageObject.menu_Link("Amendment Account ");

        menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
//
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1",testData.get("Acc_ID"));
//        PageObject.click_Locator("defaultButton");
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).sendKeys(Keys.ENTER);
        PageObject.form_Link("Amend Account");
        Thread.sleep(1000);
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);

//        PageObject.form_Tab("Mandatee Info");
//        PageObject.textinput_Locator("fieldName:MANDATEE.NAME:1",testData.get("Mname"));
//        PageObject.textinput_Locator("fieldName:KIN.ID.TYPE:1",testData.get("IDType"));
//        PageObject.textinput_Locator("fieldName:MANDATEE.NIC:1",testData.get("IDNum"));
//        PageObject.textinput_Locator("fieldName:MAND.OCCUPATION:1",testData.get("OCCUPATION"));
//        PageObject.textinput_Locator("fieldName:INCOME.SOURCE:1",testData.get("IncomeSource"));
//        PageObject.textinput_Locator("fieldName:MONTHLY.INCOME:1",testData.get("IncomeAmount"));
//        PageObject.textinput_Locator("fieldName:CUS.NATN:1",testData.get("Nationality"));
//        PageObject.textinput_Locator("fieldName:FAT.MANDT.ADDR:1",testData.get("Address"));


        // CRP Details
        PageObject.form_Tab("Clean Marking");
        driver.findElement(By.xpath("(//input[@id='fieldName:POSTING.RESTRICT:1'])[1]")).clear();
        driver.findElement(By.xpath("(//input[@id='fieldName:REASON'])")).clear();
        PageObject.textinput_Locator("fieldName:REASON","testing"+PageObject.idNumber(100,1));
//        PageObject.form_Tab("Customer's Risk Profiling Details");
//
//        PageObject.imgchild_Button("Expand Sub Value" , 2);
//        PageObject.textinput_Locator("fieldName:CUS.CATEG:2","1001");
//        PageObject.imgchild_Button("Expand Sub Value" , 4);
//        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:2","9");
//        PageObject.imgchild_Button("Expand Sub Value" , 6);
//        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:2","PK");
//        PageObject.imgchild_Button("Expand Sub Value" , 8);
//        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:2","1");
//        PageObject.imgchild_Button("Expand Sub Value" , 10);
//        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:2","402");
//        PageObject.imgchild_Button("Expand Sub Value" , 12);
//        PageObject.select_Locator("fieldName:SEDING.FACTS:2","Not Applicable");
//
//        commitDeal();
//
//        PageObject.select_Locator("fieldName:OCCUPATION","Business");
//        PageObject.textinput_Locator("fieldName:NAME.OF.BUS","EVENT MANAGEMENT");
//        PageObject.textinput_Locator("fieldName:NAT.OF.BUS","EVENT MANAGEMENT");
//        PageObject.textinput_Locator("fieldName:STAT.OWNER","EVENT MANAGEMENT");
//        PageObject.textinput_Locator("fieldName:NAME.OF.EMP","ALI REHMAN");
//        PageObject.textinput_Locator("fieldName:CS.POS","CEO");
//        PageObject.textinput_Locator("fieldName:CS.EMP.SINCE","1995");
//        PageObject.radiobutton_Locator("radio:mainTab:STATUS",1);
//
//        PageObject.textinput_Locator("fieldName:CURRENT.SALARY","");
//        PageObject.textinput_Locator("fieldName:OTHER.INCOME","");
//        PageObject.textinput_Locator("fieldName:OTHER.FUNDS","");
//        PageObject.textinput_Locator("fieldName:PER.PROP.INMNT","");
//        PageObject.textinput_Locator("fieldName:CS.ANNUM.TO","");
//        PageObject.textinput_Locator("fieldName:SOURCE.OF.INCOME","");
//        PageObject.radiobutton_Locator("radio:mainTab:REL.POILITICAL",1);
//        PageObject.textinput_Locator("fieldName:POLITICAL.FIGURE","");
//        PageObject.radiobutton_Locator("radio:mainTab:PFAMAPPROVAL",1);
//        PageObject.radiobutton_Locator("radio:mainTab:HRAMAPPROVAL",1);
//        PageObject.radiobutton_Locator("radio:mainTab:TRADE.CRP",1);
//        PageObject.textinput_Locator("fieldName:CUST.COMMENTS:1","NEW CUSTOMER");
//        PageObject.textinput_Locator("fieldName:EXP.COUNT.PARTY:1","ISLAMABAD");
//
//
//        commit2();
//        Customers.txnValidate();
//        Customers.saveToDS("ECRP");
        PageObject.commitDeal("KYCAccountAmendmentTxn");
    }

    @DataProvider(name = "TestData")
    public Object[][] readData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\Kyc_Amendment_Account.xlsx";
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



    @Test(groups = {"CaoAuthorizer1"},dataProvider = "TestDataAuth")
    public void KYCAccAuthorization(Map <String,String> testData) throws InterruptedException, IOException {
        PageObject.menu_Dropdown("CENTRALIZED ACCOUNT AUTHORISER");
        PageObject.menu_Dropdown("CORE/RETAIL MAIN MENU");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("ACCOUNT");
        PageObject.menu_Dropdown("Amendment Account");
        PageObject.menu_Link("List Of Unauthorised A/Cs ");
        menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        java.util.List<WebElement> frames = driver.findElements(By.tagName("frame"));
        // Get the count of frames
        int frameCount = frames.size();
        // Print the count of frames
        System.out.println("The webpage contains " + frameCount + " frames.");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
//        PageObject.find_Button();// <frame id="workarea205895702801" // frame id="workarea274585504201"
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).clear();
        driver.findElement(By.xpath("//input[@id='value:1:1:1']")).sendKeys(testData.get("Transaction Number"));
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
    }

    @DataProvider(name = "TestDataAuth")
    public Object[][] readData2() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\KYCAccountAmendmentTxn.xlsx";
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