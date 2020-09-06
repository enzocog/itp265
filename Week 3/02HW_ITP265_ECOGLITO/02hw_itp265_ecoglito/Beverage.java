
/**
 * This provides book Teaque
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 02
 * Email: ecoglito@usc.edu
 */
public class Beverage
{ //initialize variables
    private String name;
    private double price;
    
    public Beverage(String name, double price){ //create constructor w/ name and price
        this.name = name;
        this.price = price;
        
    }
    
    public String getName () { //create accessor for name
            return name;
        }
        
    public double getPrice() { //create accessor for price
        return price;
    }
    
    public void setName(String bName) { //mutator for name
        name = bName;
    }
    
    public void setPrice(double bPrice) { //mutator for price
        price = bPrice;
    }
    
    public String toString(){ //tostring method that returns name + price in user friendly way
        return name + " " + price;
    }
    
    public boolean equals(Beverage other){ //equals method
        return (this.getName().equals(other.name) 
        && Math.abs(this.getPrice()-other.price) <= 0.0001);
    }
}
