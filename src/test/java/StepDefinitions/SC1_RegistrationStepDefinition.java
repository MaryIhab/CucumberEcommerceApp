package StepDefinitions;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class SC1_RegistrationStepDefinition {

    WebDriver driver=null;
    RegistrationPage newUser;
    @Given("user navigates to registration  page")

    public void RegistrationPage() throws InterruptedException {
        String chromePath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\mary.nassif\\Downloads\\Egy Fwd\\AutomationProject\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        newUser = new RegistrationPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("user enters all data successfully and submits")
    public void fill_Form()
    {
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Tom");
        driver.findElement(By.id("LastName")).sendKeys("Smith");
        Select drpDate = new Select(driver.findElement(By.name("DateOfBirthDay")));
        drpDate.selectByVisibleText("10");
        drpDate = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        drpDate.selectByVisibleText("January");
        drpDate= new Select(driver.findElement(By.name("DateOfBirthYear")));
        drpDate.selectByVisibleText("2000");
        /*driver.findElement(By.id("Email")).sendKeys("Thanks@Udacity2023.com");
        driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("P@ssw0rd");
        */
        newUser.RegistrationSteps("Thanks@Udacity2023.com","P@ssw0rd","P@ssw0rd");
        driver.findElement(By.id("register-button")).click();

    }

    @Then("success registration message should be displayed to the user")
    public void SuccessMessage()
    {
        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        Assert.assertEquals(actualResult.contains(expectedResult),true);

    }
    @And("Close browser")
    public void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
