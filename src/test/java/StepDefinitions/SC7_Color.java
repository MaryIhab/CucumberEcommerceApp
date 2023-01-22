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

public class SC7_Color {

        WebDriver driver=null;
        LoginPage login;
      // @Before
//        @Given("user logged in to home page to select color")
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

        @When("user selects color")
        public void color() throws InterruptedException {
            login = new LoginPage(Hooks.driver);
            Thread.sleep(3000);
            Hooks.driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
            login.LoginSteps("Thanks@Udacity2023.com","P@ssw0rd");
            Hooks.driver.findElement(By.xpath("//img[@alt='Picture for category Apparel']")).click();
            Thread.sleep(1000);
            Hooks.driver.findElement(By.xpath("//img[@alt='Picture for category Shoes']")).click();
            Thread.sleep(2000);
            Hooks.driver.findElement(By.id("attribute-option-15")).click(); //color
            Thread.sleep(2000);

        }

        @Then("results should be filtered with the selected color")
        public void ExpectedResult()
        {
            Assert.assertEquals("https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15",Hooks.driver.getCurrentUrl());
        }
//        @And("End colors")
//        //@After
//        public void close_browser() throws InterruptedException {
//            Thread.sleep(3000);
//            driver.close();
//        }

}
