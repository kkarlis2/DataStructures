public class Comparator1 {
    public int compare_savings(Object Savings1,Object Savings2){
        if((double)Savings1>9000 &&(double)Savings2>9000){
            return 0;
        }
        else if((double)Savings1>9000 && (double)Savings2<9000){
            return 2;
        }else if((double)Savings1<9000 && (double)Savings2>9000){
            return 1;
        }
        else if ((double)Savings1<9000 && (double)Savings2<9000){
            if((double)Savings1>(double)Savings2){
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }

    public int compare_diff(Suspect[] t1,int i1,int i2){
        if(((double)t1[i1].getSavings()-(double)t1[i1].getTaxedIncome())-((double)t1[i2].getSavings()-(double)t1[i2].getTaxedIncome())>0){
            return 1;
        }else{
            return 2;
        }
    }
}
