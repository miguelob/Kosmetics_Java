package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class PantallaCrearUsuario_2 extends JFrame {
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCrearUsuario_2 frame = new PantallaCrearUsuario_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PantallaCrearUsuario_2() throws HeadlessException {
		this.setSize(500,600);
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
		
		JLabel lblJoinNow = new JLabel("<html>We're almost done! <br> Tell us a bit about yourself<html>");
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
		
		JLabel lblEmail = new JLabel("First, what's your skintone?");
		lblEmail.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelEmail.add(lblEmail, BorderLayout.NORTH);
		
		String[] SkinTonechoices = { "Light","Medium", "Tan"};
		JComboBox<String> cbSkinTones = new JComboBox<String>(SkinTonechoices);
		cbSkinTones.setFocusable(false);
		cbSkinTones.setBackground(Color.WHITE);
		cbSkinTones.setRenderer(new TwoDecimalRenderer(cbSkinTones.getRenderer()));
		panelEmail.add(cbSkinTones, BorderLayout.SOUTH);
		
		//Panel to repeat the password
		//It also contains a button to join
		JPanel panelUsername = new JPanel();
		panelUsername.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelUsername.setBackground(Color.WHITE);
		panel_2.add(panelUsername);
		panelUsername.setLayout(new BorderLayout(5, 15));
			
		JLabel lblUsername = new JLabel("What's your skin condition?");
		lblUsername.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelUsername.add(lblUsername, BorderLayout.NORTH);
				
				
		String[] SkinConditionchoices = { "Dry","Mixed", "Oily"};
		JComboBox<String> cbSkinConditions = new JComboBox<String>(SkinConditionchoices);
		cbSkinConditions.setBackground(Color.WHITE);
		cbSkinConditions.setFocusable(false);
		cbSkinConditions.setRenderer(new TwoDecimalRenderer(cbSkinTones.getRenderer()));
		panelUsername.add(cbSkinConditions, BorderLayout.SOUTH);
		
		//Panel with a text field to write down the password
		JPanel panelPassword = new JPanel();
		panelPassword.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelPassword.setBackground(Color.WHITE);
		panel_2.add(panelPassword);
		panelPassword.setLayout(new BorderLayout(0, 0));
			
		JLabel lblPassword = new JLabel("And finaly, what is your date of birth?");
		lblPassword.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelPassword.add(lblPassword, BorderLayout.NORTH);
				
				
		JTextField txtPassword = new JTextField();
		panelPassword.add(txtPassword, BorderLayout.SOUTH);
		
		
		//Panel to go join or login if you already have an account
		
		JPanel panelJoin = new JPanel();
		panelJoin.setBorder(new MatteBorder(10, 10, 20, 10, (Color) new Color(255, 255, 255)));
		panelJoin.setBackground(Color.WHITE);
		panel_2.add(panelJoin);		
		panelJoin.setLayout(new BorderLayout(0,10));
		
		JButton btnJoin = new JButton("<html> Start! <html>");
		btnJoin.setBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(255, 153, 153)));
		btnJoin.setFont(GUIConstants.FONT_REGULAR_BOLD);
		btnJoin.setForeground(Color.WHITE);
		btnJoin.setBackground(new Color(255, 153, 153));
		btnJoin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelJoin.add(btnJoin, BorderLayout.NORTH);
		


	}

	

}
