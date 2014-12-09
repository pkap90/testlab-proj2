package stringcalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
  // Test set 1-4
  // commented - method is to support unknown amount of numbers
  //@Test(expected = RuntimeException.class)
  //public void moreThanTwoNumbersShouldResultInException () {
  //  StringCalculator.add ("1,2,3");
  //}
 
  @Test
  public void twoNumbersAreOK () {
    StringCalculator.add ("1,2");
  }
  
  @Test(expected = RuntimeException.class)
  public void nonNumberShouldResultInException () {
    StringCalculator.add ("1,$");
  }
  
  @Test
  public void shouldReturnZeroForEmptyString () {
    assertEquals (0, StringCalculator.add(""));
  }
  
  @Test(expected = RuntimeException.class)
  public void shouldRaiseExceptionForStringWithEmptyNumbers () {
    assertEquals (0, StringCalculator.add(","));
    assertEquals (0, StringCalculator.add(",,"));
    assertEquals (0, StringCalculator.add(",5"));
  }
  
  @Test
  public void whenOneNumberIsUsedThenReturnValueIsThatSameNumber () {
    assertEquals (5, StringCalculator.add ("5"));
  }
  
  @Test
  public void shouldReturnSumOfGivenTwoNumbers () {
    assertEquals (3+4, StringCalculator.add ("3,4"));
  }
    
  @Test
  public void shouldReturnSumOfAnyAmountOfGivenNumbers () {
    assertEquals (3+6+1+7+8+8, StringCalculator.add ("3,6,1,7,8,8"));
  }
}