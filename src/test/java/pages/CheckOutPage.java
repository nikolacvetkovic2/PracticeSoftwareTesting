package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    By cartButton=By.cssSelector("[data-test=\"nav-cart\"]>i");

    public void clickOnCartButton() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(cartButton);
    }

    String firstAmount=".wizard-steps.horizontal>:first-child>:first-child>:first-child>:nth-child(2)>:first-child>:nth-child(5)>span";
    String secondAmount=".wizard-steps.horizontal>:first-child>:first-child>:first-child>:nth-child(2)>:last-child>:nth-child(5)>span";
    String totalAmount=".wizard-steps.horizontal>:first-child>:first-child>:first-child>:last-child>:last-child>:nth-child(5)";

     public double getFirstAmount(){
         return Double.parseDouble(getText(driver.findElement(By.cssSelector(firstAmount)),"the first amount: ").replace("$",""));
     }

    public double getSecondAmount(){
        return Double.parseDouble(getText(driver.findElement(By.cssSelector(secondAmount)),"the second amount: ").replace("$",""));
    }

    public double getTotalAmount(){
        return Double.parseDouble(getText(driver.findElement(By.cssSelector(totalAmount))," total amount ").replace("$",""));
    }

    public double totalSum(){
         double sum=0;
       sum= Double.sum(getFirstAmount(),getSecondAmount());
       return sum;
    }

}
