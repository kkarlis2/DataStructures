
import java.util.NoSuchElementException;
import java.io.PrintStream;

public class StringDoubleEndedQueueImpl implements StringDoubleEndedQueue{
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        String item;
        Node next;
        Node prev;
        Node(String item){
            this.item=item;
            next=null;
            prev=null;
        }
    }

    public StringDoubleEndedQueueImpl(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    

    public boolean isEmpty(){
        if(head==null & tail==null){
            return true;
        }else{
            return false;
        }
    }

    public void addFirst(String item){
        Node i = new Node(item);
        if (isEmpty()){
            this.head=i;
            this.tail=i;
            i.next=null;
            i.prev=null;
        }else{
            i.next=head;
            i.prev=null;
            this.head=i;
        }
        size++;
    }

    public String removeFirst() throws NoSuchElementException{
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }else{
            String item1 = head.item;
            if (size==1){
                this.head=null;
                this.tail=null;
            }else{
                Node i = head.next;
                this.head=i;
                i.prev = null;

            }
            size--;
            return item1; 

        }
    }

    public void addLast(String item){
        Node i = new Node(item);
        if (isEmpty()){
            this.head=i;
            this.tail=i;
            i.next=null;
            i.prev=null;
        }else{
            i.prev=tail;
            tail.next=i;
            this.tail=i;
            i.next=null;
        }
        size++;
    }


    public String removeLast() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }else{
            String item1=tail.item;
            if(size==1){
                this.tail=null;
                this.head=null;
            }else{
                tail.prev.next=null;
                this.tail=tail.prev;
            }
            size--;
            return item1;
        }
    }

    public String getFirst() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }else{
            return head.item;
        }
    }

    public String getLast() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }else{
            return tail.item;
        }
    }

    public void printQueue(PrintStream stream){
        int s1=size;
        Node h1=head;
        String queue_String="";
        int k=0;
        while(s1!=0){

            if(h1.next!=null){
                if (k==0){
                    queue_String=h1.item;
                    Node i = h1;
                    h1=i.next;
                    s1--;
                }else{
                    queue_String=queue_String+h1.item;
                    Node i = h1;
                    h1=i.next;
                    s1--;
                }
            }else{
                queue_String=queue_String+h1.item;
                s1--;

            }
            k++;
        }
        if (s1==0){
            stream.println(queue_String);
        }
 
    }

    public int size(){
        return size;
    }

}
