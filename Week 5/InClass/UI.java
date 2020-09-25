import java.util.Scanner;
/**
 * UI is a utility or helper class for ITP 265 that helps provide a friendly way to read input from
 * a user and verify that the input is correct.
 * 
 * @author Kendra Walther
 * ITP 265
 * Email: kwalther@usc.edu 
 *
 */

public class UI {

    private Scanner sc;


    /**
     * Constructor sets up a Scanner to be used by the class in order to read input from the standard console window (System.in)
     */
    public UI() {
        sc = new Scanner(System.in);
    }


    /**
     * Prompt the user and read one line of text as a String
     * @param prompt: the question to ask the user
     * @return: a line of user input (including spaces, until they hit enter)
     */
    public String inputLine(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    /**
     * Prompt the user and read one word of text as a String
     * @param prompt: the question to ask the user
     * @return: a one word String - if the user enters multiple words, all other input until the return will be discarded.
     */
    public String inputWord(String prompt) {
        System.out.println(prompt);
        String word = sc.next();
        sc.nextLine(); // remove any "garbage" (like extra whitespace or the return key) after the one word that is read in
        return word;
    }

    /**
     * Prompt the user and read one word - which must match either option1 or option2 parameters.
     * @param prompt: the question to ask the user (should include the two valid options the user should choose from)
     * @param option1 : One string option for the user to choose.
     * @param option2: the other string option for the user to choose.
     * @return: A string matching either option1 or option2
     */
    public String inputWord(String prompt, String option1, String option2) {

        System.out.println(prompt);
        String word = sc.nextLine();
        while(! (word.equalsIgnoreCase(option1) || word.equalsIgnoreCase(option2))) {
            System.out.println(word + " not recognized as " + option1 + " or " + option2);
            System.out.println(prompt);
            word = sc.nextLine();
        }
        return word;
    }
    /**
     * Prompt the user and read an int, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: an int 
     */
    public int inputInt(String prompt) {
        System.out.println(prompt);
        // if scanner does not see an int, get rid of garbage and ask again.
        while (!sc.hasNextInt()) {
            String garbage = sc.nextLine();
            System.out.println("Didn't recognize " + garbage + " as an integer...");
            System.out.println(prompt);
        }
        int num = sc.nextInt();
        sc.nextLine(); // clear the buffer
        return num;
    }

    /**
     * Prompt the user and read an int between (inclusive) of minValue and maxValue, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: an int between minValue and maxValue
     */
    public int inputInt(String prompt, int minValue, int maxValue) {
        int num = inputInt(prompt); // make sure you get a num
        while(num < minValue || num > maxValue) {
            System.out.println(num + " is not in the allowed range: [" + minValue
                    + "-" + maxValue + "]");
            num = inputInt(prompt); // make sure you get a num

        }
        return num;
    }

    /**
     * Prompt the user and read a floating point number, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: a double value 
     */
    public double inputDouble(String prompt) {
        System.out.println(prompt);
        // if scanner does not see a double, get rid of garbage and ask again.
        while (!sc.hasNextDouble()) {
            String garbage = sc.nextLine();
            System.out.println("Didn't recognize " + garbage + " as a double.");
            System.out.println(prompt);
        }
        double num = sc.nextDouble();
        sc.nextLine(); // clear the buffer
        return num;
    }
    /**
     * Prompt the user and read a boolean value, clearing whitespace or the enter after the number
     * @param prompt: the question to ask the user 
     * @return: a boolean value 
     */
    public boolean inputBoolean(String prompt) {
        //TODO
        System.out.println("NOT yet implememted, returning false");
        return false;
    }

    /**
     * Prompt the user enter yes or no (will match y/yes and n/no any case) and return true for yes and false for no.
     * @param prompt: the question to ask the user 
     * @return: a boolean value 
     */
    public boolean inputYesNo(String prompt) {
        //TODO
        System.out.println(prompt);
        String userInput = sc.nextLine();
        while(!userInput.equalsIgnoreCase("yes") 
        || !userInput.equalsIgnoreCase("no") 
        || !userInput.equalsIgnoreCase("y") 
        || !userInput.equalsIgnoreCase("n"));{
        System.out.println(userInput + " is not recognized.");
        System.out.println(prompt);
        userInput = sc.nextLine();
        }
        reutrn userInput.equalsIgnoreCase("y") }} answer.equalsIgnoreCase("yes"); 
    }

}