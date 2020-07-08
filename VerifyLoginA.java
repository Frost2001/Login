package Processors;
import java.util.*;
import java.io.*;
public class VerifyLoginA {
    private static Scanner x;   // declares scanner
public void VerifyLoginA(String usernameA, String passwordA, boolean check) {
        boolean flag = false;     // boolean variable set to false for later use
        String tempUsernameA = "";  // variable used for extracting the username from txt file and storing in this
        String tempPasswordA = "";  // variable used for extracting the password from txt file and storing in this
        try {
              x = new Scanner(new File("membersA.txt")); //opens the file "membersA.txt"
              x.useDelimiter("[,\n]");    // use of delimiter to specify the seperation of username & password by ","
             // delimiter is one or more characters for specifying the boundary between plain text, "\n" moves on to the next line
              boolean passedA = false;     // boolean variable set to false and later use
            while (x.hasNext()&& !flag){  // use of while to check if the file has any contents 
                
                tempUsernameA = x.next(); // extracts the username and stores it 
                tempPasswordA = x.next();// extracts the password and stores it 
                if (tempUsernameA.trim().equals(usernameA.trim()) && tempPasswordA.trim().equals(passwordA.trim())) {
                    passedA = true; // use of trim to remove any unwanted space in user input or in txt file
                    break; // boolean passedA becomes true if the username and passwords entered by user match the ones in file
                }
            }
            if(passedA) { // if passedA is true then prints succesful message
                System.out.println("**************Login Succesful****************");
                check=true;
            }else { // if passedA is false then prints a error message
                System.out.println("********WARNING**Incorrect Username or Password*********");
                check=false;
            }
            
            
            
        }
        catch (Exception e){ // prints error if there is an error in opening the file
            System.out.println("Error");
        }
    }
}