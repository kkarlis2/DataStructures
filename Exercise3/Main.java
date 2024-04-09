import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Comparator1 g = new Comparator1();
        Scanner file = new Scanner(System.in);
        RandomizedBST b = new RandomizedBST(g);
        
        while(true){
            System.out.println("\n\n------------MENU----------");
            System.out.println("\n\n1)Add a file with suspects");
            System.out.println("2)Add a suspect");
            System.out.println("3)Update Savings of a suspect");
            System.out.println("4)Search a supsect by AFM");
            System.out.println("5)Search suspects by last name");
            System.out.println("6)Remove a suspect");
            System.out.println("7)Get Mean Savings of all suspects");
            System.out.println("8)Print top k suspects");
            System.out.println("9)Print all suspects by their AFM");
            System.out.println("10)Exit program");

            int k = file.nextInt();
            Scanner file2 = new Scanner(System.in);
            if(k==1){
                System.out.println("Enter the name of the file");
                String file1 = file2.nextLine();
                b.load(file1);
                continue;
            }else if(k==2){
                String suspect="";
                System.out.println("Enter the AFM");
                int k1=file2.nextInt();
                suspect+=k1;
                Scanner file3 = new Scanner(System.in);
                System.out.println("Enter the first name");
                String k2 = file3.nextLine();
                suspect+=(" "+k2);
                Scanner file4 = new Scanner(System.in);
                System.out.println("Enter the last name");
                String k3=file4.nextLine();
                suspect+=(" "+k3);
                Scanner file5 = new Scanner(System.in);
                System.out.println("Enter the savings");
                String k4 = file5.nextLine();
                suspect+=(" "+k4);
                Scanner file6 = new Scanner(System.in);
                System.out.println("Enter the taxedIncome");
                String k5 = file6.nextLine();
                suspect+=(" "+k5);
                System.out.println(suspect);
                Suspect a = new Suspect(suspect);
                a.setSavings(a.getSavings());
                b.insert(a);
                continue;
            }
            else if(k==3){
                System.out.println("Enter AFM of the suspect");
                int k1=file2.nextInt();
                System.out.println("Enter suspect's new savings");
                Scanner file3 = new Scanner(System.in);
                String k2=file3.nextLine();
                double k3 = Double.parseDouble(k2);
                b.updateSavings(k1, k3);
                continue;
            }else if(k==4){
                System.out.println("Enter AFM");
                int k1=file2.nextInt();
                b.searchByAFM(k1);
                continue;
            }else if(k==5){
                System.out.println("Enter the last name");
                String k2=file2.nextLine();
                b.searchByLastName(k2);
                continue;
            }else if(k==6){
                System.out.println("Enter AFM to remove a suspect");
                int k1=file2.nextInt();
                b.remove(k1);
                continue;
            }else if(k==7){
                System.out.println("Mean Savings:");
                System.out.println(b.getMeanSavings());
                continue;
            }else if(k==8){
                System.out.println("Enter the number of top suspects to print");
                int k1=file2.nextInt();
                b.printTopSuspects(k1);
                continue;
            }else if(k==9){
                b.printByAFM();
                continue;
            }else if(k==10){
                break;
            }else{
                System.out.println("This choice doesn't exist!Try again?(yes/no)");
                String k2 =file2.nextLine();
                if(k2=="yes"){
                    continue;
                }else{
                    break;
                }
                
            }
        }
    }
}
