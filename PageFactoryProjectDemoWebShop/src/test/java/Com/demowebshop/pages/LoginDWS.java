package Com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginDWS {

	WebDriver driver;
	public LoginDWS(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement email;
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement password;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	WebElement login;
public void loginCheak() {
	email.sendKeys("ajaykakade22@gmail.com");
	password.sendKeys("dell@123");
	login.click();
}
}
