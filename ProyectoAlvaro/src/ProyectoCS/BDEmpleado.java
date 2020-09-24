package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class BDEmpleado {


	 static private int clave;
	    static private String usuario;
	    static private String correo;
	    
		public BDEmpleado(String usuario, int clave, String correo) {
			BDEmpleado.clave = clave;
			BDEmpleado.usuario = usuario;
			BDEmpleado.correo = correo;
		
		}

		 public int getClave() {
		        return clave;
		    }
		 
		    public void setClave(int clave) {
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

		public static void main(String[] args) {
			ArrayList<BDEmpleado> personlist = new ArrayList<BDEmpleado>();

			 try {
		            // Step 1: Cargar driver jdbc. jdbc:mysql://localhost:3306/travel
		            Class.forName("com.mysql.cj.jdbc.Driver");
		 
		            // Step 2: Establecer conexión
		            String url = "jdbc:mysql://127.0.0.1:3306/paciente?serverTimezone=UTC";
		            Connection conn = DriverManager.getConnection(url, "root", "12121984");
		            Statement st = conn.createStatement();
		            ResultSet srs = st.executeQuery("SELECT * FROM cliente");
		            while (srs.next()) {
		            	BDEmpleado empleado = new BDEmpleado(usuario, clave, correo);
		            	empleado.setUsuario(srs.getString(1));
		            	empleado.setClave(srs.getInt(2));
		                empleado.setCorreo(srs.getString(3));
		              
		         
		                personlist.add(empleado);
		            }
		 
		          
		            System.out.println(((BDEmpleado) personlist.get(1)).getUsuario());
		            System.out.println(((BDEmpleado) personlist.get(2)).getClave());
		            System.out.println(((BDEmpleado) personlist.get(3)).getCorreo());
		            
		 
		        //System.out.println(namelist.);
		        } catch (Exception e) {
		            System.err.println("Got an exception! "); //Encontré una excepción e imprime
		            System.err.println(e.getMessage());
		        }
		    }
			
		}

