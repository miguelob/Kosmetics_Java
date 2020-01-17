package icai.dtc.isw.gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AutoStars {
	public static void setStars(JPanel jpanel,int fullStarNumber,String size) {
		int emptyStarNumber = 5 - fullStarNumber;
		if(size.contentEquals("small")) {
			for(int j = 0; j<fullStarNumber; j++) {
				JLabel lblStar = new JLabel(new ImageIcon("media/icons/star.png"));
				jpanel.add(lblStar);
			}
			for(int j = 0; j<emptyStarNumber; j++) {
				JLabel lblStar = new JLabel(Images.resize(new ImageIcon("media/icons/star_empty_32.png"),24,24));
				jpanel.add(lblStar);
			}
		}else {
			for(int j = 0; j<fullStarNumber; j++) {
				JLabel lblStar = new JLabel(new ImageIcon("media/icons/star_32.png"));
				jpanel.add(lblStar);
			}
			for(int j = 0; j<emptyStarNumber; j++) {
				JLabel lblStar = new JLabel(new ImageIcon("media/icons/star_empty_32.png"));
				jpanel.add(lblStar);
			}
		}
	}
}
