/**
 * ��Ծ�� 
 * ������
 */
package com.stu.yangyuejuan;

public class Calculator {
	public int add(int a,int b)
	{
		return a+b;
	}
	public int sub(int a,int b)
	{
		return a-b;
	}
	public int div(int a,int b)
	{
		if(b==0)
		{
			throw new ArithmeticException("��������Ϊ0");
		}
		return a/b;
	}
}
