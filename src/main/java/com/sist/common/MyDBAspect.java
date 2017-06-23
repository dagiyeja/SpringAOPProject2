package com.sist.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.DBConnection;

@Aspect
@Component
/*
 *   <aop:before method="getConnection"
 *     pointcut=""/>
 *   <aop:after method="disConnection"
 *     pointcut=""/>
 *     
 *     try{
 *     	getConnection();
 *     	setAutoCommit(false);
 *     	insert();
 *     	insert();
 *     	insert();
 *     	commit();	==>Around
 *     }
 *     catch(Exception ex){
 *     	rollback(); ==>After-Throwing
 *     }
 *     finally{
 *     	setAutoCommit(true) ==>After
 *     	disConnection();
 *     }
 */
public class MyDBAspect {
   @Autowired
   private DBConnection dbCon;
   @Before("execution(* com.sist.dao.StudentDAO.std*(..))")
   public void getConnection()
   {
	   dbCon.getConnection();
	   System.out.println("Before Call...");
   }
   @After("execution(* com.sist.dao.StudentDAO.std*(..))")
   public void disConnection()
   {
	   dbCon.disConnection();
	   System.out.println("After Call...");
   }
   @AfterReturning(value="execution(* com.sist.dao.StudentDAO.std*(..))",
		   returning="ret")
   public void afterReturning(Object ret)
   {
	   System.out.println("Return°ª:"+ret);
	   System.out.println("AfterReturning Call...");
   }
   @AfterThrowing(value="execution(* com.sist.dao.StudentDAO.std*(..))",
		   throwing="ex")
   public void afterThrowing(Throwable ex)
   {
	   System.err.println(ex.getMessage());
	   System.out.println("AfterThrowing");
   }
   @Around("execution(* com.sist.dao.StudentDAO.std*(..))")
   public Object around(ProceedingJoinPoint p)
   throws Throwable
   {
	   Object obj=null;
	   long start=System.currentTimeMillis();
	   System.out.println("@Around Call");
	   Signature s=p.getSignature();
	   System.out.println("@Around:"+s.getName());
	   obj=p.proceed();
	   System.out.println("@Around End:" +obj.toString());
	   long end=System.currentTimeMillis();
	   System.out.println("Call:"+(end-start));
	   return null;
   }
   
}










