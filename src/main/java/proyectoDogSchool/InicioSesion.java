package proyectoDogSchool;
import javax.swing.AbstractAction;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.List;
import java.util.Map;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Toolkit;
import java.awt.Color;
/**
 *
 * @author candi
 */
public class InicioSesion extends javax.swing.JFrame {

    public InicioSesion() {
    	initComponents();
    	this.setLocationRelativeTo(null); 
    	getContentPane().setBackground(new Color(240, 248, 255));
    	setTitle("DogSchool - Inicio de sesi\u00F3n");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(InicioSesion.class.getResource("/proyectoDogSchool/LOGO.png")));
    	setResizable(false);
    }
                         
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelContrasenia = new javax.swing.JLabel();
        jTextFieldContrasenia = new javax.swing.JTextField();
        jButtonIniciar = new javax.swing.JButton();
        jButtonIniciar.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonIniciar.setBackground(new Color(176, 196, 222));
        
        //BOTÓN INICIAR
        jButtonIniciar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		 btnIniciar(); 
        	}	
        });
        jButtonAtras = new javax.swing.JButton();
        jButtonAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonAtras.setForeground(new Color(255, 255, 255));
        jButtonAtras.setBackground(new Color(0, 0, 139));
        jLabelOlvido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));

        jLabelUsuario.setText("Usuario");

        jLabelContrasenia.setText("Contraseña");

        jButtonIniciar.setText("Iniciar sesión");

        jButtonAtras.setText("Atrás");
        jButtonAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAtrasMouseClicked(evt);
            }
        });

        jLabelOlvido.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabelOlvido.setForeground(new java.awt.Color(0, 51, 255));
        jLabelOlvido.setText("He olvidado mi contrase\u00F1a");
        jLabelOlvido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelOlvidoMouseClicked(evt);
            }

            Font font = jLabelOlvido.getFont();
            Map attributes = font.getAttributes();
        	@Override
        	public void mouseEntered(MouseEvent e) {

        		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        		jLabelOlvido.setFont(font.deriveFont(attributes));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {

        		attributes.put(TextAttribute.UNDERLINE, -1);
        		jLabelOlvido.setFont(font.deriveFont(attributes));
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(213)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabelContrasenia)
        				.addComponent(jLabelUsuario))
        			.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jTextFieldContrasenia)
        				.addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
        			.addGap(145))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(270, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonIniciar, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
        					.addGap(301))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButtonAtras, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(523, Short.MAX_VALUE)
        			.addComponent(jLabelOlvido, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        			.addGap(193))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(176)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabelUsuario)
        				.addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(70)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabelContrasenia)
        				.addComponent(jTextFieldContrasenia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabelOlvido, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
        			.addComponent(jButtonIniciar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        			.addGap(7)
        			.addComponent(jButtonAtras, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }    
    
    private void btnIniciar() {
    	 Configuration cfg = new Configuration().configure();
	     SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
	     Session session = sf.openSession();   
	     
	     List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();
	             	     
	     for(int i=0; i<result.size(); i++) {
	    	 
	    	 Usuarios usuarioLista = result.get(i);
	    	 
	    	 if(jTextFieldUsuario.getText().equals(usuarioLista.getUsuario()) && 
	    		 jTextFieldContrasenia.getText().equals(usuarioLista.getContrasenia())) {
	    		 JOptionPane.showMessageDialog(rootPane, "Correcto");
	    		 session.close();
	    	     sf.close();
	    	     
	    	     Bienvenida bienvenida = new Bienvenida(usuarioLista.getUsuario());
	    	     bienvenida.setVisible(true);
	    	     dispose();
	    		 break;
	    	 }
	    	       	    	 
	    	 else 
	    		 if(i==result.size()-1) 
	    			 JOptionPane.showMessageDialog(rootPane, "Incorrecto, inténtalo de nuevo o pulsa en 'He olvidado "
 	         	     		+ "mi contraseña' para asignar una nueva");
	     }
	     session.close();
	     sf.close();   
    }

    private void jButtonAtrasMouseClicked(java.awt.event.MouseEvent evt) {                                          

        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }                                         

    private void jLabelOlvidoMouseClicked(java.awt.event.MouseEvent evt) {
    	
        RecuperarContr recuperarContr = new RecuperarContr();
        recuperarContr.setVisible(true);
        this.dispose();
    }
                   
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelOlvido;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextFieldContrasenia;
    private javax.swing.JTextField jTextFieldUsuario;
                
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
