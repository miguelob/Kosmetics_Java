package icai.dtc.isw.gui;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;

public class MyJButton2States extends JButton {
	
	 /**
	*
	*/
	private static final long serialVersionUID = 1L;
	public static final int STATE_1 = 1;
	    public static final int STATE_2 = 2;
	    private Icon icon1Default;
	    private Icon icon2Default;
	    private Icon icon1Bright;
	    private Icon icon2Bright;


	    private int state = STATE_1;
	
	    public MyJButton2States(Icon icon1Default, Icon icon1Bright, Icon icon2Default, Icon icon2Bright)
	      { super(icon1Default);
	        this.setIcon1Default(icon1Default);
	        this.setIcon1Bright(icon1Bright);
	        this.setIcon2Default(icon2Default);
	        this.setIcon2Bright(icon2Bright);
	        this.setContentAreaFilled(false);
	        this.setBorder(BorderFactory.createEmptyBorder());
			this.setFont(GUIConstants.FONT_TITLE);
			this.setForeground(GUIConstants.DEFAULT_FONT_COLOR);
			
			this.addMouseListener(new MouseAdapter()
	         { @Override
	           public void mouseEntered(MouseEvent me)
	             { MyJButton2States.this.setForeground(MyJButton2States.this.getForeground().darker());

	             }
	           @Override
	           public void mouseExited(MouseEvent me)
	             { MyJButton2States.this.setForeground(GUIConstants.DEFAULT_FONT_COLOR);
	             }
	         });

	        }

	    public void setState(int state)
	      { this.state = state;

	      }

	    public int getEstado()
	      { return state;

	      }

	    public void setIcon1Default(Icon icon1Default)
	      { this.icon1Default = icon1Default;

	      }
	    public void setIcon1Bright(Icon icon1Bright)
	      { this.icon1Bright = icon1Bright;

	      }
	    public void setIcon2Default(Icon icon2Default)
	      { this.icon2Default = icon2Default;

	      }

	    public void setIcon2Bright(Icon icon2Bright)
	      { this.icon2Bright = icon2Bright;

	      }
	    public Icon getIcon1Default()
	      { return icon1Default;

	      }
	    public Icon getIcon1Bright()
	      { return icon1Bright;

	      }
	    public Icon getIcon2Default()
	      { return icon2Default;

	      }

	    public Icon getIcon2Bright()
	      { return icon2Bright;

	      }

}
