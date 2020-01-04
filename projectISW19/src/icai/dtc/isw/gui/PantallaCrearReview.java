package icai.dtc.isw.gui;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import icai.dtc.isw.domain.Review;
import icai.dtc.isw.domain.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JRadioButton;

public class PantallaCrearReview extends JFrame {
	private int note = 0;
	private JLabel btnStar_1;
	private JLabel btnStar_2;
	private JLabel btnStar_3;
	private JLabel btnStar_4;
	private JLabel btnStar_5;
	private JPanel panelStarFlow;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				PantallaCrearReview frame = new PantallaCrearReview(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}});
	}
	
	public PantallaCrearReview(ArrayList<Review> reviews) throws HeadlessException {
	this.setIconImage((new ImageIcon("media/icons/Main_Logo.png")).getImage());
	this.setTitle("Kosmetics.");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	
	//Header
	//Brand name to the left
	//Profile button to the right
	
	JPanel header = new JPanel();
	header.setForeground(new Color(0, 0, 0));
	header.setBorder(new MatteBorder(15, 10, 15, 15, (Color) new Color(255, 153, 153)));
	header.setBackground(new Color(255, 153, 153));
	getContentPane().add(header, BorderLayout.NORTH);
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
	btnGoBack.setEnabled(true);
	panelKosmetics.add(btnGoBack);
	
	btnGoBack.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	if (GUIConstants.PANTALLA_ANTERIOR != null)
	{  GUIConstants.PANTALLA_ANTERIOR.setVisible(true);
	GUIConstants.PANTALLA_ANTERIOR = PantallaCrearReview.this;
	PantallaCrearReview.this.dispose();
	
	}
	
	}
	});
	
	MyJButton bntKosmetics = new MyJButton();
	bntKosmetics.setBorder(new MatteBorder(10, 15, 1, 1, (Color) new Color(255, 153, 153)));
	panelKosmetics.add(bntKosmetics);
	bntKosmetics.setText("Kosmetics.");
	bntKosmetics.setFont(GUIConstants.FONT_TITLE);
	bntKosmetics.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	bntKosmetics.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e){
	   GUIConstants.PANTALLA_PRINCIPAL.setVisible(true);
	GUIConstants.PANTALLA_ANTERIOR = PantallaCrearReview.this;
	PantallaCrearReview.this.dispose();
	
	}
	});
	
	//Profile button
	//Takes the user to his profile
	MyJButton mjbtnProfile = new MyJButton("Profile");
	header.add(mjbtnProfile, BorderLayout.EAST);
	
	//Main panel
	//Includes product name
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(Color.WHITE);
	getContentPane().add(panel_1, BorderLayout.CENTER);
	panel_1.setLayout(new BorderLayout(0, 0));
	
	//Products name
	
	JLabel mjlblProductName = new JLabel("Lip Blush Bundle");
	mjlblProductName.setBackground(Color.WHITE);
	mjlblProductName.setHorizontalAlignment(SwingConstants.CENTER);
	mjlblProductName.setFont(GUIConstants.FONT_BIG_TITLE);
	panel_1.add(mjlblProductName, BorderLayout.NORTH);
	
	//Sub panel to the main panel
	//Does not include the products name
	JPanel panel_2 = new JPanel();
	panel_2.setBorder(new MatteBorder(20, 100, 30, 100, (Color) Color.WHITE));
	panel_2.setBackground(Color.WHITE);
	panel_1.add(panel_2, BorderLayout.CENTER);
	panel_2.setLayout(new BorderLayout(0, 0));
	
	//Panel with buttons for the stars
	//The user can choose how many stars will be given to the product
	
	JPanel panelStars = new JPanel();
	panelStars.setBorder(new MatteBorder(1, 1, 15, 1, (Color) new Color(255, 255, 255)));
	panelStars.setLayout(new BorderLayout());
	panelStars.setBackground(new Color(255, 255, 255));
	panel_2.add(panelStars, BorderLayout.NORTH);
	
	JPanel panelStarsDescription = new JPanel();
	panelStarsDescription.setBorder(new MatteBorder(1, 1, 10, 1, (Color) Color.WHITE));
	panelStarsDescription.setBackground(Color.WHITE);
	panelStarsDescription.add(new MyJLabel("Your overall rating of this product"));
	panelStars.add(panelStarsDescription, BorderLayout.NORTH);
	panelStarFlow = new JPanel();
	panelStarFlow.setBackground(Color.WHITE);
	panelStars.add(panelStarFlow, BorderLayout.CENTER);
	
	btnStar_1 = new JLabel(new ImageIcon("media/icons/star_empty_32.png"));
	btnStar_1.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            PantallaCrearReview.this.setNote(1);
	PantallaCrearReview.this.changeStars();;
	            }
	
	        });
	panelStarFlow.add(btnStar_1);
	btnStar_2 = new JLabel(new ImageIcon("media/icons/star_empty_32.png"));
	btnStar_2.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            PantallaCrearReview.this.setNote(2);
	PantallaCrearReview.this.changeStars();;
	            }
	
	        });
	panelStarFlow.add(btnStar_2);
	btnStar_3 = new JLabel(new ImageIcon("media/icons/star_empty_32.png"));
	btnStar_3.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            PantallaCrearReview.this.setNote(3);
	PantallaCrearReview.this.changeStars();;
	            }
	
	        });
	panelStarFlow.add(btnStar_3);
	btnStar_4 = new JLabel(new ImageIcon("media/icons/star_empty_32.png"));
	btnStar_4.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            PantallaCrearReview.this.setNote(4);
	PantallaCrearReview.this.changeStars();;
	            }
	
	        });
	panelStarFlow.add(btnStar_4);
	btnStar_5 = new JLabel(new ImageIcon("media/icons/star_empty_32.png"));
	btnStar_5.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            PantallaCrearReview.this.setNote(5);
	PantallaCrearReview.this.changeStars();;
	            }
	
	        });
	panelStarFlow.add(btnStar_5);
	
	//Panel for the review's text and quick survey
	JPanel panelShareYourExperience = new JPanel();
	panelShareYourExperience.setBorder(new MatteBorder(1, 10, 1, 1, (Color) Color.WHITE));
	panelShareYourExperience.setLayout(new BorderLayout());
	panel_2.add(panelShareYourExperience, BorderLayout.CENTER);
	JTextPane txtpnShareYourExperience = new JTextPane();
	txtpnShareYourExperience.setFont(new Font("SansSerif", Font.PLAIN, 15));
	txtpnShareYourExperience.setCaretColor(Color.BLACK);
	txtpnShareYourExperience.setBorder(new LineBorder(new Color(192, 192, 192), 2));
	txtpnShareYourExperience.setText("Share your experience: the quality, the price, did it meet your expectations?...");
	txtpnShareYourExperience.setForeground(Color.DARK_GRAY);
	panelShareYourExperience.add(txtpnShareYourExperience, BorderLayout.CENTER);
	
	//Panel for the quick survey
	//It includes the product's questions
	//and 3 possible answers : "yes", "I'm not sure", "no".
	JPanel panelSurvey = new JPanel();
	panelSurvey.setBorder(new MatteBorder(25, 1, 1, 1, (Color) Color.WHITE));
	panelSurvey.setBackground(Color.WHITE);
	panelShareYourExperience.add(panelSurvey, BorderLayout.SOUTH);
	panelSurvey.setLayout(new GridLayout(0, 1, 0, 0));
	addSurvey(panelSurvey);
	
	
	
	//Panel with other users' reviews
	JPanel panelAside = new JPanel();
	panelAside.setBorder(new MatteBorder(1, 100, 1, 50, (Color) new Color(255, 255, 255)));
	panelAside.setBackground(Color.WHITE);
	panel_2.add(panelAside, BorderLayout.EAST);
	panelAside.setLayout(new GridLayout(0, 1, 0, 0));
	
	//Panel for an indivifual review from a different user
	/*JPanel panelIndividualReview = new JPanel();
	panelIndividualReview.setBackground(Color.WHITE);
	panelAside.add(panelIndividualReview);
	panelIndividualReview.setLayout(new BorderLayout(0, 0));*/
	
	for(int i=0; i<reviews.size(); i++) {
		//Panel for an individual review
		JPanel panelIndividualReview = new JPanel();
		panelIndividualReview.setBackground(Color.WHITE);
		panelAside.add(panelIndividualReview);
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
		
		AutoStars.setStars(panelStarFlowIndivifualReview, reviews.get(i).getProductScore(),"small");
	}
		/*MyJLabel mjlblReviewText = new MyJLabel();
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
		lblStar_1.setContentAreaFilled(false);
		panelStarFlowIndivifualReview.add(lblStar_1a);
		MyJButton2States lblStar_2a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_2a);
		MyJButton2States lblStar_3a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_3a);
		MyJButton2States lblStar_4a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_4a);
		MyJButton2States lblStar_5a = new MyJButton2States(new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"), new ImageIcon("media/icons/star.png"));
		panelStarFlowIndivifualReview.add(lblStar_5a);
		
		MyJLabel mjlblUser = new MyJLabel("maroag");
		panelAside.add(mjlblUser);*/
	}
	
	public void addSurvey(JPanel panelSurvey)
	{
	//First Question
		MyJLabel mjlblIsItLong = new MyJLabel("Is it long-lasting?");
		panelSurvey.add(mjlblIsItLong);
		
		JPanel panelSurveyRadioButtons = new JPanel();
		panelSurveyRadioButtons.setBackground(Color.WHITE);
		panelSurvey.add(panelSurveyRadioButtons);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons.add(rdbtnYes);
		
		JRadioButton rdbtnNotSure = new JRadioButton("I'm not sure");
		rdbtnNotSure.setBackground(Color.WHITE);
		rdbtnNotSure.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons.add(rdbtnNotSure);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons.add(rdbtnNo);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnYes);
		group.add(rdbtnNotSure);
		group.add(rdbtnNo);
		
		
		//Second Question
		
		MyJLabel mjlblHighPigmented = new MyJLabel("Is it highly pigmented?");
		panelSurvey.add(mjlblHighPigmented);
		
		JPanel panelSurveyRadioButtons2 = new JPanel();
		panelSurveyRadioButtons2.setBackground(Color.WHITE);
		panelSurvey.add(panelSurveyRadioButtons2);
		
		JRadioButton rdbtnYes2 = new JRadioButton("Yes");
		rdbtnYes2.setBackground(Color.WHITE);
		rdbtnYes2.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons2.add(rdbtnYes2);
		
		JRadioButton rdbtnNotSure2 = new JRadioButton("I'm not sure");
		rdbtnNotSure2.setBackground(Color.WHITE);
		rdbtnNotSure2.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons2.add(rdbtnNotSure2);
		
		JRadioButton rdbtnNo2 = new JRadioButton("No");
		rdbtnNo2.setBackground(Color.WHITE);
		rdbtnNo2.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons2.add(rdbtnNo2);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnYes2);
		group2.add(rdbtnNotSure2);
		group2.add(rdbtnNo2);
		
		//Third Question
		
		MyJLabel mjlblMatte = new MyJLabel("Is it matte?");
		panelSurvey.add(mjlblMatte);
		
		JPanel panelSurveyRadioButtons3 = new JPanel();
		panelSurveyRadioButtons3.setBackground(Color.WHITE);
		panelSurvey.add(panelSurveyRadioButtons3);
		
		JRadioButton rdbtnYes3 = new JRadioButton("Yes");
		rdbtnYes3.setBackground(Color.WHITE);
		rdbtnYes3.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons3.add(rdbtnYes3);
		
		JRadioButton rdbtnNotSure3 = new JRadioButton("I'm not sure");
		rdbtnNotSure3.setBackground(Color.WHITE);
		rdbtnNotSure3.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons3.add(rdbtnNotSure3);
		
		JRadioButton rdbtnNo3 = new JRadioButton("No");
		rdbtnNo3.setBackground(Color.WHITE);
		rdbtnNo3.setFont(GUIConstants.FONT_REGULAR);
		panelSurveyRadioButtons3.add(rdbtnNo3);
		
		ButtonGroup group3 = new ButtonGroup();
		group3.add(rdbtnYes3);
		group3.add(rdbtnNotSure3);
		group3.add(rdbtnNo3);
		
		JPanel panelButtonSendReview = new JPanel();
		panelButtonSendReview.setBackground(Color.WHITE);
		panelSurvey.add(panelButtonSendReview);
		
		JButton btnSendReview = new JButton("Send Review");
		btnSendReview.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSendReview.setBorder(new LineBorder(new Color(255, 175, 175), 6, true));
		btnSendReview.setFont(GUIConstants.FONT_REGULAR);
		btnSendReview.setBackground(Color.PINK);
		panelButtonSendReview.add(btnSendReview);
	
	}
	public void setNote(int i) {
		note = i;
	}
	public void changeStars() {
		if(note == 1) {
			btnStar_1.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_2.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
			btnStar_3.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
			btnStar_4.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
			btnStar_5.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
		}else if(note == 2){
			btnStar_1.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_2.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_3.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
			btnStar_4.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
			btnStar_5.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
		}else if(note == 3){
			btnStar_1.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_2.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_3.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_4.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
			btnStar_5.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
		}else if(note == 4){
			btnStar_1.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_2.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_3.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_4.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_5.setIcon(new ImageIcon("media/icons/star_empty_32.png"));
		}else {
			btnStar_1.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_2.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_3.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_4.setIcon(new ImageIcon("media/icons/star_32.png"));
			btnStar_5.setIcon(new ImageIcon("media/icons/star_32.png"));
		}
	}

}