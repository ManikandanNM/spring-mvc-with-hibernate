package com.techstack.studentcontroller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentModelImpl {

	public StudentModel getStudentInfo(String name) {
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";

		try {

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yogidb", "root","");
			PreparedStatement ps = conn.prepareStatement("select * from students where studentName = ?");
			ps.setString(1, name);
			StudentModel student = null;

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				student = new StudentModel(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			}

			rs.close();
			ps.close();

			return student;

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}