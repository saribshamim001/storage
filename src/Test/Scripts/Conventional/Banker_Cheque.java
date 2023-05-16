package Test.Scripts.Conventional;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;
import zmq.ZError;

public class Banker_Cheque extends BaseClass{



    @Test(groups = {"Inputter"})

    public void Banker_Cheque() {

        PageObject.menu_Dropdown("Remittance/Clearing Officer -Universal Teller");
        PageObject.menu_Dropdown("Remittance Menu");
        PageObject.menu_Dropdown("Alfalah Core/Retail Menu ");
        PageObject.childmenu_Dropdown("Customer Services",2);
        PageObject.childmenu_Dropdown("Cheque- Inputter Menu",1); //(//ul/li/span/img[contains(@alt,'Cheque- Inputter Menu')  ]  ) [1]
        PageObject.menu_Dropdown("Banker\'1s Cheque Issuance");
        PageObject.menu_Dropdown("Banker\'s Cheq Single Issuance Menu");
        PageObject.menu_Link("Banker Cheque Single Issuance- Account Holder");
        PageObject.menu_Link("Banker Cheque Single Issuance- Account Holder ");
        PageObject.img_Button("New Deal");
        PageObject.textinput_Locator("fieldName:BEN.CUSTOMER:1","Muhammad Fuad");
        PageObject.textinput_Locator("fieldName:ORDERING.CUST:1", "Aamir Jawwad");
        driver.close();






    }


}
