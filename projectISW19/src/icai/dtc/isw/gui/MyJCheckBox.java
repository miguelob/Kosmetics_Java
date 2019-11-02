package icai.dtc.isw.gui;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import java.awt.Color;

public class MyJCheckBox extends JCheckBox {

	public MyJCheckBox() {
		this.changeBackgroundColor();
	}

	public MyJCheckBox(Icon arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJCheckBox(String arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJCheckBox(Action arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJCheckBox(Icon arg0, boolean arg1) {
		super(arg0, arg1);
		this.changeBackgroundColor();
	}

	public MyJCheckBox(String arg0, boolean arg1) {
		super(arg0, arg1);
		this.changeBackgroundColor();
	}

	public MyJCheckBox(String arg0, Icon arg1) {
		super(arg0, arg1);
		this.changeBackgroundColor();
	}

	public MyJCheckBox(String arg0, Icon arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		this.changeBackgroundColor();
	}
		
	public void changeBackgroundColor(){
		this.setFont(GUIConstants.FONT_REGULAR_BOLD);
		this.setBackground(Color.WHITE);
		}
	

}
