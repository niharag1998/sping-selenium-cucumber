package com.example.demo.steps;

import com.example.demo.annotation.ElapsedTime;
import com.example.demo.annotation.LazyAutowired;
import com.example.demo.annotation.LazyComponent;
import com.example.demo.annotation.TakeScreenshot;
import com.example.demo.pages.HomePage;
import com.example.demo.pages.LoginPage;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class LoginSteps {
    @Value("${browser}")
    private String browser;

    @LazyAutowired
    HomePage homePage;

    @LazyAutowired
    LoginPage loginPage;

    public LoginSteps givenIAmAtLoginPage() {
        homePage
                .goToHomePage()
                .goToLoginPage();
        return this;
    }

    @ElapsedTime
    public LoginSteps whenILogin(String userName, String password) {
        loginPage
                .login(userName, password);
        return this;
    }

    public LoginSteps thenIVerifyUserNameErrorMessages(String expected) {
        loginPage
                .verifyLoginUserNameErrorMessage(expected);
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyInvalidLoginMessage() {
        if(!browser.equalsIgnoreCase("firefox")) {
            loginPage
                    .verifyLogEntryFailMessage();
        } else {
            loginPage.verifyPasswordErrorMessageWithCss("E-posta adresiniz veya şifreniz hatalı");
        }
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyPasswordErrorMessage(String expected) {
        loginPage
                .verifyPasswordErrorMessage(expected);
        return this;
    }

    @TakeScreenshot
    public LoginSteps thenIVerifyPasswordErrorMessageWithCss(String expected) {
        loginPage
                .verifyPasswordErrorMessageWithCss(expected);
        return this;
    }
}
