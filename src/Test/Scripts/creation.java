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

import Test.General.BaseClass;

public class creation extends BaseClass {

        public static String UsernameCopy = "RETAIL.02";
        public static String UsernameCreate = "RETAIL.";
        public static String SignonName = "retail";
        public static String startDateProfile = "20231113";

        public static int numberOfUsers = 1500;

        @Test(groups = {"PowerUser"})
        public static void UserCreate() throws IOException {


            driver.findElement(By.xpath("//div/form/input[@id='commandValue']")).sendKeys("USER,DMG");
            driver.findElement(By.xpath("//form/a/img[@id='cmdline_img']")).click();

            PageObject.switchToChildWindow();
            String EnquiryInput = driver.getWindowHandle();

            PageObject.textinput_Locator("transactionId", UsernameCopy);
            PageObject.img_Button("Edit a contract");

            PageObject.select_Locator("moreactions","EDIT|COPY");
            PageObject.img_Button("Go");

            PageObject.switchToChildWindow();
            driver.close();

            PageObject.switchToParentWindow(EnquiryInput);
            driver.close();

            PageObject.switchToParentWindow(homePage);
            PageObject.switchFrame(0);
            driver.findElement(By.xpath("//form/a/img[@id='cmdline_img']")).click();

            PageObject.switchToChildWindow();
            EnquiryInput = driver.getWindowHandle();


//        PageObject.img_Button("Commit the deal");

            for (int i=751; i<=numberOfUsers ; i++)
            {
                PageObject.textinput_Locator("transactionId", UsernameCreate+i);
                PageObject.img_Button("Edit a contract");

                PageObject.select_Locator("moreactions", "EDIT|USER,DMG_PASTE");
                PageObject.img_Button("Go");

                PageObject.textinput_Locator("fieldName:USER.NAME", UsernameCreate+i);
                PageObject.textinput_Locator("fieldName:SIGN.ON.NAME", SignonName+i);
                PageObject.textinput_Locator("fieldName:START.DATE.PROFILE", startDateProfile);
                PageObject.commitDeal("usercreation");

            }
        }

        @Test(groups = {"PowerUser"})
        public static void DateChange() throws IOException {



            driver.findElement(By.xpath("//div/form/input[@id='commandValue']")).sendKeys("USER,");
            driver.findElement(By.xpath("//form/a/img[@id='cmdline_img']")).click();

            for (int i=1; i<=numberOfUsers ; i++)
            {
                PageObject.switchToChildWindow();
                String EnquiryInput = driver.getWindowHandle();

                PageObject.textinput_Locator("transactionId", UsernameCreate+i);
                PageObject.img_Button("Edit a contract");

                PageObject.textinput_Locator("fieldName:START.DATE.PROFILE", startDateProfile);
                PageObject.commitDeal("usercreation");
            }
        }


        @Test(groups = {"firstLogin"},dataProvider = "USERNAMES")
        public static void justLogin(Map<String, String> testData) throws IOException, InterruptedException
        {
            String username = testData.get("username");
            PageObject.signIn(username, "QWer1234");
            if (driver.getPageSource().contains("Please set your new password"))
            {
                PageObject.textinput_Locator("oldPassword","QWer1234");
                PageObject.textinput_Locator("password","QWer1234");
                driver.findElement(By.xpath("//tr/td/input[@id='goButton']")).click();

                PageObject.switchFrame(0);
                PageObject.signOff();
            }
            else
            {
                PageObject.switchFrame(0);
                PageObject.signOff();
            }

        }

        static String FILE_PATH = System.getProperty("user.dir") + "\\Data\\usercreation.xlsx";
        @DataProvider(name = "USERNAMES")
        public Object[][] readExcelData1() throws IOException {

            FileInputStream fis = new FileInputStream(FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("login"); // Assuming data is in the first sheet
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
