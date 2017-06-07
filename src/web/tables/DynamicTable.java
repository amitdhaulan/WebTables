package web.tables;

import java.text.NumberFormat;
import java.text.ParseException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.POMClass;

public class DynamicTable {
	String cellValue = "";
	double tempMax = 0, maxPrice = 0;
	String company;
	POMClass pomClass;

	@BeforeClass
	public void startUp() {
		pomClass = new POMClass();
	}

	@AfterClass
	public void tearDown() {
		pomClass.closeBrowser();
	}

	@Test
	public void tableTest() throws ParseException {
		System.out.println("Row count: " + pomClass.getRowSize().size());
		System.out.println("Column count: " + pomClass.getColumnSize().size());
		getMaxPrice();
		System.out.println("Company " + getCompany() + " has maximum price, which is: " + getMaxPrice());
	}

	public double getMaxPrice() throws ParseException {
		for (int i = 0; i < pomClass.getCellData_ForPrice().size(); i++) {
			cellValue = pomClass.getCellData_ForPrice().get(i).getText();
			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(cellValue);
			cellValue = num.toString();
			tempMax = Double.parseDouble(cellValue);
			if (tempMax > maxPrice) {
				maxPrice = tempMax;
				company = pomClass.getCellData_ForCompany(i).getText();
			}
		}
		return maxPrice;
	}

	public String getCompany() {
		return company;
	}

}
