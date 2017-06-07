package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POMClass {
	public static WebDriver driver;

	public POMClass() {
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://money.rediff.com/gainers/bsc/monthly/groupa?");
	}

	public void closeBrowser() {
		driver.close();
	}

	public List<WebElement> getRowSize() {
		return driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
	}

	public List<WebElement> getColumnSize() {
		return driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		// OR
		// return
		// driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
	}

	public List<WebElement> getCellData_ForPrice() {
		System.out.println(".");
		return driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr/td[4]"));
	}

	public WebElement getCellData_ForCompany(int i) {
		return driver.findElement(
				By.xpath("//*[@id='leftcontainer']/table/tbody/" + "tr[" + Integer.toString(i + 1) + "]/td[1]/a"));

	}

}
