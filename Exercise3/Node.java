
public class Node{
        protected Suspect item;
        protected Node next=null;

        Node(Suspect item){
            this.item=item;
        }

        public Suspect getItem(){
            return item;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next=next;
        }
}

