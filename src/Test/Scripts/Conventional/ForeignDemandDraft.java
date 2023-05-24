package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ForeignDemandDraft extends BaseClass {
    @Test(groups = {"Inputter"})

    public void ForeignDemandDraftInput() throws InterruptedException, IOException {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.menu_Dropdown("Deposit/Payment/Zakat");
        PageObject.menu_Dropdown("Funds Transfer");
        PageObject.menu_Dropdown("Foreign Currency Remittances");
        PageObject.menu_Dropdown("Outward Remittance");
        PageObject.menu_Link("Foreign Demand Draft (MT110) ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");


        PageObject.textinput_Locator("fieldName:CREDIT.CURRENCY","EUR");
        PageObject.textinput_Locator("fieldName:INSTRUMENT.TYPE:1","FDD");
        Thread.sleep(3000);

        PageObject.click_Locator("fieldName:CREDIT.AMOUNT");
        PageObject.textinput_Locator("fieldName:CREDIT.AMOUNT","100");
        //String HomePage2 = driver.getWindowHandle();
        PageObject.click_Locator("fieldName:DEBIT.ACCT.NO");
        PageObject.textinput_Locator("fieldName:DEBIT.ACCT.NO","1000264788");



        String HomePage2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();
        driver.close();

        PageObject.switchToParentWindow(HomePage2);
        PageObject.switchFrame(2);


        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","SARA");

        PageObject.radiobutton_Locator("radio:mainTab:COMMISSION.CODE",4);

        PageObject.form_Tab("MT110 Details");

        PageObject.select_Locator("fieldName:SEND.TO.PARTY:1", "DRCUST");

        PageObject.textinput_Locator("fieldName:BK.TO.BK.OUT:1:1","00");

        PageObject.commitDeal("ForeignDemandDraftInput");

















    }
    }



