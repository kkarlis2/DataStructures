public class List {
    private Node head=null;
    private Node tail=null;
    int size=0;

    public List(){}

    public boolean isEmpty(){
        return head==null;
    }

    public void insertAtback(Suspect item){
        Node n = new Node(item);

        if(isEmpty()){
            head=n;
            tail=n;
        }else{
            tail.setNext(n);
            tail=n;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public Suspect[] Topk(Suspect[] TopSuspect){
        Node k=head;
        for(int i=0;i<size();i++){
            if(k!=null){
                TopSuspect[i]=k.getItem();
                k=k.getNext();
            }else{
                k=k.getNext();
            }
        }
        return TopSuspect;
    }
    public String toString(){
        Node k=head;
        while(k!=null){
            System.out.println(k.getItem().toString());
            k=k.next;
        }
        return null;
    }
}
