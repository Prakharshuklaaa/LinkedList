public class DLL{
    Node head;
    int size;

    public DLL(){
        this.size = 0;
    }

    public void insertFirst(int val){

        Node node = new Node(val);

        node.next = head;
       

        if(head!=null){
            head.prev = node;
        }        
        head = node;
        size++; 

    }
    public void insert(int val,int idx){

        Node temp = head;
        for(int i=1;i<=idx;i++){
            temp = temp.next;
        }

        Node node = new Node(val);

        if(temp.next!=null){
            node.next = temp.next;
            temp.next.prev = node;
            temp.next = node;
            node.prev = temp;
            size++;
            return;
        }

        node.next = temp.next;
        node.prev = temp;
        size++;

    }

    public void display(){
        Node temp = head;
        Node last = null;

        while(temp!=null){
            System.out.print(temp.val+" -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("End");

        while(last!=null){
            System.out.print(last.val+" -> ");
            last = last.prev;
        }
        System.out.println("End");
    }

    public class Node{
        private int val;
        //Default values will be null
        private Node next;
        private Node prev;

        public Node(int value){
            this.val = value;
        }
        public Node(int value,Node next,Node prev){
            this.val = value;
            this.next = next;
            this.next = prev;
        }
    }
}