package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

/*
 * 적용될 메소드 정하는 것:포인트 컷 (where)
 * 시점을 정하는 것 :조인 포인트 (when) ->
 * Before, After-Returning(정상수행 됐을 경우), After_throwing(실패), 
 * After =>Around=>log
 * start
 * coding => MapReduce/Spark
 * end													
 * 포인트 컷 + 조인 포인트 :어드바이스
 */
@Component 
public class DBConnection {
	private Connection dbCon;
	public DBConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex){
			
		}
	}
	
	public void getConnection(){
		try{
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			dbCon=DriverManager.getConnection(url,"scott","tiger");
		}catch(Exception ex){
			
		}
	}
	
	public void disConnection(){
		try{
			if(dbCon!=null){
				dbCon.close();
			}
		}catch(Exception ex){
			
		}
	}
}
