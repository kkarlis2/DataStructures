import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dynamic_Median {
    PriorityQueue<Integer> Minimum = null;
    PriorityQueue<Integer> Maximum = null;
    String line,file;
    BufferedReader reader;

    public Dynamic_Median(String file){
        Minimum = new PriorityQueue<>();
        Maximum = new PriorityQueue<>(Comparator.reverseOrder());
        this.file=file;
    }

    public void insert(int density){
        Minimum.offer(density);
        Maximum.offer(Minimum.poll());

        if(Minimum.size()<Maximum.size()){
            Minimum.offer(Maximum.poll());
        }
    }

    public double Median(){
        if(Minimum.size() >Maximum.size()){
            return Minimum.peek();
        }else{
            if(Minimum.peek()>Maximum.peek()){
                return Minimum.peek();
            }else{
                return Maximum.peek();
            }
        }
    }

    public void  Getdata()
    {
        try{
            int i=0;
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while (line!=null){ 
                City a=new City(line);
                int density=50000*a.getCovidCases()/a.getPopulation();
                insert(density);
                line = reader.readLine();
                i++;
                if(i%5==0){
                    System.out.println("Median at first "+i+" cities is  : "+Median());
                }
            }
            reader.close();
            System.out.println("Final Median is : "+Median());
            
        }catch (IOException e) {
            System.out.println("Error!!!");
        }
    }
}

