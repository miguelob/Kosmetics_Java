package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;

public class ScreenViewProfile extends JFrame {

	public ScreenViewProfile() throws HeadlessException {
		
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