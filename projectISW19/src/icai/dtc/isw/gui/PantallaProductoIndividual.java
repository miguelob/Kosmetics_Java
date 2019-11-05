package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Product;
import icai.dtc.isw.domain.Review;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;

public class PantallaProductoIndividual extends JFrame {
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PantallaProductoIndividual frame = new PantallaProductoIndividual();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	public PantallaProductoIndividual(Product product) throws HeadlessException {
		Client client = new Client();
		Product fullProduct = (Product) client.clientInteraction("/getProductFullInfo",product);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.WHITE);
		
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
		
		//Products name
		
		MyJLabel mjlblProductName = new MyJLabel(fullProduct.getName());
		mjlblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		mjlblProductName.setFont(GUIConstants.FONT_BIG_TITLE);
		panel.add(mjlblProductName, BorderLayout.NORTH);
		mjlblProductName.setBorder(new MatteBorder(10, 20, 30, 20, Color.WHITE));
		
		//Product's Photo
		ImageIcon productImage = Images.resize(fullProduct.getProductImage(), 300, 400);
		JLabel lblProduct = new JLabel(productImage);
		lblProduct.setBorder(new MatteBorder(1, 100, 1, 100, (Color) new Color(255, 255, 255)));
		panel.add(lblProduct, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		//Panel containing the average number stars that users have given the product
		JPanel panelStarsFlow = new JPanel();
		panelStarsFlow.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelStarsFlow.setToolTipText("");
		panelStarsFlow.setBackground(Color.WHITE);
		panel_1.add(panelStarsFlow, BorderLayout.NORTH);
		
		MyJButton2States lblStar_1a = new MyJButton2States(new ImageIcon("media/icons/star_32.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarsFlow.add(lblStar_1a);
		MyJButton2States lblStar_2a = new MyJButton2States(new ImageIcon("media/icons/star_32.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarsFlow.add(lblStar_2a);
		MyJButton2States lblStar_3a = new MyJButton2States(new ImageIcon("media/icons/star_32.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarsFlow.add(lblStar_3a);
		MyJButton2States lblStar_4a = new MyJButton2States(new ImageIcon("media/icons/star_32.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarsFlow.add(lblStar_4a);
		MyJButton2States lblStar_5a = new MyJButton2States(new ImageIcon("media/icons/star_32.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarsFlow.add(lblStar_5a);
		
		JLabel lblNumberOfReviews = new JLabel("    "+fullProduct.getReviews().size()+" Reviews                            ");
		lblNumberOfReviews.setFont(GUIConstants.FONT_REGULAR);
		panelStarsFlow.add(lblNumberOfReviews);
		
		JButton btnWriteanopinion = new JButton("Write an opinion");
		btnWriteanopinion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWriteanopinion.setBorder(new LineBorder(new Color(255, 175, 175), 6, true));
		btnWriteanopinion.setFont(GUIConstants.FONT_REGULAR);
		btnWriteanopinion.setBackground(Color.PINK);
		panelStarsFlow.add(btnWriteanopinion);
		
		//Panel containing the info about the product
		//Includes Official description and price
		JPanel panelInfo = new JPanel();
		panel_1.add(panelInfo, BorderLayout.CENTER);
		panelInfo.setLayout(new GridLayout(0, 1));
		panelInfo.setBackground(Color.WHITE);
		
		//Label for the official description of the product
		JLabel lblDescription = new JLabel();
		panelInfo.add(lblDescription);
		lblDescription.setText(fullProduct.getDescription());
		lblDescription.setFont(GUIConstants.FONT_REGULAR);
		
		
		JLabel lblPrice = new JLabel(Double.toString(fullProduct.getPrice()) + " $");
		lblPrice.setFont(GUIConstants.FONT_BIG_TITLE);
		lblPrice.setForeground(new Color(255, 113, 113));
		panelInfo.add(lblPrice, BorderLayout.SOUTH);
		
		//Panel for the Pros and Cons
		JPanel panelProsCons = new JPanel();
		panelProsCons.setBorder(new MatteBorder(1, 1, 30, 1, (Color) Color.WHITE));
		panelProsCons.setBackground(Color.WHITE);
		panel_1.add(panelProsCons, BorderLayout.SOUTH);
		panelProsCons.setLayout(new GridLayout(1, 0));

		
		//Panel for the Pros
		JPanel panelPros = new JPanel();
		panelPros.setBackground(Color.WHITE);
		panelProsCons.add(panelPros, BorderLayout.CENTER);
		panelPros.setLayout(new GridLayout(0, 1));
		
		JLabel lblPros = new JLabel("Pros");
		panelPros.add(lblPros);
		lblPros.setFont(GUIConstants.FONT_TITLE);
		
		JLabel lblPro1 = new JLabel("<html>Long Lasting <b> (80%) <b> <html>");
		panelPros.add(lblPro1);
		lblPro1.setFont(GUIConstants.FONT_REGULAR);
		JLabel lblPro2 = new JLabel("<html>Long Lasting <b> (80%) <b> <html>");
		panelPros.add(lblPro2);
		lblPro2.setFont(GUIConstants.FONT_REGULAR);
		JLabel lblPro3 = new JLabel("<html>Long Lasting <b> (80%) <b> <html>");
		panelPros.add(lblPro3);
		lblPro3.setFont(GUIConstants.FONT_REGULAR);
		
		//Panel for the Cons
		JPanel panelCons = new JPanel();
		panelCons.setBackground(Color.WHITE);
		panelProsCons.add(panelCons, BorderLayout.CENTER);
		panelCons.setLayout(new GridLayout(0, 1));
		
		JLabel lblCons = new JLabel("Cons");
		panelCons.add(lblCons);
		lblCons.setFont(GUIConstants.FONT_TITLE);
		
		JLabel lblCon1 = new JLabel("<html>Long Lasting <b> (80%) <b> <html>");
		panelCons.add(lblCon1);
		lblCon1.setFont(GUIConstants.FONT_REGULAR);
		JLabel lblCon2 = new JLabel("<html>Long Lasting <b> (80%) <b> <html>");
		panelCons.add(lblCon2);
		lblCon2.setFont(GUIConstants.FONT_REGULAR);
		JLabel lblCon3 = new JLabel("<html>Long Lasting <b> (80%) <b> <html>");
		panelCons.add(lblCon3);
		lblCon3.setFont(GUIConstants.FONT_REGULAR);
		
		
		//Panel for all the reviews
		//2 columns
		JPanel panelReviews = new JPanel();
		panelReviews.setBackground(Color.WHITE);
		panel.add(panelReviews, BorderLayout.SOUTH);
		panelReviews.setLayout(new GridLayout(0, 2, 50, 30));
		panelReviews.setBorder(new MatteBorder(30, 60, 30, 60, Color.WHITE));
		
		for(int i=0; i<fullProduct.getReviews().size(); i++) {
			//Panel for an individual review
					ArrayList<Review> reviews = fullProduct.getReviews();
					JPanel panelIndividualReview = new JPanel();
					panelIndividualReview.setBackground(Color.WHITE);
					panelReviews.add(panelIndividualReview);
					panelIndividualReview.setLayout(new BorderLayout(0, 0));
					
					MyJLabel mjlblReviewText = new MyJLabel(reviews.get(i).getComment());
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
					mjlblUsername.setText(reviews.get(i).getUser().getName());
					mjlblUsername.setBorder(new MatteBorder(15, 10, 15, 15, (Color) new Color(255, 255, 255)));
					
					//Title of the individual review
					MyJLabel mjlblTitle = new MyJLabel();
					panelHeaderReview.add(mjlblTitle, BorderLayout.CENTER);
					mjlblTitle.setText(reviews.get(i).getCommentTitle());
					mjlblTitle.setFont(GUIConstants.FONT_REGULAR_ITALICS);
					
					JPanel panelStarFlowIndivifualReview = new JPanel();
					panelStarFlowIndivifualReview.setBackground(Color.WHITE);
					panelHeaderReview.add(panelStarFlowIndivifualReview, BorderLayout.EAST);
					
					MyJButton2States lblStar_1 = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
					lblStar_1.setContentAreaFilled(false);
					panelStarFlowIndivifualReview.add(lblStar_1);
					MyJButton2States lblStar_2 = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
					panelStarFlowIndivifualReview.add(lblStar_2);
					MyJButton2States lblStar_3 = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
					panelStarFlowIndivifualReview.add(lblStar_3);
					MyJButton2States lblStar_4 = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
					panelStarFlowIndivifualReview.add(lblStar_4);
					MyJButton2States lblStar_5 = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
					panelStarFlowIndivifualReview.add(lblStar_5);
		}
	}


}
