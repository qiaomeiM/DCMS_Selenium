/**
 * 杨跃娟 
 * 多个用户登录，每个用户添加多条美食评论
 */
package com.stu.yangyuejuan;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvicer;

public class Comment2 extends BaseTest{
	String url = "http://localhost:8032/MS/index.php/Index/index/";
	int i = 0;
	@Test(dataProvider="s3",dataProviderClass=NSDataProvicer.class)
	public void excel(String uname,String pwd,String un,String pw)throws Exception {
		i++;
		webtest.open(url);
		webtest.click("link=登录");
		Thread.sleep(3000);
		webtest.getWindow(i);
		webtest.type("name=username",uname);
		webtest.type("name=userpwd",pwd);
		webtest.click("xpath=.//*[@id='login_right']/form/table/tbody/tr[4]/td[2]/button");
		webtest.click("xpath=.//*[@id='nav_cen']/div[9]/a/img");
		Thread.sleep(5000);
		for(int i=0;i<5;i++)
		{
		webtest.type("name=content","It's very delicious"+i);
		webtest.click("xpath=.//*[@id='addEva']/input[2]");
		Thread.sleep(60000);
		}
		webtest.click("link=退出");
		Thread.sleep(1000);
	}
}
