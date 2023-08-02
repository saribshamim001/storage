package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankersCheuqeInwardClearing_IBG extends BaseClass {
    @Test(groups = {"Inputter"})
    public void InwardClearingNormalBankersCheque() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing", 1);
        PageObject.childmenu_Link("Inward Clearing Normal", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1", "ISFK0012078");
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", "001");
        PageObject.textinput_Locator("fieldName:CL.NO.MV", "1");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.commitDeal("InwardClearingNormalBankersCheque");

    }

    @Test(groups = {"Authorizer"})
    public void AuthorizationofNormalClearingBC() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Normal Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void DeletionOfNormalClearingBC() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Normal Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void InwardClearingIntercityBankersCheque() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing", 1);
        PageObject.childmenu_Link("Inward Clearing Intercity", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1", "ISFK0012079");
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", "001");
        PageObject.textinput_Locator("fieldName:CL.NO.MV", "1");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.commitDeal("InwardClearingIntercityBankersCheque");
    }

    @Test(groups = {"Authorizer"})
    public void AuthorizationOfIntercityClearingBC() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Intercity Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void DeletionOfIntercityClearingBC() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Normal Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Inputter"})
    public void InwardClearingSameDayBankersCheque() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing", 1);
        PageObject.childmenu_Link("Inward Clearing Same Day", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CL.CHEQUE.NO:1", "ISFK0012076");
        PageObject.textinput_Locator("fieldName:BANK.SORT.CODE:1", "001");
        PageObject.textinput_Locator("fieldName:CL.NO.MV", "1");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(pgnameo);
        PageObject.switchFrame(2);
        PageObject.commitDeal("InwardClearingSameDayBankersCheque");

    }

    @Test(groups = {"Authorizer"})
    public void AuthorizationOfSameDayClearingBC() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Same Day Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Authorise a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Authorises a deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }

    @Test(groups = {"Authorizer"})
    public void DeletionOfSameDayClearingBC() throws InterruptedException, IOException {

        PageObject.childmenu_Dropdown("Cheque- Authorizer Menu", 1);
        PageObject.childmenu_Dropdown("Cheq Inward Clearing Authorization", 1);
        PageObject.childmenu_Link("Authorization of Same Day Clearing- BC ", 1);

        String menu1 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        PageObject.switchFrame(0);

        PageObject.img_Button("Selection Screen");
        //PageObject.textinput_Locator("value:1:1:1","CHG2300300040");
        PageObject.find_Button();
        PageObject.form_Link("Delete a Transaction");
        PageObject.parentFrame();
        PageObject.switchFrame(1);
        //Thread.sleep(4000);
        PageObject.img_Button("Deletes a Deal");
        PageObject.switchToChildWindow();
        //driver.close();
        PageObject.switchToParentWindow(menu1);
        PageObject.switchToChildWindow();

    }
}
