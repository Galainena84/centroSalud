package ProyectoCS;

import java.util.*;

public class Persona {
	String DNI;
	String nombre;
	String apellido1;
	String apellido2;
	String direccion;
	String telefono;

	public Persona(String DNI, String nombre, String apellido1, String apellido2, String direccion, String telefono) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getdni() {
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

	public String getTelefono() {
		return telefono;
	}

	public void setdni(String DNI) {
		this.DNI = DNI;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return DNI + "," + apellido1 + " " + apellido2 + ", " + nombre + ", " + direccion + ", " + telefono;
	}

	public static void main(String[] args) {
		ArrayList al = new ArrayList();

		al.add(new Persona("50893485M", "Marta", "García", "Hernández", "C/Aloma - 22", "634253456"));
		al.add(new Persona("50893484M", "Eva", "Simón", "Mas", "Camino del Prado - 30", "966124627"));
		al.add(new Persona("50893483M", "Rafael", "García", "Hernández", "C/Aloma - 1", "601123546"));
		al.add(new Persona("50893482M", "Manuel", "Bravo", "Murillo", "C/La Huerta - 22", "965123456"));
		al.add(new Persona("50893481M", "Carolina", "García", "Rodríguez", "Avda. Doctor Rico", "661228844"));

		Collections.sort(al);

		for (int i = 0; i < al.size(); i++) {
			System.out.println((Persona) (al.get(i)));
		}
	}

}