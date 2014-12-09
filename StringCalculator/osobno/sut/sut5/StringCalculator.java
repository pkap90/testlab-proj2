package stringcalculator;

public class StringCalculator {
  // SUT 5
  public static int add (String numbers) {
    if (numbers.empty ()) {
      return 0;
    }
    int returnValue = 0;
    String [] numbersArray = numbers.split (",|\n");
    for (String number : numbersArray) {
      returnValue += Integer.parseInt (number.trim()); // jeśli to nie liczba - zgłoszony wyjątek 
    }
    return returnValue;
  }
  // Testy z zestawu 1 przechodzą
  // Testy z zestawów 1-2 przechodzą
  // Testy z zestawów 1-3 przechodzą
  // Testy z zestawów 1-4 przechodzą
  // Testy z zestawów 1-5 przechodzą
  // Testy z zestawów 1-6 nie przechodzą
}
 