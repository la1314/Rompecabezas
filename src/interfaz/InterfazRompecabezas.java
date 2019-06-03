package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dominio.Editor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.GridBagLayout;
import java.awt.image.ImagingOpException;
import java.awt.Image;

public class InterfazRompecabezas extends JFrame {

	/**
	 * Atributos de clase
	 */
	
	JPanel panel;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelEleccion;
	private Image[][] piezas;
	
	
	/*
	 * Atributos de prueba
	 */
	JPanel panel_Pruebas_Piezas;
	GridBagLayout gbl_panel_1;
	
	/*
	 * Nombre provisional
	 */
	
	public void piezasIMG() {
		
		ArrayList<MyLabelPiezas> listaPiezas = new ArrayList<MyLabelPiezas>();
		
		try {
			
			/*
			 * TODO sacar fuera para mayor facilidad a la hora de llamar a sus funciones
			 */
			Editor prueba = new Editor(6);

			this.piezas = prueba.getImagenes();
			
			int ite = 0;
			for (int i = 0; i < piezas.length; i++) {
				for (int j = 0; j < piezas.length; j++) {
					
					listaPiezas.add(new MyLabelPiezas(piezas[i][j], i, j));

					panel_Pruebas_Piezas.add(listaPiezas.get(ite), listaPiezas.get(ite).getGbc_label());
					ite++;
				}
			}
			
		} catch (ImagingOpException e) {
			
			e.printStackTrace();
		} 
		
	}
	
	/*
	 * Función que contiene los rompezabecas predeterminados
	 */
	public void insertarElecciones() {
		
		panelEleccion = new JPanel();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		
		
		panelEleccion.setLayout(gbl_panel_1);
		
		contentPane.add(panelEleccion, BorderLayout.CENTER);
	}
	
	/*
	 * TODO funcion de prueba antes de modificar PEditor
	 * de momento no funcionam Jorge del futuro se encargará de ver que hacer con esta mierda
	 */
	public void insertarRompecabezas() {
		try {
			contentPane.removeAll();
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			PEditor x = new PEditor();
			panel.add(x);
			contentPane.revalidate();
			contentPane.repaint();
		} catch (IOException e) {
			
			e.printStackTrace();
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 770);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		/*
		 * Ha de llamar a la función que muestras el menú principal para la elección de los rompecabezas
		 * predeterminados
		 */
		JMenuItem nuevaPartida = new JMenuItem("Nueva Partida");
		mnArchivo.add(nuevaPartida);
		
		/*
		 * TODO ha de llamar al buscador de imagenes cuando se acaben las modificaciones de este.
		 * 
		 */
		JMenuItem mntmSubirPropio = new JMenuItem("Subir Propio");
		mnArchivo.add(mntmSubirPropio);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_Pruebas_Piezas = new JPanel();
		contentPane.add(panel_Pruebas_Piezas, BorderLayout.CENTER);
		gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{0};
		gbl_panel_1.rowWeights = new double[]{0};
		panel_Pruebas_Piezas.setLayout(gbl_panel_1);
		
		
		/*
		 * Prueba de funciones
		 */
		piezasIMG();

		

		
	}
	
}
