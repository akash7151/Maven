package Com.confirmOrder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConfirmOrder {

	WebDriver driver;
	public ConfirmOrder(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how = How.XPATH,using = "//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement con;
	public void confirmO() {
		con.click();
	}

}
