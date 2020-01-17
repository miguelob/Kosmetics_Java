package icai.dtc.isw.gui;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.Color;

public class GUIConstants {
	
	  public static final Font FONT_REGULAR = new Font("Font.SERIF_MD", Font.PLAIN, 16);
	  public static final Font FONT_REGULAR_BOLD = new Font("Font.SERIF_MD", Font.BOLD, 16);
	  public static final Font FONT_REGULAR_ITALICS = new Font("Font.SERIF_MD", Font.ITALIC, 16);
	  /**Fuente para t�tulos de la interfaz gr�fica, en este caso "SERIF_MD", en negrita y de tamano 20
	  */
	  public static final Font FONT_TITLE = new Font("Font.SERIF_MD", Font.BOLD, 20);
	  /**Fuente para t�tulos principales de la interfaz gr�fica, en este caso "SERIF_MD", en negrita y de tamano 20
	  */
	  public static final Font FONT_MEDIUM_TITLE = new Font("Font.SERIF_MD", Font.BOLD, 40);
	  public static final Font FONT_BIG_TITLE = new Font("Font.SERIF_MD", Font.BOLD, 60);
	  
	  public static final Color DEFAULT_FONT_COLOR = new Color(80, 80, 80);
	  
	  //Pantallas constantes
	  public static PantallaProductos PANTALLA_PRODUCTOS;
	  public static PantallaProductoIndividual PANTALLA_PRODUCTO_INDIVIDUAL;
	  public static PantallaCrearReview PANTALLA_CREAR_REVIEW;
	  public static PantallaCrearUsuario PANTALLA_CREAR_USUARIO;
	  public static PantallaCrearUsuario_2 PANEL_CREAR_USUARIO_2;
	  public static ScreenViewProfile PANTALLA_VER_PERFIL;

	  //Pantallas dinámicas
	
	  public static JFrame PANTALLA_PRINCIPAL;
	  public static JFrame PANTALLA_ACTUAL;
	  public static JFrame PANTALLA_ANTERIOR;

}