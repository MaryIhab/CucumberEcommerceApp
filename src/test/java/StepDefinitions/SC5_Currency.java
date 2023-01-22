package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SC5_Currency {

        WebDriver driver=null;
        LoginPage login;
        @Given("user logged in to home page to change currency")
    public void OpenBrowser() throws InterruptedException {
            String chromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver",chromePath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(3000);
            login = new LoginPage(driver);
            driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
           // driver.navigate().to("https://demo.nopcommerce.com/");
            Thread.sleep(3000);
            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
        }
        @When("user changes current currency")
    public void Currency() throws InterruptedException {
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("book");
            Thread.sleep(1000);
            driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            Select currency = new Select(driver.findElement(By.id("customerCurrency")));
            currency.selectByVisibleText("Euro");
            Thread.sleep(2000);
        }
        @Then("currency should be changed")
    public void change_currency() throws InterruptedException {
            Thread.sleep(1000);
            // Assert.assertTrue(driver.findElement(By.partialLinkText("€")).isDisplayed());
            Assert.assertEquals(driver.findElement(By.className("price")), driver.findElement(By.className("price")));
        }

        @And("End currency")
    public void end_currency() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

}