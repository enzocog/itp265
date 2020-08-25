
/**
 * This prints out some ASCII art
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 00
 * Email: ecoglito@usc.edu
 */
public class MyAnimation
{
    public void drawFrame1(){ //draw first frame
        System.out.println("^..^      /\n" + "/_/\\_____/\n" + "   /\\   /\\\n" + "  /  \\ /  \\\n");
    }
    
     public void drawFrame2(){ //draw second frame
        System.out.println("^..^      \\\n" + "/_/\\_____/\n" + "   /\\   /\\\n" + "  /  \\ /  \\\n");
    }
    
    public void run() { //calls on frame 1 then frame 2
        for(int i = 0; i < 10; i++){
            drawFrame1();
            pause(299);
            drawFrame2();
            pause(299);
        }
    }
    
    public void pause(int ms){ //stops and starts the run thread
        try{
            Thread.sleep(ms);
        }
        catch(InterruptedException e){
        }
    }
    
    public static void main(String[] args){ //lets you run automatically
        MyAnimation animationObject = new MyAnimation();
        animationObject.run();
    }
    
}
