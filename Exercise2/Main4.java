import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        Scanner file = new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String file1 = file.nextLine();

        Dynamic_Median a = new Dynamic_Median(file1);
        a.Getdata();
    }
}
