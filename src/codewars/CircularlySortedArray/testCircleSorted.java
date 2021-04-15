package codewars.CircularlySortedArray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testCircleSorted {

	@Test
    public void testtrue() {
        CircleSorted calc = new CircleSorted();
            
            int[] A={3,0,1,2};
            assertEquals(true,
            calc.isCircleSorted(A));
         
    }
	
	@Test
    public void testtrue2() {
        CircleSorted calc = new CircleSorted();
            
            int[] A={5, 7, 43, 987, -9, 0};
            assertEquals(true,
            calc.isCircleSorted(A));
         
    }
	
	@Test
    public void testtrue3() {
        CircleSorted calc = new CircleSorted();
            
            int[] A={1, 2, 3, 4, 5};
            assertEquals(true,
            calc.isCircleSorted(A));
         
    }
	
	@Test
    public void testtrue4() {
        CircleSorted calc = new CircleSorted();
            
            int[] A={1, 2, 3, 4 , 4 , 5, -1, 0};
            assertEquals(true,
            calc.isCircleSorted(A));
         
    }
	
   @Test
    public void testfalse() {
        CircleSorted calc = new CircleSorted();
            int[] A={9,10,14,12};
            assertEquals(false,
            calc.isCircleSorted(A));
   }
   
   @Test
   public void testfalse2() {
       CircleSorted calc = new CircleSorted();
           int[] A={7, 6, 5, 4, 3, 2, 1};
           assertEquals(false,
           calc.isCircleSorted(A));
  }

}
