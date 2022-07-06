package proyectoDogSchool;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.awt.Color;
import java.awt.Image;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class UsuariosPanel extends JPanel {

	public UsuariosPanel(String usuarioLogado) {

		this.usuarioLogado = usuarioLogado;
		
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		lblNewLabel.setBounds(264, 11, 118, 14);
		add(lblNewLabel);
		comboBox.setBackground(new Color(176, 196, 222));
		
		comboBox.setBounds(223, 36, 198, 22);
		opcionesComboBox(comboBox);
		add(comboBox);
		
		lblFoto.setHorizontalAlignment(0);
		lblFoto.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLUE));
		lblFoto.setBounds(431, 157, 220, 220);
		lblFoto.setVisible(false);
		add(lblFoto);
		
		lblNombre.setBounds(104, 165, 60, 14);
		lblNombre.setVisible(false);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setBounds(174, 157, 210, 30);
		txtNombre.setVisible(false);
		add(txtNombre);
		txtNombre.setColumns(10);
		btnBuscar.setBackground(new Color(176, 196, 222));
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				mostrarDatos(comboBox.getSelectedItem().toString());
			}
		});
		btnBuscar.setBounds(431, 36, 89, 23);
		add(btnBuscar);
		
		lblCorreo.setBounds(104, 227, 60, 14);
		lblCorreo.setVisible(false);
		add(lblCorreo);
		
		lblTelefono.setBounds(104, 294, 60, 14);
		lblTelefono.setVisible(false);
		add(lblTelefono);
		
		txtTelefono.setBackground(new Color(240, 248, 255));
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(174, 286, 210, 30);
		txtTelefono.setColumns(10);
		txtTelefono.setVisible(false);
		add(txtTelefono);
		
		lblDeporte.setBounds(104, 355, 60, 14);
		lblDeporte.setVisible(false);
		add(lblDeporte);
		
		txtDeporte.setBackground(new Color(240, 248, 255));
		txtDeporte.setEditable(false);
		txtDeporte.setBounds(174, 347, 210, 30);
		txtDeporte.setColumns(10);
		txtDeporte.setVisible(false);
		txtCorreo.setEditable(false);
		add(txtDeporte);
		
		txtCorreo.setBackground(new Color(240, 248, 255));
		txtCorreo.setBounds(174, 219, 210, 30);
		txtCorreo.setColumns(10);
		txtCorreo.setVisible(false);
		add(txtCorreo);
		
		btnImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				cambiarImagen();
			}
		});
		btnImagen.setBackground(new Color(176, 196, 222));
		
		btnImagen.setBounds(431, 125, 220, 23);
		btnImagen.setVisible(false);
		add(btnImagen);
		
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				botonModificar();
			}
		});
		btnModificar.setBackground(new Color(240, 248, 255));
		btnModificar.setIcon(new ImageIcon(UsuariosPanel.class.getResource("/proyectoDogSchool/Mod60Azul.png")));
		
		btnModificar.setBounds(192, 407, 60, 60);
		btnModificar.setVisible(false);
		add(btnModificar);
		
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				botonAceptar();
			}
		});
		btnAceptar.setBackground(new Color(176, 196, 222));
		
		btnAceptar.setBounds(313, 410, 89, 23);
		btnAceptar.setVisible(false);
		add(btnAceptar);
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				botonCancelar();
			}
		});
		
		btnCancelar.setBackground(new Color(176, 196, 222));
		
		btnCancelar.setBounds(313, 444, 89, 23);
		btnCancelar.setVisible(false);
		add(btnCancelar);
		
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				botonBorrar();
			}
		});
		
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBackground(new Color(255, 0, 0));
		btnBorrar.setBounds(552, 455, 118, 23);
		btnBorrar.setVisible(false);
		add(btnBorrar);
		
		comboBoxDeporte.setModel(new DefaultComboBoxModel(new String[] {"Obediencia", "Detecci\u00F3n", "Agility", "ODU"}));
		comboBoxDeporte.setBounds(174, 374, 210, 22);
		comboBoxDeporte.setVisible(false);
		add(comboBoxDeporte);
	}
	
	private void opcionesComboBox(JComboBox comboBox) {
		
		Configuration cfg = new Configuration().configure();
	    SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
	    Session session = sf.openSession();   
	     
	    List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();
	             	     
	    for(int i=0; i<result.size(); i++) {
	    	 Usuarios usuarioLista = result.get(i);
	    	 comboBox.addItem(usuarioLista.getUsuario());
	    }
	    session.close();
	    sf.close();
	}
	
	private void mostrarDatos(String usuario) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();

		if (usuario.equals(usuarioLogado)) {
			for (int i = 0; i < result.size(); i++) {

				Usuarios usuarioLista = result.get(i);

				if (usuario.equals(usuarioLista.getUsuario())) {
					lblFoto.setVisible(true);
					btnImagen.setVisible(true);

					String nombre = usuarioLista.getNombre() + " " + usuarioLista.getApellido1() + " "
							+ usuarioLista.getApellido2();
					lblNombre.setVisible(true);
					txtNombre.setText(nombre);
					txtNombre.setVisible(true);

					lblCorreo.setVisible(true);
					txtCorreo.setText(usuarioLista.getCorreo());
					txtCorreo.setBackground(new Color(240, 248, 255));
					txtCorreo.setVisible(true);

					lblTelefono.setVisible(true);
					txtTelefono.setText(String.valueOf(usuarioLista.getTelefono()));
					txtTelefono.setBackground(new Color(240, 248, 255));
					txtTelefono.setVisible(true);

					lblDeporte.setVisible(true);
					txtDeporte.setText(usuarioLista.getDeporte());
					txtDeporte.setBackground(new Color(240, 248, 255));
					txtDeporte.setVisible(true);
					comboBoxDeporte.setVisible(false);

					btnModificar.setVisible(true);
					btnBorrar.setVisible(true);
					btnAceptar.setVisible(false);
					btnCancelar.setVisible(false);
					break;
				}
			}
		}else {
			for (int i = 0; i < result.size(); i++) {

				Usuarios usuarioLista = result.get(i);

				if (usuario.equals(usuarioLista.getUsuario())) {
					lblFoto.setVisible(true);
					btnImagen.setVisible(false);

					String nombre = usuarioLista.getNombre() + " " + usuarioLista.getApellido1() + " "
							+ usuarioLista.getApellido2();
					lblNombre.setVisible(true);
					txtNombre.setText(nombre);
					txtNombre.setVisible(true);

					lblCorreo.setVisible(true);
					txtCorreo.setText(usuarioLista.getCorreo());
					txtCorreo.setBackground(new Color(240, 248, 255));
					txtCorreo.setVisible(true);

					lblTelefono.setVisible(true);
					txtTelefono.setText(String.valueOf(usuarioLista.getTelefono()));
					txtTelefono.setBackground(new Color(240, 248, 255));
					txtTelefono.setVisible(true);

					lblDeporte.setVisible(true);
					txtDeporte.setText(usuarioLista.getDeporte());
					txtDeporte.setBackground(new Color(240, 248, 255));
					txtDeporte.setVisible(true);
					comboBoxDeporte.setVisible(false);

					btnModificar.setVisible(false);
					btnBorrar.setVisible(false);
					btnAceptar.setVisible(false);
					btnCancelar.setVisible(false);
					break;
				}
			}
		}

		mostrarFoto();
		session.close();
		sf.close();
	}
	
	private void botonModificar() {
		
		txtCorreo.setEditable(true);
		txtCorreo.setBackground(new Color(255, 255, 255));
		txtTelefono.setEditable(true);
		txtTelefono.setBackground(new Color(255, 255, 255));
		
		comboBoxDeporte.setSelectedItem(txtDeporte.getText());
		comboBoxDeporte.setVisible(true);
		btnAceptar.setVisible(true);
		btnCancelar.setVisible(true);
	}
	
	private void botonAceptar() {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();

		if(!validarCampos()) 
        	JOptionPane.showMessageDialog(getRootPane(), "Ningún campo puede estar vacío");
        
        else if(!validarMail(txtCorreo.getText()))        	
        	JOptionPane.showMessageDialog(getRootPane(), "Correo electrónico incorrecto.");
        
        else if(!validarTelefono(txtTelefono.getText())) 
        	JOptionPane.showMessageDialog(getRootPane(), "El teléfono debe contener 9 caracteres numéricos.");
        
		else {
			try {
				int telefono = Integer.parseInt(txtTelefono.getText());
				
				for (int i = 0; i < result.size(); i++) {

					Usuarios usuarioLista = result.get(i);

					if (comboBox.getSelectedItem().toString().equals(usuarioLista.getUsuario())) {

						usuarioLista.setCorreo(txtCorreo.getText());
						usuarioLista.setTelefono(Integer.parseInt(txtTelefono.getText()));
						usuarioLista.setDeporte(comboBoxDeporte.getSelectedItem().toString());
						session.save(usuarioLista);
						tx.commit();
						session.close();
						sf.close();
						
						txtDeporte.setText(comboBoxDeporte.getSelectedItem().toString());
						JOptionPane.showMessageDialog(getRootPane(), "Datos modificados.");
						
						txtCorreo.setEditable(false);
						txtCorreo.setBackground(new Color(240, 248, 255));
						txtTelefono.setEditable(false);
						txtTelefono.setBackground(new Color(240, 248, 255));
						
						btnAceptar.setVisible(false);
						btnCancelar.setVisible(false);
						comboBoxDeporte.setVisible(false);
						break;
					}
				}
			}catch(NumberFormatException e) {
        		JOptionPane.showMessageDialog(getRootPane(), "El teléfono debe contener 9 caracteres numéricos.");
        	}
		}
	}
	
	private void botonCancelar() {
		
		Configuration cfg = new Configuration().configure();
	    SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
	    Session session = sf.openSession();   
	     
	    List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();
	             	     
	    for(int i=0; i<result.size(); i++) {
	    	 Usuarios usuarioLista = result.get(i);
	    	 
	    	 if(comboBox.getSelectedItem().toString().equals(usuarioLista.getUsuario())) {
	    		 
	    		 txtCorreo.setText(usuarioLista.getCorreo());
	    		 txtTelefono.setText(String.valueOf(usuarioLista.getTelefono()));
	    		 txtDeporte.setText(usuarioLista.getDeporte());
	    		 break;
	    	 }
	    }
	    session.close();
	    sf.close();
	     
		txtCorreo.setEditable(false);
		txtCorreo.setBackground(new Color(240, 248, 255));
		txtTelefono.setEditable(false);
		txtTelefono.setBackground(new Color(240, 248, 255));
		
		btnAceptar.setVisible(false);
		btnCancelar.setVisible(false);
		comboBoxDeporte.setVisible(false);
	}
	
	private void botonBorrar() {

		int resp = JOptionPane.showConfirmDialog(null,
				"¿Estás seguro de querer borrar tu usuario y salir de la aplicación?", "¡Alerta!",
				JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_NO_OPTION) {

			File foto = new File("src/main/resources/Imagenes/" + usuarioLogado + ".png");
			if (foto.exists()) foto.delete();

			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();

			List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();
			for (int i = 0; i < result.size(); i++) {
				Usuarios usuarioLista = result.get(i);

				if (usuarioLista.getUsuario().equals(usuarioLogado)) {
					session.delete(usuarioLista);
					tx.commit();
					break;
				}
			}
			session.close();
			sf.close();
			System.exit(0);
		}
	}
	
	private void cambiarImagen() {
		
		JOptionPane.showMessageDialog(getRootPane(), "Debe seleccionarse un archivo con formato imagen, "
				+ "de lo contrario no se mostrará ninguna imagen");
		JFileChooser navegador = new JFileChooser();
	    if (navegador.showOpenDialog(null) == 0) {
	        try {
	            BufferedImage imagenAbrir = ImageIO.read(navegador.getSelectedFile());
	            File imagenSeleccionada = navegador.getSelectedFile();
	            
	            Path origenPath = FileSystems.getDefault().getPath(imagenSeleccionada.getAbsolutePath());
	            Path destinoPath = FileSystems.getDefault().getPath("src/main/resources/Imagenes/" + 
	            usuarioLogado + ".png");
	            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
	            	            
	            mostrarFoto();
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(this, "Ocurrió un error al abrir la imagen");
	        }
	    }
	}
	
	private void mostrarFoto() {
		
		String sinFoto = "src/main/resources/Imagenes/sinFoto.png";
		String conFoto = "src/main/resources/Imagenes/" + comboBox.getSelectedItem().toString() + ".png";
		File foto = new File(conFoto);
		Image sinImg = new ImageIcon(sinFoto).getImage();
		Image conImg = new ImageIcon(conFoto).getImage();
		Image newimg;
		ImageIcon imageIcon;
		if (!foto.exists()) {
			newimg = sinImg.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			lblFoto.setIcon(imageIcon);
		} else {
			newimg = conImg.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			lblFoto.setIcon(imageIcon);
		}
	}
	
	private Boolean validarMail(String mail) {
    	
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(mail);
 
        return mather.find();
    }
    
	private Boolean validarTelefono(String telefono) {
    	
    	return telefono.length() == 9;
    }

    private boolean validarCampos() {
    	
    	if(txtCorreo.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
    		return false;
    	}
    	else return true;
    }
	
	private JLabel lblNewLabel = new JLabel("Selecciona un usuario");
	private JComboBox comboBox = new JComboBox();
	private JButton btnBuscar = new JButton("Buscar");
	
	private JLabel lblFoto = new JLabel("");
	private JButton btnImagen = new JButton("Modificar imagen");
	
	private JLabel lblNombre = new JLabel("Nombre:");
	private JTextField txtNombre;
	
	private JLabel lblCorreo = new JLabel("Correo:");
	private final JTextField txtCorreo = new JTextField();
	
	private JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
	private final JTextField txtTelefono = new JTextField();
	
	private JLabel lblDeporte = new JLabel("Deporte:");
	private final JTextField txtDeporte = new JTextField();
	private final JComboBox comboBoxDeporte = new JComboBox();
	
	private JButton btnModificar = new JButton();
	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnCancelar = new JButton("Cancelar");
	
	private String usuarioLogado;
	private JButton btnBorrar = new JButton("Borrar usuario");
}