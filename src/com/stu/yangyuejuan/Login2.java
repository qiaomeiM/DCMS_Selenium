/**
 * ��Ծ�� 
 * ǰ̨��¼�����������������ı�
 */
package com.stu.yangyuejuan;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class Login2 extends BaseTest{
	String url = "http://localhost:8032/MS/index.php/Index/index/";
	int i = 0;
	@Test(dataProvider="s1",dataProviderClass=NSDataProvicer.class)
	public void txt(String uname,String pwd) throws Exception {
		i++;
		webtest.open(url);
		webtest.click("link=��¼");
		Thread.sleep(3000);
		webtest.getWindow(i);
		webtest.type("name=username",uname);
		webtest.type("name=userpwd",pwd);
		webtest.click("xpath=.//*[@id='login_right']/form/table/tbody/tr[4]/td[2]/button");
		Thread.sleep(5000);
		String actual_Uname = webtest.getText("link=�˳�");
		String name = "�˳�";
		Assert.assertEquals(actual_Uname,name);
		webtest.click("link=�˳�");
	}
}
