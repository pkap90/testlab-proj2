package stringcalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {
  // Test set 1-11
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
  
  @Test
  public void newLineShouldBeTreatedAsNumberSeparator () {
    assertEquals (1+2+3, StringCalculator.add ("1,2\n3"));
  }
  
  @Test
  public void shouldSupportCustomDelimiters () {
    assertEquals (4+9+16, StringCalculator.add("//;\n4;9;16"));
  }
  
  @Test(expected = RuntimeException.class)
  public void shouldRaiseExceptionForNegativeNumber () {
    StringCalculator.add ("1,1,2,3,-5,8");
  }
  
  @Test
  public void shouldProvideExceptionReasonWithAllUsedNegativeNumbers () {
    RuntimeException exception = null;
    try {
      StringCalculator.add ("1,1,-2,3,-5,8");
    } catch (RuntimeException e) {
      exception = e;
    }
    assertNotNull (exception);
    assertEquals ("Negatives not allowed: [-2, -5]", exception.getMessage());
  }
  
  @Test
  public void numbersGreaterThan1000ShouldBeIgnored () {
    assertEquals (17+9+1000, StringCalculator.add ("17,1001,9,1000"));
  }

  @Test
  public void shouldSupportCustomDelimitersOfAnyLength () {
    //assertEquals (1+2+3, StringCalculator.add ("//[\n1—2—3"));
    assertEquals (1+2+3, StringCalculator.add ("//[—]\n1—2—3"));
    assertEquals (2+4+9, StringCalculator.add ("//[;;]\n2;;4;;9"));
  }
  
  @Test
  public void shouldSupportSeveralDelimiters () {
    assertEquals (1+2+3, StringCalculator.add ("//[-][%]\n1-2%3"));
  }
  
  @Test
  public void shouldSupportSeveralDelimitersOfAnyLength () {
    assertEquals (1+1+2+3+5+8+13, StringCalculator.add ("//[—][%][--][;;]\n1—1%2%3;;5--8—13"));
    assertEquals (StringCalculator.add ("//[—][„][%]\n1—2„3%4"), 1+2+3+4);
  }
}