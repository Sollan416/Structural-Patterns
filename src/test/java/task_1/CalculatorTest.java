package task_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    static Calculator calc = new Calculator();
    static Double a, b, c;

    @BeforeAll
    static void beforeAll() {
        a = 10D;
        b = 5D;
        c = 2D;
    }

    @ParameterizedTest
    @CsvSource(value = {
            // Операция, ОР
            "SUM, 15",
            "SUB, 5",
            "MULT, 50",
            "DIV, 2",
            "POW, 100_000",
    })
    void calculate(Calculator.Operation operation, Double expectedValue) {
        Double resultValue = calc.newFormula()
                .addOperand(a)
                .addOperand(b)
                .calculate(operation)
                .result();
        assertEquals(expectedValue, resultValue);
    }

    @Test
    void calculateException() {
        assertThrows(IllegalStateException.class, () -> calc.newFormula()
                .calculate(Calculator.Operation.SUM));
    }

    @Test
    void addOperandException() {
        assertThrows(IllegalStateException.class, () -> calc.newFormula()
                .addOperand(a)
                .addOperand(b)
                .addOperand(c)
        );
    }

    @Test
    void resultException() {
        assertThrows(IllegalStateException.class, () -> calc.newFormula()
                .addOperand(a)
                .addOperand(b)
                .result()
        );
    }
}