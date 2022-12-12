package put.io.testing.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
       calculator = new Calculator();
    }

    @Test
    public void testadd(){
        //Calculator calculator;
        //calculator = new Calculator();
        Assertions.assertEquals(99,calculator.add(90,9));
        Assertions.assertEquals(3,calculator.add(2,1));
    }

    @Test
    public void testmultiply(){
        //Calculator calculator;
        //calculator = new Calculator();
        Assertions.assertEquals(25,calculator.multiply(5,5));
        Assertions.assertEquals(100,calculator.multiply(100,1));
    }

    @Test
    void testaddPositiveNumbers() {
        //Calculator calculator;
        //calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> {calculator.addPositiveNumbers(-70, 2);});
    }

}