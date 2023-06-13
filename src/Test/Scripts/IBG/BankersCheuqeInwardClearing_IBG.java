package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankersCheuqeInwardClearing_IBG extends BaseClass {
    @Test(groups = {"Inputter"})
    public void InwardClearingNormalBankersCheque () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing",1);
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

    @Test(groups = {"Inputter"})
    public void InwardClearingIntercityBankersCheque () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing",1);
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

    @Test(groups = {"Inputter"})
    public void InwardClearingSameDayBankersCheque () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheuqe Inward Clearing",1);
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
}
