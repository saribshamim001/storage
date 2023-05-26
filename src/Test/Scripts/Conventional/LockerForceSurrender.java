package Test.Scripts.Conventional;

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

public class LockerForceSurrender extends BaseClass {

    String forceTxn;

    String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\forceSurrender.xlsx";

    @Test(groups = {"Inputter"}, dataProvider = "excelDataforceSurrender")

    public void forceSurrender(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Locker Inputter Menu");
        PageObject.menu_Dropdown("Locker Surrender");


        PageObject.menu_Link("Locker Forced Surrender ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

//        PageObject.find_Button();

        PageObject.form_Link("Locker Surrender");

        PageObject.textinput_Locator("fieldName:BRK.REASON:1", testData.get("BRK.REASON:1"));

        PageObject.commitDeal("ForceSurrender");

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("Commit the deal");

        forceTxn = PageObject.getTxn();
        System.out.println(forceTxn);

    }

    @DataProvider(name = "excelDataforceSurrender")
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



}
