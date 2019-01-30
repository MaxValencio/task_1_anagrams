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
				sb.append(getSingleAnagram(data.get(i))).append(" ");
		}	
		String totalAnagram = sb.toString().trim();
		return totalAnagram;
	}

	private String getSingleAnagram(String str) {
		char[] chars = str.toCharArray();	
		List<Character> anagramHolder = addToAnagram(getLetters(chars), getNonLetters(chars));
		StringBuilder sb = new StringBuilder();
		for( Character character : anagramHolder) {
			sb.append(character); 
		}
		String singleAnagram = sb.toString();
		return singleAnagram;
	}
	
	private List<Character> getLetters(char[] ch) {
		List<Character> letters = new ArrayList<>(); 
		for(int i = 0; i < ch.length; i++) {
			if(Character.isLetter(ch[i])) {
				letters.add(ch[i]);
			}
		}return letters;
	}
	
	private Map<Integer, Character> getNonLetters(char[]ch){
		Map<Integer, Character> nonLetters = new LinkedHashMap<>();
		for(int i = 0; i < ch.length; i++) {
			if(!Character.isLetter(ch[i])) {
				nonLetters.put(i, ch[i]);
			}
		}
		return nonLetters;
	}
	
	private List<Character> addToAnagram(List<Character> letters, Map<Integer, Character> nonLetters) {
		Collections.reverse(letters);
		List<Character> anagram = new ArrayList<>();
		anagram.addAll(letters);
		for(Map.Entry<Integer, Character> entry : nonLetters.entrySet()) {
			anagram.add(entry.getKey(), entry.getValue());	// add non-letters symbols in anagram
		}
		return anagram;
	}
}
