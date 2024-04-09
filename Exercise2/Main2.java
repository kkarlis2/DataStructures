import java.util.Arrays;

public class Main2 {
    public static void main(String[] args){
        City a = new City("23 Manchester 510746 1200");
        City b = new City("31 Amsterdam 821752 678");
        City c = new City("58 Athens 3218218 3504");
        City d = new City("124 Karditsa 56747 78");
        City e = new City("6 Arta 43166 5");
        Comparator1 g = new Comparator1();
        PQ pq = new PQ(g);
        pq.insert(b);
        pq.insert(a);
        pq.insert(c);
        pq.insert(d);
        pq.insert(e);
        System.out.println(pq.size());
        System.out.println(pq.remove(124).getName());
        pq.insert(b);


        

    

    }
}
