package com.orangehrm.pages;

import com.orangehrm.BasePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class HRMLoginPage extends BasePage {
    private final By userName_Locator = By.xpath("//div[@class='orangehrm-login-error']/div/p[1]");
    private final By passWord_Locator = By.xpath("//div[@class='orangehrm-login-error']/div/p[2]");


    //User Login
    private final By userName_Field = By.xpath("//input[@placeholder='Username']");
    private final By passWord_Field = By.cssSelector("input[name='password']");
    private final By login_Button = By.cssSelector("button[class*='oxd']");
    private final By forgotPassword_Button = By.cssSelector("p.orangehrm-login-forgot-header");
    private final By loginFailMessage = By.cssSelector(".oxd-alert-content--error");

    //ForgotPassword
    private final By forgotUserName_Field = By.cssSelector(".oxd-input--active");
    private final By resetPassword_Button = By.cssSelector("button[type='submit']");
    private final By confirmMessage = By.cssSelector(".orangehrm-forgot-password-title");

    public Map<String,String> getCredentials(){
        Map<String, String> credential = new HashMap<>();
        String userName = splitString(":",userName_Locator).get(1);
        String passWord = splitString(":",passWord_Locator).get(1);
        credential.put("username",userName);
        credential.put("password",passWord);
        return credential;
    }

    public void loginToHRM(){
        String userName = getCredentials().get("username");
        String passWord = getCredentials().get("password");

        passValue(userName_Field, userName);
        passValue(passWord_Field, passWord);
        click(login_Button);
    }

    public void setForgotPassWord(){
        String userName = getCredentials().get("username");
        click(forgotPassword_Button);
        passValue(forgotUserName_Field, userName);
    }

    public void loginToHRM(String userName, String passWord ){
        passValue(userName_Field, userName);
        passValue(passWord_Field, passWord);
        click(login_Button);
    }

    public void setForgotPassWord(String userName){
        click(forgotPassword_Button);
        passValue(forgotUserName_Field, userName);
    }

    public String verifyResetPasswordMessage(){
        return getValue(confirmMessage);
    }

    public String verifyLoginErrorMessage(){
        return getValue(loginFailMessage);
    }
}
