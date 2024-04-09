
import java.util.NoSuchElementException;
import java.io.PrintStream;

public class DNAPalindrome extends StringDoubleEndedQueueImpl{
    public String DNA;
    public StringDoubleEndedQueueImpl palindrome;

    public DNAPalindrome(String DNA,StringDoubleEndedQueueImpl palindrome){
        this.DNA=DNA;
        this.palindrome=palindrome;
    }

    
    public boolean isCorrectInput(String DNA){
        boolean a=true;
        for(int i=0;i<DNA.length();i++){
            if(DNA.charAt(i)!='A'&&DNA.charAt(i)!='T'&&DNA.charAt(i)!='C'&&DNA.charAt(i)!='G'){
                a=false;   
            }
        
        }
        if (a){
            return true;
        }else{
            return false;
        }
    }

    public char isComplemented(String DNA,int i){
            if (DNA.charAt(i)=='A'){
                char a='T';
                return a;
            }else if(DNA.charAt(i)=='T'){
                char a = 'A';
                return a;
            }else if(DNA.charAt(i)=='G'){
                char a = 'C';
                return a;
            }else{
                char a='G';
                return a;
            }
        }

    public void isWaston(String DNA){
        int b=DNA.length();
        boolean d =true;
        for(int i=0;i<DNA.length();i++){
            b--;
            char a = isComplemented(DNA, i);
            palindrome.addLast(String.valueOf(a));
            if(palindrome.getLast().charAt(0)!=DNA.charAt(b)){
                d=false;
            }
        }
        if (d){
            if(palindrome.size()>0){
                System.out.println("The sequence DNA of :"+DNA+" is Watson-Crick complemented palindorme : ");
                palindrome.printQueue(System.out);
            }else{
                System.out.println("The sequence DNA of : '' is Watson-Crick complemented palindrome!");
            }

        }else{
            System.out.println("The sequence DNA of :"+DNA+" is NOT Watson-Crick complemented palindorme because the complemented sequence is : ");
            palindrome.printQueue(System.out);
        } 
    }
}
