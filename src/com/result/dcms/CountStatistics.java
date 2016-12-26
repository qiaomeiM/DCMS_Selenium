package com.result.dcms;
/**
 * ���ߣ����
 * ʱ�䣺2016��12��13��
 * ���ܣ�������
 **/
import java.util.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CountStatistics extends TestListenerAdapter {
	@Override
	public void onFinish(ITestContext testContext) {
		
		super.onFinish(testContext);
		List<ITestResult> failure = this.getFailedTests();
		List<ITestResult> success =this.getPassedTests();
		List<ITestResult> skip =this.getSkippedTests();
		System.out.println(printResult(success));
		System.out.println(printResult(failure));
		try {
			SendEmail.sendMail("15231181069@163.com", "�����ʼ�", printResult(success)+printResult(failure));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String  printResult(List<ITestResult> result1){
		StringBuffer sb = new StringBuffer();  
		for( ITestResult r : result1){
			sb.append(this.getParams(r)+"\n");
		}
		return sb.toString();
	}
	public String  getParams(ITestResult result){  
	      Object[] params = result.getParameters();  
	      StringBuffer sb = new StringBuffer();  
	      
	      for (Object o:params){  
	          sb.append(o.toString()+" ");
	      }
	      if(result.getStatus()==1){
	    	  return  result.getMethod().getMethodName()+"("+sb.toString()+")"+"Pass";   
	      }
	      else{
	    	  return  result.getMethod().getMethodName()+"("+sb.toString()+")"+"Fail";  
	      }
	  }  
}