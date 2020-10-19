
/**
 * Brief Description Of Code: 
 * @author Enzo Coglitore
 * ITP 265, FALL 2020, Coffee Section
 * Assignment XX, Week ##
 * Email: ecoglito@usc.edu
 */
public class PopupTester {
 public static void main(String[] args) {
	 PopupUI.showMessage("Title", "This is a plain message");
	 PopupUI.showMessage("picture gang", "This is a picture", "gr.jpeg");
	 String[] names = {"Sir Enzo", "Sir Michael", "Madam Kendra", "Presley"};
	 String name = PopupUI.getStringInput("Cuteness", "What do you think the puppy should be called?", "gr.jpeg", names);

	 PopupUI.showMessage("Cuteness", name + " is perfect for this dog.", "gr.jpeg");
	 
	 
	 int num = PopupUI.getIntInput("Cuteness", "How old is this puppy?", "gr.jpeg");
 }
}
