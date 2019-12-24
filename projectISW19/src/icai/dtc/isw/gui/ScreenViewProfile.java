package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Product;

import java.awt.Cursor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

public class ScreenViewProfile extends JFrame {
	ArrayList<Product> products;
	Client client;
	JPanel panel;
	JPanel currentPanel;

	public ScreenViewProfile() throws HeadlessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initialiseProducts();
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
		
				// Contains
		// Arrow to previous page
		// Kosmetics logo

		JPanel panelKosmetics = new JPanel();
		panelKosmetics.setBackground((Color) new Color(255, 153, 153));
		panelKosmetics.setBorder(new MatteBorder(1, 15, 1, 1, (Color) new Color(255, 153, 153)));
		header.add(panelKosmetics, BorderLayout.WEST);

		JButton btnGoBack = new JButton(new ImageIcon("media/icons/left-arrow_16.png"));
		btnGoBack.setBorder(null);
		btnGoBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGoBack.setContentAreaFilled(false);
		btnGoBack.setDisabledIcon(new ImageIcon("media/icons/left-arrow_grey_16.png"));
		btnGoBack.setEnabled(false);
		panelKosmetics.add(btnGoBack);


		MyJButton bntKosmetics = new MyJButton();
		bntKosmetics.setBorder(new MatteBorder(1, 15, 1, 1, (Color) new Color(255, 153, 153)));
		panelKosmetics.add(bntKosmetics);
		bntKosmetics.setText("Kosmetics.");
		bntKosmetics.setFont(GUIConstants.FONT_TITLE);
		bntKosmetics.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bntKosmetics.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
					    GUIConstants.PANTALLA_PRINCIPAL.setVisible(true);
						GUIConstants.PANTALLA_ANTERIOR = ScreenViewProfile.this;
						ScreenViewProfile.this.dispose();

			}
		});
		
		//Profile button
		//Takes the user to his profile
		MyJButton mjbtnProfile = new MyJButton("Profile");
		header.add(mjbtnProfile, BorderLayout.EAST);
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 65, 1, 45, (Color) new Color(255, 255, 255)));
		panel.setBorder(new MatteBorder(1, 1, 1, 45, Color.WHITE));

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
		panelUser.setBorder(new MatteBorder(50, 200, 50, 45, (Color) new Color(255, 255, 255)));
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
		panelTop.setBorder(new MatteBorder(1, 1, 1, 45, (Color) new Color(255, 255, 255)));
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
		lblEmail.setBorder(new MatteBorder(20, 1, 10, 1, Color.WHITE));
		panelUserInfo.add(lblEmail, BorderLayout.CENTER);
		lblEmail.setFont(GUIConstants.FONT_REGULAR_BOLD);

		// Contains:
		// - characteristics
		JPanel panelCharacteristics = new JPanel();
		panelCharacteristics.setLayout(new GridLayout(0,1));
		panelCharacteristics.setBorder(new MatteBorder(1, 1, 1, 45, (Color) new Color(255, 255, 255)));
		panelCharacteristics.setBackground(new Color(255, 255, 255));
		panelUserInfo.add(panelCharacteristics, BorderLayout.SOUTH);

		ImageIcon imgSkinTone = Images.resize(new ImageIcon("media/images/medium2.png"), 24, 24);
		JLabel lblCharacteristic1 = new JLabel("<html> <b> Skin tone: </b> <html>");
		lblCharacteristic1.setIcon(imgSkinTone);
		panelCharacteristics.add(lblCharacteristic1, BorderLayout.CENTER);
		lblCharacteristic1.setFont(GUIConstants.FONT_REGULAR);

		JLabel lblCharacteristic2 = new JLabel("<html> <b> Skin condition: </b> Dry <html>");
		panelCharacteristics.add(lblCharacteristic2, BorderLayout.CENTER);
		lblCharacteristic2.setFont(GUIConstants.FONT_REGULAR);

		JLabel lblCharacteristic3 = new JLabel("<html> <b> Birthdate: </b> 08/10/1997 <html>");
		panelCharacteristics.add(lblCharacteristic3, BorderLayout.CENTER);
		lblCharacteristic3.setFont(GUIConstants.FONT_REGULAR);

		// Contains:
		// - button for favourites
		// - button for reviews

		JPanel panelButtons = new JPanel(new GridLayout(1, 0));
		panelButtons.setBorder(new MatteBorder(1, 1, 1, 45, (Color) new Color(255, 255, 255)));
		panelButtons.setBackground(new Color(255, 255, 255));
		panel.add(panelButtons, BorderLayout.CENTER);

		JButton btnFavourites = new JButton("FAVOURITES", new ImageIcon("media/icons/like-32.png"));
		btnFavourites.setFont(GUIConstants.FONT_TITLE);
		btnFavourites.setBorder(null);
		btnFavourites.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFavourites.setContentAreaFilled(false);
		panelButtons.add(btnFavourites);

		JButton btnReviews = new JButton("REVIEWS", new ImageIcon("media/icons/REVIEW.png"));
		btnReviews.setFont(GUIConstants.FONT_TITLE);
		btnReviews.setBorder(null);
		btnReviews.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReviews.setContentAreaFilled(false);
		panelButtons.add(btnReviews);

		btnFavourites.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				ScreenViewProfile.this.setCurrentPanel(ScreenViewProfile.this.getPanelFavourites());

			}
		});

		btnReviews.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				ScreenViewProfile.this.setCurrentPanel(ScreenViewProfile.this.getPanelReviews());

			}
		});

		currentPanel = this.getPanelFavourites();
		panel.add(currentPanel, BorderLayout.SOUTH);
	      }
	
	
		
	
		
	public void initialiseProducts(){
		client = new Client();
		products = (ArrayList) client.clientInteraction("/getProductBasicInfo",null);
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

	public JPanel getPanelFavourites(){
		// Contains:
		// - list of favourites

		JPanel panelFavourites = new JPanel();
		panelFavourites.setLayout(new GridLayout(0,1));
		panelFavourites.setBorder(new MatteBorder(20, 1, 1, 45, (Color) new Color(255, 255, 255)));
		panelFavourites.setBackground(new Color(255, 255, 255));
		

		Iterator<Product> it = products.iterator();
	      while (it.hasNext())
	      {	 //Panel for every product available. Includes name, brand, category, description, price
	          MyJPanel productPanel = new MyJPanel();
	          productPanel.setLayout(new GridLayout(1, 0));
	          Product product = (Product) it.next();
	          
	          //Button with the photo of the product
	          //Takes you to the product's screen
	          MyJButton btnProduct = new MyJButton(Images.resize(product.getProductImage(),300,200));
	          btnProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	          btnProduct.addActionListener(new ActionListener() {
	        	  @Override
	        	  public void actionPerformed(ActionEvent e) {
	        		  PantallaProductoIndividual frame = new PantallaProductoIndividual(product);
	        		  frame.setVisible(true);
	        		  ScreenViewProfile.this.dispose();
	        		  //System.exit(0);
	        		  
	        	  }
	          });
	          productPanel.add(btnProduct);
	          
	          //Panel for the name, brand, category and type
	          MyJPanel namePanel = new MyJPanel();
	          namePanel.setLayout(new GridLayout(0, 1));
	          //Name of the product
	          MyJLabel lblName = new MyJLabel(product.getName());
	          lblName.setFont(GUIConstants.FONT_MEDIUM_TITLE);
	          namePanel.add(lblName);
	          //Brand of the product
	          MyJLabel lblBrand = new MyJLabel(product.getBrand());
	          lblBrand.setFont(GUIConstants.FONT_TITLE);
	          namePanel.add(lblBrand);
	          btnProduct.setHorizontalAlignment(SwingConstants.CENTER);
	          //Category of the product
	          namePanel.add(new MyJLabel(product.getCategory()));
	          //Price of the product
	          MyJLabel lblPrice = new MyJLabel(String.valueOf(product.getPrice()) + " $");
	          lblPrice.setFont(GUIConstants.FONT_MEDIUM_TITLE);
	          lblPrice.setForeground(new Color(255, 113, 113));
	          namePanel.add(lblPrice);
	          productPanel.add(namePanel);
	          
	          
	          //Features of the product
	          /*
	          MyJLabel feature_1 = new MyJLabel("Longwear");
	          feature_1.setForeground(Color.DARK_GRAY);
	          reviewPanel.add(feature_1);
	          MyJLabel feature_2 = new MyJLabel("High Coverage");
	          feature_2.setForeground(Color.DARK_GRAY);
	          reviewPanel.add(feature_2);
	          MyJLabel feature_3 = new MyJLabel("Matte");
	          feature_2.setForeground(Color.DARK_GRAY);
	          reviewPanel.add(feature_3);*/
	 

	          btnProduct.setHorizontalAlignment(SwingConstants.CENTER);
	        
	          panelFavourites.add(productPanel);
			  
	}
	return panelFavourites;
}

public JPanel getPanelReviews(){
	// Contains:
	// - list of reviews by the user

	JPanel panelReviews = new JPanel();
	panelReviews.setLayout(new GridLayout(0,1));
	panelReviews.setBorder(new MatteBorder(45, 200, 1, 200, (Color) new Color(255, 255, 255)));
	panelReviews.setBackground(new Color(255, 255, 255));

	for(int i = 0; i<5; i++){
		//Panel for an indivifual review from a different user
		JPanel panelIndividualReview = new JPanel();
		panelIndividualReview.setBackground(Color.WHITE);
		panelReviews.add(panelIndividualReview);
		panelIndividualReview.setLayout(new BorderLayout(0, 0));
		
		MyJLabel mjlblReviewText = new MyJLabel("<html>The lip blush formula in entirely different than the matte lip kits, <br>"
				+ "but still has the vibrant beautiful appearance. <br>"
				+ "It�s light weight and smooth, feels like butter. This product doesn�t get crusty or dry out. <br>"
				+ "All four shades are stunning and highly pigmented. New favorite for sure!!</html>");
		mjlblReviewText.setFont(GUIConstants.FONT_REGULAR);
		mjlblReviewText.setForeground(Color.LIGHT_GRAY);
		panelIndividualReview.add(mjlblReviewText, BorderLayout.CENTER);
		
		//Header of the review
		//Includes username, title, number of stars
		JPanel panelHeaderReview = new JPanel();
		panelHeaderReview.setBackground(Color.WHITE);
		panelIndividualReview.add(panelHeaderReview, BorderLayout.NORTH);
		panelHeaderReview.setLayout(new BorderLayout());
		
		//User name of the individual review's author
		MyJLabel mjlblUsername = new MyJLabel();
		panelHeaderReview.add(mjlblUsername, BorderLayout.WEST);
		mjlblUsername.setText("miguelob");
		mjlblUsername.setBorder(new MatteBorder(15, 10, 15, 15, (Color) new Color(255, 255, 255)));
		
		//Title of the individual review
		MyJLabel mjlblTitle = new MyJLabel();
		panelHeaderReview.add(mjlblTitle, BorderLayout.CENTER);
		mjlblTitle.setText("Absolutely Incredible!!");
		mjlblTitle.setFont(GUIConstants.FONT_REGULAR_ITALICS);
		
		JPanel panelStarFlowIndivifualReview = new JPanel();
		panelStarFlowIndivifualReview.setBackground(Color.WHITE);
		panelHeaderReview.add(panelStarFlowIndivifualReview, BorderLayout.EAST);
		
		MyJButton2States lblStar_1a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		lblStar_1a.setContentAreaFilled(false);
		panelStarFlowIndivifualReview.add(lblStar_1a);
		MyJButton2States lblStar_2a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_2a);
		MyJButton2States lblStar_3a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_3a);
		MyJButton2States lblStar_4a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_4a);
		MyJButton2States lblStar_5a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_5a);


		panelReviews.add(panelIndividualReview);
	}	

		  

return panelReviews;
}

public void setCurrentPanel(JPanel newPanel)
{ panel.remove(currentPanel);
  panel.add(newPanel, BorderLayout.SOUTH);
  this.repaint();
  this.setVisible(true);
  currentPanel = newPanel;

}

}
