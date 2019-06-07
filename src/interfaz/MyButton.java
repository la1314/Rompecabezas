package interfaz;

import java.awt.Color;

import javax.swing.JButton;

public class MyButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyButton(String nombre) {
		
		this.setBackground(Color.decode("#232733"));
		this.setText(nombre);
		this.setForeground(Color.WHITE);
		this.setSelected(false);
	}
	
}
