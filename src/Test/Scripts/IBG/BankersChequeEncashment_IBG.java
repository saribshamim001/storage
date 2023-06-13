package Test.Scripts.IBG;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankersChequeEncashment_IBG extends BaseClass {

    @Test(groups = {"Inputter"})
    public void BankersChequeEncashmentInwardRemittance () throws IOException, InterruptedException  {

        PageObject.menu_Dropdown("Remittance Menu -Universal Teller- IBG");
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu", 1);
        PageObject.childmenu_Dropdown("Cheque Encashment",1);
        PageObject.childmenu_Link("Bankers Cheque Encashment- Inward Remittance ", 1);

        PageObject.parentFrame();
        PageObject.switchFrame(2);
        String pgnameo = driver.getWindowHandle();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CREDIT.THEIR.REF", "2");
        PageObject.switchToChildWindow();
    }
}
