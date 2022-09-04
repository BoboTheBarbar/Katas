package evaluateMathematicalExpression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("java:S3415")
class MathEvaluatorTest {

    @Test
    void testAddition() {
        assertEquals(new MathEvaluator().calculate("1+1"), 2d, 0.01);
    }

    @Test
    void testAdditionComplex() {
        assertEquals(new MathEvaluator().calculate("1+1--2-4"), 0d, 0.01);
    }

    @Test
    void testAdditionLongNumbers() {
        assertEquals(new MathEvaluator().calculate("10+11"), 21d, 0.01);
    }

    @Test
    void testSubtraction() {
        assertEquals(new MathEvaluator().calculate("1 - 1"), 0d, 0.01);
    }

    @Test
    void testMultiplication() {
        assertEquals(new MathEvaluator().calculate("1* 1"), 1d, 0.01);
    }

    @Test
    void testDivision() {
        assertEquals(new MathEvaluator().calculate("6 /2"), 3d, 0.01);
    }

    @Test
    void testDivisionLongNumber() {
        assertEquals(new MathEvaluator().calculate("120 /12"), 10d, 0.01);
    }

    @Test
    void testDivisionLongDouble() {
        assertEquals(new MathEvaluator().calculate("150 /300"), 0.5d, 0.01);
    }

    @Test
    void testDivisionComplex() {
        assertEquals(new MathEvaluator().calculate("400 / 2 / 2 / 2"), 50d, 0.01);
    }

    @Test
    void testNegative() {
        assertEquals(new MathEvaluator().calculate("-123"), -123d, 0.01);
    }

    @Test
    void testLiteral() {
        assertEquals(new MathEvaluator().calculate("123"), 123d, 0.01);
    }

    @Test
    void testExpression() {
        assertEquals(new MathEvaluator().calculate("2 /2+3 * 4.75- -6"), 21.25, 0.01);
    }

    @Test
    void testSimple() {
        assertEquals(new MathEvaluator().calculate("12* 123"), 1476d, 0.01);
    }

    @Test
    void testComplex() {
        assertEquals(new MathEvaluator().calculate("2 / (2 + 3) * 4.33 - -6"), 7.732, 0.01);
    }

}
