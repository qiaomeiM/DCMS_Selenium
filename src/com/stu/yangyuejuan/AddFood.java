/**
 * 杨跃娟 
 * 后台——添加美食——数据驱动——表格
 */
package com.stu.yangyuejuan;

import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class AddFood extends BaseTest{
	String url = "http://localhost:8032/MS/admin.php/Index/index";
	@BeforeClass
	public void startBrowser() throws InterruptedException {
		
		webtest.open(url);
		Thread.sleep(3000);
		webtest.type("id=username","admin");
		webtest.type("id=password","admin");

		webtest.click("xpath=.//*[@id='loginform']/p[3]/button");
		Thread.sleep(5000);
	}
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		webtest.click("xpath=html/body/div[1]/div[2]/div[1]/div/div[2]/a");
		Thread.sleep(3000);
		webtest.click("xpath=html/body/div[1]/div[2]/div[1]/div/div[2]/ul/li[3]/a");
		Thread.sleep(3000);
	}
	@Test(dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void add(String uname,String uprice,String uorderno,String uselection2,String upic,String udescribe) throws Exception {
		webtest.click("link=美食管理");
		webtest.click("link=添加");
		Thread.sleep(3000);
		webtest.type("class=input-xxlarge",uname);
		webtest.type("name=price",uprice);
		webtest.type("name=orderno",uorderno);
		webtest.getSelect("id=selection2").selectByVisibleText(uselection2);
		Thread.sleep(5000);
		webtest.type("name=pic",upic);
		webtest.type("name=describe",udescribe);
		webtest.click("xpath=html/body/div[1]/div[2]/div[4]/div/div/form/p[7]/button[1]");
		Thread.sleep(5000);
	}
}
