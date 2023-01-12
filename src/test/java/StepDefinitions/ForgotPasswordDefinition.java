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

public class ForgotPasswordDefinition {
    WebDriver driver=null;

    LoginPage login;
    @Given("user navigates to home page")
    public void user_open_browser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        login = new LoginPage(driver);
    }
    @When("user click on forgot link and enters correct email")
    public void ForgetPassword() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Forgot password")).click();
        driver.findElement(By.id("Email")).sendKeys("tempo@mail.com");
        driver.findElement(By.name("send-email")).click();

    }

    @Then("user should receive email with instructions")
    public void CheckMessage()
    {
        Assert.assertTrue(driver.findElement(By.className("content")).isDisplayed());

    }
    @And("Close")
    public void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
