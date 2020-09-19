package JDBC;

import java.sql.*;
	

	public class conectionnuevaJDBC {
		

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			try {
				//Paso 1: Creo conexion
				Connection miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/logincs?serverTimezone=UTC","root","12121984");
				//Paso 1: Creo el statement
				Statement misentencia = miconexion.createStatement();
				//Paso 3: Ejecuto sentencia SQL
				ResultSet miresult = misentencia.executeQuery("select * from login");
				//Paso 4: leer ResultSet
				while(miresult.next()) {
					//saca por consola el codigo del articulo -->columna1 o atributo "CodigoA"
					System.out.println(miresult.getString(1) +" -> "+miresult.getString("usuario"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}
