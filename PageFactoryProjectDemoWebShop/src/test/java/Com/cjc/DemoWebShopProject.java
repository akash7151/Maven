package Com.cjc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.confirmOrder.pages.ConfirmOrder;
import Com.demodhop.cheakout.pages.CheakOut;
import Com.demoweb.bilingaddress.pages.BilingAddress;
import Com.demowebshop.pages.LoginDWS;
import Com.orderdetails.pages.OrderDetails;
import Com.payementMethod.pages.PaymentMethod;
import Com.paymentInformation.pages.PaymentDetails;
import Com.shipingaddress.pages.ShipingAddress;

public class DemoWebShopProject {
	WebDriver driver;
	Properties pro=new Properties();
	static Logger log=Logger.getLogger(DemoWebShopProject.class.getName());
	@BeforeSuite
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\Office\\chromedriver_win32 (1)\\chromedriver.exe");
driver=new ChromeDriver();
Layout la=new SimpleLayout();
Appender ap=new ConsoleAppender(la);
log.addAppender(ap);
log.info("Browser open succesfully");
	} 
	@BeforeTest
	public void enterUrl() throws IOException {
		FileInputStream frc=new FileInputStream("D:\\Properies.txt");
		pro.load(frc);
			log.info(pro.getProperty("url"));
			driver.get(pro.getProperty("url"));
		//driver.get("http://demowebshop.tricentis.com/register");
		log.info("open url succfully");
	}
	@BeforeMethod
	public void maximizeScreen() {
		driver.manage().window().maximize();
		log.info("Maximize Screen succesfully");
	}
	@BeforeClass
	public void pageLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	log.info("Pageload timeout succesfully");
	}
	@Test(priority = 1)
	public void registerData() throws InterruptedException, IOException {
		FileInputStream f1=new FileInputStream("C:\\Users\\Akash\\Documents\\DWSProject.xlsx");
	XSSFWorkbook wb1=new XSSFWorkbook(f1);
	
	XSSFSheet sheet=wb1.getSheet("Sheet1");
	
	XSSFRow row=sheet.getRow(1);
	//FirstName
	XSSFCell cell=row.getCell(0);
	String firstname=cell.getStringCellValue();
	log.info(firstname);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"gender-male\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys(firstname);
	
	
	//LastName
	XSSFCell cell1=row.getCell(1);
	String lastname=cell1.getStringCellValue();
	log.info(lastname);
	driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys(lastname);
	
	//email
	XSSFCell cell2=row.getCell(2);
	String email=cell2.getStringCellValue();
	log.info(email);
	driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(email);
	
	//password
	XSSFCell cell3=row.getCell(3);
	String password=cell3.getStringCellValue();
	log.info(password);
	driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
	
	//ConfirmPassword
	XSSFCell cell4=row.getCell(4);
	String confirmpassword=cell4.getStringCellValue();
	log.info(confirmpassword);
	driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(confirmpassword);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
	log.info("Register data succesfully");
	}
	@Test(priority = 2)
	public void LoginData() throws InterruptedException {
		LoginDWS lp=PageFactory.initElements(driver, LoginDWS.class);
		lp.loginCheak();
		Thread.sleep(2000);
		log.info("login succesfully");
	
	
}
	@Test(priority = 3)
	public void AddToCard() throws InterruptedException {
		Thread.sleep(2000);
		
		Com.Demo.AddToCard.pages.AddToCard c1=PageFactory.initElements(driver, Com.Demo.AddToCard.pages.AddToCard.class);
		
		c1.addCard();
		log.info("AddTo Card Succesfully");
	}
	@Test(priority = 4)
	public void Cheakout() {
		CheakOut b1=PageFactory.initElements(driver, CheakOut.class);
		b1.cheaking();
	}
	@Test(priority = 5)
	public void bilingAddress() {
		WebElement w1=driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]"));
		Select s2=new Select(w1);
		s2.selectByValue("41");
		BilingAddress b1=PageFactory.initElements(driver, BilingAddress.class);
		b1.address();
		log.info("Biling Address succesfully");
	}
	@Test(priority = 6)
	public void shipingAddress() {
		ShipingAddress a1=PageFactory.initElements(driver, ShipingAddress.class);
		a1.shipAddress();
		log.info("Shiping Address succesfully");
	}
	@Test(priority = 7)
	public void paymentMethod() {
		PaymentMethod p1=PageFactory.initElements(driver, PaymentMethod.class);
		p1.paymentM();
		log.info("Paymenet method succesfully");
	}
	@Test(priority = 8)
	public void paymentInformation() {
		PaymentDetails p1=PageFactory.initElements(driver, PaymentDetails.class);
		p1.paymentInfo();
		log.info("Payment information succesfully added");
	}
	@Test(priority = 9)
	public void confirmOrder() {
		ConfirmOrder c1=PageFactory.initElements(driver, ConfirmOrder.class);
		c1.confirmO();
		log.info("Confirm Order succesfully");
	}
	@Test(priority = 10)
	public void orderDetails() {
		OrderDetails d1=PageFactory.initElements(driver, OrderDetails.class);
		d1.oDetails();
		log.info("OrderDetails succesfully added");
	}
	@AfterMethod
	public void captureScreenshot() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src,new File("C:\\Users\\Akash\\Desktop\\AutomationScreenshot")); 
		log.info("Capture Screenshot succesfully");
	}
	@AfterClass
	public void deleteCookies() {
		log.info("Cookies delete Succesfully");
	}
	@AfterTest
	public void closeDB() {
		log.info("Data base close succesfully");
	}
	@AfterSuite
	public void closeBrowser() {
		log.info("Browser close succesfully");
	driver.close();
	}
}