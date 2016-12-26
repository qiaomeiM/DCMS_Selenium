/**
 * Created by likuo on 2016/12/24
 */

package com.stu.likuo;

import com.webtest.core.BaseTest;

public class base  extends BaseTest {

	public void login() throws InterruptedException{
		webtest.open("http://localhost:8032/MS/admin.php");
		Thread.sleep(3000);
		webtest.type("id=username", "admin");
		webtest.type("id=password", "admin");
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/p[3]/button");
		Thread.sleep(5000);
	}
	
	public void logout() throws InterruptedException{
		
		webtest.click("/html/body/div[1]/div[2]/div[1]/div/div[2]/a");
		Thread.sleep(3000);
		webtest.click("/html/body/div[1]/div[2]/div[3]");
	
	}
	public void login1() throws InterruptedException {
		webtest.open("http://localhost:8032/MS/");
		Thread.sleep(2000);
		webtest.type("id=loginuser","2631524571@qq.com");
		webtest.type("id=loginpwd","139329");
		webtest.click("xpath=/html/body/div[3]/div[2]/div[1]/form/table/tbody/tr[5]/td/input");
		Thread.sleep(2000);
	}
	
	public void logout1() throws InterruptedException{
		
		webtest.click("class=clearMsg");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='header_login']/span[4]/a");
	}
	
}
