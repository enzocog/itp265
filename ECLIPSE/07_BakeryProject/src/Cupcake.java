
/**
 * Write a description of class Cupcake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cupcake
{
    // instance variables - replace the example below with your own
    private Cake cakeType; //enum of caketype
    private Frosting frostingType; // enum
    private boolean hasSprinkles;
    /**
     * Constructor for objects of class Cupcake
     */
    
    public Cupcake(Cake cakeType, Frosting frostingType, boolean hasSprinkles) {
		this.cakeType = cakeType;
		this.frostingType = frostingType;
		this.hasSprinkles = hasSprinkles;
	}

    public Cake getCakeType(){
        return cakeType;
    }
    
    

	public String toString(){
     String s =  cakeType + " cupcake " + "with " + frostingType + " frosting";
     if(hasSprinkles){
         s += " and sprinkles";
        }
         return s;
    }
}
