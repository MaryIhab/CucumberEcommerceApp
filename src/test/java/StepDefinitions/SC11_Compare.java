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

public class SC11_Compare {

        //WebDriver driver=null;
        LoginPage login;
//        @Given("user logged in to home page to compare between items")
//        //@Before
//        public void LoginCompare() throws InterruptedException {
//            String chromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
//            //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
//            System.setProperty("webdriver.chrome.driver",chromePath);
//            Hooks.driver = new ChromeDriver();
//            Hooks.driver.manage().window().maximize();
//            Thread.sleep(3000);
//            login = new LoginPage(Hooks.driver);
//            Hooks.driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
//           // driver.navigate().to("https://demo.nopcommerce.com/");
//            Thread.sleep(3000);
//            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
//        }

        @When("user adds items to compare")
        public void compare() throws InterruptedException
        {
            login = new LoginPage(Hooks.driver);
            Hooks.driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
            Thread.sleep(3000);
            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
            Hooks.driver.findElement(By.xpath("//a[@href='/books']")).click(); //add to cart
            Thread.sleep(2000);
            Hooks.driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/37\"),!1']")).click(); //add to cart
            Hooks.driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocomparelist(\"/compareproducts/add/38\"),!1']")).click(); //add to cart

        }

        @Then("item should be added to the compare")
        public void SuccessMessage() throws InterruptedException {
            Thread.sleep(2000);
            Assert.assertTrue(Hooks.driver.findElement(By.partialLinkText("product comparison")).isDisplayed());
        }
//        @And("End compare")
//        //@After
//        public void close_browser() throws InterruptedException {
//            Thread.sleep(3000);
//            driver.close();
//        }

}
