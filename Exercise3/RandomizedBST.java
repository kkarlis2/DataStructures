import java.util.Arrays;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class RandomizedBST implements MafiaInterface {
    double MeanSavings=0;
    int nodes=0;
    public Comparator1 comparator;
    private class TreeNode{
            Suspect item;
            private TreeNode left;
            private TreeNode right;
            int N;
            TreeNode(Suspect item){
                this.N=0;
                this.item=item;
                left=null;
                right=null;
            }
        
        
            public Suspect getItem(){
                return item;
            }
        
            public TreeNode getRight(){
                return right;
            }
        
            public TreeNode getLeft(){
                return left;
            }
        
            public void setRight(TreeNode right){
                this.right=right;
            }
        
            public void setLeft(TreeNode left){
                this.left=left;
            }
    };
    private TreeNode root;
    String line,file;
    BufferedReader reader;


    public RandomizedBST(Comparator1 comparator){
        this.comparator=comparator;
    }

    
    public void insert(Suspect item){
        if(!find(item.key())){
            this.root=insertAsRoot(item,root);
            nodes++;
        }else{
            System.out.println("We already have this suspect.");
        }
    }

    public boolean find(int AFM){
        TreeNode current=this.root;
        while(true){
            if(current == null){
                return false;
            }
            if(current.getItem().key()==AFM){
                System.out.println(current.getItem().getFirstName()+current.getItem().getLastName()+"added to our suspects");
                break;
            }
            if(current.getItem().key()<AFM){
                current=current.getRight();
            }else{
                current=current.getLeft();
            }

        }
        return true;
    }
    private TreeNode insertAsRoot(Suspect item,TreeNode h){
        if(h==null) return new TreeNode(item);
        if(item.key()<h.item.key()){
            h.setLeft(insertAsRoot(item,h.getLeft()));
        }else{
            h.setRight(insertAsRoot(item,h.getRight()));
        }
        h.N++;
        return h;
    }

    public void load(String filename){
        try {
            int k=0;
            reader = new BufferedReader(new FileReader(filename));
            line=reader.readLine();
            while(line!=null){
                Suspect item1=new Suspect(line);
                item1.setAFM(item1.getAFM());
                item1.setFirstName(item1.getFirstName());
                item1.setLastName(item1.getLastName());
                item1.setSavings(item1.getSavings());
                item1.setTaxedIncome(item1.getTaxedIncome());
                insert(item1);
                line=reader.readLine();
                k++;
            }
            reader.close();
            for(int i=0;i<k;i++){
                System.out.println((i+1)+"st Suspect added.");
            }
        } catch (IOException e) {
            System.out.println("Error at Reading File.");
        }
    }

    public void updateSavings(int AFM,double savings){
        TreeNode current=this.root;
        while(true){
            if(current == null){
                System.out.println("There isn't this AFM in the tree");
                break;
            }
            if(current.getItem().key()==AFM){
                current.getItem().setSavings(savings);
                break;
            }
            if(current.getItem().key()<AFM){
                current=current.getRight();
            }else{
                current=current.getLeft();
            }
        }
        
    }

    public Suspect searchByAFM(int AFM){
        TreeNode current=this.root;
        while(true){
            if(current==null){
                System.out.println("There isn't this AFM in the tree");
                return null;
            }
            if(current.getItem().key()==AFM){
                System.out.println(current.getItem().toString());
                break;
            }
            if(current.getItem().key()<AFM){
                current=current.getRight();
            }else{
                current=current.getLeft();
            }
        }
        return current.getItem();
    }


    private Node find_name(String last_name,TreeNode n,List a){
        Node result = null;
        if (n == null)
            return null;
        if (n.getItem().getLastName().equals(last_name))
            a.insertAtback(n.getItem());
        if (n.getLeft() != null)
            result = find_name(last_name,n.getLeft(),a);
        if (result == null)
            result = find_name(last_name,n.getRight(),a);
        return result;
    }
    public List searchByLastName(String last_name){
        List a = new List();
        TreeNode current=this.root;
        find_name(last_name,current,a);
        if(a.size()==0){
            System.out.println("Noone of our suspects has this last name!");
            return null;
        }
        if(a.size()<=5){
            a.toString();
            return a;
        }else{
            return a;
        }
    }


    public void remove(int AFM){
        TreeNode current=this.root;
        TreeNode parent = null;
        while(true){
            if(current==null){
                System.out.println("We don't hava a suspsect with this AFM");
                return;
            }
            if(current.getItem().key()==AFM){
                break;
            }
            parent=current;
            if(current.getItem().key()<AFM){
                current=current.getRight();
            }else{
                current=current.getLeft();
            }
        }
        
        TreeNode replace=joinLR(current.getRight(),current.getLeft());
        parent.N--;
        System.out.println(parent.N);
        if(parent==null){
            root = replace;
        }else{
            if(parent.getLeft()==current){
                parent.setLeft(replace);
            }
            if(parent.getRight()==current){
                parent.setRight(replace);
            }
        }
        nodes--;
        System.out.println("\nSuspect is removed!");
    }

    private TreeNode joinLR(TreeNode a,TreeNode b){
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        int N = a.N+b.N;
        if(Math.random()*N<1.0*a.N){
            a.setRight(joinLR(a.getRight(),b));
            return a;
        }else{
            b.setLeft(joinLR(a,b.getLeft()));
            return b;
        }
    }
    public double getMeanSavings(){
        TreeNode current=this.root;
        if(MeanSavings!=-1){
            this.MeanSavings=0;
        }
        postOrder(current);
        return MeanSavings/nodes;
    }

    private void postOrder(TreeNode n) {
        if (n == null)
            return;
        postOrder(n.getLeft());
        postOrder(n.getRight());
        MeanSavings+=n.getItem().getSavings();
    }

    private void postOrder2(TreeNode n,List a){
        if(n==null)
            return;
        postOrder2(n.getLeft(),a);
        postOrder2(n.getRight(),a);
        a.insertAtback(n.getItem());
        
    }
    int x=0;
    public void printTopSuspects(int k){
        List a = new List();
        TreeNode current=this.root;
        postOrder2(current,a);
        Suspect Final_suspects[]=new Suspect[a.size()];
        Suspect[] TopSuspects=new Suspect[a.size()];
        a.Topk(TopSuspects);
        for(int i=0;i<TopSuspects.length;i++){
            if((double)TopSuspects[i].getSavings()<9000){
                Final_suspects[i]=TopSuspects[i];
            }else if((double)TopSuspects[i].getSavings()-(double)TopSuspects[i].getTaxedIncome()>(TopSuspects[i].getSavings()*40)/100){
                Final_suspects[i]=TopSuspects[i];
            }else{
                x++;
            }
        }
        
        Suspect[] Another = new Suspect[Final_suspects.length-x];
        for(int i=0,y=0;i<Final_suspects.length;i++){
            if (Final_suspects[i]==null) { 
                continue; 
            } 
            Another[y++] = Final_suspects[i]; 
        } 
        Final_suspects=Another;
        

        boolean sort=false;
        while(!sort){
            sort=true;
            for(int i=0;i<Final_suspects.length-1;i++){
                if(comparator.compare_savings((double)Final_suspects[i].getSavings(), (double)Final_suspects[i+1].getSavings())==1){
                    Suspect temp=Final_suspects[i];
                    Final_suspects[i]=Final_suspects[i+1];
                    Final_suspects[i+1]=temp;
                    sort=false;
                }else if(comparator.compare_savings((double)Final_suspects[i].getSavings(), (double)Final_suspects[i+1].getSavings())==0){
                    if(comparator.compare_diff(Final_suspects, i, i+1)==2){
                        Suspect temp=Final_suspects[i];
                        Final_suspects[i]=Final_suspects[i+1];
                        Final_suspects[i+1]=temp;
                        sort=false;
                    }
                }
            }
        }
        for(int i=0;i<k;i++){
            if(k>Final_suspects.length){
                System.out.println("We don't have so much suspects");
                break;
            }else{
                System.out.println(Final_suspects[i].toString());
            }
            
        }
    }

    public void Inorder(TreeNode n){
        if(n==null) return;
        Inorder(n.getLeft());
        System.out.println(n.getItem().toString());
        Inorder(n.getRight());
    }
    public void printByAFM(){
        TreeNode current=this.root;
        Inorder(current);
    }

}
