/**
 * Created by likuo on 2016/11/27
 */

package com.stu.likuo;
import org.testng.annotations.Test;
import com.webtest.dataprovider.NSDataProvicer;

public class shopping  extends base{
	@Test(dataProvider="s4",dataProviderClass=NSDataProvicer.class)
	public void foodComment(String fname) throws InterruptedException{
			login1();//��¼ǰ̨
			webtest.type("name=fname", fname);
			webtest.click("id=header_sub");
			webtest.click("link=+���ﳵ");
			webtest.click("link=���ﳵ");
			webtest.click("class=all");
			webtest.click("id=createForms");
			webtest.click("link=ȷ�϶���");
			webtest.click("link=��ɶ���");
			logout1();//�˳�
		}
	}


