package proyectoDogSchool;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author candi
 */
public class Registro extends javax.swing.JFrame {

    public Registro() {
    	initComponents();
    	this.setLocationRelativeTo(null); 
    	getContentPane().setBackground(new Color(240, 248, 255));
    	setTitle("DogSchool - Registro");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/proyectoDogSchool/LOGO.png")));
    	setResizable(false);
    }
                             
    private void initComponents() {

        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelContrasenia1 = new javax.swing.JLabel();
        jTextFieldContrasenia1 = new javax.swing.JTextField();
        jLabelContrasenia2 = new javax.swing.JLabel();
        jTextFieldContrasenia2 = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonConfirmar.setBackground(new Color(176, 196, 222));
        jButtonAtras = new javax.swing.JButton();
        jButtonAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonAtras.setForeground(new Color(255, 255, 255));
        jButtonAtras.setBackground(new Color(0, 0, 139));
        jComboBoxPregunta = new javax.swing.JComboBox<>();
        jComboBoxPregunta.setBackground(new Color(176, 196, 222));
        jTextFieldPregunta = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido1 = new javax.swing.JLabel();
        jLabelApellido2 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido1 = new javax.swing.JTextField();
        jTextFieldApellido2 = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        jTextFieldMail = new javax.swing.JTextField();
        jLabelPregunta = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelContrasenia1.setText("Contraseña");

        jLabelContrasenia2.setText("Confirma tu contraseña");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmar();
            }
        });

        jButtonAtras.setText("Atrás");
        jButtonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAtrasMouseClicked(evt);
            }
        });

        jComboBoxPregunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre de primera mascota", "Segundo apellido materno", "Lugar de nacimiento" }));

        jLabelNombre.setText("Nombre");

        jLabelApellido1.setText("Primer apellido");

        jLabelApellido2.setText("Segundo apellido");

        jLabelMail.setText("Correo electrónico");

        jLabelPregunta.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabelPregunta.setText("Selecciona una pregunta de seguridad y su respuesta ante una posible futura recuperación de contraseña");

        jLabelTelefono.setText("Teléfono");
        
        lblDeporte = new JLabel("Deporte");
        
       
        comboBoxDeporte.setModel(new DefaultComboBoxModel(new String[] {"Obediencia", "Detecci\u00F3n", "Agility", "ODU"}));
        comboBoxDeporte.setBackground(new Color(176, 196, 222));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(302)
        			.addComponent(jButtonConfirmar, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
        			.addComponent(jButtonAtras, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(259, Short.MAX_VALUE)
        			.addComponent(jLabelPregunta)
        			.addGap(205))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(191, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblDeporte, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(jComboBoxPregunta, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jTextFieldPregunta, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        							.addComponent(jLabelApellido1, Alignment.LEADING)
        							.addComponent(jLabelApellido2, Alignment.LEADING)
        							.addComponent(jLabelMail, Alignment.LEADING)
        							.addComponent(jLabelTelefono, Alignment.LEADING)
        							.addComponent(jLabelContrasenia1, Alignment.LEADING)
        							.addComponent(jLabelContrasenia2, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabelNombre, Alignment.LEADING))
        						.addGap(104)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(jTextFieldNombre)
        							.addComponent(jTextFieldApellido1)
        							.addComponent(jTextFieldApellido2)
        							.addComponent(jTextFieldMail)
        							.addComponent(jTextFieldTelefono)
        							.addComponent(jTextFieldContrasenia1)
        							.addComponent(jTextFieldContrasenia2, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        							.addComponent(comboBoxDeporte, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        			.addGap(145))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(80, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabelNombre)
        				.addComponent(jTextFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabelApellido1)
        				.addComponent(jTextFieldApellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(19)
        					.addComponent(jLabelApellido2))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(jTextFieldApellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabelMail)
        				.addComponent(jTextFieldMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabelTelefono)
        				.addComponent(jTextFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabelContrasenia1)
        				.addComponent(jTextFieldContrasenia1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabelContrasenia2)
        				.addComponent(jTextFieldContrasenia2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(19)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblDeporte)
        				.addComponent(comboBoxDeporte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jLabelPregunta)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jComboBoxPregunta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jTextFieldPregunta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonConfirmar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        					.addGap(31))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonAtras, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        getContentPane().setLayout(layout);

        pack();
    }                                                                                                                           

    private void jButtonAtrasMouseClicked(java.awt.event.MouseEvent evt) {                                          

        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }
    
    private Boolean validarMail(String mail) {
    	
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        String email = mail;
 
        Matcher mather = pattern.matcher(email);
 
        return mather.find();
    }
    
    private Boolean validarTelefono(String telefono) {
    	
    	return telefono.length() == 9;
    }

    private boolean validarCampos() {
    	
    	if(jTextFieldNombre.getText().isEmpty() || jTextFieldApellido1.getText().isEmpty() || 
    			jTextFieldApellido2.getText().isEmpty() || jTextFieldTelefono.getText().isEmpty() || 
    			jTextFieldMail.getText().isEmpty() || jTextFieldPregunta.getText().isEmpty()) 
    		return false;
    	
    	else return true;
    }
    
    private void confirmar() {
    	
    	try {
    		nombre = jTextFieldNombre.getText();
            apellido1 = jTextFieldApellido1.getText();
            apellido2 = jTextFieldApellido2.getText();
            correo = jTextFieldMail.getText();
            contrasenia = jTextFieldContrasenia1.getText();
            pregunta = jComboBoxPregunta.getSelectedItem().toString();
            respuesta = jTextFieldPregunta.getText();
            deporte = comboBoxDeporte.getSelectedItem().toString();
            
            if(!validarCampos()) 
            	JOptionPane.showMessageDialog(rootPane, "Ningún campo puede estar vacío");
            
            else if(!validarMail(jTextFieldMail.getText())) 
            	JOptionPane.showMessageDialog(rootPane, "Correo electrónico incorrecto.");
            
            else if(!jTextFieldContrasenia1.getText().equals(jTextFieldContrasenia2.getText())) 
            	JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden");
            
            else if(!validarTelefono(jTextFieldTelefono.getText())) 
            	JOptionPane.showMessageDialog(rootPane, "El teléfono debe contener 9 caracteres numéricos.");
            
            else {
            
            	try {
                	telefono = Integer.parseInt(jTextFieldTelefono.getText());
                	
                    String usuario = generaUsuario(limpiarAcentos(nombre),
                            limpiarAcentos(apellido1),
                            limpiarAcentos(apellido2));
                	
                    Configuration cfg = new Configuration().configure();
                    SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
                    Session session = sf.openSession();

                    Transaction tx = session.beginTransaction();

                    Usuarios newUsuario = new Usuarios(usuario, nombre, apellido1, apellido2,
                            correo.toLowerCase(), contrasenia, pregunta, respuesta, deporte, telefono);

                    session.save(newUsuario);
                    tx.commit();
                    session.close();
                    sf.close();

                    JOptionPane.showMessageDialog(rootPane, "Tu usuario es: " + usuario);
                    
                    InicioSesion inicSes = new InicioSesion();
                    inicSes.setVisible(true);
                    this.dispose();
                }
                catch(NumberFormatException e){
                	JOptionPane.showMessageDialog(rootPane, "El teléfono debe contener 9 caracteres numéricos.");
                	System.out.println(e);
                }
            }
            
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(rootPane, "Ningún campo puede estar vacío");
    	}
    }
    
    private String generaUsuario(String nombre, String apellido1, String apellido2){
        
        String resultado = "";
        
        resultado += nombre.charAt(0);
        
        char[] apel1 = apellido1.toCharArray();
        char[] apel2 = apellido2.toCharArray();

        if (apel1.length >= 6) 
            for (int i = 0; i < 6; i++) 
                resultado += apel1[i];            
            
        else {
            for (int i = 0; i < apel1.length; i++) 
                resultado += apel1[i];
            
            for (int i = 0; i <= (6-resultado.length()); i++)
                resultado += apel2[i];
        }
        
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();

		int cont = 0;
		
		for (int i = 0; i < result.size(); i++) {

			Usuarios usuarioLista = result.get(i);
			
			if (usuarioLista.getUsuario().equals(resultado) && cont==0) {
				cont++;
				resultado += cont;
			}
			else if(usuarioLista.getUsuario().equals(resultado) &&  cont>0) {
				cont++;
				resultado = resultado.replaceFirst(".$","");
				resultado+=cont;
			}
		}
		session.close();
		sf.close();

		return resultado;
    }
    
    private static String limpiarAcentos(String cadena) {
        
        String limpio = null;
        String valor = cadena.toUpperCase();

        limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);

        limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");

        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        limpio = limpio.toLowerCase();

        return limpio;
    }
  
    private String nombre, apellido1, apellido2, correo, contrasenia, pregunta, respuesta, deporte;
    private int telefono;
    
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxPregunta;
    private javax.swing.JLabel jLabelApellido1;
    private javax.swing.JLabel jLabelApellido2;
    private javax.swing.JLabel jLabelContrasenia1;
    private javax.swing.JLabel jLabelContrasenia2;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPregunta;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JTextField jTextFieldApellido1;
    private javax.swing.JTextField jTextFieldApellido2;
    private javax.swing.JTextField jTextFieldContrasenia1;
    private javax.swing.JTextField jTextFieldContrasenia2;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPregunta;
    private javax.swing.JTextField jTextFieldTelefono;
    private JLabel lblDeporte;
    private JComboBox comboBoxDeporte = new JComboBox();
}
