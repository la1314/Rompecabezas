package interfaz;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dominio.Editor;
import dominio.Movimientos;


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
	
	public MyLabelPiezas(Image pieza, int x, int y, InterfazRompecabezas interfaz, Movimientos jugabilidad) {

		
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#000714")));
		icon = new ImageIcon(pieza);
		this.setBackground(Color.black);
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = x;
		gbc_label.gridy = y;
		this.fila = x;
		this.columna = y;
		listenerLabel(interfaz, jugabilidad);
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

	public void listenerLabel(InterfazRompecabezas interfaz, Movimientos jugabilidad) {
		
		int ultimaPieza = (Editor.dificultad *  Editor.dificultad) -1;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					
				if (getId() != ultimaPieza) {
					
//					jugabilidad.lectura();
					
//					System.out.println(getId());
					
					if (jugabilidad.comprobarMovimiento( getFila(), getColumna(), ultimaPieza)) {
						
						interfaz.realizarMovimientos(getId(), ultimaPieza);
						
					}			
					
				}
		
			}
		});
	}
	
	public void quitarIMG() {
		this.setIcon(null);
		this.revalidate();
	}
	
	public void cambioPosicion(int x, int y) {
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = x;
		gbc_label.gridy = y;
		this.fila = x;
		this.columna = y;
	}
	
}
