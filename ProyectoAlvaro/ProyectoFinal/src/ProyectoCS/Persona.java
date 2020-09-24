package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Persona {
	static int DNI;
	static String nombre;
	static String apellido1;
	static String apellido2;
	static String direccion;
	static int telefono;

	public Persona(int DNI, String nombre, String apellido1, String apellido2, String direccion, int telefono) {
		Persona.DNI = DNI;
		Persona.nombre = nombre;
		Persona.apellido1 = apellido1;
		Persona.apellido2 = apellido2;
		Persona.direccion = direccion;
		Persona.telefono = telefono;
	}



	public int getdni() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setdni(int DNI) {
		Persona.DNI = DNI;
	}

	public void setNombre(String nombre) {
		Persona.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		Persona.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		Persona.apellido2 = apellido2;
	}

	public void setDireccion(String direccion) {
		Persona.direccion = direccion;
	}

	public void setTelefono(int telefono) {
		Persona.telefono = telefono;
	}

	public String toString() {
		return DNI + "," + apellido1 + " " + apellido2 + ", " + nombre + ", " + direccion + ", " + telefono;
	}

	public static void main(String[] args) {
		ArrayList<Persona> personlist = new ArrayList<Persona>();

		 try {
	            // Step 1: Cargar driver jdbc. jdbc:mysql://localhost:3306/travel
	            Class.forName("com.mysql.jdbc.Driver");
	 
	            // Step 2: Establecer conexión
	            String url = "jdbc:mysql://127.0.0.1:3306/paciente?serverTimezone=UTC";
	            Connection conn = DriverManager.getConnection(url, "root", "12121984");
	            Statement st = conn.createStatement();
	            ResultSet srs = st.executeQuery("SELECT * FROM cliente");
	            while (srs.next()) {
	            	Persona person = new Persona(DNI, nombre, apellido1, apellido2, direccion, telefono);
	            	person.setdni(srs.getInt(1));
	            	person.setNombre(srs.getString(2));
	                person.setApellido1(srs.getString(3));
	                person.setApellido2(srs.getString(4));
	                person.setDireccion(srs.getString(5));
	                person.setTelefono(srs.getInt(6));
	         
	                personlist.add(person);
	            }
	 
	            System.out.println(personlist.size());
	            System.out.println(((Persona) personlist.get(1)).getdni());
	            System.out.println(((Persona) personlist.get(2)).getNombre());
	            System.out.println(((Persona) personlist.get(3)).getApellido1());
	            System.out.println(((Persona) personlist.get(4)).getApellido2());
	            System.out.println(((Persona) personlist.get(5)).getDireccion());
	            System.out.println(((Persona) personlist.get(6)).getTelefono());
	            System.out.println(personlist.get(7));
	 
	        //System.out.println(namelist.);
	        } catch (Exception e) {
	            System.err.println("Got an exception! "); //Encontré una excepción e imprime
	            System.err.println(e.getMessage());
	        }
	    }
		
	
		
	}

