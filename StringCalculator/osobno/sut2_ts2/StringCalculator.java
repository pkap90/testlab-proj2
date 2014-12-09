package stringcalculator;

public class StringCalculator {
  // SUT 2
  public static int add (String numbers) {
    if (numbers.isEmpty ()) {
      return 0;
    }
    String [] numbersArray = numbers.split (",");
    if (numbersArray.length > 2) {
      throw new RuntimeException ("Up to 2 comma-separated numbers are allowed.");
    } else {
      for (String number : numbersArray) {
        Integer.parseInt (number); // jeśli to nie liczba - zgłoszony wyjątek 
      }
    }
    return 0;
  }
  // Testy z zestawu 1 przechodzą
  // Testy z zestawów 1-2 przechodzą
  // Testy z zestawów 1-3 nie przechodzą
}
 