package dominio;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import interfaz.InterfazRompecabezas;

public class Editor extends Component {

	/*
	 * Atributos
	 */
	private static final long serialVersionUID = 1L;
	private Image[][] imagenes;
	private ArrayList<String> predeterminadas;
	private int dificultad;

	public Editor() {

		facil();
		rellenarPredetarminadas(predeterminadas);

	}	

	/*
	 * Función para recortar la imagen, dichos recortes se añadirán
	 * a la matriz de imagen
	 */
	public void creandoParticiones(int particiones, String nombre) throws IOException {

		URL url = getClass().getResource("/img/"+nombre+".png");

		/*
		 * Contenedor de la imagen
		 */
		Image imagenPrincipal = reescalarIMG(url, 700);	
		int width = imagenPrincipal.getWidth(null);
		int height = imagenPrincipal.getHeight(null);

		/*
		 * Ingresa en una matriz cuadrada
		 */
		for (int i = 0; i < particiones; i++) {
			for (int j = 0; j < particiones; j++) {

				Image TempImage = createImage(new FilteredImageSource(imagenPrincipal.getSource(), new CropImageFilter(j * (width/ particiones) , i * (height / particiones), width / particiones, height / particiones)));

				/*
				 * Añadiendo las partes de la imagen a la matriz de imagenes
				 */
				imagenes[i][j] = TempImage;

			}
		}
	}

	/*
	 * Función que escala la imagen pasada por url, devolviendo la imagen reescalada
	 */
	public Image reescalarIMG(URL url, int tamanyo) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(tamanyo, tamanyo, Image.SCALE_SMOOTH);
		return dimg;
	}

	public Image reescalarIMG(File file, int tamanyo) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(tamanyo, tamanyo, Image.SCALE_SMOOTH);
		return dimg;
	}
	
	/*
	 * Función que abre un FileChooser para subir una imagen propia, devuelve
	 * una imagen a la cual se le aplicarán las funciones para crear un rompecabeza
	 */
	public void buscarImagen(int dificultad, InterfazRompecabezas interfaz) {

		
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));

		//filter the files
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);

		//if the user click on save in Jfilechooser
		if(result == JFileChooser.APPROVE_OPTION){

			ladosImagen(dificultad);
			
			File selectedFile = file.getSelectedFile();
			File ruta = selectedFile.getAbsoluteFile();
			
			Image imagenPrincipal = reescalarIMG(ruta, 700);
			int width = imagenPrincipal.getWidth(null);
			int height = imagenPrincipal.getHeight(null);

			/*
			 * Ingresa en una matriz cuadrada
			 */
			for (int i = 0; i < dificultad; i++) {
				for (int j = 0; j < dificultad; j++) {
					
					Image TempImage = createImage(new FilteredImageSource(imagenPrincipal.getSource(), new CropImageFilter(j * (width/ dificultad) , i * (height / dificultad), width / dificultad, height / dificultad)));

					/*
					 * Añadiendo las partes de la imagen a la matriz de imagenes
					 */
					imagenes[i][j] = TempImage;

				}
			}
			
			interfaz.setPiezas(getImagenes());
			interfaz.generarPiezas();
		}

	}

	/*
	 * Getter de la Matriz imagenes
	 */
	public Image[][] getImagenes() {
		return imagenes;
	}

	public void rellenarPredetarminadas(ArrayList<String> predeterminadas) {
		this.predeterminadas = new ArrayList<String>();
		this.predeterminadas.add("Hatsune");
		this.predeterminadas.add("Woft");
		this.predeterminadas.add("Jhin");
		this.predeterminadas.add("Warlock");
		this.predeterminadas.add("Annie");
		this.predeterminadas.add("Sylvanas");
		this.predeterminadas.add("Vi");
		this.predeterminadas.add("Arthas");
		this.predeterminadas.add("Overlord");
	}

	public ArrayList<String> getPredeterminadas() {
		return predeterminadas;
	}

	public void ladosImagen(int lados) {
		imagenes = new Image[lados][lados];
	}

	public void facil() {
		this.dificultad = 5;
	}

	public void normal() {
		this.dificultad = 8;
	}

	public void dificil() {
		this.dificultad = 14;
	}

	public int getDificultad() {
		return dificultad;
	}

}
