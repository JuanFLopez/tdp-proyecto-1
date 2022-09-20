package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblNewLabel;
	private JTextField Legajo;
	private JTextField Apellido;
	private JTextField Nombre;
	private JTextField Mail;
	private JTextField gitURL;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentaci�n");
		try {
			Image icon = ImageIO.read(getClass().getResourceAsStream("/images/tdp.png"));
			setIconImage(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		
		
		lblNewLabel = new JLabel("LU");
		lblNewLabel.setBounds(10, 11, 24, 14);
		tabInformation.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		tabInformation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 74, 46, 14);
		tabInformation.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setBounds(10, 108, 46, 14);
		tabInformation.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Github URL");
		lblNewLabel_4.setBounds(10, 141, 63, 14);
		tabInformation.add(lblNewLabel_4);
		
		Legajo = new JTextField();
		Legajo.setText(studentData.getId()+"");
		Legajo.setBounds(66, 8, 349, 20);
		tabInformation.add(Legajo);
		Legajo.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setText(studentData.getLastName());
		Apellido.setBounds(66, 33, 349, 20);
		tabInformation.add(Apellido);
		Apellido.setColumns(10);
		
		Nombre = new JTextField();
		Nombre.setText(studentData.getFirstName());
		Nombre.setBounds(66, 71, 349, 20);
		tabInformation.add(Nombre);
		Nombre.setColumns(10);
		
		Mail = new JTextField();
		Mail.setText(studentData.getMail());
		Mail.setBounds(66, 105, 349, 20);
		tabInformation.add(Mail);
		Mail.setColumns(10);
		
		gitURL = new JTextField();
		gitURL.setText(studentData.getGithubURL());
		gitURL.setBounds(76, 138, 339, 20);
		tabInformation.add(gitURL);
		gitURL.setColumns(10);
		
		Calendar fecha = new GregorianCalendar();
		String anho = Integer.toString(fecha.get(Calendar.YEAR));
		String mes  = Integer.toString(fecha.get(Calendar.MONTH)+1);
		String dia  = Integer.toString(fecha.get(Calendar.DATE));		
		
		String fechacompleta= dia+"/"+mes+"/"+anho;
		
		String hora = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
		String minuto = Integer.toString(fecha.get(Calendar.MINUTE));
		
		String horacompleta= hora+":"+minuto;
		
		JLabel fecha_hora_ejecucion = new JLabel("La ventana fue creada el dia "+fechacompleta+" a las "+horacompleta);
		fecha_hora_ejecucion.setBounds(10, 158, 405, 14);
		tabInformation.add(fecha_hora_ejecucion);
		contentPane.add(tabbedPane);
		
		JLabel Avatar_personal = new JLabel("");
		Avatar_personal.setVerticalAlignment(SwingConstants.TOP);
		Avatar_personal.setHorizontalAlignment(SwingConstants.CENTER);
		try {
			Image avatar= ImageIO.read(getClass().getResourceAsStream(studentData.getPathPhoto()));
			Avatar_personal.setIcon(new ImageIcon(avatar));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		Avatar_personal.setBounds(441, 28, 158, 159);
	
		contentPane.add(Avatar_personal);
	}
}
