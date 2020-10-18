package com.billsearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.billsearch.bean.Payer;

public class PayerDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/payerdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "rootpasswordgiven";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static final String SELECT_PAYER_BY_NAME = "select * from payer_details where payer_name like '%?%'";

	public PayerDao() {
		
		
	}
	
	protected Connection getConnection()
	{
		Connection connection = null;
		try
		{
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return connection;
	}

	public List<Payer> selectPayer(String name)
	{
		List<Payer> payer = new ArrayList();
		
		try(
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_PAYER_BY_NAME);)
		 {
			ps.setString(1, name);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String payerName = rs.getString("payer_name");
				String payerAddress = rs.getString("payer_address");
				int dueDate = rs.getInt("dueDate");
				int accountNumber = rs.getInt("account_number");
				int amount = rs.getInt("amount");
				payer.add(new Payer(payerName,payerAddress,dueDate,accountNumber,amount));
			}
		 }
		catch(SQLException e)
		 {
			e.printStackTrace();
		 }
		return payer;
	}
	
}
