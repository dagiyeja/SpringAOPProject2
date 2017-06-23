package com.sist.dao;

import org.springframework.stereotype.Component;
/*
 * 	JAVA => �ߺ��ڵ�
 * 				=====
 * 				1)�޼ҵ� 
 * 				2)Ŭ���� ===> OOP (�츮�� ���� ȣ��, �ҽ����� �������ٴ� ����) ==> �ڵ� ȣ�� AOP
 * 									OOP+AOP => OOP  aop�� ���������� �����ϴ� ���
 * 									=== Spring => TX(Ʈ�����), SX(����)
 * 									��������
 * 									�ٽɱ��
 * 				������ ���=>��ü���� => CBD
 */


@Component  //("id")�� ���� �������� ������ default�� studentDAO�� ������.
public class StudentDAO {
	public String  stdInsert(){ 
		//Before
		System.out.println("stdInsert() call...");
		//finally ==>After
		return "stdInsert";
	}
	
	public int  stdUpdate(){
		int a=0;
		try{
			a=10/0;
			System.out.println("stdUpdate() call..");
		
		}catch(Exception e){
		}
		return a;
	}
	
	public void  stdDelete(){
		//Around
		System.out.println("stdDelete");
		//Around
	}
	
	public String toString(){
		return "";
	}
	
}
