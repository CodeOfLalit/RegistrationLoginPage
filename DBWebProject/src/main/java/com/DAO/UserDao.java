package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.StatementEvent;

import com.entities.User;

public class UserDao {
   private Connection connection;

public UserDao(Connection connection) {
	super();
	this.connection = connection;
}

public boolean userRegister(User user) {
	boolean f=false;
	String query="insert into employee(name,email,password) values(?,?,?)";
	try {
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		int line=statement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return f;
}
public User getLogin(String email,String pass) {
	User us=null;
	try {
		String query="select * from employee where email=? and password=?";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1, email);
		statement.setString(2, pass);
		ResultSet rs=statement.executeQuery();
		if(rs.next()) {
			us=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return us;
}
   
}
