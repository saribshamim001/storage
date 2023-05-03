package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class StockManagement_StocksTransfer_From_WStoMS extends BaseClass {

    @Test(groups = {"Inputter"})
    public void transferFromWStoMS() throws IOException {
        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.menu_Dropdown("Stock Managment");
        PageObject.menu_Dropdown("Stock Receive and Transfer");
        PageObject.menu_Link("Stock Transfer from WS to MS ");
        PageObject.parentFrame();
        PageObject.switchFrame(2);
        //PageObject.textinput_Locator("transactionId","BC.123456");
        driver.findElement(By.xpath("(//input[@id='transactionId'])[2]")).sendKeys("BC.123558");
        PageObject.img_Button("Edit a contract");
        PageObject.textinput_Locator("fieldName:FROM.SERIAL.NO:1","123558");
        PageObject.click_Locator("fieldName:TO.SERIAL.NO:1");
        PageObject.textinput_Locator("fieldName:TO.SERIAL.NO:1","123580");
        PageObject.textinput_Locator("fieldName:NARRATIVE:1","Transfering from Main to Working Stock");
        PageObject.commitDeal("StockManagement_StocksTransfer_From_MStoWS");
        String txn = PageObject.getTxn();
        System.out.println(txn);
    }



}
