package Test.Scripts;

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

import static Test.Scripts.Customers.commitDeal;
import static Test.Scripts.Customers.txnValidate;

public class ECRP {

    @Test
    public void changeInAddress() throws InterruptedException {

    }
    @Test
    public void individualCustomerECRP() throws InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId","");

//       check ??
        PageObject.click_Locator("Edit a contract");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1003");

        PageObject.getTxn();

    }

    @Test  (groups = {"Inputter"}, dataProvider = "TestData")
    public void corporateCustomerECRP (Map<String, String> column) throws InterruptedException, IOException {

        Accounts.CUSTOMER =  "17315419" ;

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        PageObject.menu_Link("Corporate Customers ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("transactionId",Accounts.CUSTOMER);
        PageObject.click_Locator("Edit a contract");
        // how to expand

        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1","PK");
        PageObject.expandSubvalue("Expand Sub Value",2);
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:2",column.get("EXP_GEO_INT"));
//        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1",column.get("EXP_GEO_LOCAL"));

        commitDeal();
        txnValidate();
    }



//                                 <<<      DATA PROVIDER      >>>

    @DataProvider(name = "TestData")
    public Object[][] indCustomer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DevopsTC_ECRP_Existing_CorpCust.xlsx";
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
