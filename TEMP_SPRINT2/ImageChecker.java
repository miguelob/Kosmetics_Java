package icai.dtc.isw.domain;

import java.io.File;

import javax.swing.ImageIcon;

public class ImageChecker {
	public static ImageIcon checkImage(String directory) {
		ImageIcon image;
		boolean check;
		try {
			File tempFile = new File(directory);
			check = tempFile.exists();
		}catch(Exception e) {
			check = false;
		}
		if(check)
			image = new ImageIcon(directory);
		else
			image = new ImageIcon("DIRECTORY OF ERROR IMAGE");
		return image;
	}
}
