package com.liya.dcms;
/**
 * 作者：李娅
 * 时间：2016年12月15日
 * 功能：监听器的调试测试用例
 **/

import static  org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.dataprovider.NSDataProvicer;

public class Demo {
	@Test(dataProvider="order",dataProviderClass=NSDataProvicer.class,description="one")
	public void test1(String name){
		assertEquals(name, "aaaa");
	}
	
//	@Test
//	public void test2(){
//		assertTrue(true);
//	}
}
