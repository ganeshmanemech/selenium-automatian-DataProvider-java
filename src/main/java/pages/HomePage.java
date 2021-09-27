package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.WebDriverFactory;

public class HomePage {
	@FindBy(id="welcome")
	WebElement welcome;

	@FindBy(id="menu_admin_viewAdminModule") 
	WebElement admin;
	
	private WebDriverWait wait;
//		or
	//private WebDriverWait wait=new WebDriverWait(DriveFactory.localchrome.get(), 20);
		
 public HomePage() {
		PageFactory.initElements(WebDriverFactory.localchrome.get(), this);
		wait=new WebDriverWait(WebDriverFactory.localchrome.get(), 20);
	}
	
	public HomePage display() {
		Assert.assertEquals(welcome.isDisplayed(), true, "welcome not display");

		return this.ispageLoded();
	}
	
	public AdminPage adminguid() {
		admin.click();
		return new AdminPage();
	}
	
	public HomePage ispageLoded() {
		wait.until(ExpectedConditions.visibilityOf(admin));
		return this;
	}

}
