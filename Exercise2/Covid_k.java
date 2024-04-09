import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.Arrays;


public class Covid_k {
    String line,file;
    int k;
    BufferedReader reader;
    int ID[]= new int [2];
    int population[] = new int[2];
    int Covid_Cases[] = new int[2];
    String[] Countries = new String[2];
    Object[][] data = new Object[3][4];
    Object[] onemore = new Object[4];


    public Covid_k(String file,int k){
        this.file=file;
        this.k=k;
    }

    public static int calculateDensity(Object Array[][],int high,int j){
        if((Integer)Array[j][3]*50000/(Integer)Array[j][2]>(Integer)Array[high][3]*50000/(Integer)Array[high][2]){
            return 1;
        }else if((Integer)Array[j][3]*50000/(Integer)Array[j][2]==(Integer)Array[high][3]*50000/(Integer)Array[high][2]){
            return 2;
        }else{
            return 0;
        }
    }

    public Object Comparable(Object[][] Array,int j,int high,int i){
        String s1=(String)Array[j][1];
        String s2 = (String)Array[high][1];
        if (s1== s2){
            if((Integer)Array[j][0]<(Integer)Array[high][0]){
                Object a[]=Array[i];
                Array[i]=Array[j];
                Array[j]=a;
            }
        }else if(s1.compareTo(s2)>0 ){
            Object a[]=Array[i];
            Array[i]=Array[j];
            Array[j]=a;
            
        }
        return Array;
    }

    public void quickSort(Object Array[][] ,int low ,int high){
        if(low<high){
            int w = partition(Array, low ,high);
            quickSort(Array, low, w-1);
            quickSort(Array, w+1, high);
        }
    }

    public int partition(Object Array[][],int low , int high){
        int i =(low -1);
        for (int j=low;j<= high-1;j++)
        {
            if(calculateDensity(Array,high,j)==1){
                i++;
                Object a[]=Array[i];
                Array[i]=Array[j];
                Array[j]=a;
            }else if(calculateDensity(Array,high,j)==2){
                String s1=(String)Array[j][1];
                String s2 = (String)Array[high][1];
                if (s1== s2){
                    if((Integer)Array[j][0]<(Integer)Array[high][0]){
                        i++;
                        Object a[]=Array[i];
                        Array[i]=Array[j];
                        Array[j]=a;
                    }
                }else if(s1.compareTo(s2)<0 ){
                    i++;
                    Object a[]=Array[i];
                    Array[i]=Array[j];
                    Array[j]=a;
                }
            }
        }
        Object b[] =Array[i+1];
        Array[i+1]=Array[high];
        Array[high]=b;
        return (i+1);
    }


    public void  Getdata()
    {
        try{
            int i=0;
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while (line!=null){ 
                City a=new City(line);
                if(data[data.length-1][0]!=null){
                    data=Arrays.copyOf(data, data.length+1);
                    data[data.length-1]=onemore;
                    onemore=new Object[onemore.length];
                }
                data[i][0]=(Integer)a.getID();
                data[i][2]=a.getPopulation();
                data[i][3]=a.getCovidCases();
                data[i][1]=a.getName();

                line = reader.readLine();
                i++;
            }
            reader.close();
            quickSort(data , 0, data.length-1);
            System.out.println("The top "+k+ "cities are:");
            for(i=0;i<k;i++){
                System.out.println(data[i][1]);
            }
            
        }catch (IOException e) {
            System.out.println("Error!!!");
        }
    }

    
    
}

