import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

/**
 * Write description of class here
 *
 * @author Kendra Walther
 * ITP 265
 * Email: kwalther@usc.edu
 *
 */
public class BookFileReader {
	private List<Book> allBooks; //refer to data type more generally
	
	public static final String FILE_NAME = "src/books.txt";

	public BookFileReader() {
		allBooks = new ArrayList<>();
		readInBooksFromFile();
	
	}


	// Example of the best practice in reading from files. Using the "newish"
	// try with resources code
	private void readInBooksFromFile() {
		// try with resources block -- newer structure from Java 1.7+
		try(FileInputStream fis = new FileInputStream(FILE_NAME);
				Scanner scan = new Scanner(fis))
		{  // NOTE: resources will be closed automatically

			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				try {
					Book book = parseStringIntoBook(line);// "risky" method
					allBooks.add(book);
				} catch (BadBookException e) {
					System.err.println("Skipping bad book: " + e.getMessage());
				} 

			}
		}

		catch (FileNotFoundException e) {
			System.err.println("File not found: " + FILE_NAME);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @param line
	 * @return
	 * @throws BadBookException 
	 */
	private Book parseStringIntoBook(String line) throws BadBookException {
		// every book in file is formatted the same...
		// title/author/num sold
		try { // making a book, assuming file is good
			Scanner sc = new Scanner(line);
			sc.useDelimiter("/");
			String title = sc.next();
			String author = sc.next();
			int num = sc.nextInt();
			sc.close(); // oops don't forget to close scanner
			return new Book(title, author, num);
		}
		catch(Exception e) {
			throw new BadBookException("Problem formatting " + line + " as a book");
		}



	}

	public void getBookFromUser() {
		// read in using Scanner or JOptionPane to get the user's favorite book...
		String title = JOptionPane.showInputDialog(null, "What is the title of your favorite book?");
		String author = JOptionPane.showInputDialog(null, "Who is the author of " + title + "?");
		String soldString = JOptionPane.showInputDialog(null, "How many pages in the book");
		try {
			int numSold = Integer.parseInt(soldString); // code could cause problems...
			Book b = new Book(title, author, numSold);
			allBooks.add(b);
		}
		catch(Exception e) {
			System.err.println("Couldn't turn " + soldString + " into an int... let's try again");
			JOptionPane.showMessageDialog(null, "Error getting book. Try again", "Book Getter", JOptionPane.ERROR_MESSAGE);
			getBookFromUser(); // calling the same method again.

		}

	}

	public void printBookList() {
		for(Book b: allBooks) {
			System.out.println(b);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookFileReader program = new BookFileReader();
		program.printBookList();
		program.getBookFromUser();


	}


	public List<Book> getAllBooks() {
		return allBooks;
	}
	
}
