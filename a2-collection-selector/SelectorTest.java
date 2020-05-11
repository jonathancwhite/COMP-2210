import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** A test for k = 1; with only 2 elements in array**/
   @Test public void kminTest1() {
      Collection<Integer> col1 = Arrays.<Integer>asList(new Integer[]{4,4});
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }
}
