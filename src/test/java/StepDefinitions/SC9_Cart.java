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
import org.openqa.selenium.support.ui.Select;

public class SC9_Cart {

        WebDriver driver=null;
        LoginPage login;
        @Given("user logged in to home page to add to cart")
        //@Before
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

        @When("user adds an item to the cart")
        public void cart() throws InterruptedException {
            driver.findElement(By.xpath("//img[@alt='Picture for category Apparel']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//img[@alt='Picture for category Shoes']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/25/1/1\"),!1']")).click(); //add to cart
            Thread.sleep(2000);
            Select drpDate = new Select(driver.findElement(By.id("product_attribute_9")));
            drpDate.selectByVisibleText("9");
            driver.findElement(By.id("add-to-cart-button-25")).click();

        }

        @Then("item should be added to the cart")
        public void ExpectedCart() throws InterruptedException {
            driver.navigate().to("https://demo.nopcommerce.com/cart");
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.id("checkout")).isDisplayed());

        }
        @And("End cart")
        //@After
        public void close_browser() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

}
