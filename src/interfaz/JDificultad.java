package interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Editor;

public class JDificultad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public JDificultad(Editor editor, InterfazRompecabezas interfaz) {
		
		
		setBounds(100, 100, 400, 265);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.decode("#232733"));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JButton btnFacil = new MyButton("Facíl");
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				editor.facil();
				interfaz.insertarElecciones();
				dispose();
			}
		});
		btnFacil.setBounds(144, 50, 89, 23);
		contentPanel.add(btnFacil);
		
		JButton btnNormal = new MyButton("Normal");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				editor.normal();
				interfaz.insertarElecciones();
				dispose();
				
			}
		});
		btnNormal.setBounds(144, 100, 89, 23);
		contentPanel.add(btnNormal);
		
		JButton btnDificil = new MyButton("Difícil");
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				editor.dificil();
				interfaz.insertarElecciones();
				dispose();
				
			}
		});
		btnDificil.setBounds(144, 150, 89, 23);
		contentPanel.add(btnDificil);
	}
	
	
}
