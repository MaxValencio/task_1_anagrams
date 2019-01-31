package net.maxvalencio.task_1_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnagramByCollections implements Anagram {
	
	@Override
	public String createAnagram(String str) {
		List<String> data = Arrays.asList(str.split("\\s+")); 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < data.size(); i++) {
				sb.append(createWordAnagram(data.get(i))).append(" ");
		}	
		String anagram = sb.toString().trim();
		return anagram;
	}

	private String createWordAnagram(String str) {
		char[] chars = str.toCharArray();	
		List<Character> charsAnagram = createCharsAnagramOf(lettersOf(chars), nonLettersOf(chars));
		StringBuilder sb = new StringBuilder();
		for( Character character : charsAnagram) {
			sb.append(character); 
		}
		String wordAnagram = sb.toString();
		return wordAnagram;
	}
	
	private List<Character> lettersOf(char[] ch) {
		List<Character> letters = new ArrayList<>(); 
		for(Character character : ch) {
			if(Character.isLetter(character)) {
				letters.add(character);
			}
		}return letters;
	}
	
	private Map<Integer, Character> nonLettersOf(char[]ch){
		Map<Integer, Character> nonLetters = new LinkedHashMap<>();
		for(int i = 0; i < ch.length; i++) {
			if(!Character.isLetter(ch[i])) {
				nonLetters.put(i, ch[i]);
			}
		}
		return nonLetters;
	}
	
	private List<Character> createCharsAnagramOf(List<Character> letters, Map<Integer, Character> nonLetters) {
		nonLetters.toString();
		Collections.reverse(letters);
		List<Character> charsAnagram = new ArrayList<>();
		charsAnagram.addAll(letters);
		for(Map.Entry<Integer, Character> entry : nonLetters.entrySet()) {
			charsAnagram.add(entry.getKey(), entry.getValue());
		}
		return charsAnagram;	
	}
}
