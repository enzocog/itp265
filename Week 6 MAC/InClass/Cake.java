
/**
 * Enumeration class Cake - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Cake
{
    CHOCOLATE("Tried and trusted"),
    RED_VELVET("Southern Classic"),
    VANILLA("Boring, basic"),
    MARBLE("Boujee"),
    LEMON_POPPYSEED("Fake Healthy"),
    CARROT("Fake Healthy 2.0"),
    MATCHA("Clean and Green"),
    FUNFETTI("A good time");
    UNKNOWN("No Cake Type Found");
    
    
    private String description;
    
    private Cake(String desc) {
    description = desc;
    }
    
    public String getDescription(){
    return description;
    }
    
    /** 
       Will return enum from a string input
       will say unknown if we dont know
       
       */
    public staticCake findMatchingCake(String cake){
        Cake found = UNKNOWN;
        for(Cake c: Cake.values()){
            String enumName = c.toString(); // "Chocolate"
            enumName = enumName.replace("_", " ");
            cake = cake.trim();
            System.out.println(c + " the enum name is" + enumName);
            if(enumName.equals(cake){
                found = c;
            }
        
        }
        
        return found; // will either be unknown or a matching enum
    
    }
}
