package tests;

import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

    @Test
    public void registerTest() throws InterruptedException {

        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.registerPage();



    }


}
