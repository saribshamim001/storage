package Test.Scripts.IBG.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AlfalahSpecialRateTDR_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"})
    public void AlfalahIslamicSpecialRateTDR  () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Alfalah Islamic Special Rate TDR", 1);
        PageObject.childmenu_Link("Alfalah Islamic Special Rate TDR ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "12105488");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DFOMTDA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100");
        PageObject.commitDeal("AlfalahIslamicSpecialRateTDR");

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void AlfalahIslamicSpRateTDRMonthlyProfit   () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Alfalah Islamic Special Rate TDR", 1);
        PageObject.childmenu_Link("Alfalah Islamic Sp Rate TDR (Monthly Profit) ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "12105488");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DFOMTDA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100");
        PageObject.commitDeal("AlfalahIslamicSpRateTDRMonthlyProfit");

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void DealslipforspecialTDR    () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Alfalah Islamic Special Rate TDR", 1);
        PageObject.childmenu_Link("Deal slip for special TDR ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:CUSTOMER.ID", "12105488");
        PageObject.click_Locator("fieldName:CATEGORY");
        PageObject.textinput_Locator("fieldName:JOINT.CUSTOMER", "11745297");
        PageObject.textinput_Locator("fieldName:CATEGORY", "21022");
        PageObject.textinput_Locator("fieldName:REST.PERIOD.LD", "DFOMTDA");
        PageObject.click_Locator("fieldName:AMOUNT:1");
        PageObject.textinput_Locator("fieldName:AMOUNT:1", "100");
        PageObject.commitDeal("DealslipforspecialTDR");

    }
}
