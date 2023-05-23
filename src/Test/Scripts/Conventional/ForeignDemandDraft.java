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




    }
    }




