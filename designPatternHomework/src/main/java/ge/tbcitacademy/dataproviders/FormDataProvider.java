package ge.tbcitacademy.dataproviders;

import org.testng.annotations.DataProvider;

import static ge.tbcitacademy.data.Constants.*;

public class FormDataProvider {
    @DataProvider()
    public static Object[][] formData(){
        return new Object[][]{
                {someName1, someLastName1, Male, number1},
                {someName2, someLastName2, Female, number2},
                {someName3, someLastName3, Male, number3}
        };
    }
}
