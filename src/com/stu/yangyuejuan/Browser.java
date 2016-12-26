/**
 * 杨跃娟 
 * 多浏览器——登录——yangyuejuan_Browser.xml
 */
package com.stu.yangyuejuan;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Browser {

	public WebDriver driver = null;

	@Parameters("browser")
	@BeforeClass
	public void startBrowser(String bs) {
		if (bs.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (bs.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"E:\\IEDriverServer.exe");
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(
		InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(dc);
//			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver",
					"E:\\chromedriver.exe");
			driver = new ChromeDriver();
		}

	}

	@Test
	public void browserTest() throws InterruptedException {

		driver.get("http://localhost:8032/MS/index.php/Index/index/");
		driver.findElement(By.linkText("登录")).click();
		Thread.sleep(3000);
		//跳转到新打开的页面
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			System.out.println(handle);
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.name("username")).sendKeys("1845875521@qq.com");
		driver.findElement(By.name("userpwd")).sendKeys("aomenfeng");
		driver.findElement(By.xpath(".//*[@id='login_right']/form/table/tbody/tr[4]/td[2]/button")).click();
		
		Thread.sleep(10000);

	}
	@AfterClass
	public void quitBrowser(){
		this.driver.quit();
	}


}
