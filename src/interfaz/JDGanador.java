package interfaz;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;


public class JDGanador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private MyField txtfelicidades;



	/**
	 * Create the dialog.
	 */
	public JDGanador(InterfazRompecabezas interfaz) {
		
		this.setResizable(false);
		setBounds(100, 100, 299, 155);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.decode("#232733"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtfelicidades = new MyField(15);
			txtfelicidades.setBounds(95, 26, 107, 51);
			txtfelicidades.setText("¡Felicidades!");
			contentPanel.add(txtfelicidades);
		
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						interfaz.insertarElecciones();
						dispose();
						
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
