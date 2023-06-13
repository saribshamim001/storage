package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankersChequeMaintenance_IBG extends BaseClass {

    @Test(groups = {"Inputter"})
    public void BankersChequeDuplicateIssuance () throws IOException, InterruptedException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Maintenance",1);
        PageObject.childmenu_Link("Cheque Duplicate Issuance ", 1);


        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();
    }

    @Test(groups = {"Authorizer"})
    public void BankersChequeDuplicateIssuanceAuth() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Maintenance Authorization", 1);
        PageObject.childmenu_Link("Authorization of Duplicate ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        //PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:2:1:1","1");
        //PageObject.find_Button();
        PageObject.form_Link("Authorise Duplicate BC Charges");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void BankersChequeCancellation () throws IOException, InterruptedException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Maintenance",1);
        PageObject.childmenu_Link("Cheque Cancellation ", 1);
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF","ISFK0000575");
        PageObject.commitDeal("BankersChequeCancellation");
        PageObject.switchToChildWindow();
    }

    @Test(groups = {"Inputter"})
    public void BankersChequeStaleInstrumentRevalidate () throws IOException, InterruptedException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Maintenance",1);
        PageObject.childmenu_Link("Cheque Stale Instrument Re-validate ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1","ISFK0001018");
        PageObject.find_Button();

        PageObject.parentFrame();
        PageObject.form_Link("Active Instrument");
        PageObject.switchToChildWindow();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();
        PageObject.img_Button("Commit the deal");
    }

}
