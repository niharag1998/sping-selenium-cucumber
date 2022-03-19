package com.example.demo.cucumber.steps;

import com.example.demo.annotation.LazyAutowired;
import com.example.demo.pages.HomePage;
import com.example.demo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

public class LoginSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    private HomePage homePage;

    @LazyAutowired
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        homePage
                .goToHomePage()
                .goToLoginPage();
    }

    @When("I try to login with {string} and {string}")
    public void iTryToLoginWithAnd(String userName, String password) {
        loginPage
                .login(userName, password);
    }

    @Then("I verify invalid login message")
    public void iVerifyInvalidLoginMessage() {
        if (!browser.equalsIgnoreCase("firefox")) {
            loginPage
                    .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyPasswordErrorMessageWithCss("E-posta adresiniz veya şifreniz hatalı");
        }
    }
}
