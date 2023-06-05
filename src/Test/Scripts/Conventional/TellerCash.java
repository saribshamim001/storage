//package Test.Scripts.Conventional;
//
//import POM.PageObject;
//import Test.General.BaseClass;
////import Test.General.ExtraMethods;
//import lombok.ToString;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//
////import static Test.General.ExtraMethods.*;
//import POM.PageObject.*;
//
//import javax.sql.rowset.spi.TransactionalWriter;
//
//public class TellerCash extends BaseClass {
//
//    String dateTodayGlobal = "20221231";
//
//    @Test(groups = "Inputter" , dataProvider = "cashDepoOnlineLCY")
//    public void cashDepoOnlineLCY(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String DepositAmount = testData.get("DepositAmount");
//        String DepositSlip = testData.get("DepositSlip");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit - LCY A/c Online ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
////        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", "1000321229");
//        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", AccountNumber);
//        refreshWindow(2);
////        changeFrame(2);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", "1000");
////        changeFrame(2);
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", "1000001");
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        PageObject.textinput_Locator("fieldName:CX.ACCOUNT",  AccountNumber);
//        refreshWindow(2);
//        PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//        PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//        PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//
//        PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//        String newPage = PageObject.switchToChildWindow();
//        PageObject.switchFrame(2);
//
//        refreshWindow(2);
//
//        PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//        PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//        PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
//
//        int handleCount = driver.getWindowHandles().size();
//        String handleIds = driver.getWindowHandles().toString();
//        System.out.println(handleCount);
//        System.out.println(handleIds);
//        if (handleCount == 3) {
//            System.out.println("IN IF CONDITION");
//            String ChildPage2 = PageObject.switchToChildWindow();
//            this.driver.close();
//            Thread.sleep(3000);
//            PageObject.switchToParentWindow(newPage);
//            PageObject.switchFrame(2);
//            PageObject.maximizeWindow();
//        }
//
//        PageObject.commitDeal("cashDepoOnlineLCY");
//    }
//
//    @DataProvider(name = "cashDepoOnlineLCY")
//    public Object[][] readExcelData() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\cashDepoOnlineLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "cashDepoOnlineLcy_Authorization")
//    public void cashDepoOnlineLcy_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit - LCY A/c Online ");
//
//        String ChildPage1 = PageObject.switchToChildWindow();
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        Thread.sleep(3000);
//
//        int handleCount = driver.getWindowHandles().size();
//        String handleIds = driver.getWindowHandles().toString();
//        System.out.println(handleCount);
//        System.out.println(handleIds);
//        if (handleCount == 3) {
//            System.out.println("IN IF CONDITION");
//            String ChildPage2 = PageObject.switchToChildWindow();
//            driver.close();
//            PageObject.switchToParentWindow(homePage);
//            PageObject.switchToChildWindow();
//            System.out.println("in childPage1");
//            Thread.sleep(3000);
//        }
//        PageObject.maximizeWindow();
//        PageObject.authorizeDeal();
//        Thread.sleep(3000);
//        if (handleCount == 3) {
//            System.out.println("IN SECOND IF");
//            String ChildPage3 = PageObject.switchToChildWindow();
//            driver.close();
//            Thread.sleep(3000);
//            PageObject.switchToParentWindow(homePage);
//            PageObject.switchToChildWindow();
//            System.out.println("in childPage1");
//        }
//
//    }
//
//    @DataProvider(name = "cashDepoOnlineLcy_Authorization")
//    public Object[][] readExcelData_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\cashDepoOnlineLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//
//
//    /*______________________________________________________________________*/
//
//
//    @Test(groups = "Inputter" , dataProvider = "cashDepoWithinBranchLCY")
//    public void cashDepoWithinBranchLCY(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String DepositAmount = testData.get("DepositAmount");
//        String DepositSlip = testData.get("DepositSlip");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit LCY A/c-(Within Branch) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2", AccountNumber);
//
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", DepositAmount);
//
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", DepositSlip);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//
//
////        boolean captionError2 = driver.findElement(By.xpath("(//tr/td/span[@class='captionError'])[1]")).isDisplayed();
////
////        if (captionError2){
////            WebElement captionError = driver.findElement(By.xpath("(//tr/td/span[@class='captionError'])[1]"));
////            AssertionScreenshot("cashDepoWithinBranchLCY");
////        }
////        else {
//            PageObject.commitDeal("cashDepoWithinBranchLCY");
////        }
//    }
//
//    @DataProvider(name = "cashDepoWithinBranchLCY")
//    public Object[][] readExcelData2() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\cashDepoWithinBranchLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//
//    @Test(groups = "Authorizer" , dataProvider = "cashDepoWithinBranchLCY_Authorization")
//    public void cashDepoWithinBranchLCY_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY cash deposit LCY A/c-(Within Branch) ");
//        homePage = PageObject.switchToChildWindow();
//        PageObject.textinput_Locator("transactionId",TxnNumber);
//        AssertionScreenshot("cashDepoWithinBranchLCY_Authorization");
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.img_Button("Authorises a deal");
//
//        int handlesCount = driver.getWindowHandles().size();
//        if (handlesCount == 3) {
//            String childPage = PageObject.switchToChildWindow();
//            driver.close();
//            PageObject.switchToParentWindow(childPage);
//        }
//
//    }
//
//    @DataProvider(name = "cashDepoWithinBranchLCY_Authorization")
//    public Object[][] readExcelData2_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\cashDepoWithinBranchLCY.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "LCYCashWithdrawalOnline")
//    public void LCYCashWithdrawalOnline(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String WithdrawAmount = testData.get("WithdrawAmount");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String ChequeNumber = testData.get("ChequeNumber");
////        String DateToday = "20221227";
//        String DateToday = dateTodayGlobal;
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        Thread.sleep(1000);
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c- Online ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:ACCOUNT.1:1", AccountNumber);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//
//        String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1", WithdrawAmount);
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER:1", ChequeNumber);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        //page refresh here
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//
//        driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
////        WebElement override = driver.findElement(By.xpath("(//tr/td/span[@class='captionError'])[1]"));
//        if (driver.getPageSource().contains("captionError")){
//            WebElement captionError = driver.findElement(By.xpath("(//tr/td/span[@class='captionError'])[1]"));
//            AssertionScreenshot("LCYCashWithdrawalOnline");
//        }
//        else {
//            PageObject.commitDeal("LCYCashWithdrawalOnline");
//        }
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalOnline")
//    public Object[][] readExcelData3() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\LCYCashWithdrawalOnline.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYCashWithdrawalOnline_Authorization")
//    public void LCYCashWithdrawalOnline_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c- Online ");
//
//        homePage = PageObject.switchToChildWindow();
//        PageObject.maximizeWindow();
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
////        refreshWindow(2);
//        PageObject.img_Button("Authorises a deal");
//
//        String childPage = PageObject.switchToChildWindow();
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalOnline_Authorization")
//    public Object[][] readExcelData3_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LCYCashWithdrawalOnline.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "LCYCashWithdrawalWithinBranch")
//    public void LCYCashWithdrawalWithinBranch(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String WithdrawAmount = testData.get("WithdrawAmount");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String ChequeNumber = testData.get("ChequeNumber");
//        String DateToday = dateTodayGlobal;
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c-(Within Branch) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2",AccountNumber);
//        PageObject.click_Locator("fieldName:A.CHEQUE.DATE");
//
//        String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        refreshWindow(2);
//        PageObject.click_Locator("fieldName:AMOUNT.LOCAL.1:1");
//        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1",WithdrawAmount);
//        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER:1", ChequeNumber);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//        PageObject.commitDeal("LCYCashWithdrawalWithinBranch");
//
////        driver.close();
////        PageObject.switchToParentWindow(homePage);
////        PageObject.parentFrame();
////        PageObject.switchFrame(0);
////        PageObject.signOff();
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalWithinBranch")
//    public Object[][] readExcelData4() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\LCYCashWithdrawalWithinBranch.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYCashWithdrawalWithinBranch_Authorization")
//    public void LCYCashWithdrawalWithinBranch_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - LCY A/c-(Within Branch) ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//        PageObject.img_Button("Authorises a deal");
//
//        int handlesCount = driver.getWindowHandles().size();
//        if (handlesCount == 3) {
//            String childPage = PageObject.switchToChildWindow();
//            driver.close();
//            PageObject.switchToParentWindow(childPage);
//        }
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalWithinBranch_Authorization")
//    public Object[][] readExcelData4_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LCYCashWithdrawalWithinBranch.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "LCYCashWithdrawalFCYAccFCYCheque")
//    public void LCYCashWithdrawalFCYAccFCYCheque(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String WithdrawAmount = testData.get("WithdrawAmount");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String ChequeNumber = testData.get("ChequeNumber");
//        String DateToday = dateTodayGlobal;
//        String WithdrawCurrency = testData.get("WithdrawCurrency");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - FCY A/c (FCY Cheque) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2",AccountNumber);
//        PageObject.click_Locator("fieldName:A.CHEQUE.DATE");
//
//        String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        PageObject.textinput_Locator("fieldName:CURRENCY.1", WithdrawCurrency);
//        PageObject.textinput_Locator("fieldName:CONSUMER.NO",WithdrawAmount);
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER:1", ChequeNumber);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//        refreshWindow(2);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:OTHER.REMARKS", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//        PageObject.commitDeal("LCYCashWithdrawalFCYAccFCYCheque");
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalFCYAccFCYCheque")
//    public Object[][] readExcelData5() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\LCYCashWithdrawalFCYAccFCYCheque.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "LCYCashWithdrawalFCYAccFCYCheque_Authorization")
//    public void LCYCashWithdrawalFCYAccFCYCheque_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("LCY Cash withdrawal - FCY A/c (FCY Cheque) ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//
//        PageObject.img_Button("Authorises a deal");
//
//        String childPage = PageObject.switchToChildWindow();
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "LCYCashWithdrawalFCYAccFCYCheque_Authorization")
//    public Object[][] readExcelData5_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\LCYCashWithdrawalFCYAccFCYCheque.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "FCYCashDeposit")
//    public void FCYCashDeposit(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String CustomerCnic = testData.get("CustomerCnic");
//        String CustomerTypeString = testData.get("CustomerType");
//        int CustomerType = Integer.parseInt(CustomerTypeString);
//        String DepositAmount = testData.get("DepositAmount");
//        String DepositSlip = testData.get("DepositSlip");
//        String CustomerName = testData.get("CustomerName");
//        String Remarks = testData.get("Remarks");
//        String DateOfBirth = testData.get("DateOfBirth");
//        String FatherName = testData.get("FatherName");
//        String CnicValidity = testData.get("CnicValidity");
//        String CnicType = testData.get("CnicType");
//        String DepositedCurrency = testData.get("DepositedCurrency");
//
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("FCY Cash deposit ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:ACCOUNT.2", AccountNumber);
//
//        PageObject.textinput_Locator("fieldName:CURRENCY.1",DepositedCurrency);
//
//        PageObject.textinput_Locator("fieldName:AMOUNT.FCY.1:1", "1000");
//
//        refreshWindow(2);
//
//        PageObject.textinput_Locator("fieldName:CASH.DSLIPNO", "1000001");
//
//        PageObject.click_Locator("radio:tab1:AML.TYP.CUST");
//        refreshWindow(2);
//        PageObject.radiobutton_Locator("radio:tab1:AML.TYP.CUST", CustomerType);
//
//        if (CustomerTypeString.equalsIgnoreCase("2")) {
//            PageObject.textinput_Locator("fieldName:CX.ACCOUNT", AccountNumber);
//
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:NAME.COND.TXN", CustomerName);
//            PageObject.textinput_Locator("fieldName:TT.ID.TYPE:1", CnicType);
//            PageObject.textinput_Locator("fieldName:TT.ID.VAL.DT:1", CnicValidity);
//            PageObject.textinput_Locator("fieldName:CNIC.NO", CustomerCnic);
//
//            String newPage2 = PageObject.switchToChildWindow();
//            PageObject.switchFrame(2);
//            refreshWindow(2);
//
//            PageObject.textarea_Locator("fieldName:REASON", Remarks);
//            PageObject.textinput_Locator("fieldName:DATE.OF.BIRTH", DateOfBirth);
//            PageObject.textinput_Locator("fieldName:FATHER.NAME", FatherName);
//        }
//
//        else
//        {
//            PageObject.textinput_Locator("fieldName:REASON","Testing");
//        }
//
//
//        PageObject.commitDeal("FCYCashDeposit");
//    }
//
//    @DataProvider(name = "FCYCashDeposit")
//    public Object[][] readExcelData6() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\FCYCashDeposit.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "FCYCashDeposit_Authorization")
//    public void FCYCashDeposit_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.menu_Link("FCY Cash deposit ");
//
//        homePage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("transactionId", TxnNumber);
//        PageObject.img_Button("Perform an action on the contract");
//
//        PageObject.img_Button("Authorises a deal");
//
//        String childPage = PageObject.switchToChildWindow();
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "FCYCashDeposit_Authorization")
//    public Object[][] readExcelData6_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\FCYCashDeposit.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "TellerTransactionsDoneToday")
//    public void TellerTransactionsDoneToday(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerID = testData.get("TellerID");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
////        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.childmenu_Dropdown("Enquiries",5);
//        PageObject.menu_Link("Teller Transactions done Today ");
//
////        PageObject.switchToChildWindow();
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.switchFrame(0);
//
//        PageObject.textinput_Locator("value:1:1:1",TellerID);
//        PageObject.find_Button();
//
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TellerTransactionsDoneToday");
//
//        Thread.sleep(5000);
//
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//
//    }
//
//    @DataProvider(name = "TellerTransactionsDoneToday")
//    public Object[][] readExcelData7() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TellerTransactionsDoneToday.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "TellerCreditTransactionsDoneToday")
//    public void TellerCreditTransactionsDoneToday(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerID = testData.get("TellerID");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
////        PageObject.menu_Dropdown("Teller Cash");
//        PageObject.childmenu_Dropdown("Enquiries",5);
//        PageObject.menu_Link("Teller Credit Transactions done Today ");
//
////        PageObject.switchToChildWindow();
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.switchFrame(0);
//
//        PageObject.textinput_Locator("value:1:1:1",TellerID);
//        PageObject.find_Button();
//
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TellerCreditTransactionsDoneToday");
//
//        Thread.sleep(5000);
//
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TellerCreditTransactionsDoneToday")
//    public Object[][] readExcelData8() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TellerCreditTransactionsDoneToday.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "TellerDebitTransactionsDoneToday")
//    public void TellerDebitTransactionsDoneToday(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TellerID = testData.get("TellerID");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.childmenu_Dropdown("Enquiries",5);
//        PageObject.menu_Link("Teller Debit Transactions done Today ");
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1",TellerID);
//        PageObject.find_Button();
//
//        PageObject.maximizeWindow();
//        AssertionScreenshot("TellerDebitTransactionsDoneToday");
//
//        Thread.sleep(5000);
//
//        driver.close();
//        PageObject.switchToParentWindow(childPage);
//    }
//
//    @DataProvider(name = "TellerDebitTransactionsDoneToday")
//    public Object[][] readExcelData9() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\TellerDebitTransactionsDoneToday.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter" , dataProvider = "CreditCardPayByAccount")
//    public void CreditCardPayByAccount(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String AccountNumber = testData.get("AccountNumber");
//        String ChequeNumber = testData.get("ChequeNumber");
//        String Amount = testData.get("Amount");
////        String DateToday = testData.get("DateToday");
//        String DateToday = dateTodayGlobal;
//        String CreditCardNumber = testData.get("CreditCardNumber");
//        String IdType = testData.get("IdType");
//        String CnicNumber = testData.get("CnicNumber");
//        String CnicExpiry = testData.get("CnicExpiry");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Online Transaction");
//        PageObject.menu_Link("CREDIT CARD (PAY BY ACCT) ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.img_Button("New Deal");
//
//        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO",AccountNumber);
//        PageObject.click_Locator("fieldName:CHEQUE.NUMBER");
//
//        popupWindowClose();
//        changeFrame(2);
//
//        PageObject.textinput_Locator("fieldName:CHEQUE.NUMBER",ChequeNumber);
//        PageObject.textinput_Locator("fieldName:A.CHEQUE.DATE", DateToday);
//        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT", Amount);
////        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:CX.CC.NO", CreditCardNumber);
//        PageObject.click_Locator("fieldName:ID.TYPE");
//        refreshWindow(2);
//        PageObject.textinput_Locator("fieldName:ID.TYPE", IdType);
//        PageObject.textinput_Locator("fieldName:ID.NUMBER", CnicNumber);
//        PageObject.textinput_Locator("fieldName:ID.VAL.DT", CnicExpiry);
//
//        PageObject.commitDeal("CreditCardPayByAccount");
//
//        /*String newPage = PageObject.switchToChildWindow();
//        driver.close();
//
//        PageObject.switchToParentWindow(newPage);
//        PageObject.switchFrame(2);*/
//
//
//
//    }
//
//    @DataProvider(name = "CreditCardPayByAccount")
//    public Object[][] readExcelData10() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\CreditCardPayByAccount.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "CreditCardPayByAccount_Authorization")
//    public void CreditCardPayByAccount_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Online Transaction");
//        PageObject.menu_Link("Auth. Of Credit Card Payment By Acct. ");
//
//        String childPage = PageObject.switchToChildWindow();
//
//        PageObject.textinput_Locator("value:1:1:1", TxnNumber);
//        PageObject.find_Button();
//
//        driver.findElement(By.xpath("//tr/td/a[text()='Authorise Online Transaction']")).click();
//
//        PageObject.img_Button("Authorises a deal");
//
////        String childPage2 = PageObject.switchToChildWindow();
////        driver.close();
//    }
//
//    @DataProvider(name = "CreditCardPayByAccount_Authorization")
//    public Object[][] readExcelData10_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\CreditCardPayByAccount.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*//*
//
////    @Test(groups = "Inputter" , dataProvider = "DenominationSetupCash")
//    *//*@Test(groups = "Inputter")
//    public void DenominationSetupCash(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String CurrencyType = testData.get("CurrencyType");
//        String PKR10 = testData.get("PKR10");
//        String PKR20 = testData.get("PKR20");
//        String PKR50 = testData.get("PKR50");
//        String PKR75 = testData.get("PKR75");
//        String PKR100 = testData.get("PKR100");
//        String PKR500 = testData.get("PKR500");
//        String PKR1000 = testData.get("PKR1000");
//        String PKR5000 = testData.get("PKR5000");
//
//        String Coin01 = testData.get("Coin01");
//        String Coin02 = testData.get("Coin02");
//        String Coin05 = testData.get("Coin05");
//        String Coin10 = testData.get("Coin10");
//
//        //USD
//        String USD = testData.get("USD");
//        String USD1 = testData.get("USD1");
//        String USD2 = testData.get("USD2");
//        String USD5 = testData.get("USD5");
//        String USD10 = testData.get("USD10");
//        String USD20 = testData.get("USD20");
//        String USD50 = testData.get("USD50");
//        String USD100 = testData.get("USD100");
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Denomination Setup");
//        PageObject.menu_Link("Denomination Transaction ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("transactionId",CurrencyType);
//        PageObject.img_Button("Edit a contract");
//
//        refreshWindow(2);
//
//        if (CurrencyType.equalsIgnoreCase("PKR")) {
//            for (int number = 0; number <= 4; number++) {
//                PageObject.img_Button("Expand Multi Value");
//            }
//
//            PageObject.textinput_Locator("fieldName:DENOM:1", "PKR10");
//            PageObject.textinput_Locator("fieldName:DENOM:2", "PKR20");
//            PageObject.textinput_Locator("fieldName:DENOM:3", "PKR50");
//            PageObject.textinput_Locator("fieldName:DENOM:4", "PKR75");
//            PageObject.textinput_Locator("fieldName:DENOM:5", "PKR100");
//            PageObject.textinput_Locator("fieldName:DENOM:6", "PKR500");
//            PageObject.textinput_Locator("fieldName:DENOM:7", "PKR1000");
//            PageObject.textinput_Locator("fieldName:DENOM:8", "PKR5000");
//
//            PageObject.textinput_Locator("fieldName:QUANTITY:1", PKR10);
//            PageObject.textinput_Locator("fieldName:QUANTITY:2", PKR20);
//            PageObject.textinput_Locator("fieldName:QUANTITY:3", PKR50);
//            PageObject.textinput_Locator("fieldName:QUANTITY:4", PKR75);
//            PageObject.textinput_Locator("fieldName:QUANTITY:5", PKR100);
//            PageObject.textinput_Locator("fieldName:QUANTITY:6", PKR500);
//            PageObject.textinput_Locator("fieldName:QUANTITY:7", PKR1000);
//            PageObject.textinput_Locator("fieldName:QUANTITY:8", PKR5000);
//
//            for (int number = 0; number <= 1; number++) {
////            PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[last()]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "PKR01");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:2", "PKR02");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:3", "PKR05");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:4", "PKR10");
//
//            PageObject.textinput_Locator("fieldName:QUANT.COIN:1", Coin01);
//            PageObject.textinput_Locator("fieldName:QUANT.COIN:2", Coin02);
//            PageObject.textinput_Locator("fieldName:QUANT.COIN:3", Coin05);
//            PageObject.textinput_Locator("fieldName:QUANT.COIN:4", Coin10);
//
//        } else if (CurrencyType.equalsIgnoreCase("USD")) {
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD100");
//            PageObject.textinput_Locator("fieldName:QUANTITY:1", USD100);
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD");
//            PageObject.textinput_Locator("fieldName:QUANT.COIN:1", USD);
//        }
//        PageObject.commitDeal("DenominationSetupCash");
//
//        //countCurrency(58418416);
//    }
//
//    public static void countCurrency (int amount)
//    {
//        int[] notes = new int[]{5000, 1000, 500, 100, 75, 50, 20, 10, 5, 2, 1};
//        int[] noteCounter = new int[10];
//
//        // count notes using Greedy approach
//        for (int i = 0; i < 9; i++) {
//            if (amount >= notes[i]) {
//                noteCounter[i] = amount / notes[i];
//                amount = amount % notes[i];
//            }
//        }
//
//        // Print notes
//        for (int i = 0; i < 9; i++) {
//            if (noteCounter[i] != 0) {
//                System.out.println(notes[i] + " : "
//                        + noteCounter[i]);
//                int j = 8;
//                String noteCount = Integer.toString(noteCounter[i]);
//                PageObject.textinput_Locator("fieldName:QUANTITY:"+j, noteCount);
//                j--;
//
//            }
//        }
//    }/**/
//
//    /*@DataProvider(name = "DenominationSetupCash")
//    public Object[][] readExcelData11() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DenominationSetupCash.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }*/
//
//    @Test(groups = "Authorizer" , dataProvider = "DenominationSetupCash_Authorization")
//    public void DenominationSetupCash_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Denomination Setup");
//        PageObject.menu_Link("Authorise of Denomination Transaction ");
//
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.parentFrame();
////        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("value:1:1:1", TxnNumber);
//        PageObject.find_Button();
//
//        driver.findElement(By.xpath("//tr/td/a[text()='Authorise Transaction']")).click();
//
//        PageObject.img_Button("Authorises a deal");
//
////        String childPage2 = PageObject.switchToChildWindow();
////        driver.close();
//    }
//
//    @DataProvider(name = "DenominationSetupCash_Authorization")
//    public Object[][] readExcelData11_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\DenominationSetupCash.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//
//    /*______________________________________________________________________*/
//
//
//    @Test(groups = "Inputter" , dataProvider = "DenominationSetupPrizeBond")
//    public void DenominationSetupPrizeBond(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String CurrencyType = testData.get("CurrencyType");
//        String PB100 = testData.get("PB100");
//        String PB1500 = testData.get("PB1500");
//        String PB15000 = testData.get("PB15000");
//        String PB200 = testData.get("PB200");
//        String PB25000 = testData.get("PB25000");
//        String PB40000 = testData.get("PB40000");
//        String PB750 = testData.get("PB750");
//        String PB7500 = testData.get("PB7500");
//
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond Denomination ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("transactionId","PB");
//        PageObject.img_Button("Edit a contract");
//
//        refreshWindow(2);
//
//            for (int number = 0; number <= 6; number++) {
//                PageObject.img_Button("Expand Multi Value");
//            }
//
//            PageObject.textinput_Locator("fieldName:DENOM:1", "PB100");
//            PageObject.textinput_Locator("fieldName:DENOM:2", "PB1500");
//            PageObject.textinput_Locator("fieldName:DENOM:3", "PB15000");
//            PageObject.textinput_Locator("fieldName:DENOM:4", "PB200");
//            PageObject.textinput_Locator("fieldName:DENOM:5", "PB25000");
//            PageObject.textinput_Locator("fieldName:DENOM:6", "PB40000");
//            PageObject.textinput_Locator("fieldName:DENOM:7", "PB750");
//            PageObject.textinput_Locator("fieldName:DENOM:8", "PB7500");
//
//            PageObject.textinput_Locator("fieldName:QUANTITY:1", PB100);
//            PageObject.textinput_Locator("fieldName:QUANTITY:2", PB1500);
//            PageObject.textinput_Locator("fieldName:QUANTITY:3", PB15000);
//            PageObject.textinput_Locator("fieldName:QUANTITY:4", PB200);
//            PageObject.textinput_Locator("fieldName:QUANTITY:5", PB25000);
//            PageObject.textinput_Locator("fieldName:QUANTITY:6", PB40000);
//            PageObject.textinput_Locator("fieldName:QUANTITY:7", PB750);
//            PageObject.textinput_Locator("fieldName:QUANTITY:8", PB7500);
//
//
//        PageObject.commitDeal("DenominationSetupPrizeBond");
//    }
//    @DataProvider(name = "DenominationSetupPrizeBond")
//    public Object[][] readExcelData12() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DenominationSetupPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    @Test(groups = "Authorizer" , dataProvider = "DenominationSetupPrizeBond_Authorization")
//    public void DenominationSetupPrizeBond_Authorization(Map<String, String> testData) throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String TxnNumber = testData.get("Transaction Number");
//
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Prize Bond Menu");
//        PageObject.menu_Link("Prize Bond Denomination Authorization  ");
//
//        String childPage = PageObject.switchToChildWindow();
//
////        PageObject.parentFrame();
////        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("value:1:1:1", TxnNumber);
//        PageObject.find_Button();
//
////        driver.findElement(By.xpath("//tr/td/a[text()='Authorise Transaction']")).click();
//
//        PageObject.img_Button("Authorises a deal");
//
////        String childPage2 = PageObject.switchToChildWindow();
////        driver.close();
//    }
//
//    @DataProvider(name = "DenominationSetupPrizeBond_Authorization")
//    public Object[][] readExcelData12_A() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Data\\DenominationSetupPrizeBond.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    /*______________________________________________________________________*/
//
//    @Test(groups = "Inputter")
//    public void DenominationSetupCash() throws InterruptedException, IOException {
//
//        //VARIABLE FOR EXCEL DATA STORAGE
//        String CurrencyType = "USD";
//        int amountPKR = 0;
//        double amountUSD = 0;
//
//        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
//        PageObject.menu_Dropdown("Teller");
//        PageObject.menu_Dropdown("Teller Menu");
//        PageObject.menu_Dropdown("Denomination Setup");
//        PageObject.menu_Link("Denomination Transaction ");
//
//        PageObject.parentFrame();
//        PageObject.switchFrame(2);
//
//        PageObject.textinput_Locator("transactionId", CurrencyType);
//        PageObject.img_Button("Edit a contract");
//
//        refreshWindow(2);
//
//        /*try {
//            WebElement removeFields = driver.findElement(By.xpath("(//tr/td/a/img[@alt='Delete Value'])[1]"));
//            List<WebElement> elements = driver.findElements(By.xpath("(//tr/td/a/img[@alt='Delete Value'])"));
//            int occurrences = elements.size();
//            int delete_i = occurrences;
//            System.out.println("counting is" + occurrences);
//            int j = 1;
//            if (removeFields.isDisplayed()) {
//                while (delete_i > 1) {
//                    removeFields.click();
//                    j++;
//                    delete_i--;
//                    System.out.println(j);
//                    removeFields = driver.findElement(By.xpath("(//tr/td/a/img[@alt='Delete Value'])["+delete_i+"]"));
//                }
//            }
//        }
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }*/
//
//        if (CurrencyType.equalsIgnoreCase("PKR")) {
//            for (int number = 0; number <= 6; number++) {
////                PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[1]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DENOM:1", "PKR10");
//            PageObject.textinput_Locator("fieldName:DENOM:2", "PKR20");
//            PageObject.textinput_Locator("fieldName:DENOM:3", "PKR50");
//            PageObject.textinput_Locator("fieldName:DENOM:4", "PKR75");
//            PageObject.textinput_Locator("fieldName:DENOM:5", "PKR100");
//            PageObject.textinput_Locator("fieldName:DENOM:6", "PKR500");
//            PageObject.textinput_Locator("fieldName:DENOM:7", "PKR1000");
//            PageObject.textinput_Locator("fieldName:DENOM:8", "PKR5000");
//
//            for (int number = 0; number <= 1; number++) {
////            PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[last()]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "PKR01");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:2", "PKR02");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:3", "PKR05");
//
//            for (int number = 1; number <= 8; number++) {
//                PageObject.textinput_Locator("fieldName:QUANTITY:" + number, Integer.toString(0));
//            }
//
//            for (int number = 1; number <= 3; number++) {
//                PageObject.textinput_Locator("fieldName:QUANT.COIN:" + number, Integer.toString(0));
//            }
//
//            driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
//            WebElement AmountExceed = driver.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'Amount exceeds')]"));
//            String Transaction = AmountExceed.getText();
//            String[] first = Transaction.split("-");
////            String[] second = first[1].split(" ");
//            String denominationAmount = first[1];
//            amountPKR = Integer.parseInt(denominationAmount);
//
//            int[] notes = new int[]{5000, 1000, 500, 100, 75, 50, 20, 10, 5, 2, 1};
//            int[] noteCounter = new int[11];
//
//            // count notes using Greedy approach
//            for (int i = 0; i < 11; i++) {
//                if (amountPKR >= notes[i]) {
//                    noteCounter[i] = amountPKR / notes[i];
//                    amountPKR = amountPKR % notes[i];
//                }
//            }
//
//            // Print notes
//            int note = 8;
//            int coin = 3;
//            for (int i = 0; i < 11; i++) {
//                if (noteCounter[i] != 0) {
////                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//
//                } else {
//                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//                }
//            }
//
//            AssertionScreenshot("DenominationSetupCash");
//
//            PageObject.commitDeal("DenominationSetupCash");
//
//        }
//        else if (CurrencyType.equalsIgnoreCase("USD")) {
//            for (int number = 0; number <= 5; number++) {
////                PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[1]")).click();
//            }
//
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD1");
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD2");
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD5");
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD10");
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD20");
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD50");
//            PageObject.textinput_Locator("fieldName:DENOM:1", "USD100");
//
//            for (int number = 0; number <= 5; number++) {
////            PageObject.img_Button("Expand Multi Value");
//                driver.findElement(By.xpath("(//tr/td/a/img[@alt='Expand Multi Value'])[last()]")).click();
//            }
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD1");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD10");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD2");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD25");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD5");
//            PageObject.textinput_Locator("fieldName:DEN.COIN:1", "USD50");
//
//            for (int number = 1; number <= 7; number++) {
//                PageObject.textinput_Locator("fieldName:QUANTITY:" + number, Integer.toString(0));
//            }
//
//            for (int number = 1; number <= 7; number++) {
//                PageObject.textinput_Locator("fieldName:QUANT.COIN:" + number, Integer.toString(0));
//            }
//
//            driver.findElement(By.xpath("//tr/td/a/img[@alt='Validate a deal']")).click();
//            WebElement AmountExceed = driver.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'Amount exceeds')]"));
//            String Transaction = AmountExceed.getText();
//            String[] first = Transaction.split("-");
////            String[] second = first[1].split(" ");
//            String denominationAmount = first[1];
//            amountUSD = Integer.parseInt(denominationAmount);
//
//            double[] notes = new double[]{100, 50, 20, 10, 5, 2, 1, .50, 0.05, 0.25, 0.02, 0.10, 0.01, 1};
//            int[] noteCounter = new int[14];
//
//            // count notes using Greedy approach
//            for (int i = 0; i < 11; i++) {
//                if (amountUSD >= notes[i]) {
//                    double noteCountDoubleValue = amountUSD / notes[i];
//                    noteCounter[i] = (int)noteCountDoubleValue;
//                    amountUSD = amountUSD % notes[i];
//                }
//            }
//
//            // Print notes
//            int note = 7;
//            int coin = 7;
//            for (int i = 0; i < 11; i++) {
//                if (noteCounter[i] != 0) {
////                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//
//                } else {
//                    System.out.println(notes[i] + " : " + noteCounter[i]);
//
//                    String noteCount = Integer.toString(noteCounter[i]);
//                    if (note > 0) {
//                        PageObject.textinput_Locator("fieldName:QUANTITY:" + note, noteCount);
//                        note--;
//                    } else {
//                        PageObject.textinput_Locator("fieldName:QUANT.COIN:" + coin, noteCount);
//                        coin--;
//                    }
//                }
//            }
//
//            AssertionScreenshot("DenominationSetupCash");
//
//            PageObject.commitDeal("DenominationSetupCash");
//
//        }
//
//    }
//    @DataProvider(name = "DenominationSetupCash")
//    public Object[][] readExcelData11() throws IOException {
//        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\DenominationSetupCash.xlsx";
//        FileInputStream fis = new FileInputStream(FILE_PATH);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//        Object[][] data = new Object[rowCount - 1][1]; // One column to store the HashMap
//
//        for (int i = 1; i < rowCount; i++) { // Start from row 1 to exclude header row
//            Row row = sheet.getRow(i);
//            Map<String, String> map = new HashMap<String, String>();
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                DataFormatter formatter = new DataFormatter();
//                String value = formatter.formatCellValue(cell);
//                map.put(sheet.getRow(0).getCell(j).toString(), value); // Assuming the first row contains column names
//            }
//            data[i - 1][0] = map;
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//
//    }
//
