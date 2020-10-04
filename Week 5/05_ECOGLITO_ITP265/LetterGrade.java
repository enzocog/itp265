
/**
 * Enumeration class LetterGrade - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum LetterGrade
{
  
A(4.0),
B(3.0),
C(2.0),
D(1.0),
F(0.0);

private double gpaAVG;

private LetterGrade(double gpaAVG) {
this.gpaAVG = gpaAVG;
}

private double getGpaAvg(){
return gpaAVG;
}

public static void getLetterGPA(){
  double GPA = 0;
  for (int i = 0; i < LetterGrade.values().length; i++){
    
    GPA += LetterGrade.values()[i].getGpaAvg();
    
    }
}


public static void print(){
        for(int i = 1; i < LetterGrade.values().length+1; i++){
            double x = LetterGrade.values()[i-1].gpaAVG;
            System.out.println(LetterGrade.values()[i-1] + ": " + x);
        }
        
        }
        
        
public static LetterGrade getLetterGrade(int num){
        return LetterGrade.values()[num-1];
}  

}

