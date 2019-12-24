package icai.dtc.isw.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Product;


public class PantallaProductos extends JFrame {
	private JFormattedTextField txtWhatAreYou;
    ArrayList<Product> products;
    Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaProductos frame = new PantallaProductos();
					frame.setIconImage((new ImageIcon("media/icons/Main_Logo.png")).getImage());
					frame.setTitle("Kosmetics.");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaProductos() {
		initialiseProducts();
		GUIConstants.PANTALLA_PRINCIPAL = this;
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(20);
		borderLayout.setHgap(25);
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 480);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel jpanel = new JPanel();
		jpanel.setBorder(new MatteBorder(0, 0, 15, 0, (Color) new Color(255, 153, 153)));
		jpanel.setBackground(new Color(255, 153, 153));
		getContentPane().add(jpanel, BorderLayout.NORTH);
		jpanel.setLayout(new BorderLayout(1, 1));

		
		JButton jbtnProfile = new JButton();
		jbtnProfile.setBorder(new MatteBorder(1, 1, 1, 15, (Color) new Color(255, 153, 153)));
		jbtnProfile.setBackground(new Color(255, 204, 255));
		jbtnProfile.setText("Profile");
		jbtnProfile.setIcon( new ImageIcon("media/icons/user.png"));
		jbtnProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbtnProfile.setContentAreaFilled(false);
		jbtnProfile.setFont(GUIConstants.FONT_TITLE);

		jbtnProfile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
				{ 	JFrame pantallaActual = new PantallaCrearUsuario();
					GUIConstants.PANTALLA_ACTUAL = pantallaActual;
					pantallaActual.setVisible(true);

				}
		});
		jpanel.add(jbtnProfile, BorderLayout.EAST);
		
		// Contains
		// - Navigator bar (Foundation, Mascara, Eyeshadow, Lipstick)
		MyJPanel myJPanel_3 = new MyJPanel();
		myJPanel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		myJPanel_3.setBackground(new Color(255, 153, 153));
		jpanel.add(myJPanel_3, BorderLayout.SOUTH);
		
		JButton mjbtnFoundation = new JButton(); 
		mjbtnFoundation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mjbtnFoundation.setText("FOUNDATION");
		mjbtnFoundation.setContentAreaFilled(false);
		mjbtnFoundation.setBorder(BorderFactory.createEmptyBorder());
		mjbtnFoundation.setFont(GUIConstants.FONT_TITLE);
		myJPanel_3.add(mjbtnFoundation);
		
		JButton mjbtnMascara = new JButton();
		mjbtnMascara.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mjbtnMascara.setText("MASCARA");
		mjbtnMascara.setContentAreaFilled(false);
		mjbtnMascara.setBorder(BorderFactory.createEmptyBorder());
		mjbtnMascara.setFont(GUIConstants.FONT_TITLE);
		myJPanel_3.add(mjbtnMascara);
		
		JButton mjbtnEyeshadow = new JButton();
		mjbtnEyeshadow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mjbtnEyeshadow.setText("EYESHADOW");
		mjbtnEyeshadow.setContentAreaFilled(false);
		mjbtnEyeshadow.setBorder(BorderFactory.createEmptyBorder());
		mjbtnEyeshadow.setFont(GUIConstants.FONT_TITLE);
		myJPanel_3.add(mjbtnEyeshadow);
		
		JButton mjbtnLipstick = new JButton();
		mjbtnLipstick.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mjbtnLipstick.setText("LIPSTICK");
		mjbtnLipstick.setContentAreaFilled(false);
		mjbtnLipstick.setBorder(BorderFactory.createEmptyBorder());
		mjbtnLipstick.setFont(GUIConstants.FONT_TITLE);
		myJPanel_3.add(mjbtnLipstick);
		
		// Contains
		// Arrow to previous page
		// Kosmetics logo

		JPanel panelKosmetics = new JPanel();
		panelKosmetics.setBackground((Color) new Color(255, 153, 153));
		panelKosmetics.setBorder(new MatteBorder(1, 15, 1, 1, (Color) new Color(255, 153, 153)));
		jpanel.add(panelKosmetics, BorderLayout.WEST);

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
						GUIConstants.PANTALLA_ANTERIOR = PantallaProductos.this;
						PantallaProductos.this.dispose();

					 }

			}
		});

		MyJButton bntKosmetics = new MyJButton();
		bntKosmetics.setBorder(new MatteBorder(10, 15, 1, 1, (Color) new Color(255, 153, 153)));
		panelKosmetics.add(bntKosmetics);
		bntKosmetics.setText("Kosmetics.");
		bntKosmetics.setFont(GUIConstants.FONT_TITLE);
		
		// Contains
		// -searchbar
		JPanel panelSearchBar = new JPanel();
		panelSearchBar.setBorder(new MatteBorder(10, 1, 1, 1, new Color(255, 153, 153)));
		panelSearchBar.setBackground(new Color(255, 153, 153));
		jpanel.add(panelSearchBar, BorderLayout.CENTER);
		
		MyJLabel myJLabel_1 = new MyJLabel(new ImageIcon("media/icons/magnifying-glass.png"));
		panelSearchBar.add(myJLabel_1);
		
		txtWhatAreYou = new JFormattedTextField();
		txtWhatAreYou.setCaretColor(Color.BLACK);
		txtWhatAreYou.setForeground(Color.GRAY);
		txtWhatAreYou.setText(" What are you looking for?");
		txtWhatAreYou.setBorder(BorderFactory.createEmptyBorder());
		txtWhatAreYou.setFont(GUIConstants.FONT_REGULAR);
		txtWhatAreYou.addMouseListener(new MouseAdapter()
        { @Override
	           public void mouseClicked(MouseEvent me)
	             { txtWhatAreYou.setText("");

	             }
	         });
		
		panelSearchBar.add(txtWhatAreYou);
		
		// Contains:
		// - Filters

		MyJPanel panelFilters = new MyJPanel();
		panelFilters.setBorder(new MatteBorder(50, 50, 50, 1, Color.WHITE));
		panelFilters.setBackground(Color.WHITE);
		getContentPane().add(panelFilters, BorderLayout.WEST);
		panelFilters.setLayout(new GridLayout(0, 1, 0, 0));
		panelFilters.setSize(new Dimension(100, 100));
		
		MyJLabel mjlblPrice = new MyJLabel();
		mjlblPrice.setText("Price");
		panelFilters.add(mjlblPrice);
		
		JSlider slider = new JSlider();
		slider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		slider.setForeground(Color.LIGHT_GRAY);
		slider.setValue(25);
		slider.setPaintLabels(true);
		slider.setBackground(Color.WHITE);
		panelFilters.add(slider);
		
		MyJLabel mjlblBrand = new MyJLabel();
		mjlblBrand.setText("Brand");
		panelFilters.add(mjlblBrand);
		
		for(int i = 0; i<products.size();i++) {
			Checkbox checkbox = new Checkbox(products.get(i).getBrand());
			checkbox.setForeground(Color.GRAY);
			checkbox.setFont(GUIConstants.FONT_REGULAR);
			panelFilters.add(checkbox);
		}
		
		MyJLabel mjlblBrand_1 = new MyJLabel();
		mjlblBrand_1.setText("Popularity");
		panelFilters.add(mjlblBrand_1);
		
		Checkbox checkbox_7 = new Checkbox(" 5 stars");
		checkbox_7.setForeground(new Color(128, 128, 128));
		checkbox_7.setFont(GUIConstants.FONT_REGULAR);
		panelFilters.add(checkbox_7);
		
		Checkbox checkbox_8 = new Checkbox(" 4 stars");
		checkbox_8.setForeground(Color.GRAY);
		checkbox_8.setFont(GUIConstants.FONT_REGULAR);
		panelFilters.add(checkbox_8);
		
		Checkbox checkbox_11 = new Checkbox(" 3 stars");
		checkbox_11.setForeground(Color.GRAY);
		checkbox_11.setFont(GUIConstants.FONT_REGULAR);
		panelFilters.add(checkbox_11);
		
		Checkbox checkbox_9 = new Checkbox(" 2 stars");
		checkbox_9.setForeground(Color.GRAY);
		checkbox_9.setFont(GUIConstants.FONT_REGULAR);
		panelFilters.add(checkbox_9);
		
		Checkbox checkbox_10 = new Checkbox(" 1 star");
		checkbox_10.setForeground(Color.GRAY);
		checkbox_10.setFont(GUIConstants.FONT_REGULAR);
		panelFilters.add(checkbox_10);
		
		//Panel for the list of products in out database
		MyJPanel myJPanel_2 = new MyJPanel();
		JScrollPane jsp = new JScrollPane(myJPanel_2);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		myJPanel_2.setBorder(new MatteBorder(0, 0, 0, 70, Color.WHITE));
		myJPanel_2.setBackground(Color.WHITE);
		getContentPane().add(jsp, BorderLayout.CENTER);
		myJPanel_2.setLayout(new GridLayout(0, 1, 5, 10));
		
	      Iterator<Product> it = products.iterator();
	      while (it.hasNext())
	      {	 //Panel for every product available. Includes name, brand, category, description, price
	          MyJPanel productPanel = new MyJPanel();
			  productPanel.setLayout(new BorderLayout(0, 0));
			  productPanel.setBackground(Color.WHITE);
			  productPanel.setBorder(new MatteBorder(0, 0, 2, 0, new Color(234, 237, 237)));
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
					  GUIConstants.PANTALLA_ANTERIOR = PantallaProductos.this;
	        		  PantallaProductos.this.dispose();
	        		  //System.exit(0);
	        		  
	        	  }
	          });
	          productPanel.add(btnProduct, BorderLayout.WEST);
	          
	          //Panel for the name, brand, category and type
	          MyJPanel namePanel = new MyJPanel();
			  namePanel.setLayout(new GridLayout(0, 1));
			  namePanel.setBackground(Color.WHITE);
			  namePanel.setBorder(new MatteBorder(1, 30, 1, 1, Color.WHITE));
		
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
	          
	          //Panel for the review of the product
	          MyJPanel reviewPanel = new MyJPanel();
			  reviewPanel.setLayout(new GridLayout(0, 1));
			  reviewPanel.setBorder(new MatteBorder(0, 0, 0, 20, Color.WHITE));
			  reviewPanel.setBackground(Color.WHITE);
			  //reviewPanel.setBorder(new MatteBorder(1, 1, 1, 50, Color.BLACK));
	          //Panel for the stars
			  MyJPanel starsPanel = new MyJPanel();
			  starsPanel.setBackground(Color.WHITE);
	          AutoStars.setStars(starsPanel, product.getScore(),"big");
	          reviewPanel.add(starsPanel);
	          ArrayList<String> features = product.getFeatures();
	          for(int i = 0; i<features.size();i++) {
	        	  MyJLabel feature = new MyJLabel(features.get(i));
	              feature.setForeground(Color.DARK_GRAY);
	              reviewPanel.add(feature);
	          }
	 

	          btnProduct.setHorizontalAlignment(SwingConstants.CENTER);
	        
	          
	          productPanel.add(reviewPanel, BorderLayout.EAST);
	          myJPanel_2.add(productPanel);

	      }
		
		
		
	}
	
	public void initialiseProducts(){
		client = new Client();
		products = (ArrayList) client.clientInteraction("/getProductBasicInfo",null);
	}

}