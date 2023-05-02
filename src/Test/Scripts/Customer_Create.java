package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

public class Customer_Create extends BaseClass {

    @Test(groups = {"Inputter"})
    public void customerCreation() {

        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.childmenu_Dropdown("Alfalah Customer Information",2);
        //driver.findElement(By.xpath("(//ul/li/span/img[@alt='Alfalah Customer Information'])[2]")).click();
        PageObject.menu_Link("Individual/Sole/Proprietorship/Minor ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:SECTOR","1000");
        PageObject.textinput_Locator("fieldName:ID.TYPE:1","ID-N");
        PageObject.textinput_Locator("fieldName:ID.NUMBER:1","4220179441023");
        PageObject.click_Locator("fieldName:ID.VAL.DT:1");
        PageObject.textinput_Locator("fieldName:ID.VAL.DT:1","07 AUG 2041");
        PageObject.textinput_Locator("fieldName:NAME.1:1","CUSTOMER01");
        PageObject.textinput_Locator("fieldName:MB.FATH.HUS.NAM","FATHER01");
        PageObject.textinput_Locator("fieldName:STREET:1","KARACHI");
        PageObject.textinput_Locator("fieldName:TOWN.COUNTRY:1","KARACHI PARKISTAN");
        PageObject.textinput_Locator("fieldName:SBP.IND.PARENT","60000000000");
        PageObject.textinput_Locator("fieldName:SBP.INDUSTRY","60000000800");
        PageObject.textinput_Locator("fieldName:TARGET","64");
        PageObject.textinput_Locator("fieldName:NATIONALITY","PK");
        PageObject.textinput_Locator("fieldName:RESIDENCE","PK");
        PageObject.textinput_Locator("fieldName:DATE.OF.BIRT.LC","25 JUL 1998");

        PageObject.textinput_Locator("fieldName:CRP.TYPE","1");
        PageObject.textinput_Locator("fieldName:INCM.LEVELSRC","102");
        PageObject.textinput_Locator("fieldName:CUS.CATEG:1","1001");
        PageObject.textinput_Locator("fieldName:CRP.CHANNEL:1","9");
        PageObject.textinput_Locator("fieldName:EXP.GEO.INT:1","PK");
        PageObject.textinput_Locator("fieldName:EXP.GEO.LOCAL:1","1");
        PageObject.textinput_Locator("fieldName:CREDIT.TURNOVER:1","402");
        PageObject.select_Locator("fieldName:SEDING.FACTS:1","Not Applicable");

        PageObject.commitDeal();


    }


}
