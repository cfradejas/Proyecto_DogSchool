package proyectoDogSchool;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.border.MatteBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author candi
 */
public class Galeria extends javax.swing.JFrame {

    public Galeria(Clientes cliente) {
    	
    	this.cliente=cliente;
    	
        initComponents();
        this.setLocationRelativeTo(null); 
    	getContentPane().setBackground(new Color(240, 248, 255));
    	lblInformacion.setFont(new Font("Tahoma", Font.BOLD, 13));
    	getContentPane().add(lblInformacion);
    	setTitle("DogSchool - Galería");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Bienvenida.class.getResource("/proyectoDogSchool/LOGO.png"))); 
    }
                         
    private void initComponents() {
    	
    	btnBuscar.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent e) {
    			mostrarImagenes();
    		}
    	});
    	
    	btnBuscar.setBackground(new Color(176, 196, 222));
    	btnBuscar.setBounds(562, 30, 89, 23);
    	getContentPane().add(btnBuscar);
    	
    	lblInformacion.setForeground(new Color(105, 105, 105));
    	lblInformacion.setBounds(267, 541, 355, 23);
    	lblInformacion.setHorizontalAlignment(0);
    	lblInformacion.setVisible(false);

        btnAtras = new javax.swing.JButton();
        
        btnAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        
        btnAtras.setBackground(new Color(0, 0, 139));
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAtras.setBounds(755, 549, 121, 50);
        
        comboBoxOrden = new javax.swing.JComboBox<>();
        comboBoxOrden.setBackground(new Color(176, 196, 222));
        comboBoxOrden.setBounds(341, 31, 201, 20);
        opcionesComboBox(comboBoxOrden);
        
        lblOrden = new javax.swing.JLabel();
        lblOrden.setHorizontalAlignment(0);
        lblOrden.setBounds(341, 11, 201, 14);
        
        foto1 = new javax.swing.JLabel();
        foto1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cambiarImagen(foto1, 1);
        	}
        });
        foto1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
        foto1.setVisible(false);
        foto1.setBounds(85, 62, 225, 225);
        
        foto2 = new javax.swing.JLabel();
        foto2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cambiarImagen(foto2, 2);
        	}
        });
        foto2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
        foto2.setVisible(false);
        foto2.setBounds(328, 62, 225, 225);
        
        foto3 = new javax.swing.JLabel();
        foto3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cambiarImagen(foto3, 3);
        	}
        });
        foto3.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
        foto3.setVisible(false);
        foto3.setBounds(571, 62, 225, 225);
        
        foto4 = new javax.swing.JLabel();
        foto4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cambiarImagen(foto4, 4);
        	}
        });
        foto4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
        foto4.setVisible(false);
        foto4.setBounds(85, 305, 225, 225);

        foto5 = new javax.swing.JLabel();
        foto5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cambiarImagen(foto5, 5);
        	}
        });
        foto5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
        foto5.setVisible(false);
        foto5.setBounds(328, 305, 225, 225);
        
        foto6 = new javax.swing.JLabel();
        foto6.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		cambiarImagen(foto6, 6);
        	}
        });
        foto6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLUE));
        foto6.setVisible(false);
        foto6.setBounds(571, 305, 225, 225);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(890, 637));
        setResizable(false);
        setSize(new Dimension(890, 637));

        btnAtras.setText("Atrás");

        lblOrden.setText("Selecciona una orden de " + cliente.getDeporte());
        getContentPane().setLayout(null);
        getContentPane().add(foto4);
        getContentPane().add(foto5);
        getContentPane().add(foto6);
        getContentPane().add(foto1);
        getContentPane().add(foto2);
        getContentPane().add(foto3);
        getContentPane().add(btnAtras);
        getContentPane().add(lblOrden);
        getContentPane().add(comboBoxOrden);

        pack();
    }
    
    private void opcionesComboBox(JComboBox comboBox) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Deportes> result = session.createQuery("FROM Deportes", Deportes.class).getResultList();

		for(int i = 0; i < result.size(); i++) {
			Deportes deporteLista = result.get(i);
			if(deporteLista.getDeporte().equals(cliente.getDeporte())) 
				comboBox.addItem(deporteLista.getOrden());	
		}
		session.close();
		sf.close();
	}
    
    private void mostrarImagenes() {

    	pintarFoto(foto1, 1);
    	pintarFoto(foto2, 2);
    	pintarFoto(foto3, 3);
    	pintarFoto(foto4, 4);
    	pintarFoto(foto5, 5);
    	pintarFoto(foto6, 6);
    	
    	foto1.setVisible(true);
    	foto2.setVisible(true);
    	foto3.setVisible(true);
    	foto4.setVisible(true);
    	foto5.setVisible(true);
    	foto6.setVisible(true);
    	lblInformacion.setVisible(true);
    }
    
    private void pintarFoto(JLabel label, int num) {

		String sinFoto = "src/main/resources/Imagenes/GaleriaSinFoto.png";
		String conFoto = "src/main/resources/Imagenes/" + cliente.getDni()+ "_" +
							comboBoxOrden.getSelectedItem().toString() +"_" + num+ ".png";
		File foto = new File(conFoto);
		Image sinImg = new ImageIcon(sinFoto).getImage();
		Image conImg = new ImageIcon(conFoto).getImage();
		Image newimg;
		ImageIcon imageIcon;
		
		if (!foto.exists()) {
			newimg = sinImg.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			label.setIcon(imageIcon);
		} else {
			newimg = conImg.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			label.setIcon(imageIcon);
		}
    }
    
    private void cambiarImagen(JLabel label, int num) {

		JOptionPane.showMessageDialog(getRootPane(),
				"Debe seleccionarse un archivo con formato imagen, de lo contrario no se mostrará ninguna imagen");
		JFileChooser navegador = new JFileChooser();
		if (navegador.showOpenDialog(null) == 0) {
			try {
				BufferedImage imagenAbrir = ImageIO.read(navegador.getSelectedFile());
				File imagenSeleccionada = navegador.getSelectedFile();

				Path origenPath = FileSystems.getDefault().getPath(imagenSeleccionada.getAbsolutePath());
				Path destinoPath = FileSystems.getDefault()
						.getPath("src/main/resources/Imagenes/" + cliente.getDni() + "_" + 
								comboBoxOrden.getSelectedItem().toString() + "_" + num +".png");
				Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);

				mostrarImagenes();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "Ocurrió un error al abrir la imagen");
			}
		}
	}
                   
    private javax.swing.JButton btnAtras;
    private javax.swing.JComboBox<String> comboBoxOrden;
    private javax.swing.JLabel foto1;
    private javax.swing.JLabel foto2;
    private javax.swing.JLabel foto3;
    private javax.swing.JLabel foto4;
    private javax.swing.JLabel foto5;
    private javax.swing.JLabel foto6;
    private javax.swing.JLabel lblOrden;
    private JLabel lblInformacion = new JLabel("Toca una imagen para modificarla por otra");
    private JButton btnBuscar = new JButton("Buscar");

    private Clientes cliente;
}