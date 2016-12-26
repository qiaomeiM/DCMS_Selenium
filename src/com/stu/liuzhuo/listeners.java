package com.stu.liuzhuo;
/**
 * 
 * @author LiuZhuo
 * 
 * */
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class listeners extends TestListenerAdapter{
	/**
	 * ����ָ�� ��#�ڼ����еĺ�����ÿ��Ԫ�صķָ|��Ҫ����map���͵ļ�������key��value�еķָ 
	 * */
	private static final String SEP1 = "#";
	private static final String SEP2 = "|";
	@Override
	public void onFinish(ITestContext testContext){
		super.onFinish(testContext);
		List<ITestResult> failure = this.getFailedTests();
		List<ITestResult> success = this.getPassedTests();
		List<ITestResult> skip = this.getSkippedTests();
		
		try {
			sendEmail.sendMail("15232179903@163.com", "ceshi", ListToString(success)+ListToString(failure));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String ListToString(List<ITestResult> list){
		StringBuffer sb = new StringBuffer();
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size();i++){
				if(list.get(i) == null){
					continue;
				}
				//���ֵ��list���ͣ�������Լ�
				if(list.get(i) instanceof List){
					sb.append(ListToString((List<ITestResult>) list.get(i)));
					sb.append(SEP1);
				}else{
					sb.append(list.get(i));
					sb.append(SEP1);
				}
				
			}
		}
		return sb.toString();
		
	}
	
}
