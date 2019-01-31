package net.maxvalencio.task_1_anagrams;

public class AnagramImpl implements Anagram {
	
	@Override
	public String createAnagram(String text) {
		String[] words = text.split("\\s+"); 
		StringBuilder result = new StringBuilder();
		for(String word : words) {
			result.append(createWordAnagram(word)).append(" ");
		}	
		return result.toString().trim();
	}

	private StringBuilder createWordAnagram(String word) {		
		StringBuilder anagram = new StringBuilder(); 
		anagram.append(createLettersAnagram(word));
		insertNonLettersToAnagram(word, anagram);
		return anagram;	
	}	
	
	private StringBuilder createLettersAnagram(String word) {
		StringBuilder lettersAnagram = new StringBuilder();
		char[] wordChars = word.toCharArray();
		for(Character currentCharacter : wordChars) {
			if(Character.isLetter(currentCharacter)) {
				lettersAnagram.append(currentCharacter);
			}
		}
		return lettersAnagram.reverse();
	}
	
	private StringBuilder insertNonLettersToAnagram(String word, StringBuilder anagram){
		char[] wordChars = word.toCharArray();
		for(int i = 0; i < wordChars.length; i++) {
			if(!Character.isLetter(wordChars[i])) {
				anagram.insert(i, wordChars[i]);
			}
		}
		return anagram;
	}
}
