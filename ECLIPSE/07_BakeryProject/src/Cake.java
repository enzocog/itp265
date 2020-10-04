
public enum Cake {
	CHOCOLATE("Tried and trusted"),
    RED_VELVET("Southern classic"),
    VANILLA("Boring, basic"),
    STRAWBERRY("fruity deliciousness"),
    MARBLE("boujee"),
    LEMON_POPPYSEED("fake healthy"),
    CARROT("fake healthy 2.0"),
    MATCHA("clean and green. Karen <3 matcha"),
    FUNFETTI("a good time for funfetti"),
    UNKNOWN("No cake type found");
	
	private String description;
    
    private Cake(String desc){
     description = desc;   
    }
    
    public String getDescription(){
        return description;
    }
    
    
    public static Cake findMatchingCake(String cake){
        Cake found = UNKNOWN;
        for(Cake c: Cake.values()){ //loop through all enum values
            String enumName = c.toString().toLowerCase(); // "CHOCOLATE"
            enumName = enumName.replace("_", " "); // take out underscore, replace with space
            cake = cake.trim().toLowerCase(); // get rid of extra whitespace
            // API at fingertips: CTRl-SPACE to show the options for that sat type
           // System.out.println(c + " the enum name is " + enumName);
            if(enumName.equals(cake)) { // this is good for one word matching
                found = c;
               // return c; // also badform 
               // break; // bad form, but stop when a match is found...
            }
        }
        
        return found; // will bu Unknown or a matching type
    }
    
    public static void printOptions(){
        for(Cake c: Cake.values()){ 
            System.out.println(c);
        }
    }


}
