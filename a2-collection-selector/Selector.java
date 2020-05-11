import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Jonathan White (jcw0057@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2018-01-25
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      Iterator<T> itr = coll.iterator();
      T min = (T)itr.next();
      // Sets value at 0 index and moves index to 1
      while (itr.hasNext()) {
         T nextValue = (T)itr.next();
         if (comp.compare(nextValue, min) < 0) {
            min = nextValue;
         }
      }
      
      
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      Iterator<T> itr = coll.iterator();
      T max = (T)itr.next();
      // Sets value at 0 index and moves index to 1
      while (itr.hasNext()) {
         T nextValue = (T)itr.next();
         if (comp.compare(nextValue, max) > 0) {
            max = nextValue;
         }
      }
      
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
     
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      // NEW SINCE LAST TESTED
      if (k > coll.size()) {
         throw new NoSuchElementException();
      }
      
      if (k <= 0) {
         throw new NoSuchElementException();
      }
     
     // create editable array list from coll
      ArrayList<T> minList = new ArrayList<T>(coll);
     
     // sort array list to find dupes
      java.util.Collections.<T>sort(minList, comp);
      
      // keeping track of distinct values
      int increase = 1;
      
      // tracks last item in collection
      T lastVal = minList.get(0);
      
      // loop to compare each element and count distinct values
      for (T i : minList) {
         if (comp.compare(i, lastVal) != 0) {
            increase++;
            lastVal = i;
         }
      }
      
      if (k > increase) {
         throw new NoSuchElementException();
      }
      
      // sets distinct value back to 1
      increase = 1;
      lastVal = minList.get(0);
      
      if (minList.size() != 1 && comp.compare(minList.get(0),
         minList.get(minList.size() -1)) < 0) {
         
         for(int i = 0; i > minList.size(); i++) {
            if (increase == k) {
               return lastVal;
            }
            if (comp.compare(lastVal, minList.get(i)) != 0) {
               increase++;
               lastVal = minList.get(i);
            }
         }
      }
      
      if (minList.size() != 1) {
         for (T i : minList) {
            if (increase == k) {
               return lastVal;
            }
            if (comp.compare(lastVal, i) != 0) {
               increase++;
               lastVal = i;
            }
         }
      }
      
     
      return lastVal;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
     
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
     
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      // NEW SINCE LAST TESTED
      if (k > coll.size()) {
         throw new NoSuchElementException();
      }
      
      if (k <= 0) {
         throw new NoSuchElementException();
      }
     
     // create array list from coll
      ArrayList<T> maxList = new ArrayList<T>(coll);
     
     // sort array list to find dupes
      java.util.Collections.<T>sort(maxList, comp);
      
      int in = 1;
      T lastVal = maxList.get(0);
      
      for (T i : maxList) {
         if (comp.compare(i, lastVal) != 0) {
            in++;
            lastVal = i;
         }
      }
      
      if (maxList.size() == 1) {
         return lastVal;
      }
      
      in = 1;
      lastVal = maxList.get(maxList.size() - 1);
      
      if (maxList.size() != 1 && comp.compare(maxList.get(0),
         maxList.get(maxList.size() -1)) < 0) {
         
         for(int i = maxList.size() - 1; i > -1; i--) {
            if (in == k) {
               return lastVal;
            }
            if (comp.compare(lastVal, maxList.get(i)) != 0) {
               in++;
               lastVal = maxList.get(i);
            }
         }
      }
      
      if (maxList.size() != 1) {
         for (T i : maxList) {
            if (in == k) {
               return lastVal;
            }
            if (comp.compare(lastVal, i) != 0) {
               in++;
               lastVal = i;
            }
         }
      }
      
      // checking if k > distinct values
      if (k > in) {
         throw new NoSuchElementException();
      }
      
     
      return lastVal;
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
                                 
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }              
                           
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      ArrayList<T> valid = new ArrayList<T>();
      ArrayList<T> rangeList = new ArrayList<T>(coll);
      
      for (T i : rangeList) {
         if (comp.compare(i, low) >= 0 && comp.compare(i, high) <= 0) {
            valid.add(i);
         }
      }
      
      if (valid.size() == 0) {
         throw new NoSuchElementException();
      }
     
     
      return valid;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      ArrayList<T> valid = new ArrayList<T>();
      ArrayList<T> newList = new ArrayList<T>(coll);
      
      for (T i : newList) {
         if (comp.compare(i, key) >= 0) {
            valid.add(i);
         }
      }
      
      Iterator<T> itr = valid.iterator();
      T ceiling = (T)itr.next();
      
      while (itr.hasNext()) {
         T nextVal = (T)itr.next();
         if (comp.compare(nextVal, ceiling) < 0) {
            ceiling = nextVal;
         }
      }
      
      if (valid.size() == 0) {
         throw new NoSuchElementException();
      }
      
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
      if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      ArrayList<T> valid = new ArrayList<T>();
      ArrayList<T> newList = new ArrayList<T>(coll);
      
      for (T i : newList) {
         if (comp.compare(i, key) <= 0) {
            valid.add(i);
         }
      }
      
      Iterator<T> itr = valid.iterator();
      T floor = (T)itr.next();
      
      while (itr.hasNext()) {
         T nextVal = (T)itr.next();
         if (comp.compare(nextVal, floor) > 0) {
            floor = nextVal;
         }
      }
      
      if (valid.size() == 0) {
         throw new NoSuchElementException();
      }
   
   
      return floor;
   }

}
