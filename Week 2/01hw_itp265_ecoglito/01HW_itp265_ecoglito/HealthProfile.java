/**
 * This provides a health record of a user.
 *
 * @author Enzo Coglitore
 * ITP 265, Term Year (Fall 2020), Class Session (Coffee)
 * Assignment 01
 * Email: ecoglito@usc.edu
 */
import java.util.Scanner; //import scanner
import java.time.LocalDate; //import date
public class HealthProfile
{ //initalize  variables
  private String firstName;
  private String lastName;
  private String Gender;
  private char genderChar;
  private int birthMonth;
  private int birthDay;
  private int birthYear;
  private double Height;
  private double Weight;
  private String covidChecker;
  private boolean covidPositive;
  private String allergyList;
  public void inputPatientInformation(){ //do user input
      Scanner myScanner = new Scanner(System.in);
      System.out.println("Welcome to the HealthProfile system. Please enter patient information.");
      System.out.println("Please enter first name:");
      firstName = myScanner.nextLine();
      
      System.out.println("Please enter last name:");
      lastName = myScanner.nextLine();
      System.out.println("Please enter gender (M/F/O):");
      
      Gender = myScanner.nextLine();
      genderChar = Gender.charAt(0);
      
      System.out.println("Please enter birth month (1-12):");
      birthMonth = myScanner.nextInt();
      
      System.out.println("Please enter birth day (1-31):");
      birthDay = myScanner.nextInt();
      
      System.out.println("Please enter four digit birth year:");
      birthYear = myScanner.nextInt();
      
      System.out.println("Please enter height in inches:");
      Height = myScanner.nextInt();
      
      System.out.println("Please enter weight in pounds:");
      Weight = myScanner.nextInt();
      
      System.out.println("Have you tested positive for Covid (Y/N)");
      myScanner.nextLine();
      covidChecker = myScanner.nextLine();
      if (covidChecker.equalsIgnoreCase("y")) {
          covidPositive = true;
        }
       else {
           covidPositive = false;
        }
      
      System.out.println("Please enter all of your allergies in a list:");
      allergyList = myScanner.nextLine();
    }
  public void printRecord(){ //print simple record
       System.out.println("Name: " + firstName + " " + lastName);
       System.out.println("Gender: " + genderChar);
       System.out.println("DOB: " + birthMonth + "/" + birthDay + "/" + birthYear);
       System.out.println("Height: " + Height + " inches");
       System.out.println("Weight: " + Weight + " pounds");
       System.out.println("Allergies: " + allergyList);
    }
  public int calculateAge(){ //calculate user age w/ specific date accountability
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();
    if (month < birthMonth) {
        birthYear = birthYear + 1;
    }
    else if (month == birthMonth && day < birthDay) {
        birthYear = birthYear + 1;
    };
    return year - birthYear;
}
  public String getTargetHeartRateInfo(){ //get target heart rate
    LocalDate today = LocalDate.now();
    int year = today.getYear();
    int month = today.getMonthValue();
    int day = today.getDayOfMonth();
    int maximumHeartRate = 220 - calculateAge();
    double targetHeartRateLower = maximumHeartRate * 0.5;
    double targetHeartRateUpper = maximumHeartRate * 0.85;
    String heartRate = ("Maximum Heart Rate: " + maximumHeartRate + " beats per minute. Target Heart Range: " + targetHeartRateLower + " - " + targetHeartRateUpper);  
    return heartRate;
    }
  public void displayBMIChart(){ //get the bmi chart and print values
     double bmiValue = (703 * (Weight/(Height*Height)));
     String bmiType = "";
     if (bmiValue < 18.5) {
         bmiType = "Underweight";
        }
     else if (bmiValue >= 18.5 && bmiValue <= 24.9) {
         bmiType = "Normal";
        }
     else if (bmiValue > 24.9 && bmiValue <= 29.9) {
         bmiType = "Overweight";
        }
     else if (bmiValue > 29.9) {
        bmiType = "Obese";
        }
     System.out.println("BMI Values:");
     System.out.println("Underweight: less than 18.5");
     System.out.println("Normal: between 18.5 and 24.9");
     System.out.println("Overweight: between 25 and 29.9");
     System.out.println("Obese: 30 or greater."); 
     System.out.println("");
     System.out.println("Your BMI value is: " + bmiValue + " which puts you in the " + bmiType + " category."); 
  }
  public void printFancyRecord(){ //print out fancy record
      for (int i = 0; i <75; i++){
        System.out.print("*");
    };
    System.out.println("");
    System.out.println("Health Profile:");
    System.out.println("* Name: " + firstName + " " + lastName);
    System.out.println("* Gender: " + genderChar);
    System.out.println("* DOB: " + birthMonth + "/" + birthDay + "/" + birthYear);
    System.out.println("* Height: " + Height + " inches");
    System.out.println("* Weight: " + Weight + " pounds");
    System.out.println("* Age: " + calculateAge());
    System.out.println("* ❤ Info: " + getTargetHeartRateInfo());
    System.out.println("* ALLERGIES: " + allergyList);
    if (covidPositive){
        System.out.println("* ALERT: COVID POSITIVE");
    }
    for (int i = 0; i <75; i++){
        System.out.print("*");
    };
  }
}
