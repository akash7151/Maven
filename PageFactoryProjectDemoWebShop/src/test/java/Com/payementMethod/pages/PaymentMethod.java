package Com.payementMethod.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentMethod {

	WebDriver driver;
	public PaymentMethod(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "//*[@id=\"paymentmethod_1\"]")
	WebElement ch1;
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement con;
	public void paymentM() {
		ch1.click();
		con.click();
	}

}
