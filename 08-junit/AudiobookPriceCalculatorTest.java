package put.io.testing.audiobooks;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class AudiobookPriceCalculatorTest {

    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;

    @BeforeEach
    void setUp() {
        calculator = new AudiobookPriceCalculator();
        audiobook =  new Audiobook("Harry Potter", 100); }


    @Test
    void testStandard() {
        Customer customer = new Customer("Rosita", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(100, calculator.calculate(customer, audiobook)); }


    @Test
    void testSilver() {
        Customer customer = new Customer("Glenn", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(90, calculator.calculate(customer, audiobook)); }


    @Test
    void testGold() {
        Customer customer = new Customer("Clementine", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(80, calculator.calculate(customer, audiobook)); }

    @Test
    void testIsSub() {
        Customer customer = new Customer("Rick", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(0, calculator.calculate(customer, audiobook)); }


}