package icai.dtc.isw.gui;
import java.awt.Color;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;


public class MyJButton extends JButton {
	

	public MyJButton() {
		this.changeBackgroundColor();
	}

	public MyJButton(Icon arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJButton(String arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJButton(Action arg0) {
		super(arg0);
		this.changeBackgroundColor();
	}

	public MyJButton(String arg0, Icon arg1) {
		super(arg0, arg1);
		this.changeBackgroundColor();
	}
	
	public void changeBackgroundColor(){
		this.setContentAreaFilled(false);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setFont(GUIConstants.FONT_TITLE);
		this.setForeground(GUIConstants.DEFAULT_FONT_COLOR);
		
		this.addMouseListener(new MouseAdapter()
         { @Override
           public void mouseEntered(MouseEvent me)
             { MyJButton.this.setForeground(MyJButton.this.getForeground().darker());

             }
           @Override
           public void mouseExited(MouseEvent me)
             { MyJButton.this.setForeground(GUIConstants.DEFAULT_FONT_COLOR);
             }
         });
	}

}
