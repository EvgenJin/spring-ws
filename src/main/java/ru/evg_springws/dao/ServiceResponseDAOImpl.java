/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.evg_springws.dao;

/**
 *
 * @author admin
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.example.helloservice.ServiceResponse;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ServiceResponseDAOImpl implements ServiceResponseDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	public int insertEmployee(ServiceResponse employee) {
//		
//		String insert_employee = "INSERT INTO employee(employee_id,name,age)VALUES(?,?,?);";
//		int count = jdbcTemplate.update( insert_employee,
//				new Object[] { employee.getEmployeeId(), employee.getName(),employee.getAge() });
//		return count;
//	}

	public ServiceResponse getServiceResponse() {
		ServiceResponse emp;
		try {
			emp = jdbcTemplate.queryForObject(
					"select * from models where id =3",
					new RowMapper<ServiceResponse>() {
						public ServiceResponse mapRow(ResultSet rs, int rownumber)
								throws SQLException {
							ServiceResponse e = new ServiceResponse();
							e.setGreeting(rs.getString("name"));
							return e;
						}
					});
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return emp;
	}

//	public int updateEmployee(long employeeId, String newName) {
//		String update_employee = "UPDATE employee set name =? where employee_id = ?;";
//		int count = jdbcTemplate.update( update_employee,
//						new Object[] { newName, employeeId });
//		return count;
//	}

//	public int deleteEmployee(long employeeId) {
//		String delete_employee = "DELETE from employee where employee_id = ?;";
//		int count = jdbcTemplate.update( delete_employee,
//						new Object[] { employeeId });
//		return count;
//	}
	
}