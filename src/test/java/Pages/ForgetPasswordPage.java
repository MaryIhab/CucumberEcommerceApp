package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
    WebDriver driver;
    public ForgetPasswordPage(WebDriver driver)
    {
        Hooks.driver=driver;
        PageFactory.initElements(driver,Hooks.driver);

    }

    public WebElement genderPOM ()
    {
        By email = By.id("Email");
        WebElement usernameEle = Hooks.driver.findElement(email);
        return usernameEle;
    }

    /*public WebElement passwordPOM ()
    {
        return driver.findElement(By.name("Password"));
    }*/

    public void newPasswordSteps(String email)
    {
//        usernamePOM().clear();
        genderPOM().sendKeys(email);

        ///passwordPOM().sendKeys(password);
        ///passwordPOM().sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();
    }
}
