package Com.demoweb.bilingaddress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BilingAddress {

	WebDriver driver;
	public BilingAddress(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Company\"]")
	WebElement company;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_City\"]")
	WebElement city;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Address1\"]")
	WebElement address1;
	@FindBy(xpath = "//*[@id=\"BillingNewAddress_Address2\"]")
	WebElement address2;
@FindBy(xpath = "//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
WebElement code;
@FindBy(xpath = "//*[@id=\"BillingNewAddress_PhoneNumber\"]")
WebElement phone;
@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
WebElement con1;
public void address() {
	company.sendKeys("Dell");
	city.sendKeys("Aurangabad");
	address1.sendKeys("New Chowak");
	address2.sendKeys("ABC Complex");
	code.sendKeys("00000");
	phone.sendKeys("9876543210");
	con1.click();
}

}
