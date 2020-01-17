package icai.dtc.isw.gui;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class MyJPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MyJPanel() {
		this.changeBackgroundColor();
	}

	public MyJPanel(LayoutManager arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJPanel(boolean arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		this.changeBackgroundColor();
	}
	
	public void changeBackgroundColor(){
		this.setBackground(Color.WHITE);
	}

}
