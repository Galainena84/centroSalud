package ProyectoCS;

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
		ArrayList al = new ArrayList();
		
		al.add(new Persona("50893485M","Marta", "García", "Hernández", "C/Aloma - 22", "634253456"));
		al.add(new Persona("50893484M","Eva", "Simón", "Mas", "Camino del Prado - 30", "966124627"));
		al.add(new Persona("50893483M","Rafael", "García", "Hernández", "C/Aloma - 1", "601123546"));
		al.add(new Persona("50893482M","Manuel", "Bravo", "Murillo", "C/La Huerta - 22", "965123456"));
		al.add(new Persona("50893481M","Carolina", "García", "Rodríguez", "Avda. Doctor Rico", "661228844"));
		
		guardaPersonas("ficheroPersonas.dat", al);
		ArrayList al2 = leePersonas("ficheroPersonas.dat");
		
		for (int i = 0; i < al2.size(); i++)
			System.out.println((Persona)(al2.get(i)));
	}
}