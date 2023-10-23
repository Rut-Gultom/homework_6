package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";
    @Given("Halaman login sauce demo")
    public void halaman_login_sauce_demo(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseURL);


    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user in dashboard page")
    public void userInDashboardPage() {
        String dashboardText = driver.findElement(By.xpath("//div[@class='header_label']//div[@class='app_logo']")).getText();
        driver.close();
    }

    @And("Input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");

    }

    @Then("User get Error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
