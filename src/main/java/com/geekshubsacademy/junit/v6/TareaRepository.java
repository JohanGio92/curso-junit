package com.geekshubsacademy.junit.v6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TareaRepository {

	private Connection connection;

	public TareaRepository(Connection connection) {
		this.connection = connection;
	}

	public void save(Tarea tarea) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement("INSERT INTO tareas VALUES (?)");
			prepareStatement.setString(1, tarea.getNombre());
			prepareStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
