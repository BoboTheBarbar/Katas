package commonDenominators;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FractsTest {

    @Test
    void check_fractions() {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {10, 40}};
        assertEquals("(6,12)(4,12)(3,12)", Fracts.convertFrac(lst));
    }

    @Test
    void check_fractions2() {
        long[][] lst;
        lst = new long[][]{{69, 130}, {87, 1310}, {30, 40}};
        assertEquals("(18078,34060)(2262,34060)(25545,34060)", Fracts.convertFrac(lst));
    }

    @Test
    void check_fractions_empty() {
        long[][] lst;
        lst = new long[][]{};
        assertEquals("", Fracts.convertFrac(lst));
    }

    @Test
    void check_fractions_OutOfBounds() {
        long[][] lst;
        lst = new long[][]{{1, 1}, {3, 1}, {4, 1}, {5, 1}};
        assertEquals("(1,1)(3,1)(4,1)(5,1)", Fracts.convertFrac(lst));
    }

    @Test
    void check_fractions_OutOfBounds2() {
        long[][] lst;
        lst = new long[][]{{1, 1}, {3, 1}, {4, 1}, {5, 2}};
        assertEquals("(2,2)(6,2)(8,2)(5,2)", Fracts.convertFrac(lst));
    }

    @Test
    void check_fractions_OutOfBounds3() {
        long[][] lst;
        lst = new long[][]{{1, 1}, {3, 1}, {4, 3}, {5, 2}};
        assertEquals("(6,6)(18,6)(8,6)(15,6)", Fracts.convertFrac(lst));
    }

    @Test
    void check_FaktorDecomposition() {
        List<Integer> factorSequence = createStdFactorList();
        Fracts.PrimeFactorization factorization = new Fracts.PrimeFactorization(50);
        assertEquals(factorization.factorSequence.subList(0, 3), factorSequence);
    }

    @Test
    void check_ExponentDecomposition() {
        List<Integer> exponentSequence = createStdExponentList();
        Fracts.PrimeFactorization factorization = new Fracts.PrimeFactorization(50);
        assertEquals(factorization.exponentSequence.subList(0, 3), exponentSequence);
    }

    @Test
    void check_CommonDenominator() {
        List<Fracts.PrimeFactorization> listOfFactorizations = new ArrayList<>();
        listOfFactorizations.add(new Fracts.PrimeFactorization(2 * 2 * 3));
        listOfFactorizations.add(new Fracts.PrimeFactorization(2 * 2 * 5));
        Fracts.PrimeFactorization actual = Fracts.getCommonDenominator(listOfFactorizations);
        Fracts.PrimeFactorization expected = new Fracts.PrimeFactorization(2 * 2 * 3 * 5);

        assertEquals(expected.factorSequence, actual.factorSequence);
    }

    private List<Integer> createStdFactorList() {
        List<Integer> factorSequence = new ArrayList<>();
        factorSequence.add(2);
        factorSequence.add(3);
        factorSequence.add(5);
        return factorSequence;
    }

    private List<Integer> createStdExponentList() {
        List<Integer> exponentSequence = new ArrayList<>();
        exponentSequence.add(1);
        exponentSequence.add(0);
        exponentSequence.add(2);
        return exponentSequence;
    }

}