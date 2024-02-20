package task_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntsCalculatorTest {
    Ints intsCalcTest = new IntsCalculator();

    static int a, b;
    int result;

    @BeforeAll
    static void beforeAll() {
        a = 12;
        b = 3;
    }

    @Test
    void sum() {
        result = intsCalcTest.sum(a, b);
        assertEquals(result, a + b);
    }

    @Test
    void mult() {
        result = intsCalcTest.mult(a, b);
        assertEquals(result, a * b);
    }

    @Test
    void pow() {
        result = intsCalcTest.pow(a, b);
        assertEquals(result, Math.pow(a, b));
    }
}