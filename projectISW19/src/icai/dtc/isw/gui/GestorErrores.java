package icai.dtc.isw.gui;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class GestorErrores {
	public static boolean newUser1(String email, String userName, JPasswordField jpf1, JPasswordField jpf2, JFrame frame) {
		boolean value = true;
		if(email.isBlank() || email.isEmpty()) {
			JOptionPane.showMessageDialog(frame,"You must fill in the Email.");
			value = false;
		}else if(!email.contains("@")) {
			JOptionPane.showMessageDialog(frame,"The e-mail is not valid.");
			value = false;
		}
		if(userName.isBlank() || userName.isEmpty()) {
			JOptionPane.showMessageDialog(frame,"You must fill in the user name.");
			value = false;
		}
		if(!Arrays.equals(jpf1.getPassword(),jpf2.getPassword())) {
			JOptionPane.showMessageDialog(frame,"Password doesn't match.");
			value = false;
		}else if(jpf1.getPassword().length < 5 || jpf2.getPassword().length < 5) {
			JOptionPane.showMessageDialog(frame,"Password must be more than 5 characters.");
			value = false;
		}
		return value;
	}
	public static boolean newUser2(String date, JFrame frame) {
		boolean value = false;
		if(date.charAt(2)=='/' && date.charAt(5)=='/')
			value = true;
		else
			JOptionPane.showMessageDialog(frame, "Date format must be DD/MM/YY");
		return value;
	}
	public static void login(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"Password or E-mail/Username doesn't match.");
	}
	public static void writeReview(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"You need to be logged in to write a review.");
	}
}
