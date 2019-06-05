package dominio;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Editor extends Component {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image[][] imagenes;

	public Editor(int lados) {

		imagenes = new Image[lados][lados];

		try {
			creandoParticiones(lados);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}	

	/*
	 * Función para recortar la imagen, dichos recortes se añadirán
	 * a la matriz de imagen
	 */
	private void creandoParticiones(int particiones) throws IOException {

		/*
		 * TODO Modificar para recibir el nombre de la imagen como parámetro
		 */
		URL url = getClass().getResource("/img/hatsune.png");

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
		
		/*
		 * Por defectorrrrr 700/700
		 */
		
		Image dimg = img.getScaledInstance(tamanyo, tamanyo, Image.SCALE_SMOOTH);
		return dimg;
	}

	/*
	 * Función que abre un FileChooser para subir una imagen propia, devuelve
	 * una imagen a la cual se le aplicarán las funciones para crear un rompecabeza
	 */
	public Image buscarImagen() {

		Image imagen = null;

		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File(System.getProperty("user.home")));

		//filter the files
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		file.addChoosableFileFilter(filter);
		int result = file.showSaveDialog(null);

		//if the user click on save in Jfilechooser
		if(result == JFileChooser.APPROVE_OPTION){

			File selectedFile = file.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			URL url = getClass().getResource(path);
			/*
			 * Modificar este apartado para concordar al funcionamiento del rompecabezas
			 */
			
			imagen = reescalarIMG(url, 700);
		}

		return imagen;
	}

	/*
	 * Getter de la Matriz imagenes
	 */
	public Image[][] getImagenes() {
		return imagenes;
	}

}
