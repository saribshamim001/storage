package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KYC_Amendment_Account extends BaseClass {

    String txn;

    @Test(groups = {"Inputter"})

    public void kyc_Amendment_Account() throws IOException, InterruptedException {

        String accNumber="1007240180";

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah KYC Information");
        PageObject.menu_Dropdown("Alfalah Account KYC Information");

        PageObject.menu_Link("KYC Amendment Account ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",accNumber);
        PageObject.find_Button();


        PageObject.form_Link("Amend Account KYC");

        Thread.sleep(2000);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        driver.close();

        PageObject.switchToParentWindow(menu2);
        PageObject.maximizeWindow();



        PageObject.textinput_Locator("fieldName:PURPOSE","Test12");
        PageObject.select_Locator("fieldName:MODEDEPOSITS:1","Cash");
        PageObject.select_Locator("fieldName:MODEDEPOSITS:2","Cheque");
        PageObject.select_Locator("fieldName:MODEDEPOSITS:3","Online Credits");
        PageObject.select_Locator("fieldName:MODEWITHDRAW:1","Issuing crossed Cheques");
        PageObject.select_Locator("fieldName:MODEWITHDRAW:2","Cash Withdrawls through cheque");
//        PageObject.select_Locator("fieldName:MODEWITHDRAW:3","Outward local Remittance");
        PageObject.textinput_Locator("fieldName:KYC.NO.TRANS","14");
        PageObject.textinput_Locator("fieldName:NO.TRANS.DR","11");
        PageObject.select_Locator("fieldName:MONTH.TOVER.DR","1M to 5M");
        PageObject.textinput_Locator("fieldName:EX.TOVER.DR.OTH","10000");

        PageObject.select_Locator("fieldName:KYC.ATO","Below 1M");
        PageObject.textinput_Locator("fieldName:ATOGTM","1000");
        PageObject.select_Locator("fieldName:MONTH.TOVER.RG","1M to 5M");
        PageObject.textinput_Locator("fieldName:EXP.MONTH.TOVER","10000");

        PageObject.img_Button("Commit the deal");

        String menu3 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:CUST.SEGMENT","MASS"); //MASS OR AFFLUENT
        PageObject.img_Button("Commit the deal");

        driver.close();

        PageObject.switchToParentWindow(menu3);
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:OCCUPATION","Salaried"); //Business OR Salaried

        PageObject.commitDeal("KYC_Amendment_Account");

        txn = PageObject.getTxn();
        System.out.println(txn);

        //saving acc number to file
        saveAccNumToFile(accNumber);

    }



    public static void saveAccNumToFile(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\KYC_Amendment_Account.xlsx");
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
        cell.setCellValue(TxnNum);

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

    }


    @Test(groups = {"Authorizer"},dataProvider = "excelData")

    public void kyc_Amendment_Account_Auth(Map<String, String> testData) throws IOException, InterruptedException {

//        PageObject.menu_Dropdown("Manager Operation Menu");
//        PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Authorization of KYC");
        PageObject.menu_Dropdown("Alfalah KYC Information Authorization");
        PageObject.menu_Dropdown("Authorization of Account KYC");
        PageObject.menu_Link("Authorization for Account KYC- Branch Level ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",testData.get("Acc Number"));
        PageObject.find_Button();


        PageObject.form_Link("Authorise a KYC");

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Authorises a deal");

        txn = PageObject.getTxn();
        System.out.println(txn);





    }



    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\KYC_Amendment_Account.xlsx";
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
