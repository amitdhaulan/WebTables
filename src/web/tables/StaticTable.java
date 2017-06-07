package web.tables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StaticTable {

	public static void main(String args[]) {
		List<WebElement> table_row, table_column = null;
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver",
				"D:\\amit\\testing_git\\soft\\selenium_accessories\\geckodriver-v0.16.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/selenium/table/");
		WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
		table_row = mytable.findElements(By.tagName("tr"));
		int size = table_row.size();
		for (int i = 0; i < size; i++) {
			table_column = table_row.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < table_column.size(); j++) {
				String data = table_column.get(j).getText();
				System.out.print("(" + i + j + ")" + "=>" + data + "\t");
			}
			System.out.println("\n");
		}

	}
}