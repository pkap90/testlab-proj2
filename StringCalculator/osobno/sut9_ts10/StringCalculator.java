package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
  // SUT 9
  public static int add (String numbers) {
    if (numbers.isEmpty ()) {
      return 0;
    }
    String delimiter = ",|\n";
    String numbersWithoutDelimiter = numbers;
    if (numbers.startsWith("//")) {
      int delimiterStartIndex = numbers.indexOf ("//") + 2;
      int delimiterEndIndex = numbers.indexOf("]");
      if (delimiterEndIndex == -1 || delimiterEndIndex >= numbers.indexOf("\n")
          || !numbers.substring (delimiterStartIndex,
                              delimiterStartIndex + 1).equals("[")) {
        delimiter = numbers.substring(delimiterStartIndex, delimiterStartIndex + 1);
      } else {
        delimiter = numbers.substring(delimiterStartIndex + 1,
            delimiterEndIndex);
      }
      numbersWithoutDelimiter = numbers.substring (numbers.indexOf("\n") + 1);
    }
    return add (numbersWithoutDelimiter, delimiter);
  }
  
  private static int add (String numbers, String delimiter) {
    int returnValue = 0;
    String [] numbersArray = numbers.split (delimiter);
    List negativeNumbers = new ArrayList ();
    for (String number : numbersArray) {
      int numberInt = Integer.parseInt (number.trim());
      if (numberInt < 0) {
        negativeNumbers.add (numberInt);
      } else if (numberInt <= 1000) {
        returnValue += numberInt;
      }
    }
    if (negativeNumbers.size () > 0) {
      throw new RuntimeException ("Negatives not allowed: " + negativeNumbers.toString ());
    }
    return returnValue;
  }
  // Testy z zestawu 1 przechodzą
  // Testy z zestawów 1-2 przechodzą
  // Testy z zestawów 1-3 przechodzą
  // Testy z zestawów 1-4 przechodzą
  // Testy z zestawów 1-5 przechodzą
  // Testy z zestawów 1-6 przechodzą
  // Testy z zestawów 1-7 przechodzą
  // Testy z zestawów 1-8 przechodzą
  // Testy z zestawów 1-9 przechodzą
  // Testy z zestawów 1-10 nie przechodzą
}
 