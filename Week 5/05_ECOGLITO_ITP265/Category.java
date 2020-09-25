
/**
 *Category Enum Initialization
 *Enzo Coglitore
 *ITP265
 *Ecoglito@usc.edu
 */
public enum Category
{
    SOCIAL("Social & Jobs"),
    ARTS("Arts & Entertainment"), 
    RELIGION("Religion"), 
    MILITARY("Military"), 
    EDUCATION("Education & Science"), 
    LAW("Law"), 
    POLITICS("Politics"), 
    SPORTS("Sports"), 
    NONE("N/A");
    
    private String description;

    
    private Category(String description){
        this.description = description;

    }
    
    public static Category getCategoryFromDescription(String description){
        Category c = Category.NONE; //default
        
        for(int i = 0; i < Category.values().length; i++){
            Category current = Category.values()[i];
            if(current.toString().equalsIgnoreCase(description)) {
                c = current;
            }
        }
        
        return c;
        
    }
    
    public String getDescription(){
        return description;
    }
    
    public String toString(){
        return description;
    }
    
    public static Category getCategoryByNum(int num){
    return Category.values()[num];
    }
    
    public static void getCategoryOptions(){
    for(int i = 1; i < Category.values().length; i++){
            String x = Category.values()[i-1].description;
            System.out.println(i + ":" + x);
        }
    }
    
 
    

    
        
    public static int getNumOptions(){
    return Category.values().length;
    }
    
    
    
    

}

 
