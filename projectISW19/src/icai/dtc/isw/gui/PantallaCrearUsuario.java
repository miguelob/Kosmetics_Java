package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class PantallaCrearUsuario extends JFrame {

	public PantallaCrearUsuario() throws HeadlessException {
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 30, 1, 30, (Color) Color.WHITE));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.NORTH);
		

		//Kosmetic's logo
		ImageIcon logo = Images.resize(new ImageIcon("media/icons/Main_Logo.png"), 50, 50);
		JLabel lblLogo = new JLabel(logo);
		panel.add(lblLogo);
		JLabel lblBrandName = new JLabel("Kosmetics.");
		lblBrandName.setFont(GUIConstants.FONT_MEDIUM_TITLE);
		panel.add(lblBrandName);
		
		//Big Panel including the text: "Join now, it's free!"
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 30, 20, 30, (Color) new Color(255, 255, 255)));
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblJoinNow = new JLabel("Join now, it's free!");
		lblJoinNow.setBorder(new MatteBorder(1, 1, 10, 1, (Color) Color.WHITE));
		lblJoinNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinNow.setFont(GUIConstants.FONT_TITLE);
		panel_1.add(lblJoinNow, BorderLayout.NORTH);
		
		//Big Panel including the text field for the email and passwords
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 5, 5));
		
		//Panel with a text field to write down the email
		JPanel panelEmail = new JPanel();
		panelEmail.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelEmail.setBackground(Color.WHITE);
		panel_2.add(panelEmail);
		panelEmail.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEmail = new JLabel("E-mail address");
		lblEmail.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelEmail.add(lblEmail, BorderLayout.NORTH);
		
		
		JTextField txtEmail = new JTextField("  someone@example.com");
		txtEmail.setMinimumSize(new Dimension(7, 25));
		txtEmail.setForeground(Color.GRAY);
		panelEmail.add(txtEmail, BorderLayout.SOUTH);
		
		//Panel to repeat the password
		//It also contains a button to join
		JPanel panelUsername = new JPanel();
		panelUsername.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelUsername.setBackground(Color.WHITE);
		panel_2.add(panelUsername);
		panelUsername.setLayout(new BorderLayout(5, 15));
			
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelUsername.add(lblUsername, BorderLayout.NORTH);
				
				
		JTextField txtUsername = new JTextField("  @ e.g MissContour123");
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setMinimumSize(new Dimension(7, 30));
		panelUsername.add(txtUsername, BorderLayout.SOUTH);
		
		//Panel with a text field to write down the password
		JPanel panelPassword = new JPanel();
		panelPassword.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelPassword.setBackground(Color.WHITE);
		panel_2.add(panelPassword);
		panelPassword.setLayout(new BorderLayout(0, 0));
			
		JLabel lblPassword = new JLabel("Create a password");
		lblPassword.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelPassword.add(lblPassword, BorderLayout.NORTH);
				
				
		JTextField txtPassword = new JTextField();
		panelPassword.add(txtPassword, BorderLayout.SOUTH);
		
		//Panel to repeat the password
		JPanel panelPassword_2 = new JPanel();
		panelPassword_2.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelPassword_2.setBackground(Color.WHITE);
		panel_2.add(panelPassword_2);
		panelPassword_2.setLayout(new BorderLayout(5, 15));
			
		JLabel lblPassword_2 = new JLabel("Repeat your password");
		lblPassword_2.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelPassword_2.add(lblPassword_2, BorderLayout.NORTH);
				
				
		JTextField txtPassword_2 = new JTextField();
		txtPassword_2.setMinimumSize(new Dimension(7, 30));
		panelPassword_2.add(txtPassword_2, BorderLayout.SOUTH);
		
		
		//Panel to go join or login if you already have an account
		
		JPanel panelJoin = new JPanel();
		panelJoin.setBorder(new MatteBorder(10, 10, 20, 10, (Color) new Color(255, 255, 255)));
		panelJoin.setBackground(Color.WHITE);
		panel_2.add(panelJoin);		
		panelJoin.setLayout(new BorderLayout(0,10));
		
		JButton btnJoin = new JButton("<html> Join <html>");
		btnJoin.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(255, 153, 153)));
		btnJoin.setFont(GUIConstants.FONT_REGULAR_BOLD);
		btnJoin.setForeground(Color.WHITE);
		btnJoin.setBackground(new Color(255, 153, 153));
		btnJoin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJoin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				PantallaCrearUsuario.this.dispose();
				JFrame pantallaActual = new PantallaCrearUsuario_2();
				GUIConstants.PANTALLA_ACTUAL = pantallaActual;
				pantallaActual.setVisible(true);
			}
		});
		panelJoin.add(btnJoin, BorderLayout.NORTH);
		
		//Subpanel to join if you already have an account
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		panelJoin.add(panelLogin, BorderLayout.SOUTH);
		panelLogin.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		JLabel lblLogin = new JLabel("Already have an account?");
		panelLogin.add(lblLogin);
		
		JButton btnLogin = new JButton("<html> <u> Log in <u> <html>");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(255, 153, 153));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(BorderFactory.createEmptyBorder());
		btnLogin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
				{ 	JFrame pantallaActual = new PantallaLogin();
					GUIConstants.PANTALLA_ACTUAL = pantallaActual;
					PantallaCrearUsuario.this.dispose();
					pantallaActual.setVisible(true);

				}
		});
		panelLogin.add(btnLogin);

		
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCrearUsuario frame = new PantallaCrearUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
