import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner file = new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String file1 = file.nextLine();
        System.out.println("Enter the number of towns");
        int k = file.nextInt();
        Covid_k b = new Covid_k(file1,k);
        b.Getdata();
    }
}
