
import java.util.Arrays;
import java.util.*;
import java.lang.*;



public class PQ  implements PQInterface{
    

    public  Object[][] data;
    public City x;
    private int size; 
    public Comparator1 comparator;

    private static final int DEFAULT_CAPACITY = 4; 
    private static final int AUTOGROW_SIZE = 4;
    

    public PQ(Comparator1 comparator){
        this.data
         = new Object[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void insert(City x){

        if (size >= data.length*0.75-1){
            resize();
        }
        int index=this.size+1;
        data[index][0] = x.getID();
        data[index][1] = x.getName();
        data[index][2] = x.getPopulation();
        data[index][3] = x.getCovidCases();
        this.size++;
        swim(index);



    }
    public City max(){
        if (isEmpty()){
            return null;
        }
        City k= new City((String.valueOf(data[1][0])+" "+(String.valueOf(data[1][1])+" "+String.valueOf(data[1][2])+" "+String.valueOf(data[1][3]))));
        return k;
    }

    private void resize(){
        Object[][] newData = new Object[data.length+AUTOGROW_SIZE][4];
        for (int i=0;i<=size;i++){
            newData[i]= data[i];
        }
        data=newData;
    }

    public void swim(int i) {
        boolean a= true;
        if (i == 1){
            a=false;
        }
            

        int parent = i / 2;
        while (i!=1 ){
            if (comparator.compare_densities(data,i,parent)>0) {
                swap(i, parent);
                i = parent;
                parent = i / 2;
                continue;
            }else if(comparator.compare_densities(data,i,parent)==0 && comparator.compareString((String)data[i][1],(String)data[parent][1])<0){
                swap(i, parent);
                i = parent;
                parent = i / 2;
                continue;
            }else if(comparator.compare_densities(data,i,parent)==0 && comparator.compareString((String)data[i][1],(String)data[parent][1])==0 && comparator.compare_integers(data[i][0],data[parent][0])<0){
                swap(i, parent);
                i = parent;
                parent = i / 2;
                continue;
            }
            break;
        }

    }



    public City getmax(){
        if (isEmpty()){
            return null;
        }
        City k= new City((String.valueOf(data[1][0])+" "+(String.valueOf(data[1][1])+" "+String.valueOf(data[1][2])+" "+String.valueOf(data[1][3]))));
        data[1]=data[size];
        this.size--;
        sink(1);
        return k;
    }

    public void sink(int i){
        int left = 2*i;
        int right = left +1;

        if (left > size){
            return;
        }
        while (left <= size) {
            int max = left;
            if (right <= size) {
                if (comparator.compare_densities(data,left,right) < 0)
                    max = right;
                else if(comparator.compare_densities(data,left,right) == 0 && comparator.compareString((String)data[left][1], (String)data[right][1])<0)
                    max=right;
                else if(comparator.compare_densities(data,left,right) == 0 && comparator.compareString((String)data[left][1], (String)data[right][1])==0 && comparator.compare_integers(data[left][0],data[right][0])>0){
                    max=right;
                }
            }

            if (comparator.compare_densities(data,i,max) >= 0)
                return;
            else {
                swap(i, max);
                i = max;
                left = i * 2;
                right = left + 1;
            }
        }
    }

    public void swap(int i, int j) {
    	Object[] tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public City remove(int id){
        if (isEmpty()){
            return null;
        }
        for(int i=1;i<=size;i++){
            if((Integer)data[i][0]==id){
                City k= new City((String.valueOf(data[i][0])+" "+(String.valueOf(data[i][1])+" "+String.valueOf(data[i][2])+" "+String.valueOf(data[i][3]))));
                if (max()==k){
                    getmax();
                }else{
                    for(int q=i;q<=size()-1;q++){
                        data[q]=data[q+1];
                    }
                    this.size--;
                }
                return k;
            }
        }
        return null;

    }
  
}
