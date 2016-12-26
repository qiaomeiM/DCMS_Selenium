
/**
 * author QiaoMei
 * function 添加美食评论
 */
package com.stu.qiaomei;

import org.testng.annotations.Test;
import com.webtest.dataprovider.NSDataProvicer;

public class Comment extends LoginPre{

	@Test(dataProvider="s3",dataProviderClass=NSDataProvicer.class,description="测试添加评论")
	public void addComment(String name,String pwd,String comment) throws Exception{
		openPage();
		signIn(name,pwd);
		webtest.click("xpath=//*[@id='margin_right_top']/form/table/tbody/tr[5]/td/input");
		webtest.click("xpath=//*[@id='nav_cen']/div[8]/a/img");
		Thread.sleep(2000);
		webtest.type("name=content", comment);
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='addEva']/input[2]");
		Thread.sleep(20000);
		check.verifyText("id=header_login", "退出");
		signOut();
		
	}

	
}
