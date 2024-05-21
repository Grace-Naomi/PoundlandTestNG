package com.pl.ObjectRepository.PopUp;

import com.pl.Utilities.PLActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInBox {

    private  WebDriver driver;
    PLActions plActions;
    public SignInBox(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        plActions=new PLActions(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'sign in')]")
    private WebElement signIn;

    public WebElement signInLink(){
        return signIn;

    }
    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    private WebElement acceptAllBtn;

    @FindBy(css = "[data-testid='om-overlays-close']")
    private WebElement closePopUpBtn;


    @FindBy(xpath = "//a[contains(text(),'sign in')]")
    private WebElement signInIconBtn;

    @FindBy(linkText = "Create an Account")
    WebElement createAccountBtn;
    @FindBy(css = "#email")
    private WebElement EmailInputField;
    @FindBy(css = "[placeholder='Password']")
    private WebElement PasswordInputField;

    @FindBy(xpath = "//button[@id='send3']//span[contains(text(),'Sign In')]")
    private WebElement signInButton;

       public void signInMethod(String emailInputField, String passwordInputField) {

           plActions.clickOnElement(acceptAllBtn);
           plActions.clickOnElement(closePopUpBtn);
           plActions.clickOnElement(signInIconBtn);
           plActions.typeValue(EmailInputField, emailInputField);
           plActions.typeValue(PasswordInputField, passwordInputField);
           plActions.clickOnElement(signInButton);

}



}
