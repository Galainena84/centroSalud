package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import ProyectoCS.BDEmpleado;

public class Empleado {
    static private String clave = "";
    static private String usuario = "";
    static private String correo = "";
 

 
    public String getClave() {
        return clave;
    }
 
    public void setClave(String clave) {
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
		ArrayList<BDEmpleado> personlist = new ArrayList<BDEmpleado>();

		 try {
	            // Step 1: Cargar driver jdbc. jdbc:mysql://localhost:3306/travel
	            Class.forName("com.mysql.jdbc.Driver");
	 
	            // Step 2: Establecer conexi�n
	            String url = "jdbc:mysql://127.0.0.1:3306/paciente?serverTimezone=UTC";
	            Connection conn = DriverManager.getConnection(url, "root", "12121984");
	            Statement st = conn.createStatement();
	            ResultSet srs = st.executeQuery("SELECT * FROM login");
	    
	            var j=0;
	            
	            while (srs.next()) {
	            	BDEmpleado person = new BDEmpleado(usuario,clave,correo);
	            	j=1;	            	
	            	person.setUsuario(srs.getString(j));
	            	j++;
	            	person.setClave(srs.getString(j));
	            	j++;
	                person.setCorreo(srs.getString(j));	                
	                
	                personlist.add(person);
	            }


	 for(var i = 0; i < personlist.size() ; i++) {
		 System.out.println(personlist.size());
		 System.out.println(((BDEmpleado) personlist.get(i)).getUsuario());
		 i++;
		 System.out.println(((BDEmpleado) personlist.get(i)).getClave());
		 i++;
		 System.out.println(((BDEmpleado) personlist.get(i)).getCorreo());
	 }
	       
	 
	        //System.out.println(namelist.);
	        } catch (Exception e) {
	            System.err.println("Got an exception! "); //Encontr� una excepci�n e imprime
	            System.err.println(e.getMessage());
	        }
	    }
		}
