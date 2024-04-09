
import java.util.NoSuchElementException;
import java.io.PrintStream;
import java.util.Scanner;


public class Main2 {
    public static void main(String[] args){
        try{
            Scanner mystring = new Scanner(System.in);
            System.out.println("Enter DNA sequence: ");
            String str1=mystring.nextLine();
            StringDoubleEndedQueueImpl palindrome = new StringDoubleEndedQueueImpl();
            DNAPalindrome a = new DNAPalindrome(str1,palindrome);
            while(a.isCorrectInput(str1)==false){
                System.out.println("This DNA sequence doesn't exist.Please enter a valid one!");
                str1=mystring.nextLine();
            }
            a.isWaston(str1);
        }catch(NoSuchElementException ex){
            System.out.println("Queue is Empty!!!");
        }
    }
}
