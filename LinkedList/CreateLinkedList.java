package LinkedList;

 class CreateLinkedList {
     
    Node head;
    private int size;

   CreateLinkedList () {
    size = 0;
   }


   public class Node{
    String data;
    Node next;

    Node(String data ){
        this.data = data;
        this.next = null;
        
    }
   }
    
   public void addFirst(String data){
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
   }
}
