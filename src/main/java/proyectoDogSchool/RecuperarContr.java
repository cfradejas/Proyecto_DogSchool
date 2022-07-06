package proyectoDogSchool;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Dimension;

/**
 *
 * @author candi
 */
public class RecuperarContr extends javax.swing.JFrame {
	
    public RecuperarContr() {
    	getContentPane().setPreferredSize(new Dimension(903, 635));
    	getContentPane().setSize(new Dimension(903, 635));
    	setSize(new Dimension(903, 635));
    	initComponents();
    	this.setLocationRelativeTo(null); 
    	getContentPane().setBackground(new Color(240, 248, 255));
    	setTitle("DogSchool - Recuperar contrase\u00F1a");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(RecuperarContr.class.getResource("/proyectoDogSchool/LOGO.png")));
    	setResizable(false);
    }
                         
	private void initComponents() {
    	
		jLabelUsuario = new javax.swing.JLabel();
		jLabelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPregunta = new javax.swing.JLabel();
		jLabelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldUsuario = new javax.swing.JTextField();
		jTextFieldPregunta = new javax.swing.JTextField();
		jTextFieldPregunta.setEnabled(false);
		jLabelNuevaCont = new javax.swing.JLabel();
		jLabelNuevaCont.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldNuevaCont = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldNuevaCont1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton1.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButton1.setForeground(new Color(255, 255, 255));
		jButton1.setBackground(new Color(0, 0, 139));
		jButtonConfirmar = new javax.swing.JButton();
		jButtonConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		jButtonConfirmar.setBackground(new Color(176, 196, 222));
		
		jButtonConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConfirmar();
			}
		});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUsuario.setText("Usuario");

        jLabelPregunta.setText("      ");

        jLabelNuevaCont.setText("Nueva contraseña");

        jLabel1.setText("Confirma tu nueva contraseña");

        jButton1.setText("Atrás");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        
        btnPregunta.setBackground(new Color(176, 196, 222));
        btnPregunta.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		btnPreguntar();
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(292)
        					.addComponent(jButtonConfirmar, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(320)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(jTextFieldNuevaCont, Alignment.LEADING)
        						.addComponent(jLabel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jTextFieldNuevaCont1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        						.addComponent(jLabelNuevaCont, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jTextFieldPregunta, Alignment.LEADING)
        						.addComponent(btnPregunta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jLabelUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jTextFieldUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(161)
        					.addComponent(jLabelPregunta, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(197, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(787, Short.MAX_VALUE)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(74, Short.MAX_VALUE)
        			.addComponent(jLabelUsuario)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(26)
        			.addComponent(btnPregunta, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        			.addGap(40)
        			.addComponent(jLabelPregunta)
        			.addGap(18)
        			.addComponent(jTextFieldPregunta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(38)
        			.addComponent(jLabelNuevaCont)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jTextFieldNuevaCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(33)
        			.addComponent(jLabel1)
        			.addGap(9)
        			.addComponent(jTextFieldNuevaCont1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(43)
        			.addComponent(jButtonConfirmar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }                                                                   

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        
        InicioSesion inicioSesion = new InicioSesion();
        inicioSesion.setVisible(true);
        this.dispose();
    }                                     

    private void btnPreguntar() {
    	
    	Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();

		for(int i=0; i<result.size(); i++) {
			
			Usuarios usuarioLista = result.get(i);
			if(usuarioLista.getUsuario().equals(jTextFieldUsuario.getText())) {
				
				jLabelPregunta.setForeground(Color.DARK_GRAY);
				jLabelPregunta.setText(usuarioLista.getPregunta());
				jTextFieldPregunta.setEnabled(true);
				jTextFieldUsuario.setEnabled(false);
				break;
			}
			else {
				jLabelPregunta.setForeground(Color.RED);
				jLabelPregunta.setText("El usuario indicado no está registrado. Prueba de nuevo.");
				jTextFieldPregunta.setEnabled(false);
			}
			session.close();
			sf.close();
		}
    }
    
    private void btnConfirmar() {
    	Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		List<Usuarios> result = session.createQuery("FROM Usuarios", Usuarios.class).getResultList();

		for (int i = 0; i < result.size(); i++) {

			Usuarios usuarioLista = result.get(i);
			
			if (usuarioLista.getUsuario().equals(jTextFieldUsuario.getText())) {

				if (jTextFieldNuevaCont.getText().equals(jTextFieldNuevaCont1.getText())
						&& jTextFieldPregunta.getText().equals(usuarioLista.getRespuesta())) {

					usuarioLista = session.get(Usuarios.class, usuarioLista.getUsuario());
					usuarioLista.setContrasenia(jTextFieldNuevaCont.getText());
					session.save(usuarioLista);
					tx.commit();

					JOptionPane.showMessageDialog(rootPane, "Contraseña actualizada.");
					
					InicioSesion inicSes = new InicioSesion();
			        inicSes.setVisible(true);
			        dispose();
				}else if (!jTextFieldPregunta.getText().equals(usuarioLista.getRespuesta())) 
					JOptionPane.showMessageDialog(rootPane, "Pregunta de seguridad no pasada.");
				
				else if (!jTextFieldNuevaCont.getText().equals(jTextFieldNuevaCont1.getText())) 
					JOptionPane.showMessageDialog(rootPane, "Error. Las contraseñas no coinciden.");
				
				break;
			}
		}
		session.close();
		sf.close();
    }
                   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNuevaCont;
    private javax.swing.JLabel jLabelPregunta;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextFieldNuevaCont;
    private javax.swing.JTextField jTextFieldNuevaCont1;
    private javax.swing.JTextField jTextFieldPregunta;
    private javax.swing.JTextField jTextFieldUsuario;
    private JButton btnPregunta = new JButton("Habilitar pregunta de seguridad");
}