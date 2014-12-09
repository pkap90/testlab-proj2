package stringcalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
  // Test  set 1
  @Test(expected = RuntimeException.class)
  public void moreThanTwoNumbersShouldResultInException () {
    StringCalculator.add ("1,2,3");
  }
 
  @Test
  public void twoNumbersAreOK () {
    StringCalculator.add ("1,2");
  }
  
  @Test(expected = RuntimeException.class)
  public void NonNumberShouldResultInException () {
    StringCalculator.add ("1,$");
  }
}