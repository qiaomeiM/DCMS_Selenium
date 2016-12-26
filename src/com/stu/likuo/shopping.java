/**
 * Created by likuo on 2016/11/27
 */

package com.stu.likuo;
import org.testng.annotations.Test;
import com.webtest.dataprovider.NSDataProvicer;

public class shopping  extends base{
	@Test(dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void foodComment(String fname) throws InterruptedException{
			login1();//登录前台
			webtest.type("name=fname", fname);
			webtest.click("id=header_sub");
			webtest.click("link=+购物车");
			webtest.click("link=购物车");
			webtest.click("class=all");
			webtest.click("id=createForms");
			webtest.click("link=确认订单");
			webtest.click("link=完成订单");
			logout1();//退出
		}
	}


