package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LockerSignature_IBG extends BaseClass {

    String sigTxn;
    @Test(groups = {"IBGInputter"})

    public void lockerSignautreIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
//      PageObject.menu_Dropdown("Remittance Menu");
//      PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Meu");
        PageObject.menu_Dropdown("Locker Signature");


        PageObject.menu_Link("Upload Locker Signature ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.parentFrame();
        PageObject.switchFrame(2);


        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:IMAGE.REFERENCE","OR.0001.5561");
        PageObject.textinput_Locator("fieldName:SHORT.DESCRIPTION", "Test");
        PageObject.textinput_Locator("fieldName:DESCRIPTION:1","Tester");


        driver.findElement(By.xpath("//tr/td/a/img[@alt='Commit the deal']")).click();

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.textinput_Locator("fieldName:FILE.UPLOAD","ASD");

        PageObject.commitDeal("LockerSignatureIBG");


        sigTxn = PageObject.getTxn();
        System.out.println(sigTxn);

    }

    public static void saveAccNumToFile(String accNumber) throws IOException {

        String TxnNum = accNumber ;
        System.out.println("Acc Number is: "+TxnNum);

        File file = new File(System.getProperty("user.dir") + "\\Data\\LockerSignatureIBG.xlsx");
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
    @Test(groups = {"IBGAuthorizer"})

    public void lockerSignature_AuthIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Locker- Authorizer Menu");
        PageObject.menu_Dropdown("Locker Signature");
        PageObject.menu_Link("Locker Signature-  Authorization ");

        String menu1 = PageObject.switchToChildWindow();


        PageObject.find_Button();

        String menu2 = PageObject.switchToChildWindow();


        PageObject.imgchild_Button("Select Drilldown",1);

        String menu3 = PageObject.switchToChildWindow();

        PageObject.img_Button("Authorises a deal");

        sigTxn = PageObject.getTxn();
        System.out.println(sigTxn);

    }

    @DataProvider(name = "LockerSignatureIBGData")
    public Object[][] LockerSignatureIBGData() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LockerSignatureDataIBG.xlsx";
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
