package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

/*
 * ����� �޼ҵ� ���ϴ� ��:����Ʈ �� (where)
 * ������ ���ϴ� �� :���� ����Ʈ (when) ->
 * Before, After-Returning(������� ���� ���), After_throwing(����), 
 * After =>Around=>log
 * start
 * coding => MapReduce/Spark
 * end													
 * ����Ʈ �� + ���� ����Ʈ :�����̽�
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
