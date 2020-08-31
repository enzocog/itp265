
/**
 * Making a studnet object to represent our classmates
 * 
 */

import java.time.LocalDate;
public class Student
{
    // instance variables -- attrivutes of objects of this class type
    // think of a student FORM and we would want to fill out the necessary informaiton'
    private String name;
    private double gpa;
    private String major;
    private String minor;
    private String extracurriculars;
    private String favoriteDinosaur;
    private LocalDate birthday;
    
    public static final String CLASS_SECTION = "coffee";
    
    public Student(String name, LocalDate bday){
        this.name = name;
        birthday = bday;
        // do defaults for the other variables
    
    }
    
    public Student(String name, double gpa, String major, String minor, String ec, String favDinosaur, LocalDate bday){
        this.name = name; 
        this.gpa = gpa;
        this.major = major;
        this.extracurriculars = ec;
        this.favoriteDinosaur = favDinosaur;
        birthday = bday;
    }
    /**
     * Constructor for objects of class Student
     * Default is optional, but if you don't have one, Java will make one for you by setting all instance variables to
     * default values (null, 0, 0.0, false)
     */
    
    /*
    public Student()
    {
        //initialise instance variables
        name = "";
        
    }
    */
    
}
