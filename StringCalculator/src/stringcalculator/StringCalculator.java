/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paweł
 */
public class StringCalculator {

  /**
   * @param numbers up to 2 comma-separated numbers
   * @return sum of given numbers
   */
  public static int add (String numbers) {
    String delimiter = ",|\n";
    String numbersWithoutDelimiter = numbers;
    // jesli mamy separator
    if (numbers.startsWith ("//")) {
      delimiter = "";
      int delimiterStartIndex = numbers.indexOf ("//") + 2;
      int delimiterEndIndex = numbers.indexOf("]");
      if (delimiterEndIndex == -1 ||
          delimiterEndIndex >= numbers.indexOf("\n") ||
          !numbers.substring (delimiterStartIndex,
                              delimiterStartIndex + 1).equals("[")) {
        // tylko jeden separator
        delimiter = numbers.substring (delimiterStartIndex, delimiterStartIndex + 1);
      } else {
        // wiecej separatorow
        delimiter = numbers.substring (delimiterStartIndex + 1, delimiterEndIndex);
        delimiterStartIndex = numbers.indexOf ("[", delimiterEndIndex);
        delimiterEndIndex = numbers.indexOf ("]", delimiterStartIndex);
        // dopoki mamy separator 
        while (delimiterStartIndex != -1 && delimiterEndIndex != -1 &&
               delimiterEndIndex < numbers.indexOf ("\n")) {
          delimiterStartIndex++;
          //dodaj separator
          delimiter += "|" + numbers.substring (delimiterStartIndex, delimiterEndIndex);
          // pobierz nastepny separator
          delimiterStartIndex = numbers.indexOf ("[", delimiterEndIndex);
        delimiterEndIndex = numbers.indexOf ("]", delimiterStartIndex);
        }
      }
      // pobierz liczby
      numbersWithoutDelimiter = numbers.substring (numbers.indexOf ("\n") + 1);
    }
    return add (numbersWithoutDelimiter, delimiter);
  }
  
  private static int add (final String numbers, final String delimiter) {
    int returnValue = 0;
    String [] numbersArray = numbers.split (delimiter);
    List negativeNumbers = new ArrayList ();
    for (String number : numbersArray) {
      // jesli mamy liczby
        if (!number.trim().isEmpty()) {
            int numberInt = Integer.parseInt (number);
            if (numberInt < 0) {
                negativeNumbers.add (numberInt); // zliczamy liczby < 0
            } else if (numberInt <= 1000) {
                returnValue += numberInt; // zliczamy liczby <= 1000
            }
        }
    }
    if (negativeNumbers.size () > 0) {
      throw new RuntimeException ("Negatives not allowed: " + negativeNumbers.toString());
    }
    return returnValue;
  }
}
