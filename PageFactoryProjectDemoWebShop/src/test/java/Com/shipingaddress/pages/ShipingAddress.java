package Com.shipingaddress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShipingAddress {

	WebDriver driver;
	public ShipingAddress(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "//*[@id=\"PickUpInStore\"]")
	WebElement store;
	@FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
	WebElement con;
public void shipAddress() {
	store.click();
	con.click();
}
}
