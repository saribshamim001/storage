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

public class Accounts extends BaseClass {
//    Customers customer = new Customers();

    public static String PD;
    public  String CUSTOMER,CATEGORY,ACCOUNT_TITLE_1,ACCOUNT_TITLE_2,OTHER_OFFICER,REFEREE,JOINT_HOLDER,RELATION_CODE,
            JOINT_NOTES,MULTI_ACCT,BAF_PRM_IMD,BAF_PRM_CRDNAME,BAF_PRM_PEN,BAF_PRM_DATETME,REMITTER_NAME,REMITTER_ID_NO,
            RELATIONSHIP_BE,REMITTER_RESID,REMITTER_ID_TYP,CURRENCY;



    public static String[] LCY_CURRENT_ACCOUNTS = { "1001", "1005", "1007", "1010", "1011", "1014", "1017", "1022",
                                                    "1030", "1031", "1034", "1035", "1037", "1038", "1142", "1143",
                                                    "1150", "1171", "1326" };
    public static String[] LCY_SAVING_ACCOUNTS = { "6001", "6004", "6005", "6009", "6012", "6014", "6018", "6025" };
    public static String[] FCY_CURRENT_ACCOUNTS = { "1003", "1033", "1036", "1040", "1142", "1143" };
    public static String[] FCY_SAVING_ACCOUNTS = { "6003", "6019", "6030", "6035", "6039" };
    public static String[] KIDS_ACCOUNT = { "6020" };



    //		                         <<<<    CALLING DIFFERENT SCRIPTS    >>>>

    @Test (groups = {"Inputter"}, dataProvider = "condition")
    public void callAccountCreation(Map<String, String> column) throws InterruptedException, IOException {

        Accounts.PD = column.get("CATEGORY");
        CUSTOMER = column.get("CUSTOMER");
        ACCOUNT_TITLE_1 = column.get("ACCOUNT_TITLE_1");
        ACCOUNT_TITLE_2 = column.get("ACCOUNT_TITLE_2");
        OTHER_OFFICER = column.get("OTHER_OFFICER");
        REFEREE = column.get("REFEREE");
        JOINT_HOLDER = column.get("JOINT_HOLDER");
        RELATION_CODE = column.get("RELATION_CODE");
        JOINT_NOTES = column.get("JOINT_NOTES");
        MULTI_ACCT = column.get("MULTI_ACCT");
        BAF_PRM_IMD = column.get("BAF_PRM_IMD");
        BAF_PRM_CRDNAME = column.get("BAF_PRM_CRDNAME");
        BAF_PRM_PEN = column.get("BAF_PRM_PEN");
        BAF_PRM_DATETME = column.get("BAF_PRM_DATETME");
        REMITTER_NAME = column.get("REMITTER_NAME");
        REMITTER_ID_NO = column.get("REMITTER_ID_NO");
        RELATIONSHIP_BE = column.get("RELATIONSHIP_BE");
        REMITTER_RESID = column.get("REMITTER_RESID");
        REMITTER_ID_TYP = column.get("REMITTER_ID_TYP");

        for (String typeOfProduct : LCY_CURRENT_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                lcyCurrentAccount();
            }
        }
        for (String typeOfProduct : LCY_SAVING_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                lcySavingAccount();
            }
        }
        for (String typeOfProduct : FCY_CURRENT_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                fcyCurrentAccount();
            }
        }
        for (String typeOfProduct : FCY_SAVING_ACCOUNTS) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                fcySavingAccount();
            }
        }
        for (String typeOfProduct : KIDS_ACCOUNT) {
            if ( Accounts.PD.equals(typeOfProduct)) {
                lcyKidsAccount();
            }
        }

    }



//    @Test  (groups = {"Inputter"}, dataProvider = "condition")
    public void lcyCurrentAccount() throws InterruptedException, IOException {
//        System.out.println(customer.Txn);

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Current Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
        PageObject.radiobutton_Locator("radio:tab1:BAF.PEN.ACCT", 1);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);
        PageObject.select_Locator("fieldName:MULTI.ACCT",  MULTI_ACCT);

        // TAB2
        PageObject.form_Tab("PREMIER.DEBITCARD");

        PageObject.select_Locator("fieldName:BAF.PRM.IMD", BAF_PRM_IMD);
        PageObject.textinput_Locator("fieldName:BAF.PRM.CRDNAME", BAF_PRM_CRDNAME);
        PageObject.radiobutton_Locator("radio:tab2:BAF.PRM.FMEMBR", 1);
        PageObject.textinput_Locator("fieldName:BAF.PRM.PEN", BAF_PRM_PEN);
        PageObject.textinput_Locator("fieldName:BAF.PRM.DATETME", BAF_PRM_DATETME);

        // TAB3
        PageObject.form_Tab("Alfalah Assan Remittance");

        PageObject.textinput_Locator("fieldName:REMITTER.NAME:1", REMITTER_NAME);
        PageObject.textinput_Locator("fieldName:REMITTER.ID.NO:1", REMITTER_ID_NO);
        PageObject.textinput_Locator("fieldName:RELATIONSHIP.BE:1", RELATIONSHIP_BE);
        PageObject.textinput_Locator("fieldName:REMITTER.RESID:1", REMITTER_RESID);
        PageObject.textinput_Locator("fieldName:REMITTER.ID.TYP:1", REMITTER_ID_TYP);
        PageObject.commitDeal("LCY Current Accounts");
    }

//        @Test
    public void lcySavingAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Saving Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
        PageObject.radiobutton_Locator("radio:mainTab:BAF.PEN.ACCT", 1);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);
        PageObject.select_Locator("fieldName:MULTI.ACCT",  MULTI_ACCT);


        // TAB2
        PageObject.form_Tab("PREMIER.DEBITCARD");

        PageObject.select_Locator("fieldName:BAF.PRM.IMD", BAF_PRM_IMD);
        PageObject.textinput_Locator("fieldName:BAF.PRM.CRDNAME", BAF_PRM_CRDNAME);
        PageObject.radiobutton_Locator("radio:tab1:BAF.PRM.FMEMBR", 1);
        PageObject.textinput_Locator("fieldName:BAF.PRM.PEN", BAF_PRM_PEN);
        PageObject.textinput_Locator("fieldName:BAF.PRM.DATETME", BAF_PRM_DATETME);


        // TAB3
        PageObject.form_Tab("Alfalah Assan Remittance");

        PageObject.textinput_Locator("fieldName:REMITTER.NAME:1", REMITTER_NAME);
        PageObject.textinput_Locator("fieldName:REMITTER.ID.NO:1", REMITTER_ID_NO);
        PageObject.textinput_Locator("fieldName:RELATIONSHIP.BE:1", RELATIONSHIP_BE);
        PageObject.textinput_Locator("fieldName:REMITTER.RESID:1", REMITTER_RESID);
        PageObject.textinput_Locator("fieldName:REMITTER.ID.TYP:1", REMITTER_ID_TYP);

        PageObject.commitDeal("LCY Saving Accounts");
    }

//        @Test
    public void lcyKidsAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Local Currency Account Open");
        PageObject.menu_Link("Alfalah SnaPack Kids Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.click_Locator("fieldName:ACCOUNT.TITLE.1:1");
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);


        PageObject.commitDeal("LCY Kids Accounts");

    }

//        @Test
    public void fcyCurrentAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Foreign Currency Account Open");
        PageObject.menu_Link("Current Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:CURRENCY", CURRENCY);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);

        PageObject.commitDeal("FCY Current Accounts");
    }

//        @Test
    public void fcySavingAccount() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah Account Information");
        PageObject.menu_Dropdown("Foreign Currency Account Open");
        PageObject.menu_Link("Saving Account ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CUSTOMER", CUSTOMER);
        PageObject.textinput_Locator("fieldName:CATEGORY", PD);
        PageObject.textinput_Locator("fieldName:CURRENCY", CURRENCY);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.1:1",  ACCOUNT_TITLE_1);
        PageObject.textinput_Locator("fieldName:ACCOUNT.TITLE.2:1",  ACCOUNT_TITLE_2);
        PageObject.textinput_Locator("fieldName:OTHER.OFFICER:1",  OTHER_OFFICER);
        PageObject.textinput_Locator("fieldName:REFEREE",  REFEREE);
        PageObject.textinput_Locator("fieldName:JOINT.HOLDER:1",  JOINT_HOLDER);
        PageObject.textinput_Locator("fieldName:RELATION.CODE:1",  RELATION_CODE);
        PageObject.textinput_Locator("fieldName:JOINT.NOTES:1:1", JOINT_NOTES);

        PageObject.commitDeal("FCY Saving Accounts");
    }

//        @Test
    public void accountAuthorization() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Authorization");
        PageObject.menu_Dropdown("Authorization of CIF & ACCOUNT");
        PageObject.menu_Dropdown("Authorization of Account");
        PageObject.menu_Link("Authorization for Account- Branch Level ");


        homePage = PageObject.switchToChildWindow();

//        PageObject.textinput_Locator("value:1:1:1",PageObject.TxnNum);
        PageObject.click_Locator("defaultButton");
        PageObject.form_Link("Authorise");
        PageObject.authorizeDeal();

        PageObject.commitDeal("Accounts");
    }












//                                 <<<      DATA PROVIDER      >>>

    @DataProvider(name = "condition")
    public Object[][] indCustomer() throws IOException {
        String FILE_PATH = System.getProperty("user.dir")+"\\Excel Data\\Accounts.xlsx";
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