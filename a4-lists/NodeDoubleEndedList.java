import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeDoubleEndedList<T> implements DoubleEndedList<T> {
   private Node first;
   private Node last;
   private int size;
   
   public NodeDoubleEndedList() {
      first = null;
      size = 0;
   }
   
   public void addFirst(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      
      Node n = new Node(element);
      
      if (size() == 0) {
         first =  n;
         last = n;
      }
      
      else {
         n.next = first;
         first = n;
      }
      
      size++;
   }
   
   public void addLast(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      
      Node n = new Node(element);
      
      if (size() == 0) {
         first = n;
         last = n;
      }
      
      else {
         last.next = n;
         last = n;
      }
      
      size++;
   }
   
   public T removeFirst() {
      if (size() == 0) {
         return null;
      }
      
      T removed = first.element;
      first = first.next;
      size--;
      
      return removed;
   }
   
   public T removeLast() {
      if (size() == 0) {
         return null;
      }
      
      else if (size == 1) {
         T removed = first.element;
         first = null;
         last = null;
         size--;
         return removed;
      }
      
      else {
         Node n = first;
         
         while (n.next.next != null) {
            n = n.next;
         }
         
         T removed = n.next.element;
         n.next = null;
         last = n;
         size--;
         return removed;
      }
   }
   
   public int size() {
      return size;
   }
   
   public Iterator<T> iterator() {
      return new Iteration();
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public class Node {
      private T element;
      private Node next;
      
      public Node(T var) {
         element = var;
      }  
        
      public Node(T var, Node n) {
         element = var;
         next = n;
      }
   }
   
   private class Iteration implements Iterator<T> {
      private Node curr = first;
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         
         T nextN = curr.element;
         curr = curr.next;
         return nextN;
      }
      
      public boolean hasNext() {
         return curr != null;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}