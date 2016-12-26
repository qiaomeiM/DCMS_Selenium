/**
 * ��Ծ�� 
 * ������
 */
package com.stu.yangyuejuan;

import java.util.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JianTingQi extends TestListenerAdapter {
	  /** 
   * ����ָ�� ��#�ڼ����еĺ�����ÿ��Ԫ�صķָ|��Ҫ����map���͵ļ�������key��value�еķָ 
   */  
  private static final String SEP1 = "#";  
  private static final String SEP2 = "|";  

//		  private int m_count = 0;
//
//		  @Override
//		  public void onTestFailure(ITestResult tr) {
//		    log("F");
//		  }
//
//		  @Override
//		  public void onTestSkipped(ITestResult tr) {
//		    log("S");
//		  }
//
//		  @Override
//		  public void onTestSuccess(ITestResult tr) {
//		    log(".");
//		  }
//		  private void log(String string) {
//		    System.out.print(string);
//		    if (m_count++ % 40 == 0) {
//		      System.out.println("");
//		    }
	@Override
	public void onFinish(ITestContext testContext) {
		
		
		super.onFinish(testContext);
		List<ITestResult> failure = this.getFailedTests();
		List<ITestResult> success =this.getPassedTests();
		List<ITestResult> skip =this.getSkippedTests();
		try {
			Mail.sendMail("yyj15230839058@163.com","��Ծ���С�ɹ�",ListToString(success)+ListToString(failure)+ListToString(skip));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static String ListToString(List<ITestResult> list) {  
		 
	        StringBuffer sb = new StringBuffer();  
	        if (list != null && list.size() > 0) {  
	            for (int i = 0; i < list.size(); i++) {  
	                if (list.get(i) == null) {  
	                    continue;  
	                }  
	                // ���ֵ��list����������Լ�  
	                if (list.get(i) instanceof List) {  
	                    sb.append(ListToString((List<ITestResult>) list.get(i)));  
	                    sb.append(SEP1);  
	                } else {  
	                    sb.append(list.get(i));  
	                    sb.append(SEP1);  
	                }  
	            }  
	        }  
	        return sb.toString();  
	    }  
	 
}