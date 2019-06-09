package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import dominio.Editor;
import dominio.Movimientos;

/**
 * <h1>Clase MyLabelPiezas</h1>
 * Los atributos de clase son:
 * 
 * <ul>
 * 	<li>id</li>
 * 	<li>fila</li>
 * 	<li>columna</li>
 * 	<li>icon</li>
 * 	<li>gbc_label</li>
 * </ul>
 * @author Jorge Durán
 */

public class MyLabelPiezas extends JLabel {

	private int id;
	private int fila;
	private int columna;
	private ImageIcon icon;
	private GridBagConstraints gbc_label;

	private static final long serialVersionUID = 1L;

	/**
	 * Cuando se instancia MyLabelPiezas este necesita de la pieza (un corte de la imagen original)
	 * será colocada en una posición específica dentro del gbc_label, se le pasán tambien la instancia InterfazRompecabezas y la instancia
	 * jugabilidad para ser utilizadas en su listener y realizar las funciones correspondientes que el listener requiere de estas.
	 * @param pieza
	 * @param xfila
	 * @param yColumna
	 * @param interfaz
	 * @param jugabilidad
	 */
	public MyLabelPiezas(Image pieza, int xfila, int yColumna, InterfazRompecabezas interfaz, Movimientos jugabilidad) {


		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#000714")));
		icon = new ImageIcon(pieza);
		this.setBackground(Color.black);
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = xfila;
		gbc_label.gridy = yColumna;
		this.fila = xfila;
		this.columna = yColumna;
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

	/**
	 * Esta función isntancia un listener del tipo MouseListener comprobando primeramente que 
	 * @param interfaz
	 * @param jugabilidad
	 */
	public void listenerLabel(InterfazRompecabezas interfaz, Movimientos jugabilidad) {

		int ultimaPieza = (Editor.DIFICULTAD *  Editor.DIFICULTAD) -1;	

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (getId() != ultimaPieza) {


					if (jugabilidad.comprobarMovimientoClick( getFila(), getColumna(), ultimaPieza)) {

						interfaz.realizarMovimientos(getId(), ultimaPieza);

					}			

				}

			}
		});
	}

	/*
	 * Esta funciones de abajo probablemente vayan en Editor pero no hay tiemp o para modificaciones,
	 * de eso se encargará el Jorge del futuro
	 */
	
	/** 
	 * Función que elimina el Icon actual del Label y lo reemplaza por uno de color negro. 
	 */
	public void quitarIMG() {

		int auxiliar = this.getIcon().getIconHeight();

		this.setIcon(null);
		this.setIcon(createImage(Color.BLACK, new Dimension(auxiliar, auxiliar)));

		this.revalidate();
	}

	/**
	 * Función que devuelve un Icon que recibe como parámetro c del tipo Color y size del tipo Dimension
	 * para crear y devolver un Icon del color y tamaño requerido
	 * @param c
	 * @param size
	 * @return devuelve un Icono del tipo Icon
	 */
	public Icon createImage(Color c, Dimension size) {
		BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.createGraphics();
		g.setColor(c);
		g.fillRect(0, 0, size.width, size.height);
		return new ImageIcon(img);
	}

	/**
	 * Función que vuelve a instanciar el atributo gbc_label cambiando su posición y sobreescribiendo los atributos
	 * fila y columna con sus nuevos valores
	 * @param xFila
	 * @param yColumna
	 */
	public void cambioPosicion(int xFila, int yColumna) {
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = xFila;
		gbc_label.gridy = yColumna;
		this.fila = xFila;
		this.columna = yColumna;
	}
}
