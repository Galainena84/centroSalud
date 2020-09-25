package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class BDEmpleado {


	 static private String clave;
	    static private String usuario;
	    static private String correo;
	    
		public BDEmpleado(String usuario, String clave, String correo) {
			BDEmpleado.clave = clave;
			BDEmpleado.usuario = usuario;
			BDEmpleado.correo = correo;
		
		}

		 public String getClave() {
		        return clave;
		    }
		 
		    public void setClave(String clave) {
		        BDEmpleado.clave = clave;
		    }
		    public String getUsuario() {
		        return usuario;
		    }
		 
		    public void setUsuario(String usuario) {
		        BDEmpleado.usuario = usuario;
		    }
		    public String getCorreo() {
		        return correo;
		    }
		 
		    public void setCorreo(String correo) {
		        BDEmpleado.correo = correo;
		    }

		public String toString() {
			return usuario + "," + clave + "," + correo;
		}
			
		}

