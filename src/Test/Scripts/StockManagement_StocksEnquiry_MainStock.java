package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class StockManagement_StocksEnquiry_MainStock extends BaseClass {

    @Test(groups = {"Inputter"})
    public void mainStock() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Enquiries of Stock");
        PageObject.menu_Link("Main Stock ");
        PageObject.switchToChildWindow();
        // PageObject.parentFrame();
        // PageObject.switchFrame(2);
        PageObject.textinput_Locator("value:1:1:1","FT123456789");
        //PageObject.img_Button("Run Selection");
    }

}
