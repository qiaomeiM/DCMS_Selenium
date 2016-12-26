package com.stu.zhangxiaohe;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class login5 extends BaseTest {
	@BeforeClass
	public void test1() throws InterruptedException{
		webtest.open("http://localhost:8032/MS/admin.php");
		Thread.sleep(1000);
		webtest.type("id=username","admin");
		webtest.type("id=password","admin");
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/p[3]/button");
		Thread.sleep(1000);
	}
	@Test(dataProvider="s5",dataProviderClass=NSDataProvicer.class)
	public void test2(String name,String num) throws InterruptedException{	
		webtest.click("xpath=/html/body/div[1]/div[1]/div[4]/ul/li[5]/a");
		webtest.click("link=二级分类 --- 添加");
		Thread.sleep(1000);
		webtest.type("name=sname", name);
		webtest.type("name=orderno", num);
		webtest.selectByIndex("name=pid",2);
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/form/p[4]/button[1]");
		Thread.sleep(1000);
	}
	
}
