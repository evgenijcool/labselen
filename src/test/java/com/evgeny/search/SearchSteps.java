package com.evgeny.search;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.evgeny.utils.Config.SITE;
import static com.evgeny.utils.Utils.delay;
import static com.evgeny.utils.Utils.driver;
import static org.hamcrest.CoreMatchers.is;

public class SearchSteps {

    @When("^Click search button$")
    public void clickSearchButton() throws Throwable {
        WebElement search = driver.findElement(By.name("btnG"));
        search.click();
        delay();
    }

    @Given("^I open main page$")
    public void iOpenSearchPage() throws Throwable {
        driver.get(SITE);
        delay();
    }

    @Then("^I see text (.+)")
    public void iSeeText(String text) throws Throwable {
        MatcherAssert.assertThat(driver.getPageSource().contains(text), is(true));
    }



    @And("^Input (.+) into search$")
    public void inputQueryIntoSearch(String input) throws Throwable {
        WebElement searchInput = driver.findElement(By.id("lst-ib"));
        searchInput.sendKeys(input);
        delay();
    }
}
