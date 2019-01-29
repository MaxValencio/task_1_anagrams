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
		List<String> words = new ArrayList<>(Arrays.asList(text.split(" "))); // break the text into words 
		text = "";
		for(int i = 0; i < words.size(); i++) {
			if(!(words.get(i).equals(""))) {
				text += anagramOfWord(words.get(i)) + ( i == words.size() - 1 ? "" : " ");
			}
		}
		return text;
	}

	private String anagramOfWord(String word) {
		char[] charArray = word.toCharArray();	//break the word into symbols
		List<Character> list = new ArrayList<>(); 
		Map<Integer, Character> nonLettersHolder = new LinkedHashMap<>();
		//sort symbols: letters and non-letters
		for(int i = 0; i < charArray.length; i++) {
			if(Character.isLetter(charArray[i])) {
				list.add(charArray[i]);
			} else {
				nonLettersHolder.put(i, charArray[i]);
			}
		}
		Collections.reverse(list); // get the anagram without non-letter symbols
		for(Map.Entry<Integer, Character> entry : nonLettersHolder.entrySet()) {
				list.add(entry.getKey(), entry.getValue());	// add non-letters symbols in anagram
		}	
		word ="";
		for( Character character : list) {
			word += character; 
		}
		return word;
	}
}

