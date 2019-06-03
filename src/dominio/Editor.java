package dominio;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Editor extends Component {

	/**
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
	
	private void creandoParticiones(int particiones) throws IOException {

		/*
		 * TODO Modificar para recibir el nombre de la imagen como parámetro
		 */
		URL url = getClass().getResource("/img/hatsune.png");
		
		/*
		 * Contenedor de la imagen
		 */
		Image imagenPrincipal = reescalarIMG(url);	
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
	public Image reescalarIMG(URL url) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
		return dimg;
	}
	
	/*
	 * Getter de la Matriz imagenes
	 */
	public Image[][] getImagenes() {
		return imagenes;
	}
	
}
