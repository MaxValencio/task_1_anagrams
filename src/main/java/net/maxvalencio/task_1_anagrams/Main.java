package net.maxvalencio.task_1_anagrams;

public class Main {

	public static void main(String[] args) {
		AnagramImpl anagram = new AnagramImpl();
		String s = "!!Sttt3uuu==@#ud31ennnt467 is a good programmer! Stu4&den(t 4464 =)";
		System.out.println("Text: " + s);
		System.out.println("Anagrams: "+ anagram.createAnagram(s));
	    s = "  1                      1";
	    System.out.println("Text: " + s);
	    System.out.println("Anagrams: "+ anagram.createAnagram(s));
	    s = "";
	    System.out.println("Text: " + s);
	    System.out.println("Anagrams: "+ anagram.createAnagram(s));
	    s = null;
	    System.out.println("Text: " + s);
	    System.out.println("Anagrams: "+ anagram.createAnagram(s));
	}
}
