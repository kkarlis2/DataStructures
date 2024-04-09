

public class Comparator1 {

    public int compare_integers(Object t1, Object t2) {
        return (Integer) t1 - (Integer) t2;
    }

    public int compareString (String t1, String t2){
        int i =0;
        while(i<t1.length()&& i<(t2).length()){
            if((t1.charAt(i)>t2.charAt(i))){
                return 1;
            }
            else if(t1.charAt(i)<(t2.charAt(i))){
                return -1;
            }else{
                i++;
                continue;
            }
        }
        return 0;
    }

    public int compare_densities(Object[][] t1,int i,int parent){
        if((Integer)t1[i][3]*50000/(Integer)t1[i][2]>(Integer)t1[parent][3]*50000/(Integer)t1[parent][2]){
            return 1;
        }else if((Integer)t1[i][3]*50000/(Integer)t1[i][2]<(Integer)t1[parent][3]*50000/(Integer)t1[parent][2]){
            return -1;
        }else{
            return 0;
        }
        
    }
}
