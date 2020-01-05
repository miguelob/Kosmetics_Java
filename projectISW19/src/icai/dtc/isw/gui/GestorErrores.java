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
	public static boolean newReview(int note, String title, String text, JFrame frame) {
		boolean value = true;
		if(title.isBlank() || title.isEmpty() || title.contentEquals("Give a title to your review")){
			JOptionPane.showMessageDialog(frame,"Please, fill in the title for the review.");
			value = false;
		}
		if(text.isBlank() || text.isEmpty() || text.contentEquals("Share your experience: the quality, the price, did it meet your expectations?...")) {
			JOptionPane.showMessageDialog(frame,"Please, fill in the review.");
			value = false;
		}
		if(note == 0) {
			JOptionPane.showMessageDialog(frame,"Please, choose a overall qualification of the product.\nYou can do it clicking the starts on the screen.");
			value = false;
		}
		return value;
	}
	public static void uploadReviewError(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"Something went wrong. Please, try it again.");
	}
	public static void uploadReviewOK(JFrame frame) {
		JOptionPane.showMessageDialog(frame,"Review uploaded successfully.\nSometimes, the review might not be visible untill reload.");
	}
}
