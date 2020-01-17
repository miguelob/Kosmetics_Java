package icai.dtc.isw.gui;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;

public class MyJLabel extends JLabel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MyJLabel() {
		this.changeBackgroundColor();
	}

	public MyJLabel(String text) {
		super(text);
		this.changeBackgroundColor();
	}

	public MyJLabel(Icon image) {
		super(image);
		this.changeBackgroundColor();
	}

	public MyJLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		this.changeBackgroundColor();
	}

	public MyJLabel(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		this.changeBackgroundColor();
	}

	public MyJLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		this.changeBackgroundColor();
	}
	
	public void changeBackgroundColor(){
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setFont(GUIConstants.FONT_REGULAR_BOLD);
	}

}
