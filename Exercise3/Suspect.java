import java.lang.*;


public class Suspect {
    private int AFM;
    private String firstName,lastName;
    private double Savings,taxedIncome;
    String line;

    public Suspect(String line){
        this.line=line;
    }

    public int key(){
        return getAFM();
    }

    public int getAFM(){
        String AFM1="";
        for(int i=0;i<5;i++){
            if(Character.isDigit(line.charAt(i))){
                AFM1+=String.valueOf(line.charAt(i));
                continue;
            }
            break;
        }
        int AFM=Integer.parseInt(AFM1);
        return AFM;
    }
    public  String getFirstName(){
        String FirstName1="";
        for(int i=line.indexOf(" ")+1;i<line.length();i++){
            if(Character.isLetter(line.charAt(i))){
                FirstName1+=String.valueOf(line.charAt(i));
                continue;
            }
            break;
        }
        return FirstName1;
    }

    public String getLastName(){
        String LastName1="";
        for(int i=line.indexOf(" ",line.indexOf(" ")+1)+1;i<line.length();i++){
            if(Character.isLetter(line.charAt(i))){
                LastName1+=String.valueOf(line.charAt(i));
                continue;
            }
            break;
        }
        return LastName1;
    }

    public double getSavings(){
        String Savings1="";
        for(int i=line.indexOf(" ",line.indexOf(" ",line.indexOf(" ")+1)+1)+1;i<line.length();i++){
            if(Character.isDigit(line.charAt(i))){
                Savings1+=String.valueOf(line.charAt(i));
                continue;
            }else if(line.charAt(i)=='.'){
                Savings1+=String.valueOf(line.charAt(i));
                continue;
            }
            break;
        }
        Double Savings=Double.parseDouble(Savings1);
        return Savings;
    }

    public double getTaxedIncome(){
        String TaxedIncome1="";
        String TaxedIncome2="";
        for(int i=line.length()-1;i>-1;i--){
            if(Character.isDigit(line.charAt(i))){
                TaxedIncome1+=String.valueOf(line.charAt(i));
                continue;
            }else if(line.charAt(i)=='.'){
                TaxedIncome1+=String.valueOf(line.charAt(i));
                continue;
            }
            break;
        }
        for(int i=TaxedIncome1.length()-1;i>=0;i--){
            TaxedIncome2+=String.valueOf(TaxedIncome1.charAt(i));
        }
        Double taxedIncome=Double.parseDouble(TaxedIncome2);
        return taxedIncome;
    }

    public void setAFM(int AFM){
        this.AFM=AFM;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setSavings(double Savings){
        this.Savings=Savings;
    }

    public void setTaxedIncome(double taxedIncome){
        this.taxedIncome=taxedIncome;
    }

    public String toString(){
        return "\nSuspect data:\nAFM:"+getAFM()+"\nFirst name:"+getFirstName()+"\nLast name:"+getLastName()+"\nSavings:"+Savings+"\nTaxedIncome:"+getTaxedIncome()+"\n";
    }


}
