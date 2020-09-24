package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import ProyectoCS.BDEmpleado;

public class Empleado {
    static private int clave;
    static private String usuario;
    static private String correo;
 

 
    public int getClave() {
        return clave;
    }
 
    public void setClave(int clave) {
        Empleado.clave = clave;
    }
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        Empleado.usuario = usuario;
    }
    public String getCorreo() {
        return correo;
    }
 
    public void setCorreo(String correo) {
    	Empleado.correo = correo;
    }
    
    public String toString() {
		return usuario + "," + clave + " " + correo ;
	}

    
    public static void main(String[] args) {
		ArrayList personlist = new ArrayList();

		 try {
	            // Step 1: Cargar driver jdbc. jdbc:mysql://localhost:3306/travel
	            Class.forName("com.mysql.jdbc.Driver");
	 
	            // Step 2: Establecer conexi�n
	            String url = "jdbc:mysql://127.0.0.1:3306/paciente?serverTimezone=UTC";
	            Connection conn = DriverManager.getConnection(url, "root", "12121984");
	            Statement st = conn.createStatement();
	            ResultSet srs = st.executeQuery("SELECT * FROM login");
	            while (srs.next()) {
	            	BDEmpleado person = new BDEmpleado(usuario,clave,correo);
	            	person.setUsuario(srs.getString(1));
	            	person.setClave(srs.getInt(2));
	                person.setCorreo(srs.getString(3));
	               
	         
	                personlist.add(person);
	            }


	 for(i = 0; i < personlist.length ; i++) {
		 System.out.println(personlist.size());
		 System.out.println(((BDEmpleado) personlist.get(i)).getUsuario());
		 System.out.println(((BDEmpleado) personlist.get(i)).getClave());
		 System.out.println(((BDEmpleado) personlist.get(i)).getCorreo());
	 }
	       
	 
	        //System.out.println(namelist.);
	        } catch (Exception e) {
	            System.err.println("Got an exception! "); //Encontr� una excepci�n e imprime
	            System.err.println(e.getMessage());
	        }
	    }
		}
