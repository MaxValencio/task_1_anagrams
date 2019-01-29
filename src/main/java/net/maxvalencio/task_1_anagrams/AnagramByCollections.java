package net.maxvalencio.task_1_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnagramByCollections implements Anagram {
	
	@Override
	public String createAnagram(String text) {
		List<String> data = Arrays.asList(text.split("\\s+")); 
		StringBuilder anagramBuilder = new StringBuilder();
		for(int i = 0; i < data.size(); i++) {
				anagramBuilder.append(getAnagram(data.get(i))).append(" ");
		}	
		return anagramBuilder.toString().trim();
	}

	private StringBuilder getAnagram(String word) {
		char[] chars = word.toCharArray();	
		List<Character> characters = new ArrayList<>(); 
		Map<Integer, Character> nonLettersHolder = new LinkedHashMap<>();
		//sort symbols: letters and non-letters
		for(int i = 0; i < chars.length; i++) {
			if(Character.isLetter(chars[i])) {
				characters.add(chars[i]);
			} else {
				nonLettersHolder.put(i, chars[i]);
			}
		}
		Collections.reverse(characters); // get the anagram without non-letter symbols
		for(Map.Entry<Integer, Character> entry : nonLettersHolder.entrySet()) {
				characters.add(entry.getKey(), entry.getValue());	// add non-letters symbols in anagram
		}	
		StringBuilder stringBuilder = new StringBuilder();
		for( Character character : characters) {
			stringBuilder.append(character); 
		}
		return stringBuilder;
	}
}

