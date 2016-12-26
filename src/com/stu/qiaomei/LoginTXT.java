/**
 * author QiaoMei
 * function 登录_TXT
 */
package com.stu.qiaomei;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class LoginTXT extends BaseTest{
	@BeforeMethod
	public void openPage(){
		webtest.open("http://localhost:8032/MS/index.php/Index/index");
	}
	//利用TXT完成数据驱动，进行登录    (dataProvider="s1",dataProviderClass=NSDataProvicer.class)
	@Test(dataProvider="s1",dataProviderClass=NSDataProvicer.class,description="测试登录---TXT")
	public void login(String name,String pwd) throws InterruptedException{
		webtest.type("id=loginuser", name);
		webtest.type("id=loginpwd", pwd);
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		Thread.sleep(3000);
	}
	@AfterMethod
	public void signout(){
		webtest.click("link=退出");
	}
}
