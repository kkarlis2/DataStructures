
import java.util.NoSuchElementException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main1 {
    public static void main (String[] args){
        try{

            Scanner mystring = new Scanner(System.in);
            System.out.println("Enter PostFix: ");
            String str1=mystring.nextLine();
            StringDoubleEndedQueueImpl Infix = new StringDoubleEndedQueueImpl();
            PostfixToInfix a = new PostfixToInfix(str1,Infix);

            a.conversion(str1);
        }catch(NoSuchElementException ex){
            System.out.println("Queue is Empty!!!");
        }


    }
    
}
