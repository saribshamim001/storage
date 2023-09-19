package Test.Scripts.Conventional.RetailBanking;

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

public class ECRP_DetailsUpdate extends BaseClass {

    String FILE_PATH = System.getProperty("user.dir") + "\\Excel Data\\ECRP_Update.xlsx";

    @Test(groups = {"PowerUser"}, dataProvider = "excelDataECRP_Update")

    public void ECRP_Update(Map<String, String> testData) throws IOException, InterruptedException {

        PageObject.textinput_Locator("transactionId", testData.get("value:1:1:1"));
        PageObject.img_Button("Edit a contract");
        PageObject.switchToChildWindow();
        PageObject.textinput_Locator("fieldName:ECRP.DATE","20230906");

        PageObject.commitDeal("ECRP_Update");
    }

    @DataProvider(name = "excelDataECRP_Update")
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
