package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoriesAndToolsPage;
import pages.CheckOutPage;
import pages.RegisterPage;

public class CategoriesAndToolsTest extends BaseTest{

    @Test
    public void selectTool() throws InterruptedException {
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.registerPage();

        CategoriesAndToolsPage categoriesAndToolsPage=new CategoriesAndToolsPage(driver);
        categoriesAndToolsPage.selectTools();

        Assert.assertEquals(driver.getCurrentUrl(),"https://practicesoftwaretesting.com/#/category/hand-tools","URL se ne podudaraju.");

        categoriesAndToolsPage.addHammerIntoCart();
        categoriesAndToolsPage.addSheetSanderIntoCart();

        CheckOutPage checkOutPage=new CheckOutPage(driver);
        checkOutPage.getFirstAmount();

    }




}
