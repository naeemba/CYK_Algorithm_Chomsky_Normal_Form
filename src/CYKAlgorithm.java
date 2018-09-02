import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CYKAlgorithm {
  static boolean run(CFG cfg, String word) {
    char[] chars = word.toCharArray();
    int currentLevel = 0;

    List<List<Set<String>>> strings = new ArrayList<>();
    List<Set<String>> currLevel = new ArrayList<>();

    for(char ch: chars) {
      currLevel.add(cfg.findParts(ch  + ""));
    }
    strings.add(currLevel);
    currentLevel++;

    while (currentLevel < chars.length) {
      currLevel = new ArrayList<>();
      for (int k = 0; k < chars.length - currentLevel; k++) {
        Set<String> result = new HashSet<>();
        for (int l = 0; l < currentLevel; l++) {
          Set<String> first = strings.get(currentLevel - l - 1).get(k);
          Set<String> second = strings.get(l).get(currentLevel - l + k);
          for (String f : first)
            for (String s : second)
              result.addAll(cfg.findParts(f + s));
        }
        currLevel.add(result);
      }
      strings.add(currLevel);
      currentLevel++;
    }
    return strings.get(strings.size() - 1).get(0).contains("S");
  }
}
