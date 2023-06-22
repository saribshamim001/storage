package Test.Scripts.IBG.TDR;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Enquiries_IBG extends BaseClass {

    @Test(groups = {"InputterTDR_IBG"})
    public void EnquiriesListOfTDR () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("List of Outstanding Term Deposits ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1", "12267389");
        PageObject.find_Button();

    }

        @Test(groups = {"InputterTDR_IBG"})
        public void EnquiriesOtherLoanSchedulesFull() throws IOException, InterruptedException {

            PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
            PageObject.childmenu_Dropdown("Enquiries", 1);
            PageObject.childmenu_Link("Other Loan Schedules (Full) ", 1);

            String menu = PageObject.switchToChildWindow();
            PageObject.maximizeWindow();

            PageObject.textinput_Locator("value:1:1:1", "LD1419712927");
            PageObject.find_Button();

        }
    }
