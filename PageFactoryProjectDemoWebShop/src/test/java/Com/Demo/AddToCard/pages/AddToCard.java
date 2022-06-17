package Com.Demo.AddToCard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCard {

	WebDriver driver;
	public AddToCard(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a")
	WebElement con;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
	WebElement card;
	@FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[1]")
	WebElement shop;
	public void addCard() {
		con.click();
		card.click();
		shop.click();
	}
}
