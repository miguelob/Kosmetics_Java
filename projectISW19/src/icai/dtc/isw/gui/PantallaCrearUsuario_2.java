package icai.dtc.isw.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.User;

public class PantallaCrearUsuario_2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String skinTone = "LIGHT1";;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCrearUsuario_2 frame = new PantallaCrearUsuario_2(new User(null,null,null));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PantallaCrearUsuario_2(User user) throws HeadlessException {
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
		
		JLabel lblJoinNow = new JLabel("<html>We're almost done! <br> Tell us a bit about yourself<html>");
		lblJoinNow.setBorder(new MatteBorder(1, 1, 10, 1, (Color) Color.WHITE));
		lblJoinNow.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinNow.setFont(GUIConstants.FONT_TITLE);
		panel_1.add(lblJoinNow, BorderLayout.NORTH);
		
		//Big Panel including all the questions
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 5, 5));
		
		//Panel with a text field to write down the email
		JPanel panelEmail = new JPanel();
		panelEmail.setBackground(Color.WHITE);
		panel_2.add(panelEmail);
		panelEmail.setLayout(new BorderLayout(0, 10));
		
		JLabel lblEmail = new JLabel("First, what's your skintone?");
		lblEmail.setBorder(new MatteBorder(0, 0, 10, 0, Color.WHITE));
		lblEmail.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelEmail.add(lblEmail, BorderLayout.NORTH);
		
		JPanel panelSkinTones = new JPanel();
		panelEmail.add(panelSkinTones, BorderLayout.SOUTH);
		panelSkinTones.setLayout(new GridLayout(0,6, 5, 5));
		panelSkinTones.setBackground(Color.WHITE);
		ImageIcon imgLight1 = new ImageIcon("media/images/light1.png");
		JButton btnLight1 = new JButton(Images.resize(imgLight1,24,24));

		ImageIcon imgLight2 = new ImageIcon("media/images/light2.png");
		JButton btnLight2 = new JButton(Images.resize(imgLight2,24,24));

		ImageIcon imgLight3 = new ImageIcon("media/images/light3.png");
		JButton btnLight3 = new JButton(Images.resize(imgLight3,24,24));

		ImageIcon imgMedium1 = new ImageIcon("media/images/medium1.png");
		JButton btnMedium1 = new JButton(Images.resize(imgMedium1,24,24));

		ImageIcon imgMedium2 = new ImageIcon("media/images/medium2.png");
		JButton btnMedium2 = new JButton(Images.resize(imgMedium2,24,24));

		ImageIcon imgMedium3 = new ImageIcon("media/images/medium3.png");
		JButton btnMedium3 = new JButton(Images.resize(imgMedium3,24,24));
	
		ImageIcon imgTan1 = new ImageIcon("media/images/tan1.png");
		JButton btnTan1 = new JButton(Images.resize(imgTan1,24,24));

		ImageIcon imgTan2 = new ImageIcon("media/images/tan2.png");
		JButton btnTan2 = new JButton(Images.resize(imgTan2,24,24));

		ImageIcon imgTan3 = new ImageIcon("media/images/tan3.png");
		JButton btnTan3 = new JButton(Images.resize(imgTan3,24,24));

		ImageIcon imgDeep1 = new ImageIcon("media/images/deep1.png");
		JButton btnDeep1 = new JButton(Images.resize(imgDeep1,24,24));

		ImageIcon imgDeep2 = new ImageIcon("media/images/deep2.png");
		JButton btnDeep2 = new JButton(Images.resize(imgDeep2,24,24));

		ImageIcon imgDeep3 = new ImageIcon("media/images/deep3.png");
		JButton btnDeep3 = new JButton(Images.resize(imgDeep3,24,24));


		btnLight1.setBorder(null);
		btnLight1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLight1.setContentAreaFilled(false);
		btnLight1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "LIGHT1";
			}
		});
		

		btnLight2.setBorder(null);
		btnLight2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLight2.setContentAreaFilled(false);
		btnLight2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "LIGHT2";
			}
		});

		btnLight3.setBorder(null);
		btnLight3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLight3.setContentAreaFilled(false);
		btnLight3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "LIGHT3";
			}
		});

		btnMedium1.setBorder(null);
		btnMedium1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedium1.setContentAreaFilled(false);
		btnMedium1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "MEDIUM1";
			}
		});

		btnMedium2.setBorder(null);
		btnMedium2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedium2.setContentAreaFilled(false);
		btnMedium2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "MEDIUM2";
			}
		});

		btnMedium3.setBorder(null);
		btnMedium3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMedium3.setContentAreaFilled(false);
		btnMedium3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "MEDIUM3";
			}
		});

		btnTan1.setBorder(null);
		btnTan1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTan1.setContentAreaFilled(false);
		btnTan1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "TAN1";
			}
		});

		btnTan2.setBorder(null);
		btnTan2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTan2.setContentAreaFilled(false);
		btnTan2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "TAN2";
			}
		});

		btnTan3.setBorder(null);
		btnTan3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTan3.setContentAreaFilled(false);
		btnTan3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "TAN3";
			}
		});

		btnDeep1.setBorder(null);
		btnDeep1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeep1.setContentAreaFilled(false);
		btnDeep1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "DEEP1";
			}
		});

		btnDeep2.setBorder(null);
		btnDeep2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeep2.setContentAreaFilled(false);
		btnDeep2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "DEEP2";
			}
		});

		btnDeep3.setBorder(null);
		btnDeep3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeep3.setContentAreaFilled(false);
		btnDeep3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				skinTone = "DEEP3";
			}
		});

		panelSkinTones.add(btnLight1);
		panelSkinTones.add(btnLight2);
		panelSkinTones.add(btnLight3);
		panelSkinTones.add(btnMedium1);
		panelSkinTones.add(btnMedium2);
		panelSkinTones.add(btnMedium3);
		panelSkinTones.add(btnTan1);
		panelSkinTones.add(btnTan2);
		panelSkinTones.add(btnTan3);
		panelSkinTones.add(btnDeep1);
		panelSkinTones.add(btnDeep2);
		panelSkinTones.add(btnDeep3);



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
		cbSkinConditions.setRenderer(new TwoDecimalRenderer(cbSkinConditions.getRenderer()));
		panelUsername.add(cbSkinConditions, BorderLayout.SOUTH);
		
		//Panel with a text field to write down the password
		JPanel panelBirthDay = new JPanel();
		panelBirthDay.setBorder(new MatteBorder(10, 10, 10, 10, (Color) new Color(255, 255, 255)));
		panelBirthDay.setBackground(Color.WHITE);
		panel_2.add(panelBirthDay);
		panelBirthDay.setLayout(new BorderLayout(0, 0));
			
		JLabel lblBirthDay = new JLabel("And finaly, what is your date of birth?");
		lblBirthDay.setFont(GUIConstants.FONT_REGULAR_BOLD);
		panelBirthDay.add(lblBirthDay, BorderLayout.NORTH);
				
				
		JTextField txtBday = new JTextField(" DD/MM/YYYY");
		txtBday.setForeground(Color.GRAY);
		txtBday.addMouseListener(new MouseAdapter()
        { @Override
	           public void mouseClicked(MouseEvent me){
        	txtBday.setText("");
	             }
	         });
		panelBirthDay.add(txtBday, BorderLayout.SOUTH);

		//JCalendar calendar = new JCalendar();
	//	panelBirthDay.add(calendar, BorderLayout.SOUTH);
		
		
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
		btnJoin.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(GestorErrores.newUser2(txtBday.getText(), PantallaCrearUsuario_2.this)) {
					user.setSkinTone(skinTone);
					user.setSkinCondition(cbSkinConditions.getSelectedItem().toString());
					try {
						user.setBirthDate(txtBday.getText());
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Client client = Client.getInstance();
					boolean status = (boolean) client.clientInteraction("/uploadUser", (Object) user);
					if(status) { //Validates correct upload
						status = (boolean) client.clientInteraction("/setSessionStatus", user);
						if(status){ //validates correct status of the session
							PantallaCrearUsuario_2.this.dispose();
							JFrame pantallaActual = new ScreenViewProfile();
							GUIConstants.PANTALLA_ACTUAL = pantallaActual;
							pantallaActual.setVisible(true);
						}
					}else {
						System.out.println("ERROR");
					}
				}
			}
		});
		panelJoin.add(btnJoin, BorderLayout.NORTH);
		


	}

	

}