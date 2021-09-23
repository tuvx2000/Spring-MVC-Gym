package com.xuantujava.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.xuantujava.dao.IGenericDAO;
import com.xuantujava.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {

	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/xuantudbspringmvc?";
			String user = "root";
			String password = "xuantudb";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

	}

	@Override
	public <T> List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<>();
			 
		Connection connection = null ;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			// set parameter
			setParameter(statement,parameters);
			
			//get resultset
			resultset = statement.executeQuery();
			while(resultset.next())
			{
				results.add(rowMapper.mapRow(resultset)); 
			}
			return results;
		}catch (SQLException e) {
			return null;
		}finally {
			try {
				connection.close();
				statement.close();
				resultset.close();
			} catch (SQLException e) {
				return null;
			}
		}
		
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if ( parameter instanceof Timestamp ) {
					statement.setTimestamp(index,(Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
				
		try{
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			
			connection.commit();
		}catch (Exception e2) {
			if( connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
		}finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		Long id = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			
			return id;
		} catch (SQLException e) {
			if( connection != null)
				try {
					connection.rollback();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			return null;
		}finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
