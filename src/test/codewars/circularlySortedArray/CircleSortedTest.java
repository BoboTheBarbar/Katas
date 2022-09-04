package circularlySortedArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CircleSortedTest {

    @Test
    void testtrue() {
        CircleSorted calc = new CircleSorted();

        int[] A = {3, 0, 1, 2};
        assertTrue(calc.isCircleSorted(A));

    }

    @Test
    void testtrue2() {
        CircleSorted calc = new CircleSorted();

        int[] A = {5, 7, 43, 987, -9, 0};
        assertTrue(calc.isCircleSorted(A));

    }

    @Test
    void testtrue3() {
        CircleSorted calc = new CircleSorted();

        int[] A = {1, 2, 3, 4, 5};
        assertTrue(calc.isCircleSorted(A));

    }

    @Test
    void testtrue4() {
        CircleSorted calc = new CircleSorted();

        int[] A = {1, 2, 3, 4, 4, 5, -1, 0};
        assertTrue(calc.isCircleSorted(A));

    }

    @Test
    void testfalse() {
        CircleSorted calc = new CircleSorted();
        int[] A = {9, 10, 14, 12};
        assertTrue(calc.isCircleSorted(A));
    }

    @Test
    void testfalse2() {
        CircleSorted calc = new CircleSorted();
        int[] A = {7, 6, 5, 4, 3, 2, 1};
        assertTrue(calc.isCircleSorted(A));
    }

}
