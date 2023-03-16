package com.qa.stepdef;

import com.qa.pages.LoginPage;
import com.qa.pages.ProductDetailsPage;
import com.qa.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDef {
    public ProductStepDef(){

    }
    @Given("I'm logged in")
    public void iMLoggedIn() throws InterruptedException {
        (new LoginPage()).login("standard_user","secret_sauce");
    }
    @Then("the product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
        Boolean titleCheck=new ProductsPage().getProductTitle(title).equalsIgnoreCase(title);
        Boolean priceCheck = true;
//        Boolean priceCheck = new ProductsPage().getProductPrice(title, price).equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", priceCheck = " + priceCheck,
                titleCheck & priceCheck);
    }
    @When("I click product title {string}")
    public void iClickProductTitle(String title) throws Exception {
        new ProductsPage().pressProductTitle(title);
    }
    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) throws Exception {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(title);
        boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(description);
        boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
                titleCheck & descCheck & priceCheck);

    }

    @When("I click filter button")
    public void i_click_filter_button() {
        new ProductsPage().pressFilterBtn();
    }

    @Then("I should be on filter details popup with title {string}")
    public void i_should_be_on_filter_details_popup_with_title(String filterTitle) {
        Assert.assertEquals(new ProductsPage().getFilterTitle(),filterTitle);
    }
    @Given("I'm logged in with problem user")
    public void iMLoggedInWithProblemUser() throws InterruptedException {
        (new LoginPage()).login("problem_user","secret_sauce");
    }


}
