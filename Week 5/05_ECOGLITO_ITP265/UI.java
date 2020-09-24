import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * UI is a utility or helper class for ITP 265 that helps provide a friendly way to 
 * read input from a user and verify that the input is correct.
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
        System.out.println(prompt);
        // if scanner does not see a boolean, get rid of garbage and ask again.
        while (!sc.hasNextBoolean()) {
            String garbage = sc.nextLine();
            System.out.println("Didn't recognize " + garbage + " as a boolean value. Must enter: "
                + "\"true\" or \"false\"");
            System.out.println(prompt);
        }
        boolean value = sc.nextBoolean();
        sc.nextLine(); // clear the buffer
        return value;
    }

    /**
     * Prompt the user enter yes or no (will match y/yes and n/no any case) and return true for yes and false for no.
     * @param prompt: the question to ask the user 
     * @return: a boolean value 
     */
    public boolean inputYesNo(String prompt) {
        System.out.println(prompt);
        // if scanner is seeing BAD input... loop to get good input
        String answer = sc.nextLine().toLowerCase();
        while ( ! (answer.equals("y") || answer.equals("yes") 
            || answer.equals("n") || answer.equals("no") )) {

            System.out.println("Didn't recognize " + answer + " as yes or no...");
            System.out.println(prompt);
            answer = sc.nextLine().toLowerCase();
        }
        //end of loop = good input

        if(answer.equals("y") || answer.equals("yes")) {
            return true;
        }
        else {
            return false;
        }
    }

    
    /**
     * Code from: https://stackoverflow.com/questions/7528045/large-string-split-into-lines-with-maximum-length-in-java
     * 
     * This code will take a line of text and print it nicely. Since it does not need Scanner, this can be a function
     * and called directly using a call like: Helper.printLongTextWithBreaks(bigTextString, 90)
     * 
     * @param text: the long string that needs to be split to output nicely
     * @param maxLineLength 

     */
    public static void printLongTextWithBreaks(String text, int maxLineLength) {
        char NEWLINE = '\n';
        String SPACE_SEPARATOR = " ";
        //if text has \n, \r or \t symbols it's better to split by \s+
        String SPLIT_REGEXP= "\\s+";
        String[] tokens = text.split(SPLIT_REGEXP);
        StringBuilder output = new StringBuilder(text.length());
        int lineLen = 0;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];

            if (lineLen + (SPACE_SEPARATOR + word).length() > maxLineLength) {
                if (i > 0) {
                    output.append(NEWLINE);
                }
                lineLen = 0;
            }
            if (i < tokens.length - 1 && (lineLen + (word + SPACE_SEPARATOR).length() + tokens[i + 1].length() <=
                maxLineLength)) {
                word += SPACE_SEPARATOR;
            }
            output.append(word);
            lineLen += word.length();
        }
        System.out.println(output);
    }

    /**
     * This function will read from the given file (provided it is found) and return an 
     * array of Strings, with each spot in the array holding one line from the file
     * @param fileName
     * @return array of Strings, each String is one line from the file.
     */
    public static String[] readFile(String fileName) {

        String[] array = null;
        int num = 0;

        try(FileInputStream fis = new FileInputStream(fileName);
        Scanner scan = new Scanner(fis))
        { 
            //Get the number of lines in the file in order to initialize the array.
            long lineCount = Files.lines(Paths.get(fileName)).count();

            array = new String[(int)lineCount]; //typecast will work as long as file isn't too big

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                array[num] = line;
                num++;
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return array;
    }

    /**
     * Short-cut helper function that prints a String with a series of stars around it.
     * Note: it doesn't use Scanner, so can be called on the class UI instead of on an object.
     * @param output: The String to be printed
     */
    public static void printPretty(String output) {
        System.out.println("***********************************************************************************************");
        System.out.println(output);
        System.out.println("***********************************************************************************************");
    }
    
       /**
     * Short-cut helper function that prints a String.
     * Basically, it is a shortcut, so now you can type UI.print("string");
     * instead of the longer: System.out.println("string");
     * Note: it doesn't use Scanner (UI's instance variable), so can be called on 
     * the class instead of on an object.
     * @param output: The String to be printed
     */
    public static void print(String output) {
        System.out.println(output);
          }

}