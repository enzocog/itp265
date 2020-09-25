
/**
 * Menu Enum
 *
 * @Enzo Coglitore
 * ITP 265 , Ecoglito@usc.edu
 * @version (a version number or a date)
 */
public enum Menu
{
     PRINT("Print all 479 facts"), 
     QUIZ("Quiz Game: Guess the year this first happened"), 
     FEMALE("Print all female accomplishments"), 
     MALE("Print all male accomplishments"), 
     CATEGORY("Print accomplishments by category"), 
     QUIT("Quit");
     
     private String description;
     
     private Menu(String description) {
        this.description = description;
        }
        
     public static void print(){
        for(int i = 1; i < Menu.values().length+1; i++){
            String x = Menu.values()[i-1].description;
            System.out.println(i + ":" + x);
        }
        
        }
     
     public static Menu getOption(int num){
        return Menu.values()[num-1];
        }   
        
     public static int getNumberOfMenuItems(){
        return Menu.values().length;
        
        }
}
