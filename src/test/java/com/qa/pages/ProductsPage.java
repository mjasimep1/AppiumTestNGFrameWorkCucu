package com.qa.pages;

import com.qa.utils.GlobalParams;
import com.qa.utils.TestUtils;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends MenuPage {
	TestUtils utils = new TestUtils();
	
		@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
	//@iOSXCUITFindBy (xpath ="//XCUIElementTypeOther[@name=\"test-Toggle\"]/parent::*[1]/preceding-sibling::*[1]")
	private WebElement titleTxt;
		@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
		private WebElement filterBtn;
		@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
		private WebElement filterTitle;

		@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
		private WebElement addToCartBtn;
		@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView")
		private WebElement removeFromCartBtn;
		@AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
		private WebElement firstProductTitle;
		@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
		private WebElement cartBtn;

	//@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-PRODUCTS\"]/XCUIElementTypeScrollView")
	private WebElement iOSSCrollView;

	public String getTitle() {
		return getText(titleTxt, "product page title is - ");
	}

	public String getProductTitle(String title) throws Exception {
		//switch(new GlobalParams().getPlatformName()){
			//case "Android":
				return getText(andScrollToElementUsingUiScrollable("text", title), "product title is: " + title);
			//case "iOS":
			//	return getText(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '"+ title +"'"),
			//			"product title is: " + title);
			//default:
			//	throw new Exception("Invalid platform name");
		//}
	}

	public By defProductPrice(String title) throws Exception {
		//switch(new GlobalParams().getPlatformName()){
			//case "Android":
				return By.xpath("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
		//	case "iOS":
		//		return By.xpath("//XCUIElementTypeOther[@name=\"" + title + "\"]/following-sibling::*[1]/child::XCUIElementTypeStaticText[@name=\"test-Price\"]");
		//	default:
		//		throw new Exception("Invalid platform name");
		//}
	}

/*	public String getProductPrice(String title, String price) throws Exception {
		return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
	}*/

	public ProductDetailsPage pressProductTitle(String title) throws Exception {
		//switch(new GlobalParams().getPlatformName()){
		//	case "Android":
				click(andScrollToElementUsingUiScrollable("text", title), "press " + title + " link");
				return new ProductDetailsPage();
		//	case "iOS":
		//		click(iOSScrollToElementUsingMobileScrollParent(iOSSCrollView, "label == '"+ title +"'"), "press " + title + " link");
		//		return new ProductDetailsPage();
		//	default:
		//		throw new Exception("Invalid platform name");

	}

	public void pressFilterBtn(){
		click(filterBtn, "press filter button");
	}
	public String getFilterTitle(){
		 String filterTitl= getText(filterTitle, "filter title is - ");
		return filterTitl;
	}
	public String getProductTitleToCart(){
		String addedProduct=getAttribute(firstProductTitle,"text");

		return addedProduct;
	}
	public void addToCart(){
		click(addToCartBtn);
	}
	public String getAddToCartBtnTxt(){
		String btnTxt=getAttribute(cartBtn,"text");
		if(btnTxt=="ADD TO CART"){
			return btnTxt;
		}
		else
		{
			 btnTxt=getAttribute(removeFromCartBtn,"text");
			return btnTxt;
		}

	}
	public void clickCartBtn(){
		click(cartBtn);
	}
}
