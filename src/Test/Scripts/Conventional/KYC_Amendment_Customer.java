package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KYC_Amendment_Customer extends BaseClass {

    String txn;

    String CusNumber="16992982";

    @Test(groups = {"Inputter"})

    public void KYC_Amendment_Customer() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah KYC Information");
        PageObject.menu_Dropdown("Alfalah Customer KYC Information");

        PageObject.menu_Link("KYC Amendment Customer ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1", CusNumber);
        PageObject.find_Button();


        PageObject.form_Link("Input KYC");

        Thread.sleep(2000);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:OCCUPATION","Business");  //Business or Salaried
        PageObject.textinput_Locator("fieldName:NAME.OF.BUS","Test Store");
        PageObject.textinput_Locator("fieldName:NAT.OF.BUS","Test21");
        PageObject.textinput_Locator("fieldName:STAT.OWNER","Test1");
        PageObject.textinput_Locator("fieldName:NAME.OF.EMP","7");
        PageObject.textinput_Locator("fieldName:CS.POS","11");
        PageObject.textinput_Locator("fieldName:CS.EMP.SINCE","NA");
        PageObject.radiobutton_Locator("radio:mainTab:STATUS",1);
        PageObject.textinput_Locator("fieldName:CURRENT.SALARY","0");
        PageObject.textinput_Locator("fieldName:OTHER.INCOME","0");
        PageObject.textinput_Locator("fieldName:OTHER.FUNDS","0");
        PageObject.textinput_Locator("fieldName:PER.PROP.INMNT","20000000");
        PageObject.textinput_Locator("fieldName:CS.ANNUM.TO","400000");
        PageObject.textinput_Locator("fieldName:SOURCE.OF.INCOME","Business");
        PageObject.radiobutton_Locator("radio:mainTab:REL.POILITICAL",1);
        PageObject.textinput_Locator("fieldName:POLITICAL.FIGURE","Test3");
        PageObject.radiobutton_Locator("radio:mainTab:PFAMAPPROVAL",1);
        PageObject.textinput_Locator("fieldName:KYC.REVW.COMENT","Testing");
        PageObject.radiobutton_Locator("radio:mainTab:HRAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.BS.CNT.PHNO",1);
        PageObject.textinput_Locator("fieldName:CUST.COMMENTS:1","ISL");
        PageObject.radiobutton_Locator("radio:mainTab:CH.FIN.STMT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.GEO.LOCAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.GEO.INT",1);
        PageObject.textinput_Locator("fieldName:EXP.COUNT.PARTY:1","Test4");
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.COUNT.PARTY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.OCCUPATION",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAME.OF.BUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAT.OF.BUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.STAT.OWNER",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAME.OF.EMP",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.POS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.EMP.SINCE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.STATUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CURRENT.SALARY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.COMMENTS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CUS.SATISFY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.PER.PROP.INMNT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.ANNUM.TO",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.SOURCE.OF.INCOME",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.REL.POILITICAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.POLITICAL.FIGURE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.PFAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.RISKLEVEL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.AMEND.DATE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.KYC.REVW.COMENT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.HRAMAPPROVAL",1);

        PageObject.commitDeal("KYC_Amendment_Customer");

        txn = PageObject.getTxn();
        System.out.println(txn);
//        saveAccNumToFile(CusNumber);


    }
    public static void saveAccNumToFile(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\KYC_Amendment_Customer.xlsx");
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

    public void kyc_Amendment_Customer_Auth(Map<String, String> testData) throws IOException, InterruptedException {

//        PageObject.menu_Dropdown("Manager Operation Menu");
//        PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Authorization of KYC");
        PageObject.menu_Dropdown("Alfalah KYC Information Authorization");
        PageObject.menu_Dropdown("Authorization of Cusotmer KYC");
        PageObject.menu_Link("Authorization for Customer KYC- Branch Level ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1",CusNumber);
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
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\KYC_Amendment_Customer.xlsx";
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
