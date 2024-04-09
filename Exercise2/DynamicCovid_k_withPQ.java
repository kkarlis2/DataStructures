import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class DynamicCovid_k_withPQ {
    Comparator1 g;
    PQ pq;
    String line,file;
    int k;
    BufferedReader reader;


    public DynamicCovid_k_withPQ(Comparator1 g,PQ pq,String file,int k){
        this.g=g;
        this.pq=pq;
        this.file=file;
        this.k=k;
    }


    public void ReadFile(){
        try{
            int lines=0;
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            lines++;
            while (line!=null){
                City a=new City(line);
                pq.insert(a);
                if(pq.size()>k){
                    for(int i=2;i<=k;i++){
                        if (pq.comparator.compare_densities(pq.data,i,k+1) < 0)
                            pq.swap(i,k+1);
                        else if(pq.comparator.compare_densities(pq.data,i,k+1) == 0 && pq.comparator.compareString((String)pq.data[i][1], (String)pq.data[k+1][1])<0)
                            pq.swap(i,k+1);
                        else if(pq.comparator.compare_densities(pq.data,i,k+1) == 0 && pq.comparator.compareString((String)pq.data[i][1], (String)pq.data[k+1][1])==0 && pq.comparator.compare_integers(pq.data[i][0],pq.data[k+1][0])>0){
                            pq.swap(i,k+1);
                            }
                        
                    }
                    pq.remove((Integer)pq.data[k+1][0]);
                    
                }
                if(lines==5){
                    System.out.println("Top "+k+" cities until now are:");
                    for(int i=1;i<=pq.size();i++){
                        System.out.println(i+") "+pq.data[i][1]);
                    }
                    lines=0;
                }
                line = reader.readLine();
                lines++;
            }
            reader.close();
            System.out.println("The top "+k+" cities are:");
            for(int i=1;i<=k;i++){
                System.out.println(i+") "+pq.getmax().getName());
            }
        }catch(IOException e){
            System.out.println("Error!!!");
        }
    }
}
