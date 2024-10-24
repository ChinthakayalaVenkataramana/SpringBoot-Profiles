package com.vnk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.vnk.sbeans.Student;
@Repository("MysqlRepo")
@Profile({"test","dev"})
public class MysqlDaoImpementation implements StudentDAO {
	@Autowired
	private DataSource dataSource;
 public MysqlDaoImpementation() {
	System.out.println("Mysql");
}
	@Override
	public List<Student> viewtStudent()throws Exception {
		List<Student> list=null;
		try(Connection con=dataSource.getConnection();
			 PreparedStatement ps=con.prepareStatement("SELECT * FROM client")){
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<>();
			while(rs.next()) {
				Student s=new Student();
				s.setClientId(rs.getInt(1));
				s.setClientEmail(rs.getString(2));
				s.setClientMobileNo(rs.getLong(3));
				s.setClientName(rs.getString(4));
				list.add(s);
			}
			
		}catch(SQLException error) {
			error.printStackTrace();
		}
		
		return list;
	}

}
