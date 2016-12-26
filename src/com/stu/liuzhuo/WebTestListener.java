package com.stu.liuzhuo;
/**
 * 
 * @author LiuZhuo
 * 
 * */
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class WebTestListener extends TestListenerAdapter {
	FreemarkerTemplateEngine ft = new FreemarkerTemplateEngine();

	public WebTestListener() {
			super();
	}
	    
	  /** 
	   * 获取方法参数，以逗号分隔 
	   * @param result 
	   * @return 
	   */  
	  public String getParams(ITestResult result){  
	      Object[] params = result.getParameters();  
	      List<String> list = new ArrayList<String>(params.length);  
	      for (Object o:params){  
	          list.add(renderArgument(o));  
	      }         
	      return  commaSeparate(list);          
	  }  
	  
	  /*将object 转换为String*/  
	  private String renderArgument(Object argument)  
	  {  
	      if (argument == null)  
	      {  
	          return "null";  
	      }  
	      else if (argument instanceof String)  
	      {  
	          return "\"" + argument + "\"";  
	      }  
	      else if (argument instanceof Character)  
	      {  
	          return "\'" + argument + "\'";  
	      }  
	      else  
	      {  
	          return argument.toString();  
	      }  
	  }  
	  
	  /*将集合转换为以逗号分隔的字符串*/  
	  private String commaSeparate(Collection<String> strings)  
	  {  
	      StringBuilder buffer = new StringBuilder();  
	      Iterator<String> iterator = strings.iterator();  
	      while (iterator.hasNext())  
	      {  
	          String string = iterator.next();  
	          buffer.append(string);  
	          if (iterator.hasNext())  
	          {  
	              buffer.append(", ");  
	          }  
	      }  
	      return buffer.toString();  
	  }  

		private String writeResultToMailTemplate() {
			ITestNGMethod method[] = this.getAllTestMethods();
			List failedList = this.getFailedTests();
			List passedList = this.getPassedTests();
			List failedList1 = new ArrayList();
			List passedList1 = new ArrayList();
			for (int j = 0; j < failedList.size(); j++) {
				ITestResult tr = (ITestResult) failedList.get(j);
				for (int i = 0; i < method.length; i++) {
					if (tr.getMethod().getMethodName()
							.equals(method[i].getMethodName())) {
						if (method[i].getDescription() != null) {
							tr.setAttribute("name", this.getParams(tr)+method[i].getDescription());
						} else {
							tr.setAttribute("name", "");
						}
						break;
					}
				}
				failedList1.add(tr);
			}
			for (int j = 0; j < passedList.size(); j++) {
				ITestResult tr = (ITestResult) passedList.get(j);
				for (int i = 0; i < method.length; i++) {
					if (tr.getMethod().getMethodName()
							.equals(method[i].getMethodName())) {
						if (method[i].getDescription() != null) {
							tr.setAttribute("name", this.getParams(tr)+method[i].getDescription());
						} else {
							tr.setAttribute("name", "");
						}
						break;
					}
				}
				passedList1.add(tr);
			}
			Map context = new HashMap();
			context.put("date", new Date());
			context.put("failedList", failedList);
			context.put("passedList", passedList1);
			context.put("casesize", passedList.size() + failedList.size());
			context.put("failcasesize", failedList.size());
			try {
				String content = ft.run(context);
				return content;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public void onFinish(ITestContext testContext) {
			// TODO Auto-generated method stub
			super.onFinish(testContext);
			// 本地调试
			if (System.getProperty("os.name").contains("dow")) {
				// return;
			}

			String emailContent = this.writeResultToMailTemplate();
			String emailTitle = "我就是一个测试报告" + "----" + this.getTime();
			String toMail = "3549597737@qq.com,1575129358@qq.com";


			try {
				JavaMail3.createMimeMessage(toMail, emailTitle, emailContent);
				System.out.println("success");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}

		public String getTime() {
			java.util.Calendar c = java.util.Calendar.getInstance();
			java.text.SimpleDateFormat f = new java.text.SimpleDateFormat(
					"yyyy-MM-dd  hh:mm:ss");
			return f.format(c.getTime());
		}

}

