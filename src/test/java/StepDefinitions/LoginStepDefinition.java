package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver=null;
    LoginPage login;
    @Given("user navigates to login page")
    public void user_open_browser() throws InterruptedException {
        String chromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        login = new LoginPage(driver);

    }

    @When("user enter valid username and password And user click on login button")
    public void valid_data() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        Thread.sleep(3000);
        login.LoginSteps("Thanks@UdacityJan2023.com","P@ssw0rd");
    }


    @Then("user could login successfully and go to homepage")
    public void success_login()
    {
        Assert.assertTrue(driver.findElement(By.partialLinkText("My account")).isDisplayed());
    }
    @And("End browser")
    public void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
