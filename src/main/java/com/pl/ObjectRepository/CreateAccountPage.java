package com.pl.ObjectRepository;

import com.pl.Utilities.PLActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateAccountPage {
    private final WebDriver driver;

   PLActions plActions;
    public CreateAccountPage(WebDriver driver){
       this.driver=driver;
        PageFactory.initElements(driver, this);
        plActions = new PLActions(driver);
    }

    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    private WebElement acceptAllBtn;

    @FindBy(css = "[data-testid='om-overlays-close']")
    private WebElement closePopUpBtn;

    @FindBy(css ="[title='Create an Account']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'sign in')]")
    private WebElement signInIconBtn;

    @FindBy(linkText = "Create an Account")
   private WebElement createAccountBtn;
    @FindBy(css = "#firstname")
    private WebElement FirstNameInputField;

    @FindBy(css = "#lastname")
    private WebElement LastNameInputField;

    @FindBy(css = "#email_address")
    private WebElement EmailInputField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement PasswordInputField;

    @FindBy(css = "#password-confirmation")
    private WebElement ConfirmPasswordInputField;

   /*public WebElement getSubmitButton(){

        return submitButton;
    }*/

    public void createAccountMethod(String firstname,String lastname, String email,String password,String confirmPassword) throws InterruptedException {

        plActions.clickOnElement(acceptAllBtn);
        plActions.clickOnElement(signInIconBtn);
        plActions.clickOnElement(createAccountBtn);
        plActions.typeValue(FirstNameInputField, firstname);
        plActions.typeValue(LastNameInputField, lastname);
        plActions.typeValue(EmailInputField, email);
        plActions.typeValue(PasswordInputField, password);
        plActions.typeValue(ConfirmPasswordInputField, confirmPassword);
        Thread.sleep(5000);
        submitButton.click();

    }

}
