package com.qa.stepdef;

import com.qa.pages.CartPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStepDef {
    @Then("selected product should be listed in the cart when click add to cart btn {string}")
    public void the_product_should_be_listed_in_the_cart(String string) {
        ProductsPage productsPage=new ProductsPage();
        CartPage cartPage=new CartPage();
        String title=productsPage.getProductTitleToCart();
        productsPage.addToCart();
        Assert.assertEquals(productsPage.getAddToCartBtnTxt(),"REMOVE");
        productsPage.clickCartBtn();
        Assert.assertEquals(title,cartPage.getProductTitleFromCart());
    }
}
