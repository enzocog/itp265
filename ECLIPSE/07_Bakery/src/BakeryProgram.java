
public class BakeryProgram {

	//ma + control space to generate main method
	public static void main(String[] args) {
		System.out.println("Welcome to the bakery program.");
		Bakery b = new Bakery(); //construct the object
		b.makeStartingInventory();
	//	b.printItems();
		b.printTrayOfCupcakes();
		
	}
}
