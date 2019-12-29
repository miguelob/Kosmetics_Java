package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class PantallaLogin extends JFrame {

	public PantallaLogin() throws HeadlessException {
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
		
		//Big Panel including the text: "Hi, sister!"
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 30, 20, 30, (Color) new Color(255, 255, 255)));
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHiSister = new JLabel("Hi, sister!");
		lblHiSister.setBorder(new MatteBorder(1, 1, 50, 1, (Color) Color.WHITE));
		lblHiSister.setHorizontalAlignment(SwingConstants.CENTER);
		lblHiSister.setFont(GUIConstants.FONT_TITLE);
		panel_1.add(lblHiSister, BorderLayout.NORTH);
		
		//Big Panel including the text field for the email and password
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 80, 80));
		
		//Panel with a text field to write down the email
		JPanel panelEmail = new JPanel();
		panelEmail.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelEmail.setBackground(Color.WHITE);
		panel_2.add(panelEmail);
		panelEmail.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEmail = new JLabel("Enter your username or E-mail address");
		lblEmail.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelEmail.add(lblEmail, BorderLayout.NORTH);
		
		
		JTextField txtEmail = new JTextField("  someone@example.com");
		txtEmail.setMinimumSize(new Dimension(7, 25));
		txtEmail.setForeground(Color.GRAY);
		txtEmail.addMouseListener(new MouseAdapter()
        { @Override
	           public void mouseClicked(MouseEvent me)
	             { txtEmail.setText("");

	             }
			 });

		panelEmail.add(txtEmail, BorderLayout.SOUTH);
		
		// //Panel to write the username
		// JPanel panelUsername = new JPanel();
		// panelUsername.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		// panelUsername.setBackground(Color.WHITE);
		// panel_2.add(panelUsername);
		// panelUsername.setLayout(new BorderLayout(5, 15));
			
		// JLabel lblUsername = new JLabel("Username");
		// lblUsername.setFont(GUIConstants.FONT_REGULAR_BOLD);
		// panelUsername.add(lblUsername, BorderLayout.NORTH);
				
				
		// JTextField txtUsername = new JTextField("  @ e.g MissContour123");
		// txtUsername.setForeground(Color.GRAY);
		// txtUsername.setMinimumSize(new Dimension(7, 30));
		// txtUsername.addMouseListener(new MouseAdapter()
        // { @Override
	    //        public void mouseClicked(MouseEvent me)
	    //          { txtUsername.setText("");

	    //          }
	    //      });
		// panelUsername.add(txtUsername, BorderLayout.SOUTH);
		
		//Panel with a text field to write down the password
		JPanel panelPassword = new JPanel();
		panelPassword.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelPassword.setBackground(Color.WHITE);
		panel_2.add(panelPassword);
		panelPassword.setLayout(new BorderLayout(0, 0));
			
		JLabel lblPassword = new JLabel("Enter your password");
		lblPassword.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelPassword.add(lblPassword, BorderLayout.NORTH);
				
				
		JPasswordField txtPassword = new JPasswordField();
		panelPassword.add(txtPassword, BorderLayout.SOUTH);

		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke){
			if (e.getKeyCode() == KeyEvent.VK_TAB){
				txtPassword.setText("");
			}
		}
			
		});
		
		
		//Panel to go join or login if you already have an account
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new MatteBorder(10, 10, 20, 10, (Color) new Color(255, 255, 255)));
		panelLogin.setBackground(Color.WHITE);
		panel_2.add(panelLogin);		
		panelLogin.setLayout(new BorderLayout(0,10));
		
		JButton btnLogin = new JButton("<html> Login <html>");
		btnLogin.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(255, 153, 153)));
		btnLogin.setFont(GUIConstants.FONT_REGULAR_BOLD);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(255, 153, 153));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				PantallaLogin.this.dispose();
				JFrame pantallaActual = new ScreenViewProfile();
				GUIConstants.PANTALLA_ACTUAL = pantallaActual;
				pantallaActual.setVisible(true);
			}
		});
		panelLogin.add(btnLogin, BorderLayout.NORTH);
		
		//Subpanel to join if you already have an account
		JPanel panelRegister = new JPanel();
		panelRegister.setBackground(Color.WHITE);
		panelLogin.add(panelRegister, BorderLayout.SOUTH);
		panelRegister.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
		JLabel lblLogin = new JLabel("Don't have an account yet?");
		panelRegister.add(lblLogin);
		
		JButton btnRegister = new JButton("<html> <u> Register <u> <html>");
		btnRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegister.setForeground(new Color(255, 153, 153));
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorder(BorderFactory.createEmptyBorder());
		btnRegister.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
				{ 	JFrame pantallaActual = new PantallaCrearUsuario();
					GUIConstants.PANTALLA_ACTUAL = pantallaActual;
					PantallaLogin.this.dispose();
					pantallaActual.setVisible(true);

				}
		});
		panelRegister.add(btnRegister);

		
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
