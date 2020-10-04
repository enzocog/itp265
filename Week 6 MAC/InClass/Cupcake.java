
/**
 * Write a description of class Cupcake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cupcake
{
    // instance variables - replace the example below with your own
    private String cakeType; //enum of caketype
    private String frostingType; // enum
    private boolean hasSprinkles;
    /**
     * Constructor for objects of class Cupcake
     */
    public Cupcake(String cake, String frosting, boolean hasSprinkles)
    {
        // initialise instance variables
        this.cakeType = cake;
        this.frostingType = frosting;
        this.hasSprinkles = hasSprinkles;
    }
    
    
    public String getCake(){
    return cakeType;
    }
    
    public String toString () {
    return "CakeType: " + cakeType + ", frostingType: " + frostingType + ", hasSprinkles: " + hasSprinkles;
    }
}
