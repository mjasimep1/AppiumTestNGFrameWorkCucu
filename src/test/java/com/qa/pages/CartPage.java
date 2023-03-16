package com.qa.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CartPage extends MenuPage {
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
    private WebElement productTitleCart;

    public String getProductTitleFromCart(){
        String addedProductTitle=getAttribute(productTitleCart,"text");
        return addedProductTitle;

    }

}
