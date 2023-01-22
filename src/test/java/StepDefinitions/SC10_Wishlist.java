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

public class SC10_Wishlist {

        WebDriver driver=null;
        LoginPage login;
        @Given("user logged in to home page to add to wishlist")
        //@Before
        public void LoginWishlist() throws InterruptedException {
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

        @When("user adds an item to the wishlist")
        public void wishlist() throws InterruptedException
        {
            driver.findElement(By.xpath("//a[@href='/books']")).click(); //add to cart
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/37/2/1\"),!1']")).click(); //add to cart
            driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/38/2/1\"),!1']")).click(); //add to cart

        }

        @Then("item should be added to the wishlist")
        public void ExpectedResult() throws InterruptedException {
            driver.navigate().to("https://demo.nopcommerce.com/wishlist");
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.className("remove-from-cart")).isDisplayed());

        }
        @And("End wishlist")
        //@After
        public void close_browser() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

}
