package proyectoDogSchool;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;

/**
 *
 * @author candi
 */
public class NuevoCliente extends javax.swing.JFrame {

    public NuevoCliente() {
        initComponents();
        this.setLocationRelativeTo(null); 
    	getContentPane().setBackground(new Color(240, 248, 255));
    	setTitle("DogSchool - Nuevo cliente");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Bienvenida.class.getResource("/proyectoDogSchool/LOGO.png"))); 
    }
                       
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        txtApellido1 = new javax.swing.JTextField();
        lblApellido2 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        lblDni = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtPerro = new javax.swing.JTextField();
        lblPerro = new javax.swing.JLabel();
        txtRazaPerro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxDeporte = new javax.swing.JComboBox<>();
        comboBoxDeporte.setBackground(new Color(176, 196, 222));
        lblDeporte = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnConfirmar.setBackground(new Color(176, 196, 222));
        
        btnConfirmar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		confirmar();
        	}
        });
        btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAtras = new javax.swing.JButton();
        btnAtras.setForeground(new Color(255, 255, 255));
        btnAtras.setBackground(new Color(0, 0, 139));
        
        btnAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lblNombre.setText("Nombre");

        lblApellido1.setText("Primer apellido");

        lblApellido2.setText("Segundo Apellido");

        lblDni.setText("DNI");

        lblCorreo.setText("Correo");

        lblTelefono.setText("Teléfono");

        lblPerro.setText("Perro");

        jLabel2.setText("Raza de perro");

        comboBoxDeporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Obediencia", "Detección", "Agility", "ODU" }));

        lblDeporte.setText("Deporte");

        btnConfirmar.setText("Confirmar");

        btnAtras.setText("Atrás");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(250, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNombre)
        						.addComponent(lblApellido1)
        						.addComponent(lblApellido2)
        						.addComponent(lblDni)
        						.addComponent(lblCorreo)
        						.addComponent(lblTelefono)
        						.addComponent(lblPerro)
        						.addComponent(jLabel2)
        						.addComponent(lblDeporte))
        					.addGap(38)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(comboBoxDeporte, 0, 250, Short.MAX_VALUE)
        						.addComponent(txtRazaPerro)
        						.addComponent(txtPerro)
        						.addComponent(txtTelefono)
        						.addComponent(txtCorreo)
        						.addComponent(txtDni)
        						.addComponent(txtApellido2)
        						.addComponent(txtNombre)
        						.addComponent(txtApellido1)))
        				.addComponent(btnConfirmar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(96)
        			.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDni))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNombre)
        				.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblApellido1))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtApellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblApellido2))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblCorreo))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTelefono))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtPerro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblPerro))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtRazaPerro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboBoxDeporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDeporte))
        			.addGap(52)
        			.addComponent(btnConfirmar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(59, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(439, Short.MAX_VALUE)
        			.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
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
    	
    	if(txtDni.getText().isEmpty() || txtNombre.getText().isEmpty() || 
    			txtApellido1.getText().isEmpty() || txtApellido2.getText().isEmpty() || 
    			txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || 
    			txtPerro.getText().isEmpty() || txtRazaPerro.getText().isEmpty()){
    		
    		return false;
    	}
    	else return true;
    }
    
    private boolean validarDni(String dni) {
    	
    	Pattern pat = Pattern.compile("[0-9]{8}[ñÑA-Za-z]");
		Matcher mat = pat.matcher(dni);
    	if (dni.length() == 9 && mat.matches()) {
			return true;
		}
    	else return false;
    }
    
    private void confirmar() {
    	
    	try {
    		dni = txtDni.getText();
    		nombre = txtNombre.getText();
            apellido1 = txtApellido1.getText();
            apellido2 = txtApellido2.getText();
            correo = txtCorreo.getText();
            perro = txtPerro.getText();
            razaPerro = txtRazaPerro.getText();
            deporte = comboBoxDeporte.getSelectedItem().toString();
            
            if(!validarCampos()) 
            	JOptionPane.showMessageDialog(rootPane, "Ningún campo puede estar vacío");
            
            else if(!validarDni(txtDni.getText())) 
            	JOptionPane.showMessageDialog(rootPane, "El DNI no es válido. "
            			+ "Debe contener 8 caracteres seguidos de una letra");
            
            else if(!validarMail(correo)) 
               	JOptionPane.showMessageDialog(rootPane, "Correo electrónico incorrecto.");
            
            else if(!validarTelefono(txtTelefono.getText())) 
            	JOptionPane.showMessageDialog(rootPane, "El teléfono debe contener 9 caracteres numéricos.");
            
            else {
            
            	try {
                	telefono = Integer.parseInt(txtTelefono.getText());
                	
                    Configuration cfg = new Configuration().configure();
                    SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
                    Session session = sf.openSession();

                    Transaction tx = session.beginTransaction();

                    Clientes newCliente = new Clientes(dni.toUpperCase(), nombre, apellido1, apellido2,
                            correo.toLowerCase(), perro, razaPerro, deporte, telefono);

                    session.save(newCliente);
                    tx.commit();
                    session.close();
                    sf.close();

                    JOptionPane.showMessageDialog(rootPane, "Cliente creado");
                    dispose();
                }
            	catch(NumberFormatException e) {
            		JOptionPane.showMessageDialog(rootPane, "El teléfono debe contener 9 caracteres numéricos.");
            	}
                catch(Exception e){
                	JOptionPane.showMessageDialog(rootPane, "El cliente ya existe con ese DNI.");
                }
            }
            
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(rootPane, "Ningún campo puede estar vacío");
    	}
    }

    private String dni, nombre, apellido1, apellido2, correo, perro, razaPerro, deporte;
    private int telefono;
    
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<String> comboBoxDeporte;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDeporte;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPerro;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPerro;
    private javax.swing.JTextField txtRazaPerro;
    private javax.swing.JTextField txtTelefono;               
}