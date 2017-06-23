package com.sist.dao;

import org.springframework.stereotype.Component;
/*
 * 	JAVA => 중복코딩
 * 				=====
 * 				1)메소드 
 * 				2)클래스 ===> OOP (우리가 직접 호출, 소스량이 많아진다는 단점) ==> 자동 호출 AOP
 * 									OOP+AOP => OOP  aop는 스프링에만 존재하는 기능
 * 									=== Spring => TX(트랜잭션), SX(보안)
 * 									공통사용기반
 * 									핵심기능
 * 				절차적 언어=>객체지향 => CBD
 */


@Component  //("id")를 따로 지정하지 않으면 default로 studentDAO로 설정됨.
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
