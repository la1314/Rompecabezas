package interfaz;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class PruebasBuscador extends JFrame{
    JButton button ;
    JLabel label;
    
    public PruebasBuscador(){
    	
    super("Set Picture Into A JLabel Using JFileChooser In Java");
    button = new JButton("Browse");
    button.setBounds(300,300,100,40);
    label = new JLabel();
    label.setBounds(10,10,670,250);
    add(button);
    add(label);
    
    /*
     * Listener del boton Browse
     * Posible cambio al ser llamado por el Item "Subir propio"
     */
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
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
              
              /*
               * Modificar este apartado para concordar al funcionamiento del rompecabezas
               */
              label.setIcon(ResizeImage(path));
          }
          
        }
    });
    /*
     ************************************************************************************************ 
     */
    
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(700,400);
    setVisible(true);
    }
     
     // Methode to resize imageIcon with the same size of a Jlabel
    /*
     * Posible eliminación, para utilizar el reescalado de Editor
     */
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public static void main(String[] args){
        new PruebasBuscador();
    }
   }