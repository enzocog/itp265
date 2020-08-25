
/**
 * Simple program to print hello
 *
 * @author Enzo Coglitore
 * ITP 265, Fall 2020, Coffee
 * email: ecoglito@usc.edu
 */

import java.util.Scanner;
public class HelloWorld
{

    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        String userName;
        
        System.out.println("Enter text: ");
        userName = myObj.nextLine();
        
        System.out.print("The text you entered was:" + userName);
        
    } 

    public int getNumber(){
        return 789;
    }
}
