package com.pl.ObjectRepository;
import com.pl.Utilities.PLActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AllProductsPage {
    private WebDriver driver;
    PLActions plActions;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        plActions = new PLActions(driver);
    }
    @FindBy(xpath = "//a[@class='main_menu__link'][normalize-space()='Garden']")
    private WebElement Garden;

    @FindBy(xpath = "//a[normalize-space()='Seeds and Bulbs']")
    private WebElement SeedsBulbs;

    @FindBy(xpath = "//a[normalize-space()='Garden Tools and Accessories']")
    private WebElement GardenToolsAccessories;

    @FindBy(xpath = "//ol[@class='products list items product-items']//li[@data-product-id]")
    private List<WebElement> seedsListOfProducts;

    @FindBy(xpath = " //ol[@class='products list items product-items']//li[@data-product-id]")
    private List<WebElement> GardenToolsListOfProducts;



    public void allProductsMethod() {

        plActions.clickOnElement(Garden);

    }
    public void subItemCartMethod(){

        plActions.clickOnElement(SeedsBulbs);
    }
    public void subItemWishMethod(){
        plActions.clickOnElement(GardenToolsAccessories);
    }


    public int getNumberOfSeedsProducts() {
        System.out.println(plActions.getNumberOfElements(seedsListOfProducts));
        return plActions.getNumberOfElements(seedsListOfProducts);
    }

    public int getNumberOfGardenToolsProducts() {
        System.out.println(plActions.getNumberOfElements(GardenToolsListOfProducts));
        return plActions.getNumberOfElements(GardenToolsListOfProducts);
    }
/*
    public List<String> getAllProductTitles() {
        System.out.println(plActions.getListOfTitles(listOfProducts));
        return plActions.getListOfTitles(listOfProducts);
    }*/

    }




