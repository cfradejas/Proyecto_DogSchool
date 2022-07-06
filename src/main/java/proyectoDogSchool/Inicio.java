package proyectoDogSchool;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;


/**
 *
 * @author candi
 */
public class Inicio extends javax.swing.JFrame {

    public Inicio() {
    	
    	initComponents();
    	this.setLocationRelativeTo(null); 
    	
    	getContentPane().setBackground(new Color(240, 248, 255));
    	getContentPane().setForeground(new Color(0, 0, 0));
    	
    	setTitle("DogSchool");
    	
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/proyectoDogSchool/LOGO.png")));
    	setResizable(false);  
    }
                        
    private void initComponents() {

        jButtonRegistrar = new javax.swing.JButton();
        jButtonRegistrar.setFont(new Font("Tahoma", Font.BOLD, 18));
        jButtonRegistrar.setBackground(new Color(176, 196, 222));
        jButtonIniciar = new javax.swing.JButton();
        jButtonIniciar.setFont(new Font("Tahoma", Font.BOLD, 18));
        jButtonIniciar.setBackground(new Color(176, 196, 222));
        jButtonSalir = new javax.swing.JButton();
        jButtonSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonSalir.setForeground(new Color(255, 255, 255));
        jButtonSalir.setBackground(new Color(0, 0, 139));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonRegistrar.setText("Registrarse");
        jButtonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistrarMouseClicked(evt);
            }
        });

        jButtonIniciar.setText("Iniciar sesión");
        jButtonIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonIniciarMouseClicked(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }                      

    private void jButtonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {                                              
        
        Registro registro = new Registro();
        registro.setVisible(true);
        this.dispose();
    }                                             

    private void jButtonIniciarMouseClicked(java.awt.event.MouseEvent evt) {                                            

        InicioSesion inicSes = new InicioSesion();
        inicSes.setVisible(true);
        this.dispose();
    }                                            

	private void jButtonSalirMouseClicked(java.awt.event.MouseEvent evt) {

		System.exit(0);
	}                                        

    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
                 
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonSalir;                  
}