package interfaz;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class PEditor extends JPanel {

	private Image imagenPrincipal;
	private int width, height;
	private Image imagePart1, imagePart2;

	private Image[][] imagenes;
	private Image[][] transpuesta;
	


	public PEditor() throws IOException {
		
		imagenes = new Image[6][6];
		transpuesta = new Image[imagenes[0].length][imagenes.length];
		
		initBoard(6);
	}

	private void initBoard(int lados) throws IOException {
		
		/*
		 * TODO cambiar initBOard y dividir funciones
		 */

		creandoParticiones(6);

		/*
		 * TODO comprobar si es necesaria
		 */
//		setPreferredSize(new Dimension(width, height + 2));
	}

	private void creandoParticiones(int particiones) throws IOException {
		
		
		URL url = getClass().getResource("/img/hatsune.png");
		
		/*
		 * Contenedor de la imagen
		 */
		imagenPrincipal = resizeIMG(url);

		width = imagenPrincipal.getWidth(null);
		height = imagenPrincipal.getHeight(null);

		/*
		 * TODO
		 * De momento no tiene ningun efecto al comentarlo
		 */
//		imagePart1 = createImage(new FilteredImageSource(imagenPrincipal.getSource(), new CropImageFilter(0, 0,width , height / 2)));        
//		imagePart2 = createImage(new FilteredImageSource(imagenPrincipal.getSource(), new CropImageFilter(0, height / 2, width, height / 2)));

		/*
		 * Ingresa las partes de la imagen en una matriz 5x5
		 */
		for (int i = 0; i < particiones; i++) {
			for (int j = 0; j < particiones; j++) {

				Image TempImage = createImage(new FilteredImageSource(imagenPrincipal.getSource(), new CropImageFilter(j * (width/ particiones) , i * (height / particiones), width / particiones, height / particiones)));
				
				/*
				 * Añadiendo las partes de la imagen a la matriz de imagenes
				 */
				imagenes[i][j] = TempImage;
//				System.out.println(imagenes[i][j]);
			}
		}
	}
	
	public Image[][] getTranspuesta() {
		return transpuesta;
	}

	public Image[][] getImagenes() {
		return imagenes;
	}

	public void transponerMatriz(Image[][] matriz, Image[][] transpuesta){
		
		/*
		 * Transpone la matriz para organizarla correctamente, a partir de aquí se han de añadir identificadores a cada objeto label,
		 * para compararlo con la matriz principal cuando se hagan cambios.
		 * 
		 */
		
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                transpuesta[j][i] = matriz[i][j];
            }
        }
    }
	
	/*
	 * Función para ajustar el tamaño de la imagen del Label
	 * TODO modificar parametros para pasarle el ancho y largo
	 */
	
	public Image resizeIMG(URL url) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(700, 700, Image.SCALE_SMOOTH);
		return dimg;
	}

}