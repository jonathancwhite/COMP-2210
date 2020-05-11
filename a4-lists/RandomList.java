import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * RandomList.java - Implements RandomizedList interface and uses
 * type variables to create collection
 *
 * @author Jonathan White (jcw0057@auburn.edu)
 * @version 3/5/2020
 * @param <T> type of varibale for RandomList
 *
 */
public class RandomList<T> implements RandomizedList<T> {
   private T[] elements;
   private int size;
   private static final int DEFAULT_LENGTH = 1;
   
   /**
    * creates randomlist object
    */
   @SuppressWarnings("unchecked")
   public RandomList() {
      size = 0;
      elements = (T[]) new Object[DEFAULT_LENGTH];
   }
   
  /**
   * we adding now boys
   * @param element is the one being added
   */
   public void add(T element) {
      if (element == null) {
         throw new IllegalArgumentException("This can not be null");
      }
      
      if (size == elements.length) {
         resize(elements.length * 2);
      }
      
      elements[size] = element;
      size++;
      
   }
  /**
   * removes ran element
   * @return removed - name says it all
   */
   public T remove() {
      if (size() == 0) {
         return null;
      }
      
      int ran = new Random().nextInt(size());
      T removed = elements[ran];
      elements[ran] = elements[size() - 1];
      elements[size() - 1] = null;
      size--;
      
      if (size() > 0 && size() < elements.length / 4) {
         resize(elements.length / 2);
      }
      return removed;
   }
   
  /**
      * returns a random element.
      * @return the ran element.
      */
   public T sample() {
      if (size == 0) {
         return null;
      }
      
      int ran = new Random().nextInt(size());
      return elements[ran];
   }
   
   /**
    * was told javadoc comments are standard practice in workplace
    * @return size - the name says it all
    */
   public int size() {
      return size;
   }
   
   /**
    * ye ye
    * @return true if empty false if not, duh
    */
   public boolean isEmpty() {
      return size == 0;
   }
   
   // wow
   public Iterator<T> iterator() {
      ArrayIterator<T> itr = new ArrayIterator<T>(elements, size);
      return itr;
   }
   
   /**
    * dynamic resizing of array
    * @param capacity is the new size of array
    */
   @SuppressWarnings("unchecked")
   private void resize(int capacity) {
      T[] arr = (T[]) new Object[capacity];
      for (int i = 0; i < size(); i++) {
         arr[i] = elements[i];
      }
      elements = arr;
   }
   
   /**
    * Creates iterator for program
    */
   private class ArrayIterator<T> implements Iterator<T> {
      private T[] items;
      private int count;
      
      public ArrayIterator(T[] arr, int amount) {   
         items = arr;
         count = amount;
      }
      
      /**
       * They say javadoc comments are useful, but you could just read the name
       * @return if it has next element
       */
      
      public boolean hasNext() {
         return (size > 0);
      }
      
      /** 
       * ye
       * @return next element
       */
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         
         Random ran = new Random();
         int val = ran.nextInt(size);
         T next = items[val];
         
         if (val != (size - 1)) {
            items[val] = items[size - 1];
            items[size - 1] = next;
         }
         size--;
         return next;
      }
      
      // throwing UnsupportedOperationException
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}