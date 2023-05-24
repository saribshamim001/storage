package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CDR_Cancellation_IBG extends BaseClass {

    @Test(groups = {"IBGInputter"})

    public void CDRCancellationIBG() throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.menu_Dropdown("Call Deposit Receipt- Inputter Menu");
        PageObject.menu_Dropdown("Call Deposit Receipt Maintenance");

        PageObject.menu_Link("Call Deposit Receipt- Cancellation ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF","LDA0610554");

        //PageObject.commitDeal("CDRCancellationIBG");






    }
}
