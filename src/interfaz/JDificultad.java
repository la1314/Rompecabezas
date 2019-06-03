package interfaz;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JDificultad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDificultad dialog = new JDificultad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDificultad() {
		
		setBounds(100, 100, 400, 265);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new MyButton("Facíl");
		btnNewButton.setBounds(144, 50, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new MyButton("Normal");
		btnNewButton_1.setBounds(144, 100, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new MyButton("Difícil");
		btnNewButton_2.setBounds(144, 150, 89, 23);
		contentPanel.add(btnNewButton_2);
	}
}
