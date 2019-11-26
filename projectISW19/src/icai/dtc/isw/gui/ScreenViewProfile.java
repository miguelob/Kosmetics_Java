package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import java.awt.Cursor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

public class ScreenViewProfile extends JFrame {

	public ScreenViewProfile() throws HeadlessException {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBackground(new Color(255, 153, 153));
		
		//Header
		//Brand name to the left
		//Profile button to the right
		JPanel header = new JPanel();
		header.setBorder(new MatteBorder(15, 10, 15, 15, (Color) new Color(255, 153, 153)));
		header.setBackground(new Color(255, 153, 153));
		scrollPane.setColumnHeaderView(header);
		header.setLayout(new BorderLayout(0, 0));
		
		//Brand name
		//Button that takes the user to the main page
		MyJButton mjbtnKosmetics = new MyJButton("Kosmetics.");
		header.add(mjbtnKosmetics, BorderLayout.WEST);
		
		//Profile button
		//Takes the user to his profile
		MyJButton mjbtnProfile = new MyJButton("Profile");
		header.add(mjbtnProfile, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 65, 1, 45, (Color) new Color(255, 255, 255)));
		panel.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// Contains:
		// - picture
		// - username
		// - button for editting the profile 
		// - email 
		// - characteristics 

		JPanel panelUser = new JPanel();
		panel.add(panelUser, BorderLayout.NORTH);
		panelUser.setBorder(new MatteBorder(1, 65, 1, 45, (Color) new Color(255, 255, 255)));
		panelUser.setBackground(new Color(255, 255, 255));
		panelUser.setLayout(new BorderLayout(0, 0));

		JLabel lblUserImage = new JLabel(Images.resize(new ImageIcon("media/images/user1.png"),150,150));
		panelUser.add(lblUserImage, BorderLayout.WEST);

		// Contains:
		// - username
		// - button for editting the profile 
		// - email 
		// - characteristics 

		JPanel panelUserInfo = new JPanel();
		panelUserInfo.setLayout(new BorderLayout());
		panelUserInfo.setBorder(new MatteBorder(1, 65, 1, 45, (Color) new Color(255, 255, 255)));
		panelUserInfo.setBackground(new Color(255, 255, 255));
		panelUser.add(panelUserInfo, BorderLayout.CENTER);

		// Contains:
		// - username
		// - button for editting the profile 

		JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelTop.setBorder(new MatteBorder(1, 65, 1, 45, (Color) new Color(255, 255, 255)));
		panelTop.setBackground(new Color(255, 255, 255));
		panelUserInfo.add(panelTop, BorderLayout.NORTH);

		JLabel lblUsername = new JLabel("kyliejenner  ");
		panelTop.add(lblUsername);
		lblUsername.setFont(GUIConstants.FONT_MEDIUM_TITLE);

		JButton btnEditProfile = new JButton(new ImageIcon("media/icons/settings-gears.png"));
		btnEditProfile.setBorder(null);
		btnEditProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditProfile.setContentAreaFilled(false);
		panelTop.add(btnEditProfile);

		JLabel lblEmail = new JLabel("kyliejenner@gmail.com");
		panelUserInfo.add(lblEmail, BorderLayout.CENTER);
		lblEmail.setFont(GUIConstants.FONT_TITLE);

		// Contains:
		// - characteristics
		JPanel panelCharacteristics = new JPanel();
		panelCharacteristics.setLayout(new GridLayout(0,1));
		panelCharacteristics.setBorder(new MatteBorder(1, 65, 1, 45, (Color) new Color(255, 255, 255)));
		panelCharacteristics.setBackground(new Color(255, 255, 255));
		panelUserInfo.add(panelCharacteristics, BorderLayout.SOUTH);

		ImageIcon imgSkinTone = Images.resize(new ImageIcon("media/images/medium2.png"), 24, 24);
		JLabel lblCharacteristic1 = new JLabel("Skin tone: ");
		lblCharacteristic1.setIcon(imgSkinTone);
		panelCharacteristics.add(lblCharacteristic1, BorderLayout.CENTER);
		lblCharacteristic1.setFont(GUIConstants.FONT_TITLE);

		JLabel lblCharacteristic2 = new JLabel("Skin condition: Dry");
		panelCharacteristics.add(lblCharacteristic2, BorderLayout.CENTER);
		lblCharacteristic2.setFont(GUIConstants.FONT_TITLE);

		JLabel lblCharacteristic3 = new JLabel("Birthdate: 08/10/1997");
		panelCharacteristics.add(lblCharacteristic3, BorderLayout.CENTER);
		lblCharacteristic3.setFont(GUIConstants.FONT_TITLE);
		
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenViewProfile frame = new ScreenViewProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
