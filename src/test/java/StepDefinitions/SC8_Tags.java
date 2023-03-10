package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SC8_Tags {

        WebDriver driver=null;
        LoginPage login;
//        @Given("user logged in to home page to select tags")
//        //@Before
//        public void OpenBrowser() throws InterruptedException {
//            String chromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
//            //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver",chromePath);
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            Thread.sleep(3000);
//            login = new LoginPage(driver);
//            driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
//           // driver.navigate().to("https://demo.nopcommerce.com/");
//            Thread.sleep(3000);
//            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
//        }

        @When("user selects tag")
        public void tags() throws InterruptedException {
            login = new LoginPage(Hooks.driver);
            Thread.sleep(3000);
            Hooks.driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
            Hooks.driver.findElement(By.xpath("//img[@alt='Picture for category Apparel']")).click();
            Thread.sleep(1000);
            //driver.findElement(By.xpath("//a[@href='/apparel-2']")).click(); //tag
            Hooks.driver.findElement(By.xpath("//a[@href='/cool']")).click();
            Thread.sleep(2000);

        }

        @Then("results should be filtered with the selected tag")
        public void ExpectedResult()
        {
            Assert.assertEquals("https://demo.nopcommerce.com/cool",Hooks.driver.getCurrentUrl());

        }
//        @And("End tags")
//        //@After
//        public void close_browser() throws InterruptedException {
//            Thread.sleep(3000);
//            driver.close();
//        }

}
