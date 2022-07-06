package proyectoDogSchool;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class CalendarioPanel extends JPanel {
	
	public CalendarioPanel(String usuario) {
		this.usuario = usuario;
		
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		calendar.setBounds(10, 24, 421, 250);
		add(calendar);
		btnGuardar.setBackground(new Color(176, 196, 222));
		
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnGuardar();
			}
		});
		btnGuardar.setBounds(581, 331, 89, 40);
		btnGuardar.setVisible(false);
		add(btnGuardar);
		
		lblDiaInfo.setBounds(10, 309, 561, 14);
		lblDiaInfo.setVisible(false);
		lblDiaInfo.setHorizontalAlignment(0);
		add(lblDiaInfo);
		comboBoxDeporte.setBackground(new Color(176, 196, 222));
		
		comboBoxDeporte.setModel(new DefaultComboBoxModel(new String[] {"Obediencia", "Detecci\u00F3n", "Agility", "ODU"}));
		comboBoxDeporte.setBounds(441, 95, 229, 22);
		add(comboBoxDeporte);
		
		lblDeporte.setBounds(441, 70, 229, 14);
		lblDeporte.setHorizontalAlignment(0);
		add(lblDeporte);
		

		rdbtnTarde.setBounds(517, 163, 75, 23);
		rdbtnManiana.setBounds(517, 137, 75, 23);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnTarde);
		grupo.add(rdbtnManiana);
		
		add(rdbtnTarde);
		add(rdbtnManiana);
		btnBuscar.setBackground(new Color(176, 196, 222));
		
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBuscar();
			}
		});
		btnBuscar.setBounds(460, 193, 89, 42);
		add(btnBuscar);
		btnModificar.setBackground(new Color(176, 196, 222));
		
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnModificar();
			}
		});
		
		btnModificar.setBounds(581, 385, 89, 40);
		btnModificar.setVisible(false);
		btnModificar.setEnabled(false);
		add(btnModificar);
		btnBorrar.setBackground(new Color(176, 196, 222));
		
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBorrar();
			}
		});
		
		btnBorrar.setBounds(581, 438, 89, 40);
		btnBorrar.setVisible(false);
		btnBorrar.setEnabled(false);
		add(btnBorrar);
		txtInfoDia.setFont(new Font("Monospaced", Font.BOLD, 13));
		
		txtInfoDia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			    int max = 450;
			    if(txtInfoDia.getText().length() >= max) {
			        e.consume();
			        String shortened = txtInfoDia.getText().substring(0, max);
			        txtInfoDia.setText(shortened);
			    }
			}
		});
		
		scroll.setBounds(10, 328, 561, 150);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setVisible(false);
	    add(scroll);
	    
		txtInfoDia.setBounds(10, 328, 561, 150);
		txtInfoDia.setLineWrap(true);
		txtInfoDia.setWrapStyleWord(true);
		txtInfoDia.setVisible(false);
		
		btnCancelar.setBackground(new Color(176, 196, 222));
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCancelar();
			}
		});
		btnCancelar.setBounds(559, 193, 89, 42);
		add(btnCancelar);
	}
	
	private void mostrarElementos() {
		lblDiaInfo.setVisible(true);
		scroll.setVisible(true);
		txtInfoDia.setVisible(true);
		btnGuardar.setVisible(true);
		btnModificar.setVisible(true);
		btnBorrar.setVisible(true);
	}
	
	private void ocultarElementos() {
		
		lblDiaInfo.setVisible(false);
		txtInfoDia.setVisible(false);
		scroll.setVisible(false);
		btnGuardar.setVisible(false);
		btnModificar.setVisible(false);
		btnBorrar.setVisible(false);
	}
	
	private void btnCancelar() {
		
		calendar.setEnabled(true);
		ocultarElementos();
		txtInfoDia.setText("");
		cont = 0;
	}
	
	private void btnBuscar() {
		
		fecha = String.valueOf(calendar.getCalendar().get(Calendar.DAY_OF_MONTH)) + "_" +
				String.valueOf(calendar.getCalendar().get(Calendar.MARCH)) + "_" + 
				String.valueOf(calendar.getCalendar().get(Calendar.YEAR));
		
		if(rdbtnManiana.isSelected() || rdbtnTarde.isSelected()) {
			
			calendar.setEnabled(false);
			mostrarElementos();
			
			if(rdbtnManiana.isSelected()) maniana_tarde = "Mañana";
			else if(rdbtnTarde.isSelected()) maniana_tarde = "Tarde";
			
			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sf.openSession();

			List<Calendario> result = session.createQuery("FROM Calendario", Calendario.class).getResultList();

			for (int i = 0; i < result.size(); i++) {
				Calendario calendarioLista = result.get(i);
				if((calendarioLista.getDeporte().equals(comboBoxDeporte.getSelectedItem().toString())) && 
						(calendarioLista.getFecha().equals(fecha)) && 
						(calendarioLista.getManiana_tarde().equals(maniana_tarde))) {
					btnGuardar.setEnabled(false);
					btnBorrar.setEnabled(true);
					btnModificar.setEnabled(true);
					txtInfoDia.setEnabled(false);
					txtInfoDia.setText(calendarioLista.getInfoDia());
					cont = 0;
					break;
				}else {
					btnGuardar.setEnabled(true);
					btnBorrar.setEnabled(false);
					btnModificar.setEnabled(false);
					txtInfoDia.setEnabled(true);
					txtInfoDia.setText("");
					cont = 0;
				}
			}
			session.close();
			sf.close();
		}else JOptionPane.showMessageDialog(this, "Debes seleccionar mañana o tarde.");
	}
	
	private void btnGuardar() {
		
		fecha = String.valueOf(calendar.getCalendar().get(Calendar.DAY_OF_MONTH)) + "_" +
				String.valueOf(calendar.getCalendar().get(Calendar.MARCH)) + "_" + 
				String.valueOf(calendar.getCalendar().get(Calendar.YEAR));
		
		if(rdbtnManiana.isSelected()) maniana_tarde = "Mañana";
		else maniana_tarde = "Tarde";
		
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		String texto = usuario + ": \n" + txtInfoDia.getText();
		
		Calendario newCalendario = new Calendario(comboBoxDeporte.getSelectedItem().toString(),
				fecha, maniana_tarde, texto, usuario);
		
		session.save(newCalendario);
		tx.commit();
		session.close();
		sf.close();
		calendar.setEnabled(true);
		ocultarElementos();
		JOptionPane.showMessageDialog(getRootPane(), "Cita guardada.");
	}
	
	private void btnBorrar() {

		int resp = JOptionPane.showConfirmDialog(null, "¿Estás seguro de querer borrar esta cita?", "¡Alerta!",
				JOptionPane.YES_NO_OPTION);

		if (resp == JOptionPane.YES_NO_OPTION) {

			fecha = String.valueOf(calendar.getCalendar().get(Calendar.DAY_OF_MONTH)) + "_"
					+ String.valueOf(calendar.getCalendar().get(Calendar.MARCH)) + "_"
					+ String.valueOf(calendar.getCalendar().get(Calendar.YEAR));

			if (rdbtnManiana.isSelected()) maniana_tarde = "Mañana";
			else maniana_tarde = "Tarde";

			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();

			List<Calendario> result = session.createQuery("FROM Calendario", Calendario.class).getResultList();

			for (int i = 0; i < result.size(); i++) {

				Calendario calendarioLista = result.get(i);
				if (calendarioLista.getDeporte().equals(comboBoxDeporte.getSelectedItem().toString())
						&& (calendarioLista.getFecha().equals(fecha)
								&& calendarioLista.getManiana_tarde().equals(maniana_tarde))) {
					session.delete(calendarioLista);
					tx.commit();
					JOptionPane.showMessageDialog(getRootPane(), "Cita borrada.");
					ocultarElementos();
					txtInfoDia.setText("");
					txtInfoDia.setEnabled(true);
					btnGuardar.setEnabled(true);
					btnModificar.setEnabled(false);
					btnBorrar.setEnabled(false);
					calendar.setEnabled(true);
					break;
				}
			}
			session.close();
			sf.close();
		}
	}
	
	private void btnModificar() {
		
		cont++;
		if(cont<2) txtInfoDia.setEnabled(true);
		else {
			
			Configuration cfg = new Configuration().configure();
			SessionFactory sf = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			List<Calendario> result = session.createQuery("FROM Calendario", Calendario.class).getResultList();
			
			for (int i = 0; i < result.size(); i++) {
				Calendario calendarioLista = result.get(i);
				if(calendarioLista.getDeporte().equals(comboBoxDeporte.getSelectedItem().toString()) && 
						(calendarioLista.getFecha().equals(fecha) && calendarioLista.getManiana_tarde().equals(maniana_tarde))) {

					calendarioLista.setInfoDia(txtInfoDia.getText() + " (Modificado por: " + usuario + ")");
					session.save(calendarioLista);
					tx.commit();
					break;
				}
			}
			session.close();
			sf.close();
			ocultarElementos();
			txtInfoDia.setText("");
			txtInfoDia.setEnabled(true);
			JOptionPane.showMessageDialog(getRootPane(), "Cita modificada.");
			cont = 0;
			btnGuardar.setEnabled(true);
			calendar.setEnabled(true);
		}
	}
	
	private JCalendar calendar = new JCalendar();
	private JButton btnGuardar = new JButton("Guardar");
	private JLabel lblDiaInfo = new JLabel("Informaci\u00F3n del d\u00EDa seleccionado:");
	private JComboBox comboBoxDeporte = new JComboBox();
	private JLabel lblDeporte = new JLabel("Actividad");
	private JRadioButton rdbtnTarde = new JRadioButton("Tarde");
	private JRadioButton rdbtnManiana = new JRadioButton("Ma\u00F1ana");
	private final JButton btnBuscar = new JButton("Buscar");
	private final JButton btnModificar = new JButton("Modificar");
	private final JButton btnBorrar = new JButton("Borrar");
	private JTextArea txtInfoDia = new JTextArea();
	private JButton btnCancelar = new JButton("Cancelar");
	private JScrollPane scroll = new JScrollPane (txtInfoDia);
	private String usuario;
	private int cont;
	private String fecha;
	private String maniana_tarde;
}