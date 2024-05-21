package com.pl.ObjectRepository;

import com.pl.Utilities.PLActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {


    private WebDriver driver;

    CreateAccountPage createAccountPage;
    AllProductsPage allProductsPage;
    PLActions plActions;

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        plActions=new PLActions(driver);
    }
    @FindBy(xpath = "//a[@class='top-nav__link']")
    private WebElement MyAccount;

    @FindBy(xpath = "//a[@class='top-subnav__link'][normalize-space()='My Favourites']")
    private WebElement MyFavourites;


    @FindBy(xpath = "//a[@class='fill--scarlet top-nav__minicart']//span[@class='cart-badge']")
    private WebElement Basket;


    public void myAccountElement() {

        plActions.clickOnElement(MyAccount);
    }
    public void myFavouritesElement(){

        plActions.clickOnElement(MyFavourites);
    }
    public void basketCartElement(){
        plActions.clickOnElement(Basket);

    }


}
