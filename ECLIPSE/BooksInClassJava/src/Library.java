import java.util.*;

public class Library {
	private Map<String, List<Book>> myCollection;
	private Map<String, Integer> booksWithSameTitle;
	
	public Library() {
		myCollection = new HashMap<>();
		booksWithSameTitle = new HashMap<>();
		ArrayList<Book> orwellBooks = new ArrayList<>();
		orwellBooks.add(new Book("1984", "George Orwell", 268));
		myCollection.put("George Orwell", orwellBooks);
		booksWithSameTitle.put("1984",1);
		getBooks();
	}
	
	public void print() {
		System.out.println("Here is our library");
		//Set<String> authors = myCollection.keySet();
		for (String author: myCollection.keySet()) {
			if (myCollection.isEmpty()) {
				System.out.println("No books");
			}
			System.out.println(author);
			
		}
		
	}
	
	private void getBooks() {
		BookFileReader br = new BookFileReader();
		List<Book> books = br.getAllBooks();
		System.out.println("Got books from file, here they are");
		for(Book b: books) {
			System.out.println(b);
			addBookToLibrary(b);
		}
		
	}
	
	public void addBookToLibrary(Book b) {
		String author = b.getAuthor();
		
		//two places to add: myCollection
		if (myCollection.containsKey(author)) {
			
			
		}
		else {
			List<Book> books = Arrays.asList(b);
			
		}
		List<Book> booksByAuthorInMap = myCollection.get(author); 
		
		
	}
	
	public static void main(String[] args) {
		Library library = new Library();
		library.print();
		library.getBooks();
	}
	
	
}
