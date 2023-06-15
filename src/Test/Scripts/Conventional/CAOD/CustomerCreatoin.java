package Test.Scripts.Conventional.CAOD;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CustomerCreatoin extends BaseClass {

    public static String txn;

    @Test(groups = {"CaoInputter"} )
    public void customerCreation() throws IOException {
    PageObject.menu_Dropdown("Alfalah Customer Information at CAO");
    PageObject.menu_Dropdown("Customer Opening");
    PageObject.menu_Link("Individual/Sole/Proprietorship/Minor  ");

//   PageObject.select_Locator("fieldName:CUST.SEGMENT","MASS");
        PageObject.switchToChildWindow();
    PageObject.select_Locator("fieldName:CUST.SEGMENT","MASS");
    PageObject.textinput_Locator("fieldName:CRP.TYPE","1");
   PageObject.click_Locator("fieldName:SRC.FUNDS");
    PageObject.textinput_Locator("fieldName:SRC.FUNDS","801");


        PageObject.click_Locator("fieldName:TEXT:1");

      PageObject.textinput_Locator("fieldName:TEXT:1","abc");
        PageObject.click_Locator("fieldName:TARGET");
      PageObject.textinput_Locator("fieldName:TARGET","84");

        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",2);
        PageObject.radiobutton_Locator("radio:mainTab:CUS.PEP",2);
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT","6000000");
        PageObject.click_Locator("fieldName:SBP.INDUSTRY");
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY","6000000");
        PageObject.textinput_Locator("fieldName:ID.TYPE:1","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1","4320157789462");
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1","01 JAN 2080");
        PageObject.click_Locator("fieldName:MNEMONIC");
        PageObject.textinput_Locator("fieldName:MNEMONIC","TEMP123");
        PageObject.textinput_Locator("fieldName:NAME.1:1","Mrs. ABC");
        PageObject.textinput_Locator("fieldName:NAME.2:1","Mrs. ABC");
        //PageObject.textinput_Locator("fieldName:SHORT.NAME:1","Mrs. ABC");
        PageObject.select_Locator("fieldName:A.ADDRESS.TYPE","PERMANENT");

        PageObject.textarea_Locator("fieldName:ADD.H","North Road");
        PageObject.textinput_Locator("fieldName:STREET:1","North Road");

        PageObject.click_Locator("fieldName:DATE.OF.BIRT.LC");
        PageObject.textinput_Locator("fieldName:DATE.OF.BIRT.LC","01 JAN 1990");
        PageObject.textinput_Locator("fieldName:ACCOUNT.OFFICER","1099511041");
        PageObject.textinput_Locator("fieldName:FATCA.BIRTH.CON","PK");
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","MR. ABC");

        PageObject.click_Locator("fieldName:CUS.CATEG:1");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1-001");
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1","21");
        PageObject.textinput_Locator("fieldName:DELIVERY.WDRAW:1","31");
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1","PK");
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1","1");
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1","1002");
        PageObject.select_Locator("fieldName:SEDING.FACTS:1","Other High Risk");
        PageObject.textarea_Locator("fieldName:FURTHER.DETAILS","abd");

    }
}
