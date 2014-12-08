/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcalculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paweł
 */
public class StringCalculatorTest {

  /*@Test(expected = RuntimeException.class)
  public void whenMoreThan2NumbersAreUsedThenExceptionIsThrown () {
    StringCalculator.add ("1,2,3");
  }*/
 
  @Test
  public void when2NumbersAreUsedThenNoExceptionIsThrown () {
    StringCalculator.add ("1,2");
  }
  
  @Test(expected = RuntimeException.class)
  public void whenNonNumberIsUsedThenExceptionIsThrown () {
    StringCalculator.add ("1,$");
  }
  
  @Test
  public void whenZeroNumbersAreUsedThenReturnValueIs0 () {
    assertEquals (0, StringCalculator.add(""));
  }
  
  @Test
  public void whenOneNumberIsUsedThenReturnValueIsThatSameNumber () {
    assertEquals (5, StringCalculator.add ("5"));
  }
  
  @Test
  public void whenTwoNumbersAreUsedThenReturnValueIsTheirSum () {
    assertEquals (3+4, StringCalculator.add ("3,4"));
  }
  
  @Test
  public void whenAnyNumberOfNumbersIsUsedThenReturnValueIsTheirSum () {
    assertEquals (3+6+1+7+8+8, StringCalculator.add ("3,6,1,7,8,8"));
  }
  
  @Test
  public void whenNewlineIsUsedBetweenNumbersThenReturnValueIsTheirSum () {
    assertEquals (1+2+3, StringCalculator.add ("1,2\n3"));
  }
  
  @Test
  public void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers () {
    assertEquals (4+9+16, StringCalculator.add("//;\n4;9;16"));
  }
  
  @Test(expected = RuntimeException.class)
  public void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown () {
    StringCalculator.add ("1,1,2,3,-5,8");
  }
  
  @Test
  public void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown () {
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
  public void whenOneOrMoreNumbersGreaterThan1000IsUsedThenItIsNotIncludedInSum () {
    assertEquals (17+9+1000, StringCalculator.add ("17,1001,9,1000"));
  }
  
  @Test
  public void whenDelimiterOfAnyLengthIsSpecifiedThenItIsUsedToSeparateNumbers () {
    assertEquals (1+2+3, StringCalculator.add ("//[—]\n1—2—3"));
    assertEquals (2+4+9, StringCalculator.add ("//[;;]\n2;;4;;9"));
  }
  
  @Test
  public void whenSeveralDelimitersAreSpecifiedThenAllAreUsedToSeparateNumbers () {
    assertEquals (1+2+3, StringCalculator.add ("//[-][%]\n1-2%3"));
  }
  
  @Test
  public void whenSeveralDelimitersOfAnyLengthAreSpecifiedThenAllAreUsedToSeparateNumbers () {
    assertEquals (1+1+2+3+5+8+13, StringCalculator.add ("//[—][%][--][;;]\n1—1%2%3;;5--8—13"));
    assertEquals (StringCalculator.add ("//[—][„][%]\n1—2„3%4"), 1+2+3+4);
  }
}
