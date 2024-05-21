package com.pl.WebTests;
import com.pl.Base.PoundLandBase;
import com.pl.ObjectRepository.AllProductsPage;
import com.pl.ObjectRepository.CartPage;
import com.pl.ObjectRepository.MyAccountPage;
import com.pl.ObjectRepository.PopUp.SignInBox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddToCartTest extends PoundLandBase {
    SignInBox signInBox;
    AllProductsPage allProductsPage;
    CartPage cartPage;
    MyAccountPage myAccountPage;

    @BeforeMethod
    public void initializePages() {

        signInBox = new SignInBox(driver);
        allProductsPage = new AllProductsPage(driver);
        cartPage=new CartPage(driver);
        myAccountPage=new MyAccountPage(driver);
    }

    @Test(priority = 1)
    public void signIn() {

        signInBox.signInMethod("qatester1177@yopmail.com", "Qatester1177");
    }

    @Test(priority = 2)
    public void allProductsGardenPage() throws InterruptedException {

        allProductsPage.allProductsMethod();

        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void subItem() throws InterruptedException {
        allProductsPage.subItemCartMethod();
        Thread.sleep(3000);
        cartPage.addCartItems();
        Thread.sleep(3000);
        cartPage.getSeedProductNames();
        Thread.sleep(3000);
    }

    @Test(priority =4)
    public void basketCartPage() throws InterruptedException {
        myAccountPage.basketCartElement();
        Thread.sleep(5000);
    }


    @Test(priority = 5)
    public void verifyTotalNumberOfSeedsProductsInCart() throws InterruptedException {
        cartPage.getNumberOfProductsAddedInCart();
        Assert.assertEquals(cartPage.actualListOfProductsInCart,cartPage.expectedListOfProductsInCart);

    }


  @Test(priority = 6)
    public void logOut(){
        cartPage.logOutMethod();
  }




}