package com.techstack.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.techstack.model.StudentModel;

@Component
public class StudentModelImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public StudentModel getStudentInfo(String name)
	{
		String sql = "select * from students where studentName = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{name}, new StudentMapper());
	}
	
	public List<StudentModel> getStudentList()
	{
		String sql = "select * from students";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static final class StudentMapper implements RowMapper<StudentModel>{

		@Override
		public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentModel student = new StudentModel(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4));
			return student;
		}
		
	}
	
}