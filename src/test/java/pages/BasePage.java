package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    Faker faker;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        faker = new Faker(new Locale("en-us"));
    }

    protected WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    protected void typeIn(By locator, String text){
        WebElement element=getElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    protected void clickOnRandoElement(By locator){
        List<WebElement> list=driver.findElements(locator);
        Random random=new Random();
        int randomElement= random.nextInt(list.size());
        list.get(randomElement).click();
    }
    protected  void hover(By locator, long wait){
        WebElement element=getElement(locator);
        new Actions(driver).moveToElement(element).pause(wait).build().perform();
    }

    protected  void hoverAndClick(By locator, long wait){
        WebElement element=getElement(locator);
        new Actions(driver).moveToElement(element).pause(wait).click().build().perform();
    }

    protected void clickOnElement(By locator){
        try{
           wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (ElementClickInterceptedException e){
            wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        } catch (StaleElementReferenceException s) {
            s.printStackTrace();
            hoverAndClick(locator, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getText(WebElement element, String log){
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));

        System.out.println("Getting text from: " + log);

        return element.getText();

}
}