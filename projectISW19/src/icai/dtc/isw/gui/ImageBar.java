package icai.dtc.isw.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageBar {
	public static void getBar(JPanel jp, JLabel lblBlue,JLabel lblRed,JLabel lblGrey,float[] val) {
		ImageIcon blue = new ImageIcon("media/images/blue.jpg");
		ImageIcon red = new ImageIcon("media/images/red.jpg");
		ImageIcon grey = new ImageIcon("media/images/grey.jpg");
		 int ancho = 20;
		 int largo = 200;

		 if(val[0]!=0)
			 jp.add(lblBlue = new JLabel(Images.resize(blue,(int) (largo*val[0]),ancho)));
		 if(val[1]!=0)
			 jp.add(lblRed= new JLabel(Images.resize(red,(int) (largo*val[1]),ancho)));
		 if(val[2]!=0)
			 jp.add(lblGrey = new JLabel(Images.resize(grey,(int) (largo*val[2]),ancho)));
		 //System.out.println("\nValor1: "+val[0]+"\nValor2: "+val[1]+"\nValor3: "+val[2]);
	}
}
