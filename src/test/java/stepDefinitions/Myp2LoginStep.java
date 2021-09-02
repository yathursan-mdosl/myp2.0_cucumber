package stepDefinitions;


import dataProvider.FileResourcesTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import static dataProvider.FileResourcesTest.*;
import static sun.net.NetProperties.get;

public class Myp2LoginStep
{
    WebDriver driver;
    FileResourcesTest fileResourcesTest;

    @Given("user is on login page")
    public void user_is_on_login_page() throws IOException, URISyntaxException
    {
//        System.setProperty("webdriver.chrome.driver","D://driver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        fileResourcesTest= new FileResourcesTest();
        driver.manage().window().maximize();
//        driver.get(fileResourcesTest.loadPropTest().getProperty("url").toString());
//        driver.get(fileResourcesTest.loadPropTest().getProperty("implicitlyWait").toString());

        driver.get(getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(getImplicityWait(),TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://myp2_dev.mydigitaloffice.com");

    }
    @When("the user enter valid username and password")
    public void the_user_enter_valid_username_and_password() throws IOException, URISyntaxException
    {
        driver.findElement(By.id("email")).sendKeys(getUsername());
        driver.findElement(By.id("password")).sendKeys(getPassword());
    }
    @When("clicks on login button")
    public void clicks_on_login_button()
    {
        driver.findElement(By.id("btn-login")).click();
    }
    @Then("the user should navigated to home page")
    public void the_user_should_navigated_to_home_page()
    {
        boolean status = driver.findElement(By.xpath("//span[text()='Becklegacy Corporate']")).isDisplayed();
        Assert.assertTrue(status);

    }

    @Then("Logout button should exist")
    public void logoutButtonShouldExist()
    {
        boolean status= driver.findElement(By.linkText("logout")).isDisplayed();
        Assert.assertTrue(status);
    }
}
