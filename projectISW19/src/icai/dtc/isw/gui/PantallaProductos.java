package icai.dtc.isw.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Checkbox;
import java.awt.Label;
import javax.swing.JSlider;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import icai.dtc.isw.client.Client;
import icai.dtc.isw.domain.Product;


public class PantallaProductos extends JFrame {
	private JFormattedTextField txtWhatAreYou;
    ArrayList products;
    Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaProductos frame = new PantallaProductos();
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
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(20);
		borderLayout.setHgap(25);
//      EN TEORIA PONE EN PANTALLA COMPLETA PERO NO SE AJUSTA
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		//this.setSize(617,479);
		
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 480);
		getContentPane().setBackground(new Color(255, 204, 204));
		
		MyJPanel myJPanel = new MyJPanel();
		myJPanel.setBorder(new MatteBorder(15, 10, 15, 15, (Color) new Color(255, 153, 153)));
		myJPanel.setBackground(new Color(255, 153, 153));
		getContentPane().add(myJPanel, BorderLayout.NORTH);
		myJPanel.setLayout(new BorderLayout(1, 1));
		
		MyJButton mjbtnProfile = new MyJButton();
		mjbtnProfile.setBackground(new Color(255, 204, 255));
		mjbtnProfile.setText("Profile");
		mjbtnProfile.setIcon( new ImageIcon("media/icons/user.png"));
		myJPanel.add(mjbtnProfile, BorderLayout.EAST);
		
		MyJPanel myJPanel_3 = new MyJPanel();
		myJPanel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		myJPanel_3.setBackground(new Color(255, 153, 153));
		myJPanel.add(myJPanel_3, BorderLayout.SOUTH);
		
		MyJButton mjbtnFoundation = new MyJButton(); 
		mjbtnFoundation.setText("FOUNDATION");
		myJPanel_3.add(mjbtnFoundation);
		
		MyJButton mjbtnMascara = new MyJButton();
		mjbtnMascara.setText("MASCARA");
		myJPanel_3.add(mjbtnMascara);
		
		MyJButton mjbtnEyeshadow = new MyJButton();
		mjbtnEyeshadow.setText("EYESHADOW");
		myJPanel_3.add(mjbtnEyeshadow);
		
		MyJButton mjbtnLipstick = new MyJButton();
		mjbtnLipstick.setText("LIPSTICK");
		myJPanel_3.add(mjbtnLipstick);
		
		MyJLabel mjlblKosmetics = new MyJLabel();
		myJPanel.add(mjlblKosmetics, BorderLayout.WEST);
		mjlblKosmetics.setText("Kosmetics.");
		
		MyJPanel myJPanel_8 = new MyJPanel();
		myJPanel_8.setBackground(new Color(255, 153, 153));
		myJPanel.add(myJPanel_8, BorderLayout.CENTER);
		
		MyJLabel myJLabel_1 = new MyJLabel(new ImageIcon("media/icons/magnifying-glass.png"));
		myJPanel_8.add(myJLabel_1);
		
		txtWhatAreYou = new JFormattedTextField();
		txtWhatAreYou.setForeground(Color.GRAY);
		txtWhatAreYou.setText("What are you looking for?");
		txtWhatAreYou.setBorder(BorderFactory.createEmptyBorder());
		txtWhatAreYou.setFont(GUIConstants.FONT_REGULAR);
		txtWhatAreYou.addMouseListener(new MouseAdapter()
        { @Override
	           public void mouseClicked(MouseEvent me)
	             { txtWhatAreYou.setText("");

	             }
	         });
		
		myJPanel_8.add(txtWhatAreYou);
		
		MyJPanel myJPanel_1 = new MyJPanel();
		myJPanel_1.setBorder(new LineBorder(new Color(250, 180, 180), 50));
		myJPanel_1.setBackground(new Color(250, 180, 180));
		getContentPane().add(myJPanel_1, BorderLayout.WEST);
		myJPanel_1.setLayout(new GridLayout(0, 1, 0, 0));
		myJPanel_1.setSize(new Dimension(100, 100));
		
		MyJLabel mjlblPrice = new MyJLabel();
		mjlblPrice.setText("Price");
		myJPanel_1.add(mjlblPrice);
		
		JSlider slider = new JSlider();
		slider.setForeground(Color.LIGHT_GRAY);
		slider.setValue(25);
		slider.setPaintLabels(true);
		slider.setBackground(new Color(250, 180, 180));
		myJPanel_1.add(slider);
		
		MyJLabel mjlblBrand = new MyJLabel();
		mjlblBrand.setText("Brand");
		myJPanel_1.add(mjlblBrand);
		
		Checkbox checkbox_2 = new Checkbox(" Fenty Beauty");
		checkbox_2.setForeground(Color.WHITE);
		checkbox_2.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_2);
		
		
		Checkbox checkbox_3 = new Checkbox(" Kylie Cosmetics");
		checkbox_3.setForeground(Color.WHITE);
		checkbox_3.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_3);
		
		Checkbox checkbox_4 = new Checkbox(" Anastasia");
		checkbox_4.setForeground(Color.WHITE);
		checkbox_4.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_4);
		
		Checkbox checkbox_5 = new Checkbox(" Too Faced");
		checkbox_5.setForeground(Color.WHITE);
		checkbox_5.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_5);
		
		Checkbox checkbox = new Checkbox(" KKW Beauty");
		checkbox.setForeground(Color.WHITE);
		checkbox.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox);
		
		Checkbox checkbox_6 = new Checkbox(" Benefit");
		checkbox_6.setForeground(Color.WHITE);
		checkbox_6.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_6);
		
		MyJLabel mjlblBrand_1 = new MyJLabel();
		mjlblBrand_1.setText("Popularity");
		myJPanel_1.add(mjlblBrand_1);
		
		Checkbox checkbox_7 = new Checkbox(" 5 stars");
		checkbox_7.setForeground(Color.WHITE);
		checkbox_7.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_7);
		
		Checkbox checkbox_8 = new Checkbox(" 4 stars");
		checkbox_8.setForeground(Color.WHITE);
		checkbox_8.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_8);
		
		Checkbox checkbox_11 = new Checkbox(" 3 stars");
		checkbox_11.setForeground(Color.WHITE);
		checkbox_11.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_11);
		
		Checkbox checkbox_9 = new Checkbox(" 2 stars");
		checkbox_9.setForeground(Color.WHITE);
		checkbox_9.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_9);
		
		Checkbox checkbox_10 = new Checkbox(" 1 star");
		checkbox_10.setForeground(Color.WHITE);
		checkbox_10.setFont(GUIConstants.FONT_REGULAR);
		myJPanel_1.add(checkbox_10);
		
		//Panel for the list of products in out database
		MyJPanel myJPanel_2 = new MyJPanel();
		JScrollPane jsp = new JScrollPane(myJPanel_2);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		myJPanel_2.setBorder(new MatteBorder(1, 1, 1, 100, (Color) new Color(255, 204, 204)));
		myJPanel_2.setBackground(new Color(255, 204, 204));
		getContentPane().add(jsp, BorderLayout.CENTER);
		myJPanel_2.setLayout(new GridLayout(0, 1, 5, 10));

		
		initialiseProducts();
		
	      Iterator it = products.iterator();
	      while (it.hasNext())
	      {	 //Panel for every product available. Includes name, brand, category, description, price
	          MyJPanel productPanel = new MyJPanel();
	          productPanel.setLayout(new GridLayout(1, 0));
	          Product product = (Product) it.next();
	          
	          //Button with the photo of the product
	          //Takes you to the product's screen
	          MyJButton mjb = new MyJButton(new ImageIcon("media/images/product0.jpg"));
	          productPanel.add(mjb);
	          
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
	          mjb.setHorizontalAlignment(SwingConstants.CENTER);
	          //Category of the product
	          namePanel.add(new MyJLabel(product.getCategory()));
	          //Price of the product
	          MyJLabel lblPrice = new MyJLabel(String.valueOf(product.getPrice()) + " $");
	          lblPrice.setFont(GUIConstants.FONT_MEDIUM_TITLE);
	          lblPrice.setForeground(new Color(255, 113, 113));
	          namePanel.add(lblPrice);
//	          mjb.addActionListener(new ActionListener()
//	            {@Override
//	              public void actionPerformed(ActionEvent e)
//	                {
//	                  jventana.remove(jventana.getVentanaActual());
//	                  JScrollPaneCanciones jventanaCancionesDeArtista = new JScrollPaneCanciones(jventana, album, jventana.COLOR_SECUNDARIO);
//	                  jventana.add(jventanaCancionesDeArtista, BorderLayout.CENTER);
//	                  jventana.setVentanaActual(jventanaCancionesDeArtista);
//	                  jventana.repaint();
//	                  jventana.setVisible(true);
//	                }
//
//	            });
	          productPanel.add(namePanel);
	          
	          //Panel for the review of the product
	          MyJPanel reviewPanel = new MyJPanel();
	          reviewPanel.setLayout(new GridLayout(0, 1));
	          //Panel for the stars
	          MyJPanel starsPanel = new MyJPanel();
	          starsPanel.add(new MyJLabel(new ImageIcon("media/icons/star.png")));
	          starsPanel.add(new MyJLabel(new ImageIcon("media/icons/star.png")));
	          starsPanel.add(new MyJLabel(new ImageIcon("media/icons/star.png")));
	          starsPanel.add(new MyJLabel(new ImageIcon("media/icons/star.png")));
	          starsPanel.add(new MyJLabel(new ImageIcon("media/icons/star.png")));

	          reviewPanel.add(starsPanel);
	          //Features of the product
	          //Feature 1
	          MyJLabel feature_1 = new MyJLabel("Longwear");
	          feature_1.setForeground(Color.DARK_GRAY);
	          reviewPanel.add(feature_1);
	          MyJLabel feature_2 = new MyJLabel("High Coverage");
	          feature_2.setForeground(Color.DARK_GRAY);
	          reviewPanel.add(feature_2);
	          MyJLabel feature_3 = new MyJLabel("Matte");
	          feature_2.setForeground(Color.DARK_GRAY);
	          reviewPanel.add(feature_3);
	 

	          mjb.setHorizontalAlignment(SwingConstants.CENTER);
	        
	          
	          productPanel.add(reviewPanel);
	          myJPanel_2.add(productPanel);

	      }
		
		
		
	}
	
	public void initialiseProducts(){
		client = new Client();
		products = client.clientInteraction("/getProduct");
	}

}
