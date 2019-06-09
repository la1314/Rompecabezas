package interfaz;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import dominio.Editor;

/**
 * <h1>Clase MyLabelEleccion</h1>
 * Los atributos de clase son:
 * 
 * <ul>
 * 	<li>gbc_label</li>
 * 	<li>icon</li>
 * </ul>
 * @author Jorge Durán
 */

public class MyLabelEleccion extends JLabel {

	
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc_label;
	private ImageIcon icon;
	
	/**
	 *  Cuando se instancia MyLabelEleccion este necesita una Imagen la cual es una de las imagenes predeterminadas de los rompecabezas
	 * será colocada en una posición específica dentro del gbc_label, se le pasán tambien la instancia InterfazRompecabezas y la instancia
	 * jugabilidad para ser utilizadas en su listener y realizar las funciones correspondientes que el listener requiere de estas.
	 * @param imagen
	 * @param xFila
	 * @param yColumna
	 * @param interfaz
	 * @param editor
	 * @param nombre
	 * @param dificultad
	 */
	
	public MyLabelEleccion(Image imagen, int xFila, int yColumna, InterfazRompecabezas interfaz, Editor editor, String nombre, int dificultad) {
		
		
		icon = new ImageIcon(imagen);
		this.setIcon(icon);
		gbc_label = new GridBagConstraints();
		gbc_label.gridx = xFila;
		gbc_label.gridy = yColumna;
		
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
				interfaz.generarPiezas();
			}
		});
	}
	
	public GridBagConstraints getGbc_label() {
		return gbc_label;
	}
}
