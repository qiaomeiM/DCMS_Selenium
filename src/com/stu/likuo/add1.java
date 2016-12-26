/**
 * Created by likuo on 2016/11/23
 */

package com.stu.likuo;

import org.openqa.jetty.html.Select;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class add1 extends base {
	
	@Test(dataProvider="s6",dataProviderClass=NSDataProvicer.class)
	public void test2(String sname,String orderno) throws InterruptedException{
		login();
		webtest.click("link=分类管理");
		webtest.click("link=二级分类 --- 添加");
		webtest.type("name=sname", sname);
		webtest.type("name=orderno",orderno);
		webtest.selectByIndex("id=selection2", 2);
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/form/p[4]/button[1]");
		logout();
		
	
		
	}
	

}
