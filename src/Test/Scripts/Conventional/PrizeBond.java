package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrizeBond extends BaseClass {
    String lcyTxn;
    String tillToVaultTxn;
    String vaultToTillTxn;
    String sellTxn;
    String buyTxn;

    @Test(groups = {"Inputter"})
    public void lcyTillTransfer() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Prize Bond Menu");
        PageObject.menu_Link("LCY Till Transfer ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:TELLER.ID.1","1005");
        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","10");

        PageObject.commitDeal("LCY Till Transfer PB");
        lcyTxn = PageObject.getTxn();
    }

    @Test(groups = {"Inputter"})
    public void tillToVault() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Prize Bond Menu");
        PageObject.menu_Link("Till to Vault ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","10");
        PageObject.commitDeal("Till To Vault PB");
        tillToVaultTxn = PageObject.getTxn();

    }

    @Test(groups = {"Inputter"})
    public void vaultToTill() throws IOException {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Prize Bond Menu");
        PageObject.menu_Link("Vault To Till ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

        PageObject.textinput_Locator("fieldName:AMOUNT.LOCAL.1:1","10");
        PageObject.commitDeal("Vault To Till PB");
        vaultToTillTxn = PageObject.getTxn();

    }

    @Test(groups = {"Inputter"})
    public void sellBond() {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Prize Bond Menu");
        PageObject.menu_Link("Prize Bond - Sell ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

    }

    @Test(groups = {"Inputter"})
    public void buyBond() {

        PageObject.menu_Dropdown("Head Teller Menu-Universal Teller-Conventiona");
        PageObject.menu_Dropdown("Teller");
        PageObject.menu_Dropdown("Teller Menu");
        PageObject.menu_Dropdown("Prize Bond Menu");
        PageObject.menu_Link("Prize Bond - Buy ");

        PageObject.parentFrame();
        PageObject.switchFrame(2);

        PageObject.img_Button("New Deal");

    }

}
