package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRompecabezas extends JFrame {

	/**
	 * Atributos de clase
	 */
	
	JPanel panel;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelEleccion;
	private Image[][] piezas;
	Editor editor;
	
	/*
	 * Atributos de prueba
	 */

	
	/*
	 * Nombre provisional
	 */
	
	public void piezasIMG() {
		
		contentPane.removeAll();
		
		ArrayList<MyLabelPiezas> listaPiezas = new ArrayList<MyLabelPiezas>();
		
		JPanel panel_Piezas = new JPanel();
		contentPane.add(panel_Piezas, BorderLayout.CENTER);
		GridBagLayout gbl_panel_Piezas = new GridBagLayout();
		gbl_panel_Piezas.columnWidths = new int[]{0};
		gbl_panel_Piezas.rowHeights = new int[]{0};
		gbl_panel_Piezas.columnWeights = new double[]{0};
		gbl_panel_Piezas.rowWeights = new double[]{0};
		panel_Piezas.setLayout(gbl_panel_Piezas);
		
		
		try {
			
			/*
			 * TODO sacar fuera para mayor facilidad a la hora de llamar a sus funciones
			 */
			this.piezas = editor.getImagenes();
			
			int ite = 0;
			for (int i = 0; i < piezas.length; i++) {
				for (int j = 0; j < piezas[0].length; j++) {
					
					listaPiezas.add(new MyLabelPiezas(piezas[i][j], i, j));
					panel_Piezas.add(listaPiezas.get(ite), listaPiezas.get(ite).getGbc_label());
					ite++;
				}
			}
			
		} catch (ImagingOpException e) {
			
			e.printStackTrace();
		} 
		
		contentPane.revalidate();
		contentPane.repaint();
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
				
				/*
				 * TODO implementar el añadir las imagenes predeterminadas
				 */
				URL url = getClass().getResource("/img/hatsune.png");
				elecciones.add(new MyLabelEleccion(editor.reescalarIMG(url, 150), i, j, this));
				
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
		
		/*
		 * TODO mover editor dentro de la función correspondiente para poder modificar el número de piezas del rompecabezas
		 */
		editor = new Editor(6);
		
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
		nuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				insertarElecciones();
			}
		});
		mnArchivo.add(nuevaPartida);
		
		/*
		 * TODO ha de llamar al buscador de imagenes cuando se acaben las modificaciones de este.
		 * 
		 */
		JMenuItem mntmSubirPropio = new JMenuItem("Subir Propio");
		mntmSubirPropio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * TODO implementar las llamadas para crear el rompecabezas
				 *	buscarImagen devuelve Image
				 */
				editor.buscarImagen();
			}
		});
		mnArchivo.add(mntmSubirPropio);
		
		JMenuItem mntmDificultad = new JMenuItem("Dificultad");
		mntmDificultad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO llamar a JDialogo
			}
		});
		mnArchivo.add(mntmDificultad);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
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
	
}
