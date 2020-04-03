/*
Generics, Arrays and Containers

Create a generic, singly linked list class called SList,
which, to keep things simple, does not implement the List interface.

Each Link object in the list should contain a reference to the
next element in the list, but not the previous one (LinkedList,
in contrast, is a doubly linked list, which means it maintains
 links in both directions).

Create your own SListIterator which, again for simplicity, does
not implement ListIterator. The only method in SList other than
toString( ) should be iterator( ), which produces an SListIterator.

The only way to insert and remove elements from an SList is through
SListIterator. Write code to demonstrate SList.

 */
package Assignment;

class Slist{
    public Node head;
    public Slist(Node head){
        this.head =  head;
    }
    public SListIterator iterator(){
        return new SListIterator(this.head);
    }

    @Override
    public String toString() {
        StringBuilder output= new StringBuilder("[");
        SListIterator iter=iterator();
        while(iter.hasNext()){
            output.append(iter.next());
            if(iter.hasNext()){
                output.append(",");
            }
        }
        output.append("]");
        return output.toString();
    }
}
class SListIterator{
    Node node;

    public SListIterator(Node node){
        this.node = node;
    }
    public Node next(){
        if(node.next!=null){
        node=node.next;
        return node;
        }else{
            return null;
        }
    }
    public boolean hasNext(){
        return node.next!=null;
    }
    public void insert(String value){
        Node temp=new Node(value);
        if(!hasNext()){
            node.next=temp;
            node=temp;
        }else{
            temp.next=node.next;
            node.next=temp;
        }
    }
    public void remove(){
        if(hasNext()){
            node.next=node.next.next;
        }
    }

}
class Node{
    public String value;
    public Node next;
    public Node(String value){
        this.value=value;
    }
    public Node(String value,Node next){
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value;
    }
}
public class JavaAssignment10 {
    public static void main(String[] args) {
        Slist sll=new Slist(new Node(null));
        System.out.println(sll);
        SListIterator iterate= sll.iterator();
        iterate.insert("1");
        System.out.println(sll);
        iterate.insert("2");
        iterate.insert("3");
        System.out.println(sll);
        iterate= sll.iterator();
        iterate.next();
        iterate.remove();
        iterate.remove();
        System.out.println(sll);
        iterate.insert("4");
        iterate.insert("5");
        System.out.println(sll);

    }
}