package interfaz;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;


/**
 * Clase MyField que extiende de JTextField y que posee unas configuración específicas para la
 * interfaz del rompecabezas
 */

public class MyField extends JTextField {

	private static final long serialVersionUID = 1L;

	public MyField(int columns) {
		
		this.setBackground(Color.decode("#232733"));
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#232733")));
		this.setForeground(Color.WHITE);
		this.setColumns(columns);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setEditable(false);
	}
}
