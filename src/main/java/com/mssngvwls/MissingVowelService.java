package com.mssngvwls;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class MissingVowelService {
    private static final List<Character> VOWELS = List.of('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');
    private final Map<Integer, String> words;
    private final Random random;

    public MissingVowelService(Map<Integer, String> words) {
        this.words = words;
        this.random = new Random();
    }

    public boolean check(int index, String answer) {
        Optional<String> maybeCorrectAnswer = Optional.ofNullable(words.get(index));
        return (maybeCorrectAnswer.isPresent() && matches(maybeCorrectAnswer.get(), answer));
    }

    public String getWord() {
        String word = words.get(random.nextInt(words.size()));
        return removeVowels(word);
    }

    public String getWord(int index) {
        return words.get(index);
    }

    private boolean matches(String a, String b) {
        return a != null && a.equalsIgnoreCase(b);
    }

    private String removeVowels(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (!(' ' == character || isVowel(character))) {
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }

    private boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}
