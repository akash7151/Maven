package Com.orderdetails.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderDetails {
WebDriver driver;
public  OrderDetails(WebDriver driver) {
	this.driver=driver;
	}
@FindBy(how = How.XPATH,using = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")
WebElement d1;
@FindBy(how = How.XPATH,using = "/html/body/div[4]/div[1]/div[4]/div/div/div[1]/a[2]")
WebElement d2;
public void oDetails() {
	d1.click();
	d2.click();
}
}
