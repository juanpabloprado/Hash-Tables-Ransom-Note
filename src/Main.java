import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    String magazine[] = new String[m];
    for (int magazine_i = 0; magazine_i < m; magazine_i++) {
      magazine[magazine_i] = scanner.next();
    }
    String ransom[] = new String[n];
    for (int ransom_i = 0; ransom_i < n; ransom_i++) {
      ransom[ransom_i] = scanner.next();
    }

    scanner.close();
    System.out.println(canBuildRandomNote(magazine, ransom)? "Yes": "No");
  }

  public static boolean canBuildRandomNote(String[] magazine, String[] note) {
    Map<String, Integer> magazineFreq = getStringFrequency(magazine);
    return hasEnoughStrings(magazineFreq, note);
  }

  private static boolean hasEnoughStrings(Map<String, Integer> magazineFreq,
      String[] noteWords) {
    for (String word : noteWords) {
      if (!magazineFreq.containsKey(word)) {
        return false;
      } else {
        magazineFreq.put(word, magazineFreq.get(word) - 1);
      }

      if(magazineFreq.get(word) < 0) {
        return false;
      }
    }
    return true;
  }

  private static HashMap<String, Integer> getStringFrequency(String[] text) {
    HashMap<String, Integer> frequencies = new HashMap<>();
    for (String word : text) {
      if (!frequencies.containsKey(word)) {
        frequencies.put(word, 0);
      }
      frequencies.put(word, frequencies.get(word) + 1);
    }
    return frequencies;
  }
}
