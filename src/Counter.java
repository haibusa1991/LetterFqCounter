import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Counter {
    public static void main(String[] args) throws IOException {
        String[] text = new FileHandler().readFileFromDisk().replace("-"," ").split("\\s+");

        Map<Character, Integer> letterFrequencies = new HashMap<>();
        Map<Integer, Integer> wordLengths = new HashMap<>();

        for (String word : text) {
            for (Character c : word.toCharArray()) {
                if (!Config.validLetters.contains(c)) {
                    continue;
                }
                letterFrequencies.putIfAbsent(c, 0);
                letterFrequencies.put(c, letterFrequencies.get(c) + 1);
            }
            wordLengths.putIfAbsent(word.length(), 0);
            wordLengths.put(word.length(), wordLengths.get(word.length()) + 1);
            if (word.length() >= 25) {
                System.out.println(word + System.lineSeparator());
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Честота на букви:")
                .append(System.lineSeparator());

        letterFrequencies.entrySet()
                .stream()
                .sorted((Map.Entry.<Character, Integer>comparingByValue().reversed()))
                .forEach((e -> sb.append(e.getKey()).append(" -> ").append(e.getValue()).append(System.lineSeparator())));

        sb.append(System.lineSeparator())
                .append("Дължина на думи:")
                .append(System.lineSeparator());

        wordLengths.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .filter(e -> e.getKey() < 20 && e.getKey() > 3)
                .forEach((e -> sb.append(e.getKey()).append(" -> ").append(e.getValue()).append(System.lineSeparator())));

        new FileHandler().writeResultsToDisk(sb.toString());
    }

}
