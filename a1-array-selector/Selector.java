import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Jonathan White (jcw0057@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  1/11/20
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
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int minValue = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] < minValue) {
            minValue = a[i];
         }
      }
      return minValue;
   }

   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int maxValue = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] > maxValue) {
            maxValue = a[i];
         }
      }
      return maxValue;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      
      // New array to sort
      int[] a1 = new int[a.length];
      int indexA1 = 0;
      
      // Add elements to new array
      for (int i = 0; i < a.length; i++) {
         a1[indexA1++] = a[i];
      }
      
      
      // Sort array to have duplicates next to each other
      Arrays.sort(a1);
      
      // Compare previous value to next value
      int previous = a[0] - 1;
      int dupeCount = 0;
      
      // loop to count duplicates
      for (int i = 0; i < a.length; i++) {
         if (a1[i] == previous) {
            dupeCount++;
         } else {
            previous = a1[i];
         }
      }
      
      // new array to add non dupes to
      int[] kminArr = new int[a1.length - dupeCount];
      
      // throws new IAE if k > distinct values
      if (k > kminArr.length) {
         throw new IllegalArgumentException();
      }
      
      // reset previous for next loop
      previous = a1[0] - 1;
      int newIndex = 0;
      
      // loop to add distinct values to new array
      for (int i = 0; i < a1.length; i++) {
         if (a1[i] == previous) {
            //skip this number
         } else {
            previous = a1[i];
            kminArr[newIndex++] = a1[i];
         }
      }
      
      int kmin = kminArr[k-1];
               
      // int kthMin = a[k-1]; ONLY WORKS WITHOUT DUPLICATES
      return kmin;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
   
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      
      // New array to sort
      int[] a1 = new int[a.length];
      int indexA1 = 0;
      
      // Add elements to new array
      for (int i = 0; i < a.length; i++) {
         a1[indexA1++] = a[i];
      }
   
      
      // Sort array ascending order
      Arrays.sort(a1);  
             
      // Compare previous value to next value
      int previous = a1[0] - 1;
      int dupeCount = 0;
      
      // loop to count duplicates
      for (int i = 0; i < a1.length; i++) {
         if (a1[i] == previous) {
            dupeCount++;
         } else {
            previous = a1[i];
         }
      }
      
      // new array to add non dupes to
      int[] kmaxArr = new int[a1.length - dupeCount];
      
      // throws new IAE if k > distinct values
      if (k > kmaxArr.length) {
         throw new IllegalArgumentException();
      }
      
      // reset previous for next loop
      previous = a1[0] - 1;
      int newIndex = 0;
      
      // loop to add distinct values to new array
      for (int i = 0; i < a1.length; i++) {
         if (a1[i] == previous) {
            //skip this number
         } else {
            previous = a1[i];
            kmaxArr[newIndex++] = a1[i];
         }
      }
      int end = kmaxArr.length;
      int kmax = kmaxArr[end - k];
      
      
      return kmax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int numForArray = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            numForArray++;
            // add a[i] to new array
         }
      }
      int [] range = new int[numForArray];
      int index = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= low && a[i] <= high) {
            range[index++] = a[i];
         }
      }
      return range;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      boolean setNum = false;
      int minCeiling = 0;
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= key) {
            if (!setNum) {
               minCeiling = a[i];
               setNum = true;
            }
            else if (a[i] < minCeiling) {
               minCeiling = a[i];
            }
         }
      
      }
      
      if (!setNum) {
         throw new IllegalArgumentException();
      }
      return minCeiling;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      boolean setNum = false;
      int larFloor = 0;
      
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= key) {
            if (!setNum) {
               larFloor = a[i];
               setNum = true;
            }
            else if (a[i] > larFloor) {
               larFloor = a[i];
            }
         }
      }
      
      if (!setNum) {
         throw new IllegalArgumentException();
      }
   
      return larFloor;
   }

}
