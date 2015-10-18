package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
		assertEquals(15, Calculator.add("15"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
		assertEquals(35, Calculator.add("13,22"));
	}

	@Test
    public void testNumbers(){
    	assertEquals(55, Calculator.add("1,2,3,4,5,6,7,8,9,10"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    	assertEquals(55, Calculator.add("1,2,3\n4\n5,6,7\n8,9,10"));
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    @Test
    public void testDelimiter(){
    	assertEquals(6, Calculator.add("//;\n1;2;3"));
    	assertEquals(55, Calculator.add("//.\n1.2,3\n4\n5,6,7\n8.9.10"));
    	assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void testNegativeNumbers(){
    	try {
    		assertEquals(6, Calculator.add("1,-2,3"));
    	}
    	catch(IllegalArgumentException e) {
    		assertEquals(1, 1);
    	}
    	
    }

    @Test
    public void testBiggerThanK(){
    	assertEquals(6, Calculator.add("1,2,3,1234"));
    }
}