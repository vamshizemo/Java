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

import java.util.logging.Logger;

class Slist<T> {
    public Node<T> head;

    public Slist() {
        this.head = null;
    }

    public SListIterator<T> iterator() {
        return new SListIterator<T>(this);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        SListIterator<T> iter = iterator();
        while (iter.hasNext()) {
            output.append(iter.next());
            if (iter.hasNext()) {
                output.append(",");
            }
        }
        output.append("]");
        return output.toString();
    }
}

class Node<T> {
    public T value;
    public Node<T> next;
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    @Override
    public String toString() {
        return value.toString();
    }
}

class SListIterator<T> {
    Slist<T> sList;
    Node<T> head;
    Node<T> previous = null;
    private Node<T> temp;
    Node<T> present;

    public SListIterator(Slist<T> sList) {
        this.sList = sList;
        this.head = sList.head;
        present = head;
    }

    public void insert(T value) {
        temp = new Node<T>(value);
        if (sList.head == null) {
            sList.head = temp;
            present = sList.head;
        } else if (present.next==null) {
            previous = present;
            present.next = temp;
            present = temp;
        } else {
            previous = present;
            temp.next = present.next;
            present.next = temp;
            present = temp;
        }
    }

    public Node<T> next() {
        if (present != null) {
            previous = present;
            present = present.next;
            return previous;
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return (present != null);
    }

    public void remove(){
        if (present == sList.head) {
            sList.head = sList.head.next;
            present = sList.head;
        } else if (hasNext()) {
            if(present.next!=null){
                present.value=present.next.value;
                present.next=present.next.next;
            }else{
                present=previous.next;
            }

        }
    }

}


public class JavaAssignment10 {
    private static final Logger logger = Logger.getLogger(JavaAssignment10.class.getName());
    public static void main(String[] args) {
        Slist<Integer> singleLinkedList = new Slist<Integer>();
        logger.info(singleLinkedList.toString());
        SListIterator<Integer> iterate = singleLinkedList.iterator();
        iterate.insert(1);
        logger.info("printing 1");
        logger.info(singleLinkedList.toString());
        logger.info("inserting 2");
        iterate.insert(2);
        logger.info("inserting 3");
        iterate.insert(3);
        logger.info("printing 1,2,3");
        logger.info(singleLinkedList.toString());
        iterate = singleLinkedList.iterator();
        logger.info(iterate.next().toString());
        iterate.remove();
        logger.info("after remove"+singleLinkedList+iterate.present);
        iterate.remove();
        logger.info("after remove"+singleLinkedList+iterate.present);
        logger.info("printing 1");
        logger.info(singleLinkedList.toString());
        logger.info("inserting 4");
        iterate.insert(4);
        logger.info("inserting 5");
        iterate.insert(5);
        logger.info(singleLinkedList.toString());


    }
}