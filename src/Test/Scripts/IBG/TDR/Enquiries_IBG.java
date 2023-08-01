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

    @Test(groups = {"InputterTDR_IBG"})
    public void OtherLoansdisbursedtoday () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Other Loans disbursed today ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void InterestAccrualsOtherLoans  () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Interest Accruals (Other Loans) ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void RepaymentHistoryOtherLoans () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Repayment History (Other Loans) ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1", "LD1419712927");
        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void LDNewDepositsReceivedToday   () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("LD New Deposits Received Today ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TransactionSchedules   () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Transaction Schedules ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void TransactionSchedulesForward    () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Transaction Schedules Forward ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void AccountEntriesforGivendates      () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Account Entries for Given dates  ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    @Test(groups = {"InputterTDR_IBG"})
    public void AccountStmt () throws IOException, InterruptedException {

        PageObject.menu_Dropdown("Centralized TDR Menu - IBG");
        PageObject.childmenu_Dropdown("Enquiries", 1);
        PageObject.childmenu_Link("Account Stmt ", 1);

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.find_Button();

    }

    }
