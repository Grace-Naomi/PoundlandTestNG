package com.pl.ObjectRepository;

import com.pl.Utilities.PLActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage {

    AllProductsPage allProductsPage;
    MyAccountPage myAccountPage;

    private WebDriver driver;
    public  String actualProductName;
    public String expectedProductName;

    public List<String> actualListOfProductsInCart;
    public List<String> expectedListOfProductsInCart;
    PLActions plActions;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        plActions=new PLActions(driver);
    }
    @FindBy(xpath = "//a[@class='main_menu__link'][normalize-space()='Garden']")
    private WebElement Garden;

    @FindBy(xpath = "//a[normalize-space()='Seeds and Bulbs']")
    private WebElement SeedsBulbs;
    @FindBy(xpath = "//div[@class='product-add-info']/div/following::form")
    private List<WebElement> SeedsAddBtnProduct;

    @FindBy(xpath = "//div[@class='tocart-qty']//parent::form//parent::div//preceding-sibling::span/a")
    private List<WebElement> ListOfSeedsProducts;

    @FindBy(xpath = "//div[@class='product-item-details']//strong/a")
    private List<WebElement> NumberOfProductsAddedInCart;

    @FindBy(xpath = "//a[@class='top-nav__link']")
    private WebElement MyAccount;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    private WebElement Logout;

/*
    @FindBy(xpath = "//h1[@class='page-title']")
    private WebElement BasketPageTitle;*/

    /*
    public void addedItems() throws InterruptedException {
        Thread.sleep(3000);
        allProductsPage=new AllProductsPage(driver);
       //myAccountPage = new MyAccountPage(driver);



        plActions.clickOnElement(AddedItem1);
        plActions.clickOnElement(AddItemToCart);
        plActions.moveToElement(Garden);
        plActions.clickOnElement(SeedsBulbs);
        plActions.clickOnElement(AddedItem2);
        plActions.clickOnElement(AddItemToCart);
        plActions.moveToElement(Garden);
        plActions.clickOnElement(SeedsBulbs);
        plActions.clickOnElement(AddedItem3);
        plActions.clickOnElement(AddItemToCart);

        myAccountPage.basketCartElement();
        Thread.sleep(3000);

        */

/*

*******************

        List<String>listOfProducts=new ArrayList<>();
        List<WebElement>listOfProductsInSubItem=driver.findElements(By.xpath("//div[@class='products list products-grid']/child::ol[@class='products list items product-items']"));
        for (WebElement element : listOfProductsInSubItem) {
            listOfProducts.add(element.getText());

        }
       /*

        List<WebElement> listOfProductsInWishlistEle = driver.findElements(By.xpath("//table[@class='list']/tbody/tr/following-sibling::tr/descendant::p/span[@class='product-name']"));

        for (WebElement element : listOfProductsInWishlistEle) {
            listOfProductsInCart.add(element.getText());

        }
    }*/


    public void addCartItems() {

        for (int i = 0; i < 3; i++) {
            WebElement item = SeedsAddBtnProduct.get(i);
            plActions.clickOnElement(item);
        }
    }

    public void getSeedProductNames() throws InterruptedException {
        actualListOfProductsInCart = new ArrayList();
        int count=0;
        for (WebElement element : ListOfSeedsProducts) {
            actualProductName=element.getText();
            actualListOfProductsInCart.add(actualProductName);
            Thread.sleep(5000);

            count++;
            if (count == 3) {
                break;
            }
        }
        Collections.sort(actualListOfProductsInCart);
        System.out.println(actualListOfProductsInCart);

    }
    public void getNumberOfProductsAddedInCart() throws InterruptedException {
        expectedListOfProductsInCart=new ArrayList<>();

        for (WebElement element:NumberOfProductsAddedInCart) {
            expectedProductName=element.getText();
            expectedListOfProductsInCart.add(expectedProductName);
            Thread.sleep(5000);


        }
        Collections.sort(expectedListOfProductsInCart);
        System.out.println(expectedListOfProductsInCart);




    }

    public void logOutMethod(){
        plActions.clickOnElement(MyAccount);
        plActions.clickOnElement(Logout);

    }
    }


