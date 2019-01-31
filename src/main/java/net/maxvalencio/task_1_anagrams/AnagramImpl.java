package net.maxvalencio.task_1_anagrams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnagramImpl implements Anagram {
	
	@Override
	public String createAnagram(String line) {
		List<String> words = Arrays.asList(line.split("\\s+")); 
		StringBuilder anagramBuilder = new StringBuilder();
		for(String word : words) {
			anagramBuilder.append(createWordAnagram(word)).append(" ");
		}	
		return anagramBuilder.toString().trim();
	}

	private String createWordAnagram(String word) {		
		StringBuilder wordAnagamBuilder = new StringBuilder(); 
		wordAnagamBuilder.append(createLettersAnagram(word));
		for(Map.Entry<Integer, Character> entry : createNonLetters(word).entrySet()) {
			wordAnagamBuilder.insert((int)entry.getKey(),(char)entry.getValue());
		}
		return wordAnagamBuilder.toString();	
	}	
	
	private String createLettersAnagram(String word) {
		StringBuilder lettersAnagramBuilder = new StringBuilder();
		for(Character character : word.toCharArray()) {
			if(Character.isLetter(character)) {
				lettersAnagramBuilder.append(character);
			}
		}
		return lettersAnagramBuilder.reverse().toString();
	}
	
	private Map<Integer, Character> createNonLetters(String word){
		Map<Integer, Character> nonLetters = new LinkedHashMap<>();
		for(int i = 0; i < word.toCharArray().length; i++) {
			if(!Character.isLetter(word.toCharArray()[i])) {
				nonLetters.put(i, word.toCharArray()[i]);
			}
		}
		return nonLetters;
	}
}
