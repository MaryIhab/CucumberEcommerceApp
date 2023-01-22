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

public class SC4_SearchStepDefinition {

        WebDriver driver=null;
        LoginPage login;
//        @Given("user logged in to home page")
//    //@Before
//        public void OpenBrowser() throws InterruptedException {
//            String chromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
//            //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver",chromePath);
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            Thread.sleep(3000);
//            login = new LoginPage(driver);
//            }

        @When("user type in the search field")
        public void Search() throws InterruptedException {
            login = new LoginPage(Hooks.driver);
            Hooks.driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
            // driver.navigate().to("https://demo.nopcommerce.com");
            Thread.sleep(3000);
            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
            Hooks.driver.findElement(By.xpath("//input[@name='q']")).sendKeys("book");
            Thread.sleep(1000);
            Hooks.driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ENTER);
            Thread.sleep(2000);

        }

        @Then("results should be displayed based on the search criteria")
        public void SuccessMessage()
        {
            Assert.assertTrue(Hooks.driver.findElement(By.partialLinkText("MacBook ")).isDisplayed());
        }
//        @And("End")
//        public void close_browser() throws InterruptedException {
//            Thread.sleep(3000);
//            driver.close();
//        }

}
