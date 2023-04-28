// nested class
//0 based indexing for linked lsit
public class LL{

    // Variable of type node & initially pointing to null
    Node head;
    Node tail;

    int size;  
    public LL(){
        this.size = 0;
    }
    public int size(){
        return size;
    }
    public void insertFirst(int val){
        Node node = new Node(val);

        node.next = head;
        head = node;

        if(tail==null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){

        Node node = new Node(val);

        if(head==null){
            node.next = head;
            head = node;
            tail = head;
            return;
        }

        tail.next = node;
        tail = node;
        
        size++;
    }
    public void insertExcatMiddle(int val){
        Node node = new Node(val);
        Node temp = head;
        int count = size/2;

        while(count>2){
            temp = temp.next;

        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void insertMiddle(int val,int idx){
        
        if(idx == 0){
            insertFirst(val);
            return;
        }

        if(idx==size){
            insertLast(val);
            return;
        }


        Node temp = head;
        for(int i=1;i<idx;i++){
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;      
        

    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head==null){
            tail = null;
        }
        return val;
    }
    public int deleteLast(){

        Node secondLast = get(size-2);
        int val = tail.value;
        secondLast.next = null;
        tail = secondLast;
        size--;
        return val;
        
    }

    public Node get(int idx){
        Node temp = head;
        for(int i=1;i<=idx;i++){
            temp = temp.next;
        }
        return temp;

    }

    public int deleteIdx(int idx){
    
    if(idx==0){        
        size--;
        return deleteFirst();
    }
    

    Node temp = head;
    for(int i=1;i<idx;i++){
        temp = temp.next;
    }
    Node dlt = temp.next;
    int val = dlt.value;
    temp.next = dlt.next;      
    size--;
    return val;        


    }


    public void display(){
        //*changing temp will not change head of ll */ 
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;  
        }
        System.out.println("End");

    }

    class Node{

        int value;
        //next is the reference to the next node of the linked list
        Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
}