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

public class WishListPage {
    private WebDriver driver;

    public  String actualFavProductName;
    public String expectedFavProductName;

    public List<String> actualListOfProductsInFav;
    public List<String> expectedListOfProductsInFav;
    PLActions plActions;
    AllProductsPage allProductsPage;
    MyAccountPage myAccountPage;
    public WishListPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        plActions=new PLActions(driver);
    }

    @FindBy(xpath = "//a[@class='main_menu__link'][normalize-space()='Garden']")
    private WebElement Garden;

    @FindBy(xpath = "//a[normalize-space()='Garden Tools and Accessories']")
    private WebElement GardenToolsAccessories;
    @FindBy(xpath = "//span[@class='product name product-item-name']")
    private List<WebElement> ListGardenAccessoriesProductNames;

    @FindBy(xpath = "//div[@class='add-to-links']//a[@data-action='add-to-wishlist']")
    private List<WebElement> GardenAccessoriesFavBtn;

    @FindBy(xpath = "//div[@class='product-det']/child::p[@class='productName']//span[@class='product-name']")
    private List<WebElement> NumberOfProductsAddedInFav;

    @FindBy(xpath = "//a[@class='top-nav__link']")
    private WebElement MyAccount;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    private WebElement Logout;


    /*
    @FindBy(xpath = "//a[@class='product-item-link'][normalize-space()='Artificial Ivies 25.2m (12 Pieces)']")
    private WebElement FavItem1;
    @FindBy(xpath = "//a[@class='product-item-link'][normalize-space()='Artificial Mini Topiary Ball Garden Decoration']")
    private WebElement FavItem2;
    @FindBy(xpath = "//a[@class='product-item-link'][normalize-space()='Citronella Outdoor Candle']")
    private WebElement FavItem3;

    @FindBy(xpath = "//a[@class='main_menu__link'][normalize-space()='Garden']")
    private WebElement Garden;

    @FindBy(xpath = "//a[normalize-space()='Garden Tools and Accessories']")
    private WebElement GardenToolsAccessories;

    @FindBy(xpath = "//a[@id='addtowish']")
    ////a[@data-action='add-to-wishlist'][@id='addtowish']
    private WebElement AddWishToItem;


    public void favItemsList() throws InterruptedException {
        Thread.sleep(3000);

        allProductsPage=new AllProductsPage(driver);
        myAccountPage=new MyAccountPage(driver);


        plActions.clickOnElement(FavItem1);
        plActions.clickOnElement(AddWishToItem);
     //   Thread.sleep(1000);
        plActions.moveToElement(Garden);
        plActions.clickOnElement(GardenToolsAccessories);
        plActions.clickOnElement(FavItem2);
        plActions.clickOnElement(AddWishToItem);
       // Thread.sleep(1000);
        plActions.moveToElement(Garden);
        plActions.clickOnElement(GardenToolsAccessories);

        plActions.clickOnElement(FavItem3);
        plActions.clickOnElement(AddWishToItem);

        myAccountPage.myAccountElement();
        myAccountPage.myFavouritesElement();

        List<String> listOfProductsInWishlist = new ArrayList();

        List<WebElement> listOfProductsInWishlistEle = driver.findElements(By.xpath("//table[@class='list']/tbody/tr/following-sibling::tr/descendant::p/span[@class='product-name']"));

        for (WebElement element : listOfProductsInWishlistEle) {

           listOfProductsInWishlist.add(element.getText());

        }
    }*/




        public void favItemsList() {


                for (int i = 0; i < 3; i++) {
                    WebElement item = GardenAccessoriesFavBtn.get(i);
                    plActions.clickOnElement(item);
                }
            }

            public void getFavGardenAccessoriesProductNames() throws InterruptedException {
            actualListOfProductsInFav=new ArrayList();

                int count=0;
                for (WebElement element : ListGardenAccessoriesProductNames) {
                    actualFavProductName=element.getText();
                    actualListOfProductsInFav.add(actualFavProductName);

                    Thread.sleep(5000);

                    count++;
                    if (count == 3) {
                        break;
                    }
                }
                Collections.sort(actualListOfProductsInFav);
                System.out.println(actualListOfProductsInFav);

            }
            public void getNumberOfProductsAddedInCart() throws InterruptedException {
            expectedListOfProductsInFav=new ArrayList<>();

                for (WebElement element:NumberOfProductsAddedInFav) {
                    expectedFavProductName=element.getText();
                    expectedListOfProductsInFav.add(expectedFavProductName);
                    Thread.sleep(5000);
                                    }
                Collections.sort(expectedListOfProductsInFav);
                System.out.println(expectedListOfProductsInFav);
        }

            public void logOutMethod(){
                plActions.clickOnElement(MyAccount);
                plActions.clickOnElement(Logout);

            }
        }
