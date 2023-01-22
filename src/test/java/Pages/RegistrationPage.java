package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement genderPOM ()
    {
        By email = By.id("Email");
        WebElement usernameEle = driver.findElement(email);
        return usernameEle;
    }

    public WebElement passwordPOM ()
    {
        return driver.findElement(By.id("Password"));
    }

    public WebElement confirmPasswordPOM ()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }
    public void RegistrationSteps(String email,String password, String confirmPassword)
    {
//        usernamePOM().clear();
        genderPOM().sendKeys(email);
        passwordPOM().sendKeys(password);
        confirmPasswordPOM().sendKeys(confirmPassword);

        //passwordPOM().sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]")).click();
    }
}
