/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoDogSchool;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;

/**
 *
 * @author candi
 */
public class Bienvenida extends javax.swing.JFrame {

    public Bienvenida(String usuario) {
    	this.usuario = usuario;
    	initComponents();
    	this.setLocationRelativeTo(null); 
    	getContentPane().setBackground(new Color(240, 248, 255));
    	setTitle("DogSchool");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Bienvenida.class.getResource("/proyectoDogSchool/LOGO.png"))); 
    }
                         
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(240, 248, 255));
        
        jButtonClien = new javax.swing.JButton();
        jButtonClien.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		jButtonClien.setBackground(new Color(110, 197, 255));
        		jButtonCalen.setBackground(new Color(176,196,222));
        		jButtonUsuar.setBackground(new Color(176,196,222));
        		ClientesPanel clientesPanel = new ClientesPanel();
        		nuevoPanel(clientesPanel);
        	}
        });
        jButtonClien.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonClien.setBackground(new Color(176, 196, 222));
        
        jButtonCalen = new javax.swing.JButton();
        jButtonCalen.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		jButtonCalen.setBackground(new Color(110, 197, 255));
        		jButtonUsuar.setBackground(new Color(176,196,222));
        		jButtonClien.setBackground(new Color(176,196,222));
        		CalendarioPanel calendarioPanel = new CalendarioPanel(usuario);
        		nuevoPanel(calendarioPanel);
        	}
        });
        jButtonCalen.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonCalen.setBackground(new Color(176, 196, 222));
        
        jButtonUsuar = new javax.swing.JButton();
        jButtonUsuar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		jButtonUsuar.setBackground(new Color(110, 197, 255));
        		jButtonCalen.setBackground(new Color(176,196,222));
        		jButtonClien.setBackground(new Color(176,196,222));
        		UsuariosPanel usuariosPanel = new UsuariosPanel(usuario);
        		nuevoPanel(usuariosPanel);
        	}
        });
        jButtonUsuar.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonUsuar.setBackground(new Color(176, 196, 222));
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBorder(new LineBorder(new Color(110, 197, 255), 2, true));
        jPanel2.setBackground(new Color(240, 248, 255));
        
        jButtonAtras = new javax.swing.JButton();
        jButtonAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        jButtonAtras.setForeground(new Color(255, 255, 255));
        jButtonAtras.setBackground(new Color(0, 0, 139));
        jButtonAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {       		
        		cerrarSesion();
        	}
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(180, 480));

        jButtonClien.setText("Clientes");
        jButtonCalen.setText("Calendario");
        jButtonUsuar.setText("Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCalen, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jButtonUsuar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUsuar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonClien, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCalen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonAtras.setText("Cerrar sesi\u00F3n");
        jButtonAtras.setPreferredSize(new java.awt.Dimension(115, 46));
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(Bienvenida.class.getResource("/proyectoDogSchool/Logo tra.png")));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel)
        					.addGap(18)
        					.addComponent(jButtonAtras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jButtonAtras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(30)))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 489, Short.MAX_VALUE))
        			.addGap(14))
        );
        jPanel2.setLayout(new CardLayout(0, 0));
        getContentPane().setLayout(layout);
        pack();
    }
    
    private void nuevoPanel(JPanel panelActual) {
    	
    	jPanel2.removeAll();
    	jPanel2.add(panelActual);
    	jPanel2.repaint();
    	jPanel2.revalidate();
    }
    
    private void cerrarSesion() {
		Inicio inicio = new Inicio();
        inicio.setVisible(true);
        this.dispose();
    }
                  
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonCalen;
    private javax.swing.JButton jButtonClien;
    private javax.swing.JButton jButtonUsuar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private String usuario;
}