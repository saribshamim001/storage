package Test.Scripts;

import POM.PageObject;
import Test.General.BaseClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class KYC_Amendment_Customer extends BaseClass {

    String txn;

    @Test(groups = {"Inputter"})

    public void KYC_Amendment_Customer() throws IOException, InterruptedException {
        PageObject.menu_Dropdown("Customer Relation Officer Menu");
        PageObject.menu_Dropdown("Alfalah Customer Information");
        PageObject.menu_Dropdown("Branch Level Inputter");
        PageObject.menu_Dropdown("Alfalah KYC Information");
        PageObject.menu_Dropdown("Alfalah Customer KYC Information");

        PageObject.menu_Link("KYC Amendment Customer ");

        String menu = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.textinput_Locator("value:1:1:1", "16992982");
        PageObject.find_Button();


        PageObject.form_Link("Input KYC");

        Thread.sleep(2000);

        String menu2 = PageObject.switchToChildWindow();
        PageObject.maximizeWindow();

        PageObject.select_Locator("fieldName:OCCUPATION","Salaried");  //Business or Salaried
        PageObject.textinput_Locator("fieldName:NAME.OF.BUS","Test Store");
        PageObject.textinput_Locator("fieldName:NAT.OF.BUS","Test1");
        PageObject.textinput_Locator("fieldName:STAT.OWNER","Test2");
        PageObject.textinput_Locator("fieldName:NAME.OF.EMP","7");
        PageObject.textinput_Locator("fieldName:CS.POS","11");
        PageObject.textinput_Locator("fieldName:CS.EMP.SINCE","NA");
        PageObject.radiobutton_Locator("radio:mainTab:STATUS",1);
        PageObject.textinput_Locator("fieldName:CURRENT.SALARY","0");
        PageObject.textinput_Locator("fieldName:OTHER.INCOME","0");
        PageObject.textinput_Locator("fieldName:OTHER.FUNDS","0");
        PageObject.textinput_Locator("fieldName:PER.PROP.INMNT","20000000");
        PageObject.textinput_Locator("fieldName:CS.ANNUM.TO","400000");
        PageObject.textinput_Locator("fieldName:SOURCE.OF.INCOME","Business");
        PageObject.radiobutton_Locator("radio:mainTab:REL.POILITICAL",1);
        PageObject.textinput_Locator("fieldName:POLITICAL.FIGURE","Test3");
        PageObject.radiobutton_Locator("radio:mainTab:PFAMAPPROVAL",1);
        PageObject.textinput_Locator("fieldName:KYC.REVW.COMENT","Testing");
        PageObject.radiobutton_Locator("radio:mainTab:HRAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.BS.CNT.PHNO",1);
        PageObject.textinput_Locator("fieldName:CUST.COMMENTS:1","ISL");
        PageObject.radiobutton_Locator("radio:mainTab:CH.FIN.STMT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.GEO.LOCAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.GEO.INT",1);
        PageObject.textinput_Locator("fieldName:EXP.COUNT.PARTY:1","Test4");
        PageObject.radiobutton_Locator("radio:mainTab:CH.EXP.COUNT.PARTY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.OCCUPATION",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAME.OF.BUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAT.OF.BUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.STAT.OWNER",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.NAME.OF.EMP",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.POS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.EMP.SINCE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.STATUS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CURRENT.SALARY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.COMMENTS",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CUS.SATISFY",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.PER.PROP.INMNT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.CS.ANNUM.TO",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.SOURCE.OF.INCOME",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.REL.POILITICAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.POLITICAL.FIGURE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.PFAMAPPROVAL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.RISKLEVEL",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.AMEND.DATE",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.KYC.REVW.COMENT",1);
        PageObject.radiobutton_Locator("radio:mainTab:CH.HRAMAPPROVAL",1);

        PageObject.commitDeal("KYC_Amendment_Customer");

        txn = PageObject.getTxn();
        System.out.println(txn);



    }
}
