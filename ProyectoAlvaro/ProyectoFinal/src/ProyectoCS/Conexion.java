package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	//M�todo utilizado para recuperar el valor del atributo conexion
	public Connection getConexion() {
		return getConexion();
	}
	
	/* M�todo utilizado para establecer la conexi�n con la base de datos
	* @return estado regresa el estado de la conexi�n, true si se estableci� la conexi�n,
	* falso en caso contrario
	*/
	
	public boolean crearConexion() {
		try { Class.forName("com.mysql.cj.jdbc.Driver");
		 
        // Step 2: Establecer conexi�n
		String url = "jdbc:mysql://127.0.0.1:3306/paciente?serverTimezone=UTC";
        Connection conexion = DriverManager.getConnection(url, "root", "12121984");
		} catch (SQLException ex) {
		      ex.printStackTrace();
		      return false;
		   } catch (ClassNotFoundException ex) {
		      ex.printStackTrace();
		      return false;
		   }

		   return true;
		}

	/*
	*M�todo utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
	*@param sql Cadena que contiene la instrucci�n SQL a ejecutar
	*@return estado regresa el estado de la ejecuci�n, true(�xito) o false(error)
	*/
	public boolean ejecutarSQL(String sql)
	{
	   try {
	      Connection conexion = null;
		Statement sentencia = conexion.createStatement();
	      sentencia.executeUpdate(sql);
	   } catch (SQLException ex) {
	      ex.printStackTrace();
	   return false;
	   }

	   return true;
	}
	
	/*
	*M�todo utilizado para realizar la instrucci�n SELECT
	*@param sql Cadena que contiene la instrucci�n SQL a ejecutar
	*@return resultado regresa los registros generados por la consulta
	*
	*/
	
	
	public ResultSet ejecutarSQLSelect(String sql)
	{
	   ResultSet resultado;
	   try {
	      Connection conexion = null;
		Statement sentencia = conexion.createStatement();
	      resultado = sentencia.executeQuery(sql);
	   } catch (SQLException ex) {
	      ex.printStackTrace();
	      return null;
	   }

	   return resultado;
	}

}
