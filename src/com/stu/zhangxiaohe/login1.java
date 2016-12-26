package com.stu.zhangxiaohe;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.Test;

	public class login1 {
		
	WebDriver driver = null;

	@Test
	public void testCreate() throws InterruptedException{
		driver = new FirefoxDriver();
		driver.get("http://localhost:8032/MS/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/span[2]/a")).click();
		Thread.sleep(2000);
		driver.get("http://localhost:8032/MS/index.php/Login/reg/");
		driver.findElement(By.name("email")).sendKeys("129952770@qq.com");
		Thread.sleep(2000);
		driver.findElement(By.name("userpwd")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.name("ruserpwd")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("hengc");
		Thread.sleep(2000);
		driver.findElement(By.name("verify")).sendKeys("");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/form/table/tbody/tr[6]/td[2]/button")).click();
		Thread.sleep(2000);

		

	}
	  

	}


