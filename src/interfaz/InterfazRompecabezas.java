package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dominio.Editor;
import dominio.Movimientos;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.image.ImagingOpException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRompecabezas extends JFrame {

	/**
	 * Atributos de clase
	 */

	private JPanel panel;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelEleccion;
	private JPanel panel_Piezas;
	private ArrayList<MyLabelPiezas> listaPiezas;
	private Image[][] piezas;
	private Editor editor;
	private ArrayList<String> imgPredeterminadas;
	private JDificultad dialogoDificultad;
	private Movimientos jugabilidad;

	/*
	 * Nombre provisional
	 */

	public void generarPiezas() {


		contentPane.removeAll();
		listaPiezas = new ArrayList<MyLabelPiezas>();
		panel_Piezas = new JPanel();
		contentPane.add(panel_Piezas, BorderLayout.CENTER);
		GridBagLayout gbl_panel_Piezas = new GridBagLayout();
		gbl_panel_Piezas.columnWidths = new int[]{0};
		gbl_panel_Piezas.rowHeights = new int[]{0};
		gbl_panel_Piezas.columnWeights = new double[]{0};
		gbl_panel_Piezas.rowWeights = new double[]{0};
		panel_Piezas.setLayout(gbl_panel_Piezas);
		jugabilidad = new Movimientos(editor.getDificultad()*editor.getDificultad(), editor.getDificultad());

		//		try {
		//			

		generarLabelsOrdenados();

		ingresarPiezasAleatorias();


		//		} catch (ImagingOpException e) {
		//
		//			e.printStackTrace();
		//		} 

		contentPane.revalidate();
		//		contentPane.repaint();
	}

	/*
	 * Funcion que genera el Arraylist con las piezas ordenadas
	 */
	private void generarLabelsOrdenados() {

		this.piezas = editor.getImagenes();

		int ite = 0;
		for (int i = 0; i < piezas.length; i++) {
			for (int j = 0; j < piezas[0].length; j++) {

				/*
				 * Se añade al arrayList de labels la imagen, posiciones e ID correspondientes
				 */
				listaPiezas.add(new MyLabelPiezas(piezas[j][i], i, j, this, jugabilidad));
				listaPiezas.get(ite).setId(ite);
				/*
				 * 
				 */
				//					panel_Piezas.add(listaPiezas.get(ite), listaPiezas.get(ite).getGbc_label());
				ite++;

			}
		}
	}

	/*
	 * Funcion que ingresa desordenadas las piezas dentro del panel_Piezas
	 */
	private void ingresarPiezasAleatorias() {
		
		

		for (int i = 0; i < jugabilidad.getMatrizAleatoria().length; i++) {
			for (int j = 0; j < jugabilidad.getMatrizAleatoria()[0].length; j++) {
				
				/*
				 * 
				 */
				int id = jugabilidad.getMatrizAleatoria()[i][j];

				listaPiezas.get(id).cambioPosicion(i, j);
				panel_Piezas.add(listaPiezas.get(id), listaPiezas.get(id).getGbc_label());
				
			}
		}
		
		listaPiezas.get(listaPiezas.size()-1).quitarIMG();
		
	}

	public void setPiezas(Image[][] piezas) {
		this.piezas = piezas;
	}

	/*
	 * Función que contiene los rompezabecas predeterminados
	 */
	public void insertarElecciones() {

		contentPane.removeAll();
		panelEleccion = new JPanel();
		ArrayList<MyLabelEleccion> elecciones = new ArrayList<MyLabelEleccion>();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{0};
		gbl_panel_1.rowWeights = new double[]{0};
		panelEleccion.setLayout(gbl_panel_1);

		int ite = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				String nombre = imgPredeterminadas.get(ite);
				URL url = getClass().getResource("/img/"+nombre+".png");


				elecciones.add(new MyLabelEleccion(editor.reescalarIMG(url, 240), i, j, this, editor, nombre, editor.getDificultad()));
				panelEleccion.add(elecciones.get(ite), elecciones.get(ite).getGbc_label());
				ite++;
			}
		} 

		panelEleccion.setLayout(gbl_panel_1);

		contentPane.add(panelEleccion, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}

	/*
	 * Realiza el movimiento de piezas, donde las piezas inicial y cambio (pieza negra) intercambiarán posiciones
	 */
	public void realizarMovimientos(int inicial, int cambio) {

		int filaInicial, columnaInicial, filaCambio, columnaCambio;

		filaInicial = listaPiezas.get(inicial).getFila();
		columnaInicial = listaPiezas.get(inicial).getColumna();

		filaCambio = listaPiezas.get(cambio).getFila();
		columnaCambio = listaPiezas.get(cambio).getColumna();

		jugabilidad.cambiarPosicion(filaInicial, columnaInicial, filaCambio, columnaCambio);
		jugabilidad.lectura();
		/*
		 * Se tiene que remover ambas piezas 
		 */
		panel_Piezas.remove(listaPiezas.get(inicial));
		panel_Piezas.remove(listaPiezas.get(cambio));


		/*
		 * Reescritura y posición de inicial
		 */
		listaPiezas.get(inicial).cambioPosicion(filaCambio, columnaCambio);
		panel_Piezas.add(listaPiezas.get(inicial), listaPiezas.get(inicial).getGbc_label());

		/*
		 * Reescritura y posición de cambio
		 */
		listaPiezas.get(cambio).cambioPosicion(filaInicial, columnaInicial);
		panel_Piezas.add(listaPiezas.get(cambio), listaPiezas.get(cambio).getGbc_label());

		contentPane.revalidate();
		contentPane.repaint();
		
		if (jugabilidad.comparar()) {
			System.out.println("Haz ganado");
			
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazRompecabezas frame = new InterfazRompecabezas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazRompecabezas() {

		editor = new Editor();
		imgPredeterminadas = editor.getPredeterminadas();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 780);
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenuItem nuevaPartida = new JMenuItem("Nueva Partida");
		nuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				insertarElecciones();

			}
		});
		mnArchivo.add(nuevaPartida);

		JMenuItem mntmSubirPropio = new JMenuItem("Subir Propio");
		mntmSubirPropio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				editor.buscarImagen(editor.getDificultad(), devolverInterfaz());

			}
		});
		mnArchivo.add(mntmSubirPropio);

		JMenuItem mntmDificultad = new JMenuItem("Dificultad");
		mntmDificultad.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dialogoDificultad = new JDificultad(editor, devolverInterfaz());

			}
		});
		mnArchivo.add(mntmDificultad);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		mnArchivo.add(mntmSalir);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/*
		 * Se ha de llamar en la ejecución
		 */
		insertarElecciones();
	}

	/*
	 * No me dejaba pasar la interfaz como parámetro si no hacía esta guarrada
	 */
	public InterfazRompecabezas devolverInterfaz() {
		return this;
	}

}
