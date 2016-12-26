/**
 * 杨跃娟 
 * 一个用户登录，每个用户添加一条美食评论
 */
package com.stu.yangyuejuan;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class Comment extends BaseTest{
	String url = "http://localhost:8032/MS/index.php/Index/index/";
	@BeforeClass
	public void startBrowser() throws InterruptedException {
		webtest.open(url);
		webtest.click("link=登录");
		Thread.sleep(3000);
		webtest.getWindow(1);
		webtest.type("name=username","1845875521@qq.com");
		webtest.type("name=userpwd","aomenfeng");
		webtest.click("xpath=.//*[@id='login_right']/form/table/tbody/tr[4]/td[2]/button");
		Thread.sleep(5000);
	}

	@AfterClass
	public void quitBrowser() throws InterruptedException {
		webtest.click("link=退出");
		Thread.sleep(3000);
	}
	@Test()
	public void order() throws Exception {
		webtest.click("xpath=.//*[@id='nav_cen']/div[1]/a/img");
		Thread.sleep(3000);
		for(int i=0;i<5;i++)
		{
		webtest.type("name=content","It's very delicious"+i);
		webtest.click("xpath=.//*[@id='addEva']/input[2]");
		Thread.sleep(60000);
		}
	}
}

