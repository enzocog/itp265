import java.time.*;
/**
 * Write a description of class TalkativeStudents here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class TalkativeStudents
{ //instance variables -- replace the example w/ your own
    private Student s1;
    private Student s2;
    
    /**
     * constructor for objects of class talkative students
     */
    public TalkativeStudents(){
        s1 = new Student("Steve", LocalDate.of(2001,4,10));
        s2 = new Student("Enzo", LocalDate.of(2001,4,17));
        
    }
    
}
