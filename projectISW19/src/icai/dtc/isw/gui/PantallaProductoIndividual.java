package icai.dtc.isw.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
import icai.dtc.isw.domain.Question;
import icai.dtc.isw.domain.Review;
import icai.dtc.isw.domain.Survey;
import icai.dtc.isw.domain.User;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Cursor;

public class PantallaProductoIndividual extends JFrame {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PantallaProductoIndividual(Product product) throws HeadlessException {
		Client client = Client.getInstance();
		Product fullProduct = (Product) client.clientInteraction("/getProductFullInfo",product);
		this.setIconImage((new ImageIcon("media/icons/Main_Logo.png")).getImage());
		this.setTitle("Kosmetics: " + fullProduct.getName());
		//TEMPORAL CLOSE METHOD SO THAT PROGRAM DONT GET ALWAYS ON MEMORY
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	PantallaProductoIndividual.this.setVisible(false);
                PantallaProductoIndividual.this.dispose();
                System.exit(0);
            }
        });
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setVisible(true);
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
		mjbtnProfile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
				{ 	
					User user = client.getSessionStatus();
					if(user == null) {
						JFrame pantallaActual = new PantallaLogin();
						GUIConstants.PANTALLA_ACTUAL = pantallaActual;
						pantallaActual.setVisible(true);
					}else {
						JFrame pantallaActual = new ScreenViewProfile();
						GUIConstants.PANTALLA_ACTUAL = pantallaActual;
						PantallaProductoIndividual.this.setVisible(false);
						pantallaActual.setVisible(true);
					}

				}
		});
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
		ImageIcon productImage = Images.resize(fullProduct.getProductImage(), 400, 300);
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
		
		AutoStars.setStars(panelStarsFlow, fullProduct.getScore(),"big");
		
		JLabel lblNumberOfReviews = new JLabel("    "+fullProduct.getReviews().size()+" Reviews                            ");
		lblNumberOfReviews.setFont(GUIConstants.FONT_REGULAR);
		panelStarsFlow.add(lblNumberOfReviews);
		
		JButton btnWriteanopinion = new JButton("Write an opinion");
		btnWriteanopinion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnWriteanopinion.setBorder(new LineBorder(new Color(255, 175, 175), 6, true));
		btnWriteanopinion.setFont(GUIConstants.FONT_REGULAR);
		btnWriteanopinion.setBackground(Color.PINK);
		btnWriteanopinion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				User user = client.getSessionStatus();
				if(user != null) {
					PantallaCrearReview frame = new PantallaCrearReview();
					frame.setVisible(true);
					PantallaProductoIndividual.this.dispose();
				}else {
					GestorErrores.writeReview(PantallaProductoIndividual.this);
				}
				
				
			}
		});
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
		
		//
		Survey survey = fullProduct.getSurvey();
		Collection<Question> questions = survey.getQuestions();
		int size = questions.size();
	
		//Panel with Survey and statistics
		JPanel panelProsCons = new JPanel();
		panelProsCons.setBorder(new MatteBorder(1, 1, 30, 1, (Color) Color.WHITE));
		panelProsCons.setBackground(Color.WHITE);
		panel_1.add(panelProsCons, BorderLayout.SOUTH);
		panelProsCons.setLayout(new GridLayout(size+1,2));
		
		panelProsCons.add(new JLabel(""));
		JPanel ex = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		ex.setBackground(Color.WHITE);
		JLabel yes = new JLabel("Yes%");
		JLabel no = new JLabel("No%");
		JLabel yesNo = new JLabel("No Answer%");
		yes.setForeground(new Color(255,153,153));
		no.setForeground(new Color(191,115,115));
		yesNo.setForeground(new Color(205,205,205));
		yes.setBorder(new MatteBorder(1, 13, 1, 13, (Color) Color.WHITE));
		no.setBorder(new MatteBorder(1, 13, 1, 13, (Color) Color.WHITE));
		yesNo.setBorder(new MatteBorder(1, 13, 1, 13, (Color) Color.WHITE));
		ex.add(yes);
		ex.add(no);
		ex.add(yesNo);
		panelProsCons.add(ex);
		Iterator<Question> it = questions.iterator();
	    while (it.hasNext()) {
	    	JPanel jp = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    	jp.setBackground(Color.WHITE);
	    	jp.setBorder(new MatteBorder(1, 1, 30, 1, (Color) Color.WHITE));
	    	Question question = (Question) it.next();
			JLabel lbl = new JLabel(question.getQuestionText());
			jp.add(lbl);
			panelProsCons.add(jp);
			JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    	jp2.setBackground(Color.WHITE);
	    	jp2.setBorder(new MatteBorder(1, 1, 30, 1, (Color) Color.WHITE));
			JLabel lblBlue = null;
			JLabel lblRed = null;
			JLabel lblGrey = null;
			ImageBar.getBar(jp2,lblBlue, lblRed, lblGrey, survey.getResult(question));
			panelProsCons.add(jp2);
		}	
		
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
					
					AutoStars.setStars(panelStarFlowIndivifualReview, reviews.get(i).getProductScore(),"small");
		}
		this.setResizable(true);
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
	}


}
