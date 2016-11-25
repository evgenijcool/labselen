package com.evgeny.authorization;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;

import static com.evgeny.utils.Config.LOGIN;
import static com.evgeny.utils.Config.PASSWORD;
import static com.evgeny.utils.Utils.delay;
import static com.evgeny.utils.Utils.driver;
import static org.hamcrest.core.Is.is;

public class AuthSteps {

    @Given("^I go to auth page$")
    public void iGoToAuthPage() throws Throwable {
        WebElement search = driver.findElement(By.id("gb_70"));
        search.click();
        delay();
    }

    @Given("^Input correct login and pass$")
    public void inputCorrectLoginAndPass() throws Throwable {
        inputLogin(LOGIN);
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
        delay();
        inputPass(PASSWORD);
    }

    private void inputPass(String password) throws InterruptedException {
        WebElement input = driver.findElement(By.id("Passwd"));
        input.sendKeys(password);
        delay();
    }

    private void inputLogin(String login) throws InterruptedException {
        WebElement input = driver.findElement(By.id("Email"));
        input.sendKeys(login);
        delay();
    }

    @And("^I click profile button$")
    public void clickProfileButton() throws Throwable{
        WebElement icon = driver.findElement(By.className("gb_b gb_db gb_R"));
        icon.click();
        delay();
    }


    @Given("^Ask to input CAPTCHA if needed$")
    public void askToInputCAPTCHAIfNeeded() throws Throwable {
        if (driver.getPageSource().contains("CAPTCHA Проверка безопасности")) {
            System.out.println("Введите текст с капчи");
            String s = JOptionPane.showInputDialog(null, "Введите капчу со страницы");
            driver.findElement(By.id("mw-input-captchaWord")).sendKeys(s);
            delay();
        }
    }

    @When("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        WebElement enterButton = driver.findElement(By.id("signIn"));
        enterButton.click();
        delay();
        delay();
    }

    @Then("^I see my profile$")
    public void checkMyProfile(){
        WebElement email = driver.findElement(By.className("gb_vb"));
        MatcherAssert.assertThat(driver.getPageSource().contains(LOGIN), is(true));
    }

    @Given("^Input correct login$")
    public void inputCorrectLogin() throws Throwable {
        inputLogin(LOGIN);
    }

    @Given("^Input incorrect pass$")
    public void inputIncorrectPass() throws Throwable {
        inputPass(PASSWORD + "wrong");
    }
}
