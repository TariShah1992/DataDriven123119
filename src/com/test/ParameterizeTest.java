package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\driver79\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		driver.findElement(By.id("user_login")).sendKeys("opensourcecms");
		driver.findElement(By.id("user_pass")).sendKeys("opensourcecms");
		driver.findElement(By.id("wp-submit")).click();
		
		
		Xls_Reader reader = new Xls_Reader("C:\\workspace\\dataDriven_firstProject\\src\\com\\data\\openSourcedata.xlsx");
		
		int rowCount =reader.getRowCount("info");
		
		for(int rowNum =2; rowNum<= rowCount;rowNum++ ){
			
			String username =reader.getCellData("info", "username", rowNum);
			System.out.println(username);
			String email =reader.getCellData("info", "email", rowNum);
			System.out.println(email);
			String firstname =reader.getCellData("info", "firstname", rowNum);
			System.out.println(firstname);
			String lastname =reader.getCellData("info", "lastname", rowNum);
			System.out.println(lastname);
			String website =reader.getCellData("info", "website", rowNum);
			System.out.println(website);
			
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'New')]"))).build().perform();
			driver.findElement(By.linkText("User")).click();
			driver.findElement(By.id("user_login")).sendKeys(username);
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("first_name")).sendKeys(firstname);
			driver.findElement(By.id("last_name")).sendKeys(lastname);
			driver.findElement(By.id("url")).sendKeys(website);
			driver.findElement(By.id("createusersub")).click();
			
		}
			
			
		
	

	}

}
