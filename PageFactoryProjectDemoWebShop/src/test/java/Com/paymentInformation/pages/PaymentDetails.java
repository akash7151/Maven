package Com.paymentInformation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentDetails {

	WebDriver driver;
	public PaymentDetails(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how = How.XPATH,using = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement p1;
	public void paymentInfo() {
		p1.click();
	}
}
