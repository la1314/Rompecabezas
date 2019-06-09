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
import dominio.Editor;

/**
 * La clese JDificultad extiende de Jdialog, esta clase consta de 3 listener los cuales modificarán la dificultad del rompecabezas y llamarán nuevamente a la ventana principal
 * de elección
 * @author Jorge Durán
 */

public class JDificultad extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();

	/**
	 * Cuando se instancia JDificultad requiere que se pasen como parámetro el Editor y InterfazRompecabezas para llamar a sus espectivas función en sus Listener
	 * @param editor
	 * @param interfaz
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
