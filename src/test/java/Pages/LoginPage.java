package Pages;

import StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        Hooks.driver=driver;
        PageFactory.initElements(driver,Hooks.driver);
    }

    public WebElement usernamePOM ()
    {
        By username = By.id("Email");
        WebElement usernameEle = Hooks.driver.findElement(username);
        return usernameEle;
    }

    public WebElement passwordPOM ()
    {
        return Hooks.driver.findElement(By.name("Password"));
    }

    /*public By flashPOM ()
    {
        return By.id("flash");
    }

    public By logoutPOM ()
    {
        return By.cssSelector("a[href=\"/logout\"]");
    }
*/
    public void LoginSteps(String username, String password)
    {
//        usernamePOM().clear();
        usernamePOM().sendKeys(username);

        passwordPOM().sendKeys(password);
        passwordPOM().sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();
    }
}
