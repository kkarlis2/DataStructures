import java.util.Scanner;


public class Main3 {
    public static void main(String[] args){
        Scanner file = new Scanner(System.in);
        System.out.println("Enter the name of the file");
        String file1 = file.nextLine();
        System.out.println("Enter the number of towns");
        int k = file.nextInt();

        Comparator1 g = new Comparator1();
        PQ pq = new PQ(g);
        DynamicCovid_k_withPQ a= new DynamicCovid_k_withPQ(g, pq, file1, k);
        a.ReadFile();
    }
}
