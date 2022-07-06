package proyectoDogSchool;

import javax.swing.JPanel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.MatteBorder;

public class ClientesPanel extends JPanel {
	
	public ClientesPanel() {
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		lblNewLabel.setBounds(191, 11, 270, 14);
		lblNewLabel.setHorizontalAlignment(0);
		add(lblNewLabel);
		
		comboBoxBusqueda.setBackground(new Color(176, 196, 222));
		comboBoxBusqueda.setBounds(183, 36, 293, 22);
		opcionesComboBox(comboBoxBusqueda);
		add(comboBoxBusqueda);
		
		comboBoxBusqueda.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				comboBoxBusqueda.removeAllItems();
				opcionesComboBox(comboBoxBusqueda);
			}
		});
		btnBuscar.setBackground(new Color(176, 196, 222));
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarDatos();
			}
		});
		
		btnBuscar.setBounds(486, 36, 98, 23);
		add(btnBuscar);
		btnNuevo.setBackground(new Color(176, 196, 222));
		
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nuevoCliente();
			}
		});
		btnNuevo.setBounds(36, 11, 110, 70);
		add(btnNuevo);
		
		lblDni.setBounds(183, 121, 65, 14);
		lblDni.setVisible(false);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBackground(new Color(240, 248, 255));
		txtDni.setEditable(false);
		txtDni.setBounds(258, 114, 218, 30);
		txtDni.setVisible(false);
		add(txtDni);
		txtDni.setColumns(10);
		
		lblNombre.setBounds(183, 161, 65, 14);
		lblNombre.setVisible(false);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(240, 248, 255));
		txtNombre.setEditable(false);
		txtNombre.setBounds(258, 154, 218, 30);
		txtNombre.setVisible(false);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblCorreo.setBounds(183, 241, 65, 14);
		lblCorreo.setVisible(false);
		add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBackground(new Color(240, 248, 255));
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(258, 234, 218, 30);
		txtCorreo.setVisible(false);
		add(txtCorreo);
		txtCorreo.setColumns(10);

		lblTelefono.setBounds(183, 281, 65, 14);
		lblTelefono.setVisible(false);
		add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBackground(new Color(240, 248, 255));
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(258, 274, 218, 30);
		txtTelefono.setVisible(false);
		add(txtTelefono);
		txtTelefono.setColumns(10);

		lblPerro.setBounds(183, 201, 65, 14);
		lblPerro.setVisible(false);
		add(lblPerro);
		
		txtPerro = new JTextField();
		txtPerro.setBackground(new Color(240, 248, 255));
		txtPerro.setEditable(false);
		txtPerro.setBounds(258, 194, 218, 30);
		txtPerro.setVisible(false);
		add(txtPerro);
		txtPerro.setColumns(10);

		lblDeporte.setBounds(183, 321, 65, 14);
		lblDeporte.setVisible(false);
		add(lblDeporte);
		
		txtDeporte = new JTextField();
		txtDeporte.setBackground(new Color(240, 248, 255));
		txtDeporte.setEditable(false);
		txtDeporte.setBounds(258, 314, 218, 30);
		txtDeporte.setVisible(false);
		add(txtDeporte);
		txtDeporte.setColumns(10);
		
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {			
				botonModificar();
			}
		});
		
		btnModificar.setIcon(new ImageIcon(ClientesPanel.class.getResource("/proyectoDogSchool/Mod60Azul.png")));
		btnModificar.setBounds(284, 388, 60, 60);
		btnModificar.setVisible(false);
		add(btnModificar);
		
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonAceptar();
			}
		});
		btnAceptar.setBackground(new Color(176, 196, 222));
		
		btnAceptar.setBounds(365, 391, 89, 23);
		btnAceptar.setVisible(false);
		add(btnAceptar);
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonCancelar();
			}
		});
		btnCancelar.setBackground(new Color(176, 196, 222));
		
		btnCancelar.setBounds(365, 425, 89, 23);
		btnCancelar.setVisible(false);
		add(btnCancelar);
		comboBoxDeporte.setBackground(new Color(176, 196, 222));
		
		comboBoxDeporte.setModel(new DefaultComboBoxModel(new String[] {"Obediencia", "Detecci\u00F3n", "Agility", "ODU"}));
		comboBoxDeporte.setBounds(258, 343, 218, 22);
		comboBoxDeporte.setVisible(false);
		add(comboBoxDeporte);
		
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonBorrar();
			}
		});
		btnBorrar.setBackground(Color.RED);
		
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrar.setBounds(552, 455, 118, 23);
		btnBorrar.setVisible(false);
		add(btnBorrar);
		
		btnGaleria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				galeria();
			}
		});
		btnGaleria.setBackground(new Color(176, 196, 222));
		btnGaleria.setIcon(new ImageIcon(ClientesPanel.class.getResource("/proyectoDogSchool/Galeria.png")));
		
		btnGaleria.setBounds(520, 170, 125, 125);
		btnGaleria.setVisible(false);
		add(btnGaleria);
		
		lblGaleria.setBounds(520, 150, 125, 18);
		lblGaleria.setHorizontalAlignment(0);
		lblGaleria.setVisible(false);
		add(lblGaleria);
		
		lblFoto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 255)));
		lblFoto.setBackground(new Color(176, 196, 222));
		lblFoto.setBounds(10, 154, 150, 150);
		lblFoto.setVisible(false);
		add(lblFoto);
		
		btnImagen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cambiarImagen();
			}
		});
		btnImagen.setBackground(new Color(176, 196, 222));
		
		btnImagen.setBounds(10, 131, 150, 23);
		btnImagen.setVisible(false);
		add(btnImagen);
	}
	
	private void opcionesComboBox(JComboBox comboBox) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();

		String cliente;
		for (int i = 0; i < result.size(); i++) {
			Clientes clienteLista = result.get(i);
			cliente = clienteLista.getNombre() + " " + 
			clienteLista.getApellido1() + " " + clienteLista.getApellido2() + " (" + 
					clienteLista.getDni() +")";
			comboBox.addItem(cliente);
		}
		session.close();
		sf.close();
	}
	
	private void nuevoCliente() {
		
		int resp = JOptionPane.showConfirmDialog(null, 
				"Se abrirá una nueva ventana por encima de la actual. "
				+ "Por favor, no cierres la ventana actual.", 
				"Aviso", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_NO_OPTION) {
			
			NuevoCliente ventana = new NuevoCliente();
	        ventana.setVisible(true);
		}
	}
	
	private void galeria() {
		
		int resp = JOptionPane.showConfirmDialog(null, 
				"Se abrirá una nueva ventana por encima de la actual. "
				+ "Por favor, no cierres la ventana actual.", 
				"Aviso", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_NO_OPTION) {
			
			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sf.openSession();

			List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();

			String cliente;
			for (int i = 0; i < result.size(); i++) {
				Clientes clienteLista = result.get(i);
				cliente = clienteLista.getNombre() + " " + 
				clienteLista.getApellido1() + " " + clienteLista.getApellido2() + " (" + 
						clienteLista.getDni() +")";
				if(comboBoxBusqueda.getSelectedItem().toString().equals(cliente)) {
					
					Galeria ventana = new Galeria(clienteLista);
			        ventana.setVisible(true);
			        break;
				}
			}
			session.close();
			sf.close();
		}
	}
	
	private void ocultarDatos() {
		
		lblFoto.setVisible(false);
		btnImagen.setVisible(false);
		
		lblDni.setVisible(false);
		txtDni.setVisible(false);
		
		lblNombre.setVisible(false);
		txtNombre.setVisible(false);
		
		lblCorreo.setVisible(false);
		txtCorreo.setVisible(false);
		
		lblTelefono.setVisible(false);
		txtTelefono.setVisible(false);
		
		lblPerro.setVisible(false);
		txtPerro.setVisible(false);
		
		lblDeporte.setVisible(false);
		txtDeporte.setVisible(false);
		
		btnModificar.setVisible(false);
		btnBorrar.setVisible(false);
		lblGaleria.setVisible(false);
		btnGaleria.setVisible(false);
	}
	
	private void mostrarDatos() {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();

		for (int i = 0; i < result.size(); i++) {

			Clientes clienteLista = result.get(i);
			String nombreCompleto = clienteLista.getNombre() + " " + clienteLista.getApellido1() + " " + 
					clienteLista.getApellido2() + " (" + clienteLista.getDni() +")";
			String perroRaza = clienteLista.getPerro() + " (" + clienteLista.getRaza_perro() +")";
			if(nombreCompleto.equals(comboBoxBusqueda.getSelectedItem().toString())) {
				
				lblDni.setVisible(true);
				txtDni.setText(clienteLista.getDni());
				txtDni.setVisible(true);
				
				lblNombre.setVisible(true);
				txtNombre.setText(clienteLista.getNombre() + " " + clienteLista.getApellido1() + " " + 
						clienteLista.getApellido2());
				txtNombre.setVisible(true);
				
				lblCorreo.setVisible(true);
				txtCorreo.setText(clienteLista.getCorreo());
				txtCorreo.setVisible(true);
				
				lblTelefono.setVisible(true);
				txtTelefono.setText(String.valueOf(clienteLista.getTelefono()));
				txtTelefono.setVisible(true);
				
				lblPerro.setVisible(true);
				txtPerro.setText(perroRaza);
				txtPerro.setVisible(true);
				
				lblDeporte.setVisible(true);
				txtDeporte.setText(clienteLista.getDeporte());
				txtDeporte.setVisible(true);
				
				btnImagen.setVisible(true);
				lblFoto.setVisible(true);
				mostrarFoto();
				
				btnModificar.setVisible(true);
				btnBorrar.setVisible(true);
				lblGaleria.setVisible(true);
				btnGaleria.setVisible(true);
				break;
			}
		}
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

		List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();

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

					Clientes clienteLista = result.get(i);
					String nombreCompleto = clienteLista.getNombre() + " " + clienteLista.getApellido1() 
							+ " " + clienteLista.getApellido2() + " (" + clienteLista.getDni() +")";

					if (comboBoxBusqueda.getSelectedItem().toString().equals(nombreCompleto)) {

						clienteLista.setCorreo(txtCorreo.getText());
						clienteLista.setTelefono(telefono);
						clienteLista.setDeporte(comboBoxDeporte.getSelectedItem().toString());
						session.save(clienteLista); // save guarda o modifica
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

		List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();

		for (int i = 0; i < result.size(); i++) {
			Clientes clienteLista = result.get(i);
			String nombreCompleto = clienteLista.getNombre() + " " + clienteLista.getApellido1() 
								+ " " + clienteLista.getApellido2() + " (" + clienteLista.getDni() +")";
			
			if (comboBoxBusqueda.getSelectedItem().toString().equals(nombreCompleto)) {

				txtCorreo.setText(clienteLista.getCorreo());
				txtTelefono.setText(String.valueOf(clienteLista.getTelefono()));
				txtDeporte.setText(clienteLista.getDeporte());
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
				"¿Estás seguro de querer borrar este cliente?", "¡Alerta!", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_NO_OPTION) {

			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();

			List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();
			for (int i = 0; i < result.size(); i++) {
				Clientes clienteLista = result.get(i);
				String nombreCompleto = clienteLista.getNombre() + " " + clienteLista.getApellido1() 
								+ " " + clienteLista.getApellido2() + " (" + clienteLista.getDni() +")";
				String usuarioBorrar = txtNombre.getText() + " (" + txtDni.getText() + ")";

				if (usuarioBorrar.equals(nombreCompleto)) {
					session.delete(clienteLista);
					tx.commit();
					
					File foto = new File("src/main/resources/Imagenes/" + nombreCompleto + ".png");
					if (foto.exists()) foto.delete();
					break;
				}
			}

			session.close();
			sf.close();
			comboBoxBusqueda.removeAllItems();
			opcionesComboBox(comboBoxBusqueda);
			ocultarDatos();
			JOptionPane.showMessageDialog(getRootPane(), "Cliente borrado.");
		}
	}
	
	private Boolean validarMail(String mail) {

		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(mail);

		return mather.find();
	}

	private Boolean validarTelefono(String telefono) {

		return telefono.length() == 9;
	}

	private boolean validarCampos() {

		if (txtCorreo.getText().isEmpty() || txtTelefono.getText().isEmpty()) return false;
		else return true;
	}

	private void mostrarFoto() {

		String sinFoto = "src/main/resources/Imagenes/PerrosinFoto.png";
		String conFoto = "src/main/resources/Imagenes/" + comboBoxBusqueda.getSelectedItem().toString() + ".png";
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
	
	private void cambiarImagen() {
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Clientes> result = session.createQuery("FROM Clientes", Clientes.class).getResultList();
		for (int i = 0; i < result.size(); i++) {
			Clientes clienteLista = result.get(i);
			String nombreCompleto = clienteLista.getNombre() + " " + clienteLista.getApellido1() 
							+ " " + clienteLista.getApellido2() + " (" + clienteLista.getDni() +")";

			if (comboBoxBusqueda.getSelectedItem().toString().equals(nombreCompleto)) {
				
				JOptionPane.showMessageDialog(getRootPane(), "Debe seleccionarse un archivo con formato "
						+ "imagen, de lo contrario no se mostrará ninguna imagen");
				JFileChooser navegador = new JFileChooser();
			    if (navegador.showOpenDialog(null) == 0) {
			        try {
			            BufferedImage imagenAbrir = ImageIO.read(navegador.getSelectedFile());
			            File imagenSeleccionada = navegador.getSelectedFile();
			            
			            Path origenPath = FileSystems.getDefault().getPath(imagenSeleccionada.getAbsolutePath());
			            Path destinoPath = FileSystems.getDefault().getPath("src/main/resources/Imagenes/" + 
			            nombreCompleto + ".png");
			            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
			            	            
			            mostrarFoto();
			        } catch (IOException e) {
			            JOptionPane.showMessageDialog(this, "Ocurrió un error al abrir la imagen");
			        }
			    }
			    break;
			}
		}
		session.close();
		sf.close();
	}
	
	private JComboBox comboBoxBusqueda = new JComboBox();
	private JLabel lblNewLabel = new JLabel("Selecciona un cliente");
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnNuevo = new JButton("Nuevo cliente");
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtPerro;
	private JTextField txtDeporte;
	private JLabel lblDni = new JLabel("DNI:");
	private JLabel lblNombre = new JLabel("Nombre:");
	private JLabel lblCorreo = new JLabel("Correo:");
	private JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
	private JLabel lblPerro = new JLabel("Perro:");
	private JLabel lblDeporte = new JLabel("Deporte:");
	private final JButton btnModificar = new JButton("");
	private final JButton btnAceptar = new JButton("Aceptar");
	private final JButton btnCancelar = new JButton("Cancelar");
	private JComboBox comboBoxDeporte = new JComboBox();
	private final JButton btnBorrar = new JButton("Borrar cliente");
	private final JButton btnGaleria = new JButton("");
	private final JLabel lblGaleria = new JLabel("Abrir galer\u00EDa");
	private JLabel lblFoto = new JLabel("");
	private JButton btnImagen = new JButton("Cambiar imagen");
}