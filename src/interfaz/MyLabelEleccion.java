package interfaz;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dominio.Editor;

public class MyLabelEleccion extends JLabel {

	/**
	 * 
	 */
	private String nombre;
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc_label;
	private ImageIcon icon;
	
	
	public MyLabelEleccion(Image imagen, int x, int y, InterfazRompecabezas interfaz, Editor editor, String nombre, int dificultad) {
		
		this.nombre = nombre;
		icon = new ImageIcon(imagen);
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = x;
		gbc_label.gridy = y;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					
					editor.ladosImagen(dificultad);
					editor.creandoParticiones(dificultad, nombre);
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
				
				interfaz.setPiezas(editor.getImagenes());
				interfaz.piezasIMG();
			}
		});
	}
	
	public GridBagConstraints getGbc_label() {
		return gbc_label;
	}
}
