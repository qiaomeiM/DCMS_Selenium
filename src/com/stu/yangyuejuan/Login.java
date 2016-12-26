/**
 * 杨跃娟 
 * 无框架，前台登录
 */
package com.stu.yangyuejuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver = null;

	@BeforeClass
	public void startBrowser() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();// 浏览器最大化
	}

	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}

	@Test
	public void login() throws InterruptedException{
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
		driver.findElement(By.name("userpwd")).sendKeys("aomenfeng1");
		driver.findElement(By.xpath(".//*[@id='login_right']/form/table/tbody/tr[4]/td[2]/button")).click();
		
		Thread.sleep(10000);
	}
}
