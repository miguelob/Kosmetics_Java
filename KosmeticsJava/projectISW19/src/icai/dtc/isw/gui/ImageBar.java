package icai.dtc.isw.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageBar {
	public static void getBar(JPanel jp, JLabel lblBlue,JLabel lblRed,JLabel lblGrey,float[] val) {
		ImageIcon yes = new ImageIcon("media/images/yes.jpg");
		ImageIcon no = new ImageIcon("media/images/no.jpg");
		ImageIcon yesNo = new ImageIcon("media/images/yesNo.jpg");
		 int ancho = 20;
		 int largo = 200;

		 if(val[0]!=0)
			 jp.add(lblBlue = new JLabel(Images.resize(yes,(int) (largo*val[0]),ancho)));
		 if(val[1]!=0)
			 jp.add(lblRed= new JLabel(Images.resize(no,(int) (largo*val[1]),ancho)));
		 if(val[2]!=0)
			 jp.add(lblGrey = new JLabel(Images.resize(yesNo,(int) (largo*val[2]),ancho)));
	}
}
