package interfaz;

import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabelEleccion extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc_label;
	private ImageIcon icon;
	
	
	public MyLabelEleccion(Image imagen, int x, int y, InterfazRompecabezas interfaz) {
		
		icon = new ImageIcon(imagen);
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = x;
		gbc_label.gridy = y;
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				/*
				 * TODO implementar al nombre de la imagen correspondiente
				 */
				interfaz.piezasIMG();
			}
		});
	}
	
	public GridBagConstraints getGbc_label() {
		return gbc_label;
	}
}
