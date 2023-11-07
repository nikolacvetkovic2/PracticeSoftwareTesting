package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoriesAndToolsPage extends BasePage {
    public CategoriesAndToolsPage(WebDriver driver) {
        super(driver);
    }

    private By categoriesButton=By.cssSelector("[data-test=\"nav-categories\"]");
    private By handToolsButton=By.xpath("//*[text()='Hand Tools']");

    private By ClawHammer=By.xpath("//*[text()=' Claw Hammer with Shock Reduction Grip ']");
    private By addOneMOreClawHammer=By.cssSelector(".fa.fa-plus");
    private By AddToCartClawHammer=By.cssSelector("#btn-add-to-cart");

    private By PowerToolsButton=By.xpath("//*[text()='Power Tools']");

    private By SheetSander=By.xpath("//*[text()=' Sheet Sander ']");
    private By addOneMOreSheetSander=By.cssSelector("#btn-increase-quantity>i");
    private By AddToCartSheetSander=By.cssSelector("#btn-add-to-cart");

    public void clickOnCategoriesButton(){
        clickOnElement(categoriesButton);
    }

    public void clickOnHandTools(){
        clickOnElement(handToolsButton);
    }

    public void selectTools() throws InterruptedException {
       Thread.sleep(1000);
        clickOnCategoriesButton();
        clickOnHandTools();
    }

    public void addHammerIntoCart(){
        clickOnElement(ClawHammer);
        clickOnElement(addOneMOreClawHammer);
        clickOnElement(AddToCartClawHammer);
    }
    public void addSheetSanderIntoCart() throws InterruptedException {
        clickOnElement(categoriesButton);
        clickOnElement(PowerToolsButton);
        clickOnElement(SheetSander);
        Thread.sleep(3000);
        clickOnElement(addOneMOreSheetSander);
        clickOnElement(AddToCartSheetSander);
    }

}
