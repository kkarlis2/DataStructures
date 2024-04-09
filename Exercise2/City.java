import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.Arrays;




public class City implements CityInterface{
    String line;
    int ID3,population3,Covid_Cases3;
    String Cities3;
    Object data[][];

    
    public City(String line){
        this.line=line;
    }

    public int getID(){
        String ID="";
        for (int i=0;i<line.length();i++){
            if (Character.isDigit(line.charAt(i))){
                ID+=String.valueOf(line.charAt(i));
                continue;
            }
            break;
        }
        int ID1 =Integer.parseInt(ID);
        if(ID1<0||ID1>999){
            System.out.println("Error at ID"); 
            System.exit(0);
        }
        return ID1;
    }

    public String getName(){
        String Cities="";
        for (int i=line.indexOf(" ")+1;i<line.length();i++){
            if (Character.isLetter(line.charAt(i))){
                Cities+=String.valueOf(line.charAt(i));
                continue;
            }else if(line.charAt(i)==' ' && Character.isLetter(line.charAt(i+1))){
                Cities+=String.valueOf(line.charAt(i));
                continue;
            }else{
                break;
            }
        }
        if (Cities.length()>50){
            System.out.println("Error at a name of City");
            System.exit(0);
        }
        return Cities;
    }
    
    public int getPopulation(){
        String Population="";
        for (int i=line.indexOf(" ",line.indexOf(" ")+1)+1;i<line.length();i++){
            if (Character.isDigit(line.charAt(i))){
                Population+=String.valueOf(line.charAt(i));
                continue;
            }else if(line.charAt(i)==' ' && Character.isLetter(line.charAt(i+1))){
                continue;
            }else if(line.charAt(i)==' '&&Population.length()!=0){
                break;
            }else{
                continue;
            }
        }
        int Population1=Integer.parseInt(Population);
        if(Population1<0||Population1>10000000){
            System.out.println("Error at Population");
            System.exit(0);
        }
        return Population1;
    }
    
    public int getCovidCases(){
        String Cases ="";
        String Cases1="";
        for(int i=line.length()-1;i>-1;i--){
            if (Character.isDigit(line.charAt(i))){
                Cases+=String.valueOf(line.charAt(i));
                continue;
            }else if(line.charAt(i)==' '){
                break;
            }
        }
        for(int i=Cases.length()-1;i>=0;i--){
            Cases1+=String.valueOf(Cases.charAt(i));
        }
        int Cases2=Integer.parseInt(Cases1);
        return Cases2;
    }
    
    public void setID(int ID){
        this.ID3=ID;
    }
    
    public void setName(String name){
        this.Cities3=name;
    }
    
    public void setPopulation(int population){
        this.population3=population;
    }
    
    public void setCovidCases(int CovidCases){
        
        this.Covid_Cases3=CovidCases;
    }

    
}
