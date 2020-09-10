
/**
 * This allows a user to purchase things with their credit card.
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 03
 * Email: ecoglito@usc.edu
 */
public class CreditCard
{
    private String name;
    private int zipCode;
    private String number;
    private String expirationDate;
    private int securityCode;
    private double balance;
    
    public CreditCard(String name, int zipCode, String number, String expirationDate, int securityCode, double Balance){
        this.name = name;
        this.zipCode = zipCode;
        this.number = number;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.balance = balance;
    }
    
    public String getName () { //create accessor for name
        return name;
        }
        
    public void setName(String name) { //mutator for name
        this.name = name;
    }
    
    public double getBalance () { //create accessor for balance 
        return balance;
    }
    
    public void setBalance (double Balance) { //create mutator for balance 
        this.balance = balance;
    }
    
    public String toString(){ //tostring method that returns book info
        return name + "'s Credit Card: " + number + ", " + securityCode
        + ", " + expirationDate + " ," + zipCode + ". Balance: " + balance + "." ;  
    }
}
