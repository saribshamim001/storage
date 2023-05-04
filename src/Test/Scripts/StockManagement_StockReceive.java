package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class StockManagement_StockReceive extends BaseClass {

    @Test(groups = {"Inputter"})
    public void stocksReceived() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Recieve  ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:INSTRUMENT.TYPE:1","BC");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NUM:1","123456");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NUM:1","123456");
        PageObject.textinput_Locator("fieldName:DEBIT.AMOUNT","345");
        PageObject.textinput_Locator("fieldName:INVOICE.NUMBER","55555");


        PageObject.commitDeal("StockManagement_StocksReceived");
        String txn = PageObject.getTxn();
        System.out.println(txn);

    }

    @Test(groups = {"Authorizer"})
    public void authTheStocks(){
        //PageObject.menu_Dropdown("Manager Operation Menu");
        //PageObject.menu_Dropdown("Core Retail Menu");
        PageObject.menu_Dropdown("Customer Services");
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Authorisation of Stock");
        PageObject.menu_Link("Authorise/Delete Stock Records ");
        String HomePage2 = driver.getWindowHandle();
        PageObject.switchToChildWindow();

    }

}
