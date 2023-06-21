package Test.Scripts.Conventional.CAOD;

import POM.PageObject;
import Test.General.BaseClass;
import Test.Scripts.Conventional.Accounts;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Test.Scripts.Conventional.Customers.TC;

public class JointAccountCreation_LCY extends BaseClass {

    @Test(groups = {"CaoInputter"}, dataProvider = "inputterData")
    public void JointAccCreation_LCY(Map<String, String> testData) {

        PageObject.menu_Dropdown("Conventional Account Open");//test
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Current Account  ");
        String homePage = PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:CUSTOMER",testData.get("Cid"));
        PageObject.textinput_Locator("fieldName:CATEGORY",testData.get("CategoryProduct"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",testData.get("Acc name"));
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",testData.get("Acc name2"));
        PageObject.textinput_Locator("fieldName:AOR",testData.get("SignOffData"));
        PageObject.textinput_Locator("fieldName:SBP.COMPANY",testData.get("sbpCompany"));
        PageObject.textinput_Locator("fieldName:SBP.SECTOR.ID",testData.get("sbpSector"));
        PageObject.textinput_Locator("fieldName:SBP.SSECTOR.ID",testData.get("sbpSubSector"));
        PageObject.textinput_Locator("fieldName:SBP.SEGMENT.ID",testData.get("sbpSegment"));
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",testData.get("Jholder"));
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",testData.get("RelationCode"));
        PageObject.textinput_Locator("fieldName:PURPOSE",testData.get("Purpose"));
//        PageObject.textinput_Locator("",testData.get("Purpose"));
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS",testData.get("ExpectedNumOfTxn"));//30
        PageObject.radiobutton_Locator("radio:tab1:UNSCLISTST",Integer.parseInt(testData.get("AC Screen list")));
        PageObject.select_Locator("fieldName:KYC.ATO",testData.get("TurnoverA"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG",testData.get("TurnoverM"));
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR",testData.get("debitTxnNum"));
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR",testData.get("TurnoverDebitMonth"));
        //Txn:1008213906
        try {
            PageObject.commitDeal("CAO_JointAccCreation_LCYTxn");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(groups={"CaoInputter2Auth"},dataProvider = "authData")
    public void authAccCreationLCY(Map<String, String> testData){
        //
        PageObject.menu_Dropdown("Conv Account Authorization ");
        PageObject.menu_Link("List Of Unauthorised A/Cs  ");
        String homePage = PageObject.switchToChildWindow();
        driver.manage().window().maximize();
        PageObject.switchFrame(0);
        PageObject.form_Tab("Authorization of Account");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.switchFrame(0);
        PageObject.textinput_Locator("value:1:1:1","1008213910");
        PageObject.find_Button();
        PageObject.form_Link("VER A @ID");
        driver.switchTo().parentFrame();
        PageObject.switchFrame(1);
        PageObject.img_Button("Authorises a deal");
        //
    }

    @DataProvider(name = "inputterData")
    public Object[][] JointAccCreation_LCYData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\COAD_AccCreation.xlsx";
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


    @DataProvider(name = "authData")
    public Object[][] AuthData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CAO_JointAccCreation_LCYTxn.xlsx";
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
