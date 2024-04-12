package ge.tbcitacademy.dataproviders;

import org.testng.annotations.DataProvider;

import static ge.tbcitacademy.data.Constants.*;
import static ge.tbcitacademy.data.Constants.permAddrss;

public class TelerikFormDataProvider {
    @DataProvider()
    public static Object[][] telerikFormData(){
        return new Object[][]{
                {someName1, someLastName1, number1, permanentAddr, sumCompany, zipcode, someCity },
                {someName2, someLastName3, number2, permAddrss, sumCompany, zipcode, someCity}
        };
    }
}
