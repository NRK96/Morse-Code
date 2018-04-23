/*Name: Nicholas Keen
 *Course: Computer Science II - CIS 203
 *Assignment: 10
 *Due: May 8 2015
*/


import java.io.*;
import java.util.*;

//Decodes Morse Code and puts the decrypted message in a file
public class Decode {
    public static void main(String args[])
              throws FileNotFoundException{
        //Reads the "Coded" file
        Scanner fileScanner = new Scanner(new File("Coded.txt"));
        //Creates a file called "Decoded.txt"
        File file = new File("Decoded.txt");
        ArrayList<String> s = readFile(fileScanner);
        String decoded = translate(s);
        //Opens a printstream on the "decoded" file
        PrintStream ps = new PrintStream("Decoded.txt");
        //Prints the decoded message into the "decoded" file
        ps.print(decoded);
    }

    //Returns: a String - The decoded answer
    //Parameter: s - A String[] containing the coded file
    public static String translate(ArrayList<String> s){
        String result = "";
        char letter;
        //Goes through the entire array
        for(int i = 0; i < s.size(); i++){
            //Checks for coded strings
            if(morseCheck(s.get(i))){
                //Decodes and adds letterss to the string
                letter = MorseCode.getLetter(s.get(i));
                result += letter;
            }else
                //Otherwise string is not coded and can be added directly
                result += s.get(i);
        }
        return result;
    }

    //Returns: an ArrayList<String> - Contains the coded file
    //Parameter: fileScanner - A scanner open on the "coded" file
    public static ArrayList<String> readFile(Scanner fileScanner){
        ArrayList<String> s = new ArrayList<String>();
        //Ensures theres another line
        while(fileScanner.hasNextLine()){
            //Takes each line individually and scans it for words
            String line = fileScanner.nextLine();
            Scanner wordScanner = new Scanner(line);
            //Ensures theres another word
            while(wordScanner.hasNext()){
                //Takes each word and scans it for tokens
                String word = wordScanner.next();
                //Gets rid of the '|' character replacing them with spaces
                word = word.replace('|', ' ');
                Scanner tokenScanner = new Scanner(word);
                //Ensures theres another token
                while(tokenScanner.hasNext()){
                    //Adds each token into the array
                    String token = tokenScanner.next();
                    s.add(token);
                }
                //Adds a space after each word
                s.add(" ");
            }
            //Begins a new line after each line
            s.add("\n");
        }
        return s;
    }

    //Returns: boolean - False if it is not coded, true otherwise
    //Parameter: s - The string that is going to be examined
    public static boolean morseCheck(String s){
        //Goes through the whole string to check for coded letters
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '-' && s.charAt(i) != '.')
                //Letter isn't coded
                return false;
        }
        //Otherwise letter is coded
        return true;
    }
}
