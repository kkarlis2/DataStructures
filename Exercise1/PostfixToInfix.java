
import java.util.NoSuchElementException;
import java.io.PrintStream;


public class PostfixToInfix extends StringDoubleEndedQueueImpl{
    public String PostFix;
    public StringDoubleEndedQueueImpl Infix;

    public PostfixToInfix(String PostFix, StringDoubleEndedQueueImpl Infix){

        this.PostFix=PostFix;
        this.Infix=Infix;
    }

    public boolean isaNumber(String PostFix,int i){
        if(PostFix.charAt(i)>='0' && PostFix.charAt(i)<='9'){
            return true;
        }else{
            return false;
        }
    }

    public void conversion(String PostFix){
        int nums=0;
        int operators=0;
        for(int i=0;i<PostFix.length();i++){
            if (isaNumber(PostFix, i)){
                Infix.addLast(String.valueOf(PostFix.charAt(i)));
                nums++;
                if(i+1==PostFix.length()){
                    if ((isaNumber(PostFix, 0)==false||isaNumber(PostFix, 1)==false)||nums<=operators-1){
                        System.out.println("Not valid PostFix form");
                        break;
                    }else{
                        Infix.printQueue(System.out);
                    }
                }
            }else if(PostFix.charAt(i)=='+'||PostFix.charAt(i)=='-'||PostFix.charAt(i)=='/'||PostFix.charAt(i)=='*'){
                operators++;
                if(i+1==PostFix.length()){
                    if ((isaNumber(PostFix, 0)==false|| isaNumber(PostFix, 1)==false)||nums<=operators){
                        System.out.println("Not valid PostFix form");
                        break;
                    }
                }
                if (Infix.isEmpty()){
                    Infix.addLast("("+String.valueOf(PostFix.charAt(i)+")"));
                    if(i+1==PostFix.length()){
                        Infix.printQueue(System.out);
                    }
                }else if(Infix.size()==2 && PostFix.charAt(i)=='/'){
                    String one = Infix.getLast();
                    Infix.removeLast();
                    String two = Infix.getLast();
                    Infix.removeLast();
                    Infix.addLast("("+two+")"+String.valueOf(PostFix.charAt(i)+one));
                    if(i+1==PostFix.length()){
                        Infix.printQueue(System.out);
                    }
                }else if(Infix.size()>2){
                    String one = Infix.getLast();
                    Infix.removeLast();
                    String two = Infix.getLast();
                    Infix.removeLast();
                    Infix.addLast("("+two+String.valueOf(PostFix.charAt(i)+one+")"));
                    if(i+1==PostFix.length()){
                        Infix.printQueue(System.out);
                    }
                }else if(Infix.size()==2){
                    String one = Infix.getLast();
                    Infix.removeLast();
                    String two = Infix.getLast();
                    Infix.removeLast();
                    Infix.addLast(two+String.valueOf(PostFix.charAt(i)+one));
                    if(i+1==PostFix.length()){
                        Infix.printQueue(System.out);
                    }
                }
                else{
                    String one = Infix.getLast();
                    Infix.removeLast();
                    Infix.addLast("("+one+String.valueOf(PostFix.charAt(i)+")"));
                    if(i+1==PostFix.length()){
                        Infix.printQueue(System.out);
                    }
                }

            }else{
                System.out.println("Unknown characters!");
                break;
            }
        }
        

    }
}