package Com.demodhop.cheakout.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheakOut {

	WebDriver driver;
	public CheakOut(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "//*[@id=\"termsofservice\"]")
	WebElement cheak;
	@FindBy(xpath = "//*[@id=\"checkout\"]")
	WebElement out;
	public void cheaking() {
		cheak.click();
		out.click();
	}

}
