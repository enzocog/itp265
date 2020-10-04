import java.util.*;
/**
 * Wrapper for a boolean object
 *
 * @Enzo Coglitore
 * ecoglito@usc.edu
 * ITP265 Coffee
 *
 */
public class Light
{
    boolean isOn;
    public static final String ON = "💡";
    public static final String OFF = "⬛";
    
    public Light(boolean isOn){
    this.isOn = isOn;
    }
    
   
    public void flip(){
    if (isOn == true){
        isOn = false;
    }
    else if (isOn == false){
        isOn = true;
    }
    }
   
    public String isOn(){
    if (isOn){
        return ON;
    }
    else {
        return OFF;
    }
    }
    
    public boolean isLightOn() {
         return isOn;
    }
}

   