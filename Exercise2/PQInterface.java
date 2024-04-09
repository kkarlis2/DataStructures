public interface PQInterface  {
    
    boolean isEmpty();

    int size();

    void insert(City x);

    City max();

    City getmax(); 

    City remove(int id);
}
