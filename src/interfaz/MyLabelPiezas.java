package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class MyLabelPiezas extends JLabel {

	/**
	 * 
	 */
	private int id;
	private int fila;
	private int columna;
	private ImageIcon icon;
	private GridBagConstraints gbc_label;

	private static final long serialVersionUID = 1L;

	/*
	 * Fila se coloca en columna y visceversa, X referencia la fila e Y las columnas
	 */
	
	public MyLabelPiezas(Image pieza, int x, int y, InterfazRompecabezas interfaz) {

		
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#000714")));
		icon = new ImageIcon(pieza); 
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = x;
		gbc_label.gridy = y;
		this.fila = x;
		this.columna = y;
		listenerLabel(interfaz);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public GridBagConstraints getGbc_label() {
		return gbc_label;
	}

	public void listenerLabel(InterfazRompecabezas interfaz) {
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.out.println(getId());
				interfaz.realizarMovimientos(getId(), 24);
		
			}
		});
	}
	
	public void cambioPosicion(int x, int y) {
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = x;
		gbc_label.gridy = y;
		this.fila = x;
		this.columna = y;
	}
	
}
