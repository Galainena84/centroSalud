package ProyectoCS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;


public class GUInuevo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GUIcompleto GUI = new GUIcompleto();
	}
}

class GUIcompleto extends JFrame {

	public GUIcompleto() {

		setBounds(300, 300, 330, 150);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		this.setIconImage(new ImageIcon(getClass().getResource("/ProyectoCS/imagen centro de salud.png")).getImage());

		GUILamina Gpanel = new GUILamina();
		add(Gpanel);

		setVisible(true);
	}// Fin de la clase GUIcompleto
}

class GUILamina extends JPanel implements ActionListener {

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Color colorAzulclaro = new Color(191, 198, 255);
		g.setColor(colorAzulclaro);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		Nombre = new JTextField();
		Contraseña = new JPasswordField();
		Correo = new JTextField();
		etiqueta1 = new JLabel("Usuario:     ");
		etiqueta2 = new JLabel("Contraseña: ");
		etiqueta3 = new JLabel("Correo: ");
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		Nombre.setBounds(100, 10, 200, 20);
		Contraseña.setBounds(100, 30, 200, 20);
		Correo.setBounds(100, 50, 200, 20);
		aceptar.setBounds(100, 80, 90, 20);
		cancelar.setBounds(200, 80, 90, 20);
		etiqueta1.setBounds(10, 10, 150, 20);
		etiqueta2.setBounds(10, 30, 200, 20);
		etiqueta3.setBounds(10, 50, 180, 20);

		setLayout(null);

		add(Nombre);
		add(Contraseña);
		add(Correo);
		add(etiqueta1);
		add(etiqueta2);
		add(etiqueta3);
		add(aceptar);
		add(cancelar);

		aceptar.addActionListener((ActionListener) this);
		cancelar.addActionListener(this);

		// Nombre.addFocusListener(new GUIdeFoco());
		Contraseña.addFocusListener(new GUIdeFoco());
		Correo.addFocusListener(new GUIdeFoco());
	}

	public void actionPerformed(ActionEvent e) {

		Object objeto = e.getSource();

		Component buttonClose;

		if (objeto == cancelar)
			JOptionPane.showMessageDialog(null, "Gracias por visitarnos");
			System.exit(WIDTH);

		if (objeto == aceptar) {
			// TODO jframe de Agenda cuando este implementado
			
	
		}
	}
	private void setIconImage(Image miicono) {
		// TODO Auto-generated method stub
	}

	private JTextField Nombre, Correo;
	private JPasswordField Contraseña;
	private JLabel etiqueta1, etiqueta2, etiqueta3;
	private JButton aceptar, cancelar;

	class GUIdeFoco implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			char[] Contra = Contraseña.getPassword();
			System.out.println(Contra);
			int longitud = Contra.length;
			String Nom = Nombre.getText();
			System.out.println(Nom);
			int longNom = Nom.length();
			int contadorCorrectos = 0;

			String email = Correo.getText();
			System.out.println(email);

			if (e.getSource() == Contraseña) {

				if (longitud < 3) {
					JOptionPane.showMessageDialog(null,
							"La Contraseña introducida no es correcta, debe contener al menos 6 caracteres");
				}
			} else {
				contadorCorrectos++;
			}
			if (e.getSource() == Correo)
				// System.out.println("Correo");
				for (int i = 0; i < email.length(); i++) {

					char total = email.charAt(i);

					if (total == '@' && i == 0) {
						JOptionPane.showMessageDialog(null, "El Correo es incorrecto");
						break;
					} else if (total == '@') {
						JOptionPane.showMessageDialog(null, "El Correo es correcto");
						contadorCorrectos++;
						break;
					} else if (i == email.length() - 1) {
						JOptionPane.showMessageDialog(null, "El Correo es incorrecto");
						break;
					}
				}
			if (e.getSource() == Nombre) {

				if (Nom.length() < 3)
					JOptionPane.showMessageDialog(null,
							"Entre en el cuadro del Usuario e introduzcalo de nuevo con mas de tres caracteres, porfavor");
				else {
					JOptionPane.showMessageDialog(null, "El usuario introducido es correcto");
					contadorCorrectos++;
				}
			}

			if (contadorCorrectos == 3) {
				JOptionPane.showMessageDialog(null, "Los datos introducidos son correctos");
			}
		}
	}
}