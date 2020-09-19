package ProyectoCS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Agenda extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Agenda agenda = new Agenda(new String());
	}

	/*
	 * definir unas variables globales de la clase, que serán las que utilicemos
	 * después en diferentes eventos y funciones. Dichas variables son los cuadros
	 * de text, y el desplegable
	 */

	ArrayList listaPersonas = new ArrayList();
	String fichero = null;
	JComboBox personas1 = new JComboBox();
	JTextField txtdni = new JTextField();
	JTextField txtNombre = new JTextField();
	JTextField txtApellido1 = new JTextField();
	JTextField txtApellido2 = new JTextField();
	JTextField txtDireccion = new JTextField();
	JTextField txtTelefono = new JTextField();

	JButton btnVer = new JButton("Ver Datos");
	JButton btnGuardar = new JButton("Modificar Datos");
	JButton btnAnadir = new JButton("Añadir Persona");
	JButton btnQuitar = new JButton("Quitar Persona");
	JButton btnGuardarFich = new JButton("Guardar Fichero");
	JButton btnBorrarCuadros = new JButton("Borrar Cuadros");

	/*
	 * Veamos ahora cómo gestionar la lista de personas. Para almacenarla en
	 * memoria, vamos a hacernos una variable , de tipo ArrayList, que nos servirá
	 * de almacén temporal
	 */

	public Agenda(String fich) {
		/*
		 * definiremos un tamaño y una linea, para hacer que se cierre la ventana cuando
		 * pulsemos el botón de cerrar
		 */

		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Toolkit misistema = Toolkit.getDefaultToolkit();
		Image miicono = misistema.getImage("centro_sanitario.png");
		setIconImage(miicono);

		// controles para definir 3 zonas: Norte Centro y Sur.

		/*
		 * Para la zona superior, definimos un subpanel, que será un GridLayout de una
		 * sola celda, ponemos el desplegable dentro
		 */

		JPanel panelSup = new JPanel();
		panelSup.setLayout(new GridLayout(1, 1));
		panelSup.add(personas1);

		/*
		 * Para la zona central, definimos otro panel que será un GridLayout de 5 filas
		 * y 2 columnas, para almacenar las 5 etiquetas que hay, y sus correspondientes
		 * 5 cuadros de texto
		 */

		JPanel panelCen = new JPanel();
		panelCen.setLayout(new GridLayout(5, 2));

		panelCen.add(new JLabel("DNI:"));
		panelCen.add(txtdni);
		panelCen.add(new JLabel("Nombre:"));
		panelCen.add(txtNombre);
		panelCen.add(new JLabel("Apellido 1:"));
		panelCen.add(txtApellido1);
		panelCen.add(new JLabel("Apellido 2:"));
		panelCen.add(txtApellido2);
		panelCen.add(new JLabel("Direccion:"));
		panelCen.add(txtDireccion);
		panelCen.add(new JLabel("Telefono:"));
		panelCen.add(txtTelefono);

		/*
		 * para la zona inferior definimos otro panel, con un GridLayout de 2 filas y 3
		 * columnas, donde poner todos los botones que hemos visto
		 */
		JPanel panelInf = new JPanel();
		panelInf.setLayout(new GridLayout(2, 3));

		JButton btnVer = new JButton("Ver Datos");
		JButton btnGuardar = new JButton("Modificar Datos");
		JButton btnAnadir = new JButton("Añadir Persona");
		JButton btnQuitar = new JButton("Quitar Persona");
		JButton btnGuardarFich = new JButton("Guardar Fichero");
		JButton btnBorrarCuadros = new JButton("Borrar Cuadros");

		panelInf.add(btnVer);
		panelInf.add(btnGuardar);
		panelInf.add(btnAnadir);
		panelInf.add(btnQuitar);
		panelInf.add(btnGuardarFich);
		panelInf.add(btnBorrarCuadros);

		/*
		 * Finalmente, añadimos cada uno de los subpaneles a la zona que le corresponde
		 */

		getContentPane().add(panelSup, BorderLayout.NORTH);
		getContentPane().add(panelCen, BorderLayout.CENTER);
		getContentPane().add(panelInf, BorderLayout.SOUTH);

		/*
		 * Después, al final del constructor, una vez estén todos los controles puestos,
		 * cargamos los datos en la lista, y los volcamos en el desplegable. utilizando
		 * el método io.LeeGuardaPersona.leePersonas
		 */

		fichero = fich;
		listaPersonas = ProyectoCS.LeeGuardaPersona.leePersonas(fichero);

		// llamar a este método tras cargar por primera vez las personas del fichero

		listaPersonas = ProyectoCS.LeeGuardaPersona.leePersonas(fichero);
		actualizaLista();

		// LOS EVENTOS

		// a) Ver los datos de la persona seleccionada

		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Buscar en la lista la persona que coincida con el nombre y apellidos
				// seleccionados
				int indice = buscaPersona();

				// Quedarnos con los datos de la persona encontrada
				Persona p = (Persona) (listaPersonas.get(indice));

				// Actualizar los cuadros de texto con el dato correspondiente de la persona
				// seleccionada
				txtdni.setText(p.getdni());
				txtNombre.setText(p.getNombre());
				txtApellido1.setText(p.getApellido1());
				txtApellido2.setText(p.getApellido2());
				txtDireccion.setText(p.getDireccion());
				txtTelefono.setText(p.getTelefono());
			}
		});

		// c) Añadir una nueva persona a la lista

		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p = new Persona(txtdni.getText(), txtNombre.getText(), txtApellido1.getText(),
						txtApellido2.getText(), txtDireccion.getText(), txtTelefono.getText());
				listaPersonas.add(p);
				actualizaLista();
				borraCampos();
			}
		});

		// d) Quitar una persona de la lista

		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = buscaPersona();
				listaPersonas.remove(indice);
				actualizaLista();
				borraCampos();
			}
		});

		// e) Modificar una persona de la lista

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indice = buscaPersona();
				Persona p = (Persona) (listaPersonas.get(indice));
				p.setdni(txtdni.getText());
				p.setNombre(txtNombre.getText());
				p.setApellido1(txtApellido1.getText());
				p.setApellido2(txtApellido2.getText());
				p.setDireccion(txtDireccion.getText());
				p.setTelefono(txtTelefono.getText());
				actualizaLista();
				borraCampos();
			}
		});

		// f) Guardar en fichero los datos

		btnGuardarFich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeeGuardaPersona.guardaPersonas(fichero, listaPersonas);
			}
		});
	}

	// AQUI METEMOS METEMOS METODOS PRIVADOS O PUBLICOS FUERA DE LA CLASS Agenda

	// mantendremos actualizado el ArrayList en todo momento

	private void actualizaLista() {
		personas1.removeAllItems();

		for (int i = 0; i < listaPersonas.size(); i++) {
			Persona p = (Persona) (listaPersonas.get(i));
			personas1.addItem(p.getNombre() + " " + p.getApellido1());
		}
	}

	/*
	 * método que nos devuelva el índice de la lista (ArrayList) donde se encuentra
	 * la persona actualmente seleccionada en el desplegable
	 */

	private int buscaPersona() {
		String cad = (String) (personas1.getSelectedItem());
		int indice = 0;
		for (int i = 0; i < listaPersonas.size(); i++) {
			Persona p = (Persona) (listaPersonas.get(i));
			if (cad.equals(p.getNombre() + " " + p.getApellido1())) {
				indice = i;
				break;
			}
		}
		return indice;
	}

	// b) Borrar todos los cuadros de texto

	private void borraCampos() {
		// Rellena esto como creas conveniente
	}

	class GUIcompleto extends JFrame {

		public GUIcompleto() {

			setSize(400, 300);
			
			Toolkit misistema = Toolkit.getDefaultToolkit();
			Image miicono = misistema.getImage("centro_sanitario.png");
			setIconImage(miicono);

			setVisible(true);
		}// Fin de la clase GUIcompleto
	}

}
