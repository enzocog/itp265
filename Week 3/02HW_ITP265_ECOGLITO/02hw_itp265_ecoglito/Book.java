
/**   * This provides book Teaque
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 02
 * Email: ecoglito@usc.edu
 */
public class Book{
    //initalize variables
    private String title;
    private String author;
    private double price;
    private String format;
    private int numPages;
    
    public Book(String bTitle, String bAuthor, double bPrice, String bFormat, int bNumPages){
        title = bTitle;
        author = bAuthor;
        price = bPrice;
        format = bFormat;
        numPages = bNumPages;
    }
    
    public Book(String title, String author, int numPages){
        this(title, author, 9.99, "paperback", numPages);

    }
       
    public String getTitle() { //create accessor for title
        return title;
    }
    
    
    public String getAuthor() { //create accessor for author
        return author;
    }
    
    
    public double getPrice() { //create accessor for price
        return price;
    }
    public void setPrice(double bookPrice) { //mutator for price
        price = bookPrice;
    }
    
    public String getFormat() { //create accessor for format
        return author;
    }
    public void setFormat(String bookFormat) { //mutator for price
        format = bookFormat;
    }
    
    public int getNumPages() { //acessor for numpages
        return numPages;
    }
    public void setNumPages(int bookNumPages) { //mutator for numPages
        numPages = bookNumPages;
    }
    
    public String toString(){ //tostring method that returns book info
        return "\"" + title + "\""+ " by " + author + " (" + format + ";" + numPages + " pages)" + " $" + price;
    }
    
    /**public boolean equals(){ //method for checking if books are equal
        return(name.equals(price)); //
    }
    */
}
