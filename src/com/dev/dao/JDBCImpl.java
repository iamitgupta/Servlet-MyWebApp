package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.dev.beans.User;
public class JDBCImpl implements UserDAO {

	public JDBCImpl(){
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//db query
	String url="jdbc:mysql://127.0.0.1:3306/cleaveridiots_db?user=root&password=root";


	@Override
	public Boolean createProfile(User user) {
		//Insert into db if user doesn't exist
		String query="INSERT INTO users_info VALUES (?,?,?,?)";
		User tempuser=searchUser(user.getUserId());
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				){
			if(tempuser!=null){
				return false;
			}else{
				pstmt.setInt(1, user.getUserId());
				pstmt.setString(2, user.getFirstName());
				pstmt.setString(3, user.getLastName());
				pstmt.setString(4, user.getPassword());
				pstmt.executeUpdate();
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User searchUser(Integer userId) {
		//return user detail
		String query="SELECT  * FROM users_info where uid="+userId;

		try(Connection conn=DriverManager.getConnection(url);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){

			User user= new User();
			if(rs.next()){
				user.setUserId(rs.getInt("uid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setPassword(rs.getString("password"));

				return user;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
		//update user if already exists in db
		String query="UPDATE users_info SET password=? WHERE uid="+userId;
		User user=searchUser(userId);
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				){
			if(user.getPassword().equals(oldPassword)) {
				pstmt.setString(1, newPassword);
				pstmt.executeUpdate();

				return true;
			}
			else {
				return false;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		//delete user if already exists 
		String query="DELETE FROM users_info WHERE uid="+userId;
		User user=searchUser(userId);
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				){
			if(user.getPassword().equals(password)) {
				pstmt.executeUpdate();
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User loginUser(Integer userId, String passwd) {
		//return user detail
				String query="SELECT * FROM users_info where uid="+userId+" and password="+passwd;

				try(Connection conn=DriverManager.getConnection(url);
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(query)){

					User user= new User();
					
					if(rs.next()){
						user.setUserId(rs.getInt("uid"));
						user.setFirstName(rs.getString("firstname"));
						user.setLastName(rs.getString("lastname"));
						user.setPassword(rs.getString("password"));
						return user;
						
					}

				}catch(Exception e) {
					e.printStackTrace();
				}
				return null;
	}
}


