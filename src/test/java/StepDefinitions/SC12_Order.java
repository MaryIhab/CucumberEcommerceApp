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

public class SC12_Order {

        WebDriver driver=null;
        LoginPage login;
        @Given("user logged in to home page to place an order")
        //@Before
        public void LoginOrder() throws InterruptedException {
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

        @When("user adds items to cart and place order")
        public void order() throws InterruptedException
        {
            driver.findElement(By.xpath("//a[@href='/jewelry']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/41/1/1\"),!1']")).click();
            driver.navigate().to("https://demo.nopcommerce.com/cart");
            driver.findElement(By.id("termsofservice")).click();
            driver.findElement(By.id("checkout")).click();
            Select country = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
            country.selectByVisibleText("Egypt");
            driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Cairo");//city
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Heliopolis");//street
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("11311");//zip
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0223456789");//phone

            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='ShippingMethod.save()']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='PaymentMethod.save()']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='PaymentInfo.save()']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@onclick='ConfirmOrder.save()']")).click();


        }

        @Then("order should be created successfully")
        public void SuccessMessage() throws InterruptedException {
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.className("order-number")).isDisplayed());
            //Assert.assertTrue(driver.findElement(By.partialLinkText("Thank you")).isDisplayed());

        }
        @And("End Order")
        //@After
        public void close_browser() throws InterruptedException {
            Thread.sleep(3000);
            driver.close();
        }

}
