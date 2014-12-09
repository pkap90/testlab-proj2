package stringcalculator;

public class StringCalculator {
  // SUT 3
  public static int add (String numbers) {
    if (numbers.isEmpty ()) {
      return 0;
    }
    int returnValue = 0;
    String [] numbersArray = numbers.split (",");
    if (numbersArray.length > 2) {
      throw new RuntimeException ("Up to 2 comma-separated numbers are allowed.");
    } else {
      for (String number : numbersArray) {
        returnValue += Integer.parseInt (number.trim()); // jeśli to nie liczba - zgłoszony wyjątek 
      }
    }
    return returnValue;
  }
  // Testy z zestawu 1 przechodzą
  // Testy z zestawów 1-2 przechodzą
  // Testy z zestawów 1-3 przechodzą
  // Testy z zestawów 1-4 nie przechodzą
}
 