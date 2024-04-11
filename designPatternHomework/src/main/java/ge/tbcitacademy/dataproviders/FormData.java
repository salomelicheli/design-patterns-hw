package ge.tbcitacademy.dataproviders;

import org.testng.annotations.DataProvider;

import static ge.tbcitacademy.data.Constants.*;

public class FormData {
    @DataProvider()
    public static Object[][] formData(){
        return new Object[][]{
                {firstName, gmail, currentAddr, permanentAddr },
                {firstName2, gmail1, currentAddrs, permAddrss},
        };
    }
}
