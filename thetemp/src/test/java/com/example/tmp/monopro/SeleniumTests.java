package com.turksat.azerspace.azweb;
/*
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class SeleniumTests {
    static WebDriver driver;
    String url = "http://localhost/azspace";

    public SeleniumTests() {

        System.setProperty("webdriver.chrome.driver", "D://Apps//chromedriver_win32//new//chromedriver.exe");


    }


    @Given("^Open the Chrome and launch the application$")
    public void open_the_chrome_and_launch_the_application() throws Throwable {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get(url);


    }

    @And("^Welcome page will be displayed$")
    public void verify_welcome_page() throws Throwable {

        driver.findElement(By.id("usermail")).sendKeys("admin@turksat.com.tr");
        WebElement text = driver.findElement(By.id("password"));
        text.sendKeys("123");
        text.click();
        text.submit();
        Thread.sleep(1000);
        String actualString = driver.findElement(By.id("mydiv")).getText();
        assertTrue(actualString.contains("hello"));
    }

    @When("^User visit encyrpt link$")
    public void enter_the_Username_and_Password() throws Throwable {

        String str = driver.findElement(By.className("col-sm-12")).getText();
        //System.out.println(str);
    }

    @Then("^User execute some js$")
    public void enter_and_submi_form() throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        js.executeScript("alert('" + "--Hi--!" + "')");
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
    }

    @Then("^User will see the text$")
    public void verify_redurect_to_student__listpage() throws Throwable {
        String actualString = driver.findElement(By.ByTagName.tagName("title")).getText();
        //System.out.println(actualString);
        //  assertTrue(actualString.contains(""));
        driver.close();
    }

}
*/