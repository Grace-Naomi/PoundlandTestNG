package com.pl.WebTests;

import com.pl.Base.PoundLandBase;
import com.pl.ObjectRepository.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WishlistTest extends PoundLandBase {

    CreateAccountPage cap;
    AllProductsPage allProductsPage;
    MyAccountPage myAccountPage;

    WishListPage wishListPage;

    CartPage cartPage;

    @BeforeMethod
    public void initializePages() {
        cap = new CreateAccountPage(driver);
        allProductsPage = new AllProductsPage(driver);
        myAccountPage = new MyAccountPage(driver);
        wishListPage = new WishListPage(driver);

    }

    @Parameters({"firstname", "lastname", "email", "password", "confirmPassword"})
    @Test(priority = 1)

    public void createdAccountData(String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {

        cap.createAccountMethod(firstname, lastname, email, password, confirmPassword);
    }


    @Test(priority = 2)
    public void allProductsGardenPage() throws InterruptedException {

        allProductsPage.allProductsMethod();

        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void subItem() throws InterruptedException {
        allProductsPage.subItemWishMethod();
        Thread.sleep(3000);
        wishListPage.favItemsList();
        Thread.sleep(3000);
        wishListPage.getFavGardenAccessoriesProductNames();
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void verifyTotalNumberOfGardeToolsProducts() throws InterruptedException {
        wishListPage.getFavGardenAccessoriesProductNames();
        Assert.assertEquals(wishListPage.actualListOfProductsInFav, wishListPage.expectedListOfProductsInFav);
    }




    @Test(priority = 5)
    public void myAccountMethod() throws InterruptedException {
        myAccountPage.myAccountElement();
        Thread.sleep(5000);

    }

    @Test(priority = 6)
    public void myFavouritesMethod() throws InterruptedException {
        myAccountPage.myFavouritesElement();
        Thread.sleep(5000);
    }

    @Test(priority = 8)
    public void logOut(){
        wishListPage.logOutMethod();
    }


}