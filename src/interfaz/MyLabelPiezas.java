package interfaz;

import java.awt.GridBagConstraints;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabelPiezas extends JLabel {

	/**
	 * 
	 */
	private int id;
	private int fila;
	private int columna;
	private GridBagConstraints gbc_label;
	
	private static final long serialVersionUID = 1L;

	public MyLabelPiezas(Image pieza, int x, int y) {
		
		ImageIcon icon = new ImageIcon(pieza); 
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = y;
		gbc_label.gridy = x;
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

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public GridBagConstraints getGbc_label() {
		return gbc_label;
	}
}
