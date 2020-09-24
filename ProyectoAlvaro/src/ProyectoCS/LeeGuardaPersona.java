package ProyectoCS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class LeeGuardaPersona
{
	

	
	public static ArrayList leePersonas(String fichero)
	{
		return null;
	}
	
	public static void guardaPersonas(String fichero, ArrayList personas)
	{
	}
	
	public static void main(String[] args)
	{
		 ArrayList <Persona>personlist = new ArrayList<Persona>();
	        //List<Person> personlist = new List<Person>();
	        try {
	            // Step 1: Cargar driver jdbc. jdbc:mysql://localhost:3306/travel
	            Class.forName("com.mysql.cj.jdbc.Driver");
	 
	            // Step 2: Establecer conexión
	            String url = "jdbc:mysql://127.0.0.1:3306/paciente?serverTimezone=UTC";
	            Connection conn = DriverManager.getConnection(url, "root", "12121984");
	            Statement st = conn.createStatement();
	            ResultSet srs = st.executeQuery(" SELECT* FROM cliente");
	            while (srs.next()) {
	            	int DNI = 0;
	            	String direccion = null;
					String nombre = null;
					String apellido1 = null;
					int telefono = 0;
					String apellido2 = null;
					Persona person = new Persona( DNI, nombre, apellido1, apellido2, direccion, telefono);
	            	person.setdni(srs.getInt(1));
	                person.setNombre(srs.getString(2));
	                person.setApellido1(srs.getString(3));
	                person.setApellido2(srs.getString(4));
	                person.setDireccion(srs.getString(5));
	                person.setTelefono(srs.getInt(6));
	         
	                personlist.add(person);
	            }
	 
	            System.out.println((personlist.get(0)).getdni());
	            System.out.println((personlist.get(1)).getNombre());
	            System.out.println((personlist.get(2)).getApellido1());
	            System.out.println((personlist.get(3)).getApellido2());
	            System.out.println((personlist.get(4)).getDireccion());
	            System.out.println((personlist.get(5)).getTelefono());
	          
	        //System.out.println(namelist.);
	        } catch (Exception e) {
	            System.err.println("Got an exception! "); //Encontré una excepción e imprime
	            System.err.println(e.getMessage());
		
		

		guardaPersonas("ficheroPersonas.dat", personlist);
		ArrayList al2 = leePersonas("ficheroPersonas.dat");
		
		for (int i = 0; i < al2.size(); i++)
			System.out.println((Persona)(al2.get(i)));
	}
}}