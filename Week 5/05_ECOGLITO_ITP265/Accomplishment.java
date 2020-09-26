
/**
 * Writes about accomplishments of african-americans. Class that we can call in accomplishment program
 *
 * Enzo Coglitore
 * ITP265
 * ecoglito@usc.edu
 */
public class Accomplishment //makeing the class
{
    
    private int year;
    private String accomplishment;
    private String person;
    private boolean isFemale;
    private Category category;
    
    public Accomplishment(int year, String accomplishment, String person, boolean isFemale, Category category){ //constructor
        this.year = year;
        this.accomplishment = accomplishment;
        this.person = person;
        this.isFemale = isFemale;
        this.category = category;
    }
    //various accessors + mutators
    public int getYear() {
        return year;
    }
    
    public String getAccomplishment() { 
        return accomplishment;
    }
    
    public String getPerson() { 
        return person;
    }
    
    public boolean isFemale() {
        return isFemale;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public String toString() {
    return "Year: " + year
    + ", Accomplishment: " + accomplishment
    + ", Person:" + person
    + ", Female?:" + isFemale
    + ", Category: " + category;
    }
    
   
}
