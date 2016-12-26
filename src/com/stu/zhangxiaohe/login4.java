package com.stu.zhangxiaohe;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class login4 extends BaseTest {
	@BeforeClass
	public void test1() throws InterruptedException{
		webtest.open("http://localhost:8032/MS/admin.php");
		Thread.sleep(1000);
		webtest.type("id=username","admin");
		webtest.type("id=password","admin");
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/p[3]/button");
		Thread.sleep(1000);
	}
	@Test(dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void test2(String num) throws InterruptedException{
		webtest.click("link=分类管理");
		webtest.click("link=二级分类 --- 列表");
		Thread.sleep(1000);
		webtest.type("xpath=/html/body/div[1]/div[2]/div[4]/div/div/div[2]/label/input",num);
		Thread.sleep(1000);
	}
	@Test
	public void test3() throws InterruptedException{
		webtest.selectByIndex("name=dyntable_length",1);
		Thread.sleep(1000);
		webtest.selectByIndex("name=dyntable_length",2);
		Thread.sleep(1000);
		webtest.selectByIndex("name=dyntable_length",3);
		Thread.sleep(1000);
	}
	@Test
	public void test4() throws InterruptedException{
		webtest.open("http://localhost:8032/MS/admin.php/Sclass/selSclass");
		webtest.click("xpath=/html/body/div[1]/div[2]/div[4]/div/div/table/tbody/tr[1]/td[6]/a/span");
		webtest.alertAccept();
		Thread.sleep(1000);
		
		
	}


}



