import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Brief Description Of Code: Kind of Like UI, but using J Option Pane to do I/O to user.
 * @author Enzo Coglitore
 * ITP 265, FALL 2020, Coffee Section
 * Assignment XX, Week ##
 * Email: ecoglito@usc.edu
 */
public class PopupUI {

	
	public static void showMessage(String title, String message) {
		
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	/** 
	 * 
	 * 
	 * @param title
	 * @param message
	 * @param pictureFile: must be stored in src directory
	 * */
	
	public static void showMessage(String title, String message, String pictureFile) {
		ImageIcon icon = new ImageIcon("bin/" + pictureFile);
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon );
		
		
	}
	
	public static String getStringInput(String title, String message) {
		return JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
	public static String getStringInput(String title, String message, String pictureFile, String[] options) {
		ImageIcon icon = new ImageIcon("bin/" + pictureFile);
		Object o = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
		return (String)o; 
		
	}
	
	public static int getIntInput(String title, String message, String pictureFile) {
		ImageIcon icon = new ImageIcon("bin/" + pictureFile);
		String answer = getStringInput(title, message);
		int value = Integer.parseInt(answer);
		return value;
		
	}

	/**
	 * @param o
	 * @return
	 */
	
	
}
